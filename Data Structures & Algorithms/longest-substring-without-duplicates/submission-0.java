class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; int start = 0;
        Map<Character, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (seen.containsKey(c)) {
                start = Math.max(start, seen.get(c) + 1);
            }

            max = Math.max(max, i - start + 1);
            seen.put(c, i);
        }
        return max;
    }
}