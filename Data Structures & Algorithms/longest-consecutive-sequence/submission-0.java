class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;

        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            uniques.add(num);
        }

        int max = 1;
        for (int num : uniques) {
            if (uniques.contains(num - 1)) continue;
            int sequence = 0;
            int currNum = num;
            while (uniques.contains(currNum)) {
                sequence++;
                currNum++;
            }
            max = Math.max(max, sequence);    
        }
        
        return max;
    }
}