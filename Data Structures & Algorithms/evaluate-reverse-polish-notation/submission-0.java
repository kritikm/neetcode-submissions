class Solution {
    Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (operators.contains(tokens[i])) {
                int a = s.pop();
                int b = s.pop();
                int res;
                if (tokens[i].equals("+")) {
                    res = b + a;
                } else if (tokens[i].equals("-")) {
                    res = b - a;
                } else if (tokens[i].equals("*")) {
                    res = b * a;
                } else {
                    res = b / a;
                }
                s.push(res);
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }

        return s.pop();
    }
}