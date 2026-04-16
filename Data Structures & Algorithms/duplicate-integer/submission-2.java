class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            seen.add(nums[i]);
        }
        return seen.size() < nums.length;        
    }
}