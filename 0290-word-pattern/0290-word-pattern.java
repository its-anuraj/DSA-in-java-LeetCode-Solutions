class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n1 = pattern.length();
        int n2 = words.length;

        if (n1 != n2) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (pattern.charAt(i) == pattern.charAt(j)
                        && !words[i].equals(words[j])) {
                    return false;
                }

                if (pattern.charAt(i) != pattern.charAt(j)
                        && words[i].equals(words[j])) {
                    return false;
                }
            }
        }

        return true;
    }
}