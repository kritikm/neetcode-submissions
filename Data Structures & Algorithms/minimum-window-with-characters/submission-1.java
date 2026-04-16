class Solution {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] counts = new int[128];

        for (char c : t.toCharArray()) {
            counts[c]++;
        }

        int left = 0;
        int right = 0;
        int start = -1;
        int end = s.length();

        int counter = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (counts[c] > 0) {
                counter--;
            }
            counts[c]--;
            right++;

            while (counter == 0) {
                if (start == -1 || right - left < end - start) {
                    end = right;
                    start = left;
                }

                char remove = s.charAt(left);
                counts[remove]++;
                if (counts[remove] > 0) {
                    counter++;
                }
                left++;
            }
        }

        return start == -1 ? "" : s.substring(start, end);
    }

}