class Solution {
    private char[] getCharCounts(String s) {
        char[] counts = new char[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        return counts;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charCounts = getCharCounts(str);
            String sign = Arrays.toString(charCounts);

            List<String> group = groups.getOrDefault(sign, new ArrayList<>());
            group.add(str);
            groups.put(sign, group);
        }

        return new ArrayList<>(groups.values());
    }
}
