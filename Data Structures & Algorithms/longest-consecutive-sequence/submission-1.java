class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        Set<Integer> uniques = new HashSet<>();

        for (int num : nums) {
            uniques.add(num);
        }

        int max = 1;

        for (int num : uniques) {
            int prev = num - 1;
            if (uniques.contains(prev)) continue;

            int trav = num + 1;
            int length = 1;
            while (uniques.contains(trav)) {
                length++;
                trav++;
            }
            max = Math.max(max, length);
        }

        return max;
    }
}