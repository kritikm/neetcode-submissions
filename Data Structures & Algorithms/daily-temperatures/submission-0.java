class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] results = new int[len];

        for (int i = len - 2; i >= 0; i--) {
             int checkingAtDay = i + 1;
             while (checkingAtDay < len) {
                if (temperatures[i] < temperatures[checkingAtDay]) {
                    results[i] = checkingAtDay - i;
                    break;
                }

                if (results[checkingAtDay] == 0) {
                    results[i] = 0;
                    break;
                }
                checkingAtDay += results[checkingAtDay];
             }
        }

        return results;
    }
}
