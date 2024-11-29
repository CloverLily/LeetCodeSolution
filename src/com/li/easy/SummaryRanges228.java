package com.li.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 *
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 *
 * 提示：
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
public class SummaryRanges228 {

    public static void main(String[] args) {
        int[][] nums = {
                {-1},//["-1"]
                {0, 1, 2, 4, 5, 7},//["0->2","4->5","7"]
                {0, 2, 3, 4, 6, 8, 9}//["0","2->4","6","8->9"]
        };
        for (int[] num : nums) {
            List<String> resList = summaryRanges(num);
            System.out.print("[");
            for (String res : resList) {
                System.out.print(res + ", ");
            }
            System.out.println("]");
        }
    }

    /**
     * 自解 + 官方stringBuffer
     * time:O(N), space:O(1)
     */
    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> resList = new ArrayList<>();
        if (n == 1) {
            resList.add(String.valueOf(nums[0]));
            return resList;
        }

        int i = 0;
        while (i < n - 1) {
            int headI = i;
            while (i < n - 1 && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (i > headI) {
                StringBuffer sb = new StringBuffer();
                sb.append(nums[headI]).append("->").append(nums[i]);
                resList.add(sb.toString());
            } else {
                resList.add(String.valueOf(nums[headI]));
            }
            i++;
            if (i == n - 1) {
                resList.add(String.valueOf(nums[i]));
            }
        }
        return resList;
    }

}
