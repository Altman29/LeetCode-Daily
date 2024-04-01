package org.example;


/*
输出字符串中**连续重复出现**次数最多的字符和次数，假设只有一个字符出现的次数最多
（例子：输入14444112442aa44442244311222222244445444243334444ccc4444， 输出应该是2和7，因为2连续重复出现了7次）
 */
public class 最大重复次数的字符 {
    public static void main(String[] args) {
        String input = "14444112442aa44442244311222222244445444243334444ccc4444";
        char[] charArray = input.toCharArray();

        char maxChar = charArray[0];
        int maxCount = 1;

        char currentChar = charArray[0];
        int currentCount = 1;

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == currentChar) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxChar = currentChar;
                    maxCount = currentCount;
                }
                currentChar = charArray[i];
                currentCount = 1;
            }
        }

        // 检查最后一个字符序列的计数
        if (currentCount > maxCount) {
            maxChar = currentChar;
            maxCount = currentCount;
        }

        System.out.println("最多连续重复出现的字符是: " + maxChar + "，出现了 " + maxCount + " 次。");
    }

}
