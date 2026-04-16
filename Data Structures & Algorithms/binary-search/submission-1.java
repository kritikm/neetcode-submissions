class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left > 0 && nums[left - 1] == target) {
            return left - 1;
        }
        return -1;        
    }
}
