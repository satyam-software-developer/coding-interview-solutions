#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
#include <stack>
#include <sstream>
using namespace std;

int main() {
    int n, q;
    cin >> n >> q;
    cin.ignore();

    map<string, string> attributes;
    vector<string> tags;

    for (int i = 0; i < n; i++) {
        string line;
        getline(cin, line);

        // Closing tag
        if (line.substr(0, 2) == "</") {
            tags.pop_back();
        }
        // Opening tag
        else {
            // Remove '<' and '>'
            line = line.substr(1, line.length() - 2);

            stringstream ss(line);

            string tagName;
            ss >> tagName;

            tags.push_back(tagName);

            // Current tag path
            string path = tags[0];
            for (int j = 1; j < tags.size(); j++) {
                path += "." + tags[j];
            }

            string attrName, equalSign, value;

            while (ss >> attrName) {
                ss >> equalSign;
                ss >> value;

                // Remove quotes
                value = value.substr(1, value.length() - 2);

                attributes[path + "~" + attrName] = value;
            }
        }
    }

    // Process queries
    while (q--) {
        string query;
        getline(cin, query);

        if (attributes.find(query) != attributes.end())
            cout << attributes[query] << endl;
        else
            cout << "Not Found!" << endl;
    }

    return 0;
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna