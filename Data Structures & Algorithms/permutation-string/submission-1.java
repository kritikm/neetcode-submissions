class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Counts =  new int[26];
        int[] s2Window = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Window[s2.charAt(i) - 'a']++;
        }

        if (s1.length() == s2.length()) return Arrays.equals(s1Counts, s2Window);

        int right = s1.length();
        for (int i = right; i < s2.length(); i++) {
            if (Arrays.equals(s1Counts, s2Window)) return true;
            s2Window[s2.charAt(i) - 'a']++;
            s2Window[s2.charAt(i - right) - 'a']--;
        }

        return Arrays.equals(s1Counts, s2Window);
    }
}