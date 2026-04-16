class Solution {

    private void withSet(int[] nums, int start, int target, List<List<Integer>> results) {
        Set<Integer> seen = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.contains(complement)) {
                results.add(Arrays.asList(-target, complement, nums[i]));
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            }
            seen.add(nums[i]);
        }
    }

    private void twoPointers(int[] nums, int left, int right, int target, List<List<Integer>> results) {
        while (left < right) {
            int total = nums[left] + nums[right];
            if (total < target) {
                left++;
            } else if (total > target) {
                right--;
            } else {
                results.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left - 1] == nums[left]) left++;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoPointers(nums, i + 1, nums.length - 1, -nums[i], result);
                // withSet(nums, i + 1, -nums[i], result);
            }
        }
        return result;
    }
}