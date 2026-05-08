#include <vector>
#include <string>
#include <queue>
#include <unordered_set>
#include <algorithm>
#include <set>

using namespace std;

class Solution {
public:
    bool isValid(string s) {
        int count = 0;
        for (char c : s) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }

    vector<string> validParenthesis(string &s) {
        vector<string> result;
        unordered_set<string> visited;
        queue<string> q;
        set<string> validStrings;

        q.push(s);
        visited.insert(s);

        bool found = false;

        while (!q.empty()) {
            string current = q.front();
            q.pop();

            if (isValid(current)) {
                validStrings.insert(current);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < current.length(); i++) {
                if (current[i] != '(' && current[i] != ')') continue;

                string next = current.substr(0, i) + current.substr(i + 1);
                if (visited.find(next) == visited.end()) {
                    q.push(next);
                    visited.insert(next);
                }
            }
        }

        for (const string &str : validStrings) {
            result.push_back(str);
        }
        
        if (result.empty()) result.push_back("");

        return result;
    }
};