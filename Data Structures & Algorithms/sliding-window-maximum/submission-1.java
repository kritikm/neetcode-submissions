class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int size = nums.length - k + 1;
        int[] results = new int[size];

        Queue<int[]> q = new PriorityQueue<>( (a, b) -> b[0] - a[0]);
        int iter = 0;

        for (int i = 0; i < nums.length; i++) {
            q.add(new int[] {nums[i], i});
            if (i >= k - 1) {
                while (q.peek()[1] <= i - k) {
                    q.poll();
                }
                results[iter] = q.peek()[0];
                iter++;
            }
        }
        return results;
    }
}
