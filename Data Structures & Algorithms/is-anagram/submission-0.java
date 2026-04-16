class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;

        int[] schars = new int[26];
        int[] tchars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            schars[s.charAt(i) - 'a']++;
            tchars[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (schars[i] != tchars[i]) return false;
        }
        return true;
    }
}
