class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] counts = new int[128];

        for (char c : t.toCharArray()) {
            counts[c]++;
        }

        int end = s.length(); int start = -1;
        int left = 0; int right = 0;

        int unmatched = t.length();

        while (right < s.length()) {
            char add = s.charAt(right);
            if (counts[add] > 0) unmatched--;
            counts[add]--;
            right++;

            while (left < right && unmatched == 0) {
                if (start == -1 || right - left < end - start) {
                    end = right;
                    start = left;
                }
                char remove = s.charAt(left);
                counts[remove]++;
                if (counts[remove] > 0) unmatched++;
                left++;
            }
        }

        return start == -1 ? "" : s.substring(start, end);
    }
}
