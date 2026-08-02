class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty())
            return "";
        int[] longestPalindromeIndices = { 0, 0 };
        for (int i = 0; i < s.length(); ++i) {
            int[] currentIndices = expandAroundCenter(s, i, i);
            if (currentIndices[1] - currentIndices[0] > longestPalindromeIndices[1] - longestPalindromeIndices[0]) {
                longestPalindromeIndices = currentIndices;
            }
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                int[] evenIndices = expandAroundCenter(s, i, i + 1);
                if (evenIndices[1] - evenIndices[0] > longestPalindromeIndices[1] - longestPalindromeIndices[0]) {
                    longestPalindromeIndices = evenIndices;
                }
            }
        }

        // Extract and return the longest palindrome substring using the indices
        return s.substring(longestPalindromeIndices[0], longestPalindromeIndices[1] + 1);
    }

    // Helper function to find and return the indices of the longest palindrome
    // extended from s[i..j] (inclusive) by expanding around the center
    private int[] expandAroundCenter(final String s, int i, int j) {
        // Expand the palindrome by moving outward from the center while the characters
        
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--; 
            j++; 
        }
        return new int[] { i + 1, j - 1 };
    }
}