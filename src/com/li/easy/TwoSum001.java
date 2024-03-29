package com.li.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数的下标。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @author system
 */
public class TwoSum001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>(16);

        //边界判断
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }
            indexMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("no result");
    }
}
