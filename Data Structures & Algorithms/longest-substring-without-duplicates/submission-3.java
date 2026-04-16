class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int result = 0;
        Map<Character, Integer> seenAt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (seenAt.containsKey(c)) {
                start = Math.max(start, seenAt.get(c) + 1);
            }
            seenAt.put(c, i);

            result = Math.max(result, i - start + 1);
        }
        return result;        
    }
}