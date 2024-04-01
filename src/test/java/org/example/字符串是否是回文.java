package org.example;

public class 字符串是否是回文 {

    public static boolean isPalindrome(String s) {
        // 调用递归辅助函数来检查字符串是否是回文
        return isPalindromeRecursive(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeRecursive(String str, int start, int end) {
        // 如果字符串长度为1或0，则是回文
        if (start >= end)
            return true;
        // 检查首尾字符是否相同，如果不同，则不是回文
        if (str.charAt(start) != str.charAt(end))
            return false;
        // 递归地检查剩余子字符串是否是回文
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // 测试
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));  // 输出：true
        System.out.println(isPalindrome("abccba"));  // 输出：true
        System.out.println(isPalindrome("abc"));     // 输出：false
    }

}
