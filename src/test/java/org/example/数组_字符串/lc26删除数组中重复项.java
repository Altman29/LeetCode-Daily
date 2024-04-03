package org.example.数组_字符串;

import org.junit.Test;

/*
给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
返回 k 。

示例 1：

输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
示例 2：

输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */
public class lc26删除数组中重复项 {
    /*
    思路：原地 意思不能有额外空间了，还是靠指针。数组本身是有序的，所以双指针可以解决。
    一个指针用于结果数组，一个指针用于为结果数组筛选元素。好像还可以叫做快慢指针。我觉得双指针叫法就够了。
     */
    public int removeDuplicates(int[] nums) {
        int top = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[top] != nums[i]) {
                top++;
                nums[top] = nums[i];
            }
        }
        return top + 1;
    }

    @Test
    public void test() {
        //int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates(nums);
        System.out.println("length is " + result);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
