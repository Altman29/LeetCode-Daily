package org.example;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

public class 故障键盘 {

    /*
    你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。

给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。

返回最终笔记本屏幕上输出的字符串。



示例 1：

输入：s = "string"
输出："rtsng"
解释：
输入第 1 个字符后，屏幕上的文本是："s" 。
输入第 2 个字符后，屏幕上的文本是："st" 。
输入第 3 个字符后，屏幕上的文本是："str" 。
因为第 4 个字符是 'i' ，屏幕上的文本被反转，变成 "rts" 。
输入第 5 个字符后，屏幕上的文本是："rtsn" 。
输入第 6 个字符后，屏幕上的文本是： "rtsng" 。
因此，返回 "rtsng" 。
示例 2：

输入：s = "poiinter"
输出："ponter"
解释：
输入第 1 个字符后，屏幕上的文本是："p" 。
输入第 2 个字符后，屏幕上的文本是："po" 。
因为第 3 个字符是 'i' ，屏幕上的文本被反转，变成 "op" 。
因为第 4 个字符是 'i' ，屏幕上的文本被反转，变成 "po" 。
输入第 5 个字符后，屏幕上的文本是："pon" 。
输入第 6 个字符后，屏幕上的文本是："pont" 。
输入第 7 个字符后，屏幕上的文本是："ponte" 。
输入第 8 个字符后，屏幕上的文本是："ponter" 。
因此，返回 "ponter" 。


提示：

1 <= s.length <= 100
s 由小写英文字母组成
s[0] != 'i'
     */

    public static void main(String[] args) {
        String s = "string";
        //String s = "poiinter";
        //System.out.println(finalString(s));
        System.out.println(finalString2(s));
    }


    /*
    方法1：直观方法，遇到i就reverse即可。
     */
    @Test
    public static String finalString(String s) {
        ArrayList<Object> l1 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i')
                Collections.reverse(l1);
            else
                l1.add(s.charAt(i));
        }
        return l1.stream().map(Object::toString).collect(Collectors.joining());
    }

    /*
    方法2：双端队列，因为可以头插可以尾插，符合这个问题的特性。记录一个方向，遇到i就改变方向。
     */
    @Test
    public static String finalString2(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        boolean direct = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i')
                direct = !direct;
            else {
                if (direct)
                    deque.addLast(s.charAt(i));
                else
                    deque.addFirst(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character c : deque) ans.append(c);
        if (!direct) ans.reverse();
        return ans.toString();
    }
}
