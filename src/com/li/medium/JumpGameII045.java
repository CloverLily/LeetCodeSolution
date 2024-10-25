package com.li.medium;

/**
 * 45. 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *  0 <= j <= nums[i]
 *  i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * 提示:
 *
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 */
public class JumpGameII045 {

    public static void main(String[] args) {
        int[][] numsArr = {
                {2, 4, 1, 1, 4},//2
                {2, 3, 0, 1, 4},//2
                {1, 2},//1
                {2, 1},//1
                {2, 3, 1},//1
                {1,1,1,1}//3
        };
        for(int[] nums : numsArr){
            System.out.println(jump(nums));
        }
    }

    /**
     * 官方：
     * 贪心
     * 局部最优解:可走的步数里找可走最远的
     * time: O(n), space: O(1)
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int maxPosition = 0;
        int steps = 0;
        int end = 0;
        for (int i = 0; i < (n - 1); i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 原创
     * 贪心
     * 局部最优解:可走的步数里找可走最远的
     * time: O(n), space: O(1)
     */
    public static int jumpOrigin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int maxFarIndex = nums[0];
        int i = 0;
        int count = 1;
        while (i < (n - 1)) {
            if (maxFarIndex != 0) {
                int k = i;
                int farIndex = 0;
                boolean isJump = false;
                for (int j = 1; j <= maxFarIndex; j++) {
                    if ((k + j) >= (n - 1)) {
                        return count;
                    }
                    if ((k + j + nums[k + j]) > (i + farIndex)) {
                        farIndex = nums[k + j];
                        i = k + j;
                        isJump = true;
                    }
                }

                if ((i + farIndex) >= (n - 1)) {
                    return ++count;
                }
                if (isJump) {
                    maxFarIndex = farIndex;
                    count++;
                }
            }
        }
        return count;
    }

}
