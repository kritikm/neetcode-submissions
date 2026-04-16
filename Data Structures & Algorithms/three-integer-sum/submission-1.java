class Solution {

    private void twoSum(int[] nums, int i, List<List<Integer>> results) {
        int left = i + 1;
        int right = nums.length - 1;
        int target = -nums[i];

        while (left < right) {
            int total = nums[left] + nums[right];

            if (total < target) {
                left++;
            } else if (total > target) {
                right--;
            } else {
                results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;

                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]){
                twoSum(nums, i, results);
            }
        }

        return results;
    }
}