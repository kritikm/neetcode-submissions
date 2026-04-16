class Solution {
    public int lengthOfLongestSubstring(String s) {

        int result = 0;
        int[] counts = new int[128];

        int left = 0; int right = 0;

        while (right < s.length()) {
            // expand window
            char add = s.charAt(right);
            counts[add]++;
            right++;

            // if window is invalid, increment left until it becomes valid
            while (left < right && counts[add] > 1) {
                char remove = s.charAt(left);
                counts[remove]--;
                left++;
            }

            // update result and right++
            result = Math.max(result, right - left);
        }

        return result;        
    }
}