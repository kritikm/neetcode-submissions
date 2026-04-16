class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int size = nums.length - k + 1;
        int[] results = new int[size];

        for (int i = 0; i < size; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            results[i] = max;
        }

        return results;
        
    }
}
