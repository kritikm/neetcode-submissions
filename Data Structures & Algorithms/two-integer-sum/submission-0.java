class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> memory = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (memory.containsKey(diff)) {
                return new int[] { memory.get(diff), i };
            }
            memory.put(nums[i], i);
        }
        return new int[2];
    }
}
