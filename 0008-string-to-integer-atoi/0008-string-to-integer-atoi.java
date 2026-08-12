class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int ans = 0;
        int sign = 1;
        int start = 0;

        while (start < n && s.charAt(start) == ' ') {
            start++;
        }

        for (int i = start; i < n; i++) {

            if (i == start && s.charAt(i) == '-') {
                sign = -1;
                continue;
            }
            if (i == start && s.charAt(i) == '+') {
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int digit = s.charAt(i) - '0';

                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }

                ans = ans * 10 + digit;

            } else {
                break;
            }
        }
        return sign * ans;
    }
}