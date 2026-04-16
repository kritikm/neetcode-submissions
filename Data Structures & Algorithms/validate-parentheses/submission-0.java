class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> closedToOpen = new HashMap<>();
        closedToOpen.put(')', '(');
        closedToOpen.put(']', '[');
        closedToOpen.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (closedToOpen.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != closedToOpen.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}