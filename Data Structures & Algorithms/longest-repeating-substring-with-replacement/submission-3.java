class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> counts = new HashMap<>();

        int maxF = 0;

        int left = 0; int right = 0;
        int result = 0;

        while (right < s.length()) {
            char add = s.charAt(right);
            counts.put(add, counts.getOrDefault(add, 0) + 1);
            maxF = Math.max(maxF, counts.get(add));
            right++;
            
            while (left < right && right - left - maxF > k) {
                char remove = s.charAt(left);
                counts.put(remove, counts.get(remove) - 1);
                left++;
            }

            result = Math.max(result, right - left);
        }
        return result;
        
    }
}
