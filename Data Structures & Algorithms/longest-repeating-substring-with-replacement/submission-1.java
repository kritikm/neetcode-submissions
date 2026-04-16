class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> uniques = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniques.add(c);
        }

        int result = 0;
        for (char c : uniques) {
            int left = 0;
            int right = 0;
            int count = 0;

            while (left < s.length() && right < s.length()) {
                if (s.charAt(right) == c) count++;
                if ((right - left + 1) - count > k) {
                    if (s.charAt(left) == c) count--;
                    left++;
                } else {
                    result = Math.max(right - left + 1, result);
                    right++;
                }
            }
        }

        return result;
    }
}
