class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] counts = new int[128];

        for (char c : t.toCharArray()) {
            counts[c]++;
        }

        int left = 0; int right = 0;
        int unmatched = t.length();
        int start = Integer.MIN_VALUE; int end = s.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (counts[c] > 0) {
                unmatched--;
            }
            counts[c]--;
            right++;

            while (unmatched == 0) {
                if (start == Integer.MIN_VALUE || end - start > right - left) {
                    end = right;
                    start = left;
                }
                char remove = s.charAt(left);
                counts[remove]++;
                if (counts[remove] > 0) {
                    unmatched++;
                }
                left++;
            }
        }

       return start == Integer.MIN_VALUE ? "" : s.substring(start, end);
    }

}