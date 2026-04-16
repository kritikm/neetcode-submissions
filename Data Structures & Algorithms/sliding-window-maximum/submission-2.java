class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int size = nums.length - k + 1;
        int[] results = new int[size];

        Deque<Integer> q = new LinkedList<>();

        int left = 0; int right = 0;
        int iter = 0;

        while (right < nums.length) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[right]) {
                q.removeLast();
            }
            q.addLast(right);

            if (left > q.getFirst()) {
                q.removeFirst();
            }

            if (right >= k - 1) {
                results[iter] = nums[q.getFirst()];
                iter++;
                left++;
            }
            right++;
        }

        return results;
    }
}
