class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int start = -1;
        int litterCount = 0;

        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(litterId[i], -1);

            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    start = i * n + j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int totalMasks = 1 << litterCount;
        int cells = m * n;

        boolean[][][] visited = new boolean[cells][totalMasks][energy + 1];

        java.util.ArrayDeque<int[]> queue = new java.util.ArrayDeque<>();

        visited[start][0][energy] = true;
        queue.offer(new int[] { start, 0, energy });

        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        int moves = 0;
        int fullMask = totalMasks - 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] state = queue.poll();

                int pos = state[0];
                int mask = state[1];
                int currentEnergy = state[2];

                if (mask == fullMask) {
                    return moves;
                }

                if (currentEnergy == 0) {
                    continue;
                }

                int r = pos / n;
                int c = pos % n;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int newPos = nr * n + nc;
                    int newEnergy = currentEnergy - 1;
                    int newMask = mask;

                    char cell = classroom[nr].charAt(nc);

                    if (cell == 'L') {
                        newMask |= 1 << litterId[nr][nc];
                    }

                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[newPos][newMask][newEnergy]) {
                        visited[newPos][newMask][newEnergy] = true;
                        queue.offer(new int[] {
                                newPos, newMask, newEnergy
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna