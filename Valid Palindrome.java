/*
	Valid Palindrome
	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.

	Note:
	Have you consider that the string might be empty? This is a good question to ask during an interview.

	For the purpose of this problem, we define empty string as valid palindrome.
*/

/*
	除了数字和英文字母以外的字符都不算进palindrome的比较，所以遇到其他字符就跳过，对下个字符进行比较
	//except from number and alphbet,other characters are not included to the compare, just skip
*/

public class Solution {
    //use to lowercase
     public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        s = s.toLowerCase();
        int low1 = 'a';
        int high1 = 'z';
        int low2 = '0';
        int high2 = '9';
        
        int low = 0;
        int high = s.length() - 1;
        
        while (low < high) {
            if ((s.charAt(low) < low1 || s.charAt(low) > high1)
                && (s.charAt(low) < low2 || s.charAt(low) > high2)) {
                    low++;
                    continue;
                }
            if ((s.charAt(high) < low1 || s.charAt(high) > high1) 
                && (s.charAt(high) < low2 || s.charAt(high) > high2)) {
                    high--;
                    continue;
                }
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

    //no use lower
        public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!isValid(s.charAt(l))) {
                l++;
                continue;
            }
            if (!isValid(s.charAt(r))) {
                r--;
                continue;
            }
            if (!isSame(s.charAt(l), s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValid(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')
            return true;
        return false;
    }

    private boolean isSame(char c1, char c2) {
        if (c1 >= 'A' && c1 <= 'Z')
            c1 = (char) (c1 - 'A' + 'a');
        if (c2 >= 'A' && c2 <= 'Z')
            c2 = (char) (c2 - 'A' + 'a');
        return c1 == c2;

    }
}