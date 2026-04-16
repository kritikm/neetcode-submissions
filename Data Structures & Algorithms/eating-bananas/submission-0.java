class Solution {
    private boolean canFinishAll(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k > 0) {
                hours++;
            }

            if (hours > h) return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MAX_VALUE;
        int min = 1;
        int res = max;

        while (min <= max) {
            int k = min + (max - min) / 2;

            boolean canFinish = canFinishAll(piles, k, h);

            if (canFinish) {
                max = k - 1;
                res = Math.min(res, k);
            } else {
                min = k + 1;
            }
        }

        return res;
    }
}
