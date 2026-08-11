class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < columnTitle.length(); i++) {
            int value = alphabet.indexOf(columnTitle.charAt(i)) + 1;
            ans = ans * 26 + value;
        }
        return ans;
    }
}