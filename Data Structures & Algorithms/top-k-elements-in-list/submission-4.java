class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        Queue<int[]> heap = new PriorityQueue<>( (a, b) -> a[1] - b[1] );

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            heap.offer(new int[] { entry.getKey(), entry.getValue() });
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[heap.size()];
        int iter = 0;
        while (!heap.isEmpty()) {
            result[iter] = heap.poll()[0];
            iter++;
        }

        return result;
    }
}
