class Solution {

    private final char delim = 257;

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(str.length()).append(delim).append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != delim) j++;
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = j + length + 1;
            String message = str.substring(i, j);
            strs.add(message);
            i = j;
        }
        return strs;
    }
}
