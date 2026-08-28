class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int odd = 0;
        int mid = -1;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd++;
                mid = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        char[] p = new char[halfLen];
        int[] cnt = half.clone();

        for (int i = 0; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';

            if (cnt[c] == 0) {
                break;
            }

            p[i] = target.charAt(i);
            cnt[c]--;
        }

        boolean exact = true;

        for (int i = 0; i < halfLen; i++) {
            if (p[i] == 0) {
                exact = false;
                break;
            }
        }

        if (exact) {
            String candidate = build(new String(p), mid);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        for (int pivot = halfLen - 1; pivot >= 0; pivot--) {
            cnt = half.clone();
            boolean valid = true;

            for (int i = 0; i < pivot; i++) {
                int c = target.charAt(i) - 'a';

                if (cnt[c] == 0) {
                    valid = false;
                    break;
                }

                cnt[c]--;
            }

            if (!valid) {
                continue;
            }

            int cur = target.charAt(pivot) - 'a';

            for (int c = cur + 1; c < 26; c++) {
                if (cnt[c] == 0) {
                    continue;
                }

                cnt[c]--;

                StringBuilder left = new StringBuilder();

                for (int i = 0; i < pivot; i++) {
                    left.append(target.charAt(i));
                }

                left.append((char) ('a' + c));

                for (int x = 0; x < 26; x++) {
                    while (cnt[x] > 0) {
                        left.append((char) ('a' + x));
                        cnt[x]--;
                    }
                }

                return build(left.toString(), mid);
            }
        }

        return "";
    }

    private String build(String left, int mid) {
        StringBuilder ans = new StringBuilder(left);

        if (mid != -1) {
            ans.append((char) ('a' + mid));
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            ans.append(left.charAt(i));
        }

        return ans.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna