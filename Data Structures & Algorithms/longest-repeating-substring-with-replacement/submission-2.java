class Solution {
    public int characterReplacement(String s, int k) {
        // for every window [i, j]
        // what is the max frequency of a character
        // can we flip other characters and stay within k?
        // if yes, that is a valid window
        // maximize on the size of the window = j - i + 1

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> counts = new HashMap<>();
            int maxF = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                // track frequency of c
                counts.put(c, counts.getOrDefault(c, 0) + 1);

                // track max frequency in [i, j]
                maxF = Math.max(maxF, counts.get(c));

                // check if it is a valid window
                if ((j - i + 1) - maxF <= k) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}
