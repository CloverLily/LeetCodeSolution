package com.li.easy;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *  Example 1:
 *    Input: [2,2,1]
 *    Output: 1
 *  Example 2:
 *    Input: [4,1,2,1,2]
 *    Output: 4
 *
 * @author system
 */
public class SingleNumber136 {

    public int singleNumber(int[] nums) {

        List numList = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(numList.contains(nums[i])){
                numList.remove(nums[i]);
            }else {
                numList.add(nums[i]);
            }
        }

        return (int)numList.get(0);
    }

}
