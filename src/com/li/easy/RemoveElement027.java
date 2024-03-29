package com.li.easy;

/**
 * 27. 移除元素
 * 给定一个数组nums和一个值val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author system
 */
public class RemoveElement027 {

    public static int removeElement(int[] nums, int val) {
        //如果存在等于val的值，则用尾端的数值覆盖该值
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        for (int i = 0; i < len; ) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
            } else {
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int len = removeElement(nums, 2);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+",");
        }
    }
}
