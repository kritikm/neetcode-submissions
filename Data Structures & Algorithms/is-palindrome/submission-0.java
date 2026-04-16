class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            while (left < right && !Character.isLetter(leftChar) && !Character.isDigit(leftChar)) {
                left++;
                leftChar = s.charAt(left);
            }
            while (left < right && !Character.isLetter(rightChar) && !Character.isDigit(rightChar)) {
                right--;
                rightChar = s.charAt(right);
            }

            if (Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar)) return false;

            left++;
            right--;
        }

        return true;
    }
}