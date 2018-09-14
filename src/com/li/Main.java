package com.li;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here


    }
}


/**
 * 1 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

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

/**
 * 7 反转整数
 *
 */
class Solution7 {
    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            //溢出则返回0
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            rev = rev * 10 + pop;
            x /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        List<List> qList=new ArrayList<>();
    }
}

/**
 * 9 回文数
 *
 */
class Solution9 {
    public static boolean isPalindrome(int x) {
        if (x >= 0 && x <= 9) return true;
        if (x < 0 || x % 10 == 0) return false;

        int rev = 0;
        while (x > rev) {
            int pop = x % 10;
            rev = rev * 10 + pop;
            x /= 10;
            if (x == rev || x / 10 == rev) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}

/**
 * 13 罗马数字转整数
 * char[] romans={'I','V','X','L','C','D','M'};
 * int[] romanValues={1,5,10,50,100,500,1000};
 */
class Solution13 {
    public static int romanToInt(String s) {
        //罗马数的十进制表示
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }

        if (s.indexOf("IV") != -1) sum -= 2;
        if (s.indexOf("IX") != -1) sum -= 2;
        if (s.indexOf("XL") != -1) sum -= 20;
        if (s.indexOf("XC") != -1) sum -= 20;
        if (s.indexOf("CD") != -1) sum -= 200;
        if (s.indexOf("CM") != -1) sum -= 200;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}

/**
 * 14 最长公共前缀
 */
class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (String s : strs) {
            if (s == null || s.length() == 0)
                return "";
        }

        if (strs.length == 1) return strs[0];

        String prefix = strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            prefix = commonPrefix(prefix, strs[i + 1]);
        }
        return prefix;

    }

    private static String commonPrefix(String str1, String str2) {
        String prefix = str1;
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (prefix.charAt(i) != str2.charAt(i)) {
                prefix = prefix.substring(0, i);
                break;
            }
        }

        if (prefix == null || prefix.length() == 0) {
            return "";
        } else if (prefix.length() > len) {
            return prefix.substring(0, len);
        } else {
            return prefix;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"ca", "a"};
        System.out.println(longestCommonPrefix(strs3));
        // System.out.println(longestCommonPrefix(new String[]{""}));
    }

}

/**
 * oppo笔试
 */
class RandomNums {

    public static void main(String[] args) {

        int[] randomArr = new int[10];
        for (int i = 0; i < 10; i++) {
            randomArr[i] = (int) Math.round(Math.random() * 1000);
        }

        System.out.print("原随机数组：[");
        for (int i = 0; i < 10; i++) {
            System.out.print(randomArr[i]);
            if (i != 9) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();

        System.out.print("反转-> [");
        for (int i = 0; i < 10; i++) {
            randomArr[i] = reverse(randomArr[i]);
            System.out.print(randomArr[i]);
            if (i != 9) {
                System.out.print(",");
            }
        }
        System.out.println("]");

        Arrays.sort(randomArr);

        System.out.print("降序-> [");
        for (int i = 9; i >= 0; i--) {
            System.out.print(randomArr[i]);
            if (i != 0) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();

    }

    /**
     * 反转数字
     *
     * @param num
     * @return
     */
    private static int reverse(int num) {
        if (num >= 0 && num <= 9) return num;
        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) return -1;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) return -1;
            rev = rev * 10 + pop;
            num /= 10;
        }
        return rev;
    }

}

/**
 * 测试：
 * 静态初始化>实例初始化>构造方法
 */
class TestABC {
    public static int i = 0;
    public static String s = "全局静态变量";

    public TestABC() {
        i = 3;
        s = "构造方法";
        System.out.println(s);
    }

    {
        i = 2;
        s = "实例初始化";
        System.out.println(s);
    }


    static {
        i = 1;
        s = "静态语句块";
        System.out.println(s);
    }


    public static void main(String[] args) {
        TestABC a = new TestABC();
        System.out.println("main方法");
        System.out.println(s);
        System.out.println(TestABC.s);
        System.out.println(a.s);
    }
}

/**
 * 20 有效的括号
 * 成对出现才有效
 */
class Solution20 {
    public static boolean isValid(String s) {
        char[] sArr = s.toCharArray();
        List<Character> sList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (sArr[i]) {
                case '(':
                    sList.add(sArr[i]);
                    break;
                case ')':
                    if (sList == null || sList.size() == 0 || !sList.get(sList.size() - 1).equals('(')) {
                        return false;
                    } else {
                        sList.remove(sList.size() - 1);
                        break;
                    }
                case '{':
                    sList.add(sArr[i]);
                    break;
                case '}':
                    if (sList == null || sList.size() == 0 || !sList.get(sList.size() - 1).equals('{')) {
                        return false;
                    } else {
                        sList.remove(sList.size() - 1);
                        break;
                    }
                case '[':
                    sList.add(sArr[i]);
                    break;
                case ']':
                    if (sList == null || sList.size() == 0 || !sList.get(sList.size() - 1).equals('[')) {
                        return false;
                    } else {
                        sList.remove(sList.size() - 1);
                        break;
                    }
            }
        }
        if (sList.size() == 0 || sList == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }
}

/**
 * 21. 合并两个有序链表
 */

/**
 * 单向链表
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 26. 删除排序数组中的重复项
 */
class Solution26 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int arrLen = nums.length;
        int i = 0, j = 1;
        while (i < arrLen && j < arrLen) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                j++;
            } else
                j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}

/**
 * 27. 移除元素
 */
class Solution27 {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (nums == null || len == 0) return 0;
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
        System.out.println(removeElement(nums, 2));
    }
}

/**
 * 28. 实现strStr()
 * 返回haystack中第一次出现needle的位置索引
 */
class Solution28 {
    public int strStr(String haystack, String needle) {
        //String的indexOf()方法源代码
        return haystack.indexOf(needle);
    }
}

/**
 * 35. 搜索插入位置
 */
class Solution35 {
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        int len = right - left + 1;
        if (len == 0) return right + 1;

        if (len == 1) {
            if (nums[left] == target) return left;
            else if (nums[left] < target) return left + 1;
            else return left;
        }

        int mid = left + len / 2;
        if (target == nums[mid]) return mid;
        else if (target > nums[mid]) return binarySearch(nums, mid + 1, right, target);
        else return binarySearch(nums, left, mid - 1, target);

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 8, 9, 10};
        int[] nums1 = {1, 3, 5};
        System.out.println(searchInsert(nums1, 4));
    }
}

/**
 * 38 报数
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
class Solution38 {
    public static String[] strArr = new String[30];

    public static void main(String[] args) {
        strArr[0] = "1";
        strArr[1] = "11";
        System.out.println(countAndSay(9));
    }

    public static String countAndSay(int n) {

        while (strArr[n - 1] == null) {
            if (strArr[n - 2] != null) {
                strArr[n - 1] = count(strArr[n - 2]);
            } else {
                strArr[n - 2] = countAndSay(n - 1);
            }
        }
        return strArr[n - 1];
    }

    private static String count(String s) {
        char[] sChar = s.toCharArray();
        //存放字符
        List<Character> charList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < sChar.length; i++) {
            int index = charList.indexOf(sChar[i]);
            if (index != -1) {
                int val = countList.get(index);
                countList.set(index, val + 1);
            } else {
                charList.add(sChar[i]);
                countList.add(1);
            }
        }

        StringBuffer countSb = new StringBuffer();
        for (int i = 0; i < charList.size(); i++) {
            countSb.append(countList.get(i));
            countSb.append(charList.get(i));
        }

        return countSb.toString();
    }
}

/**
 * 53. 最大子序和
 */
class Solution53 {
    /**
     * 动态规划
     * * 最重要考虑子问题与主问题的联系
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] numsDp = new int[len];
        numsDp[0] = nums[0];
        int max = numsDp[0];
        for (int i = 1; i < len; i++) {
            numsDp[i] = nums[i] + (numsDp[i - 1] > 0 ? numsDp[i - 1] : 0);
            max = Math.max(max, numsDp[i]);
        }
        return max;
    }

    /**
     * 无需动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum > maxsum)
                maxsum = sum;

            if (sum < 0)
                sum = 0;

        }

        return maxsum;
    }
}

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * lastIndexOf()
 */
class Solution58 {
    public static int lengthOfLastWord(String s) {
        if (s.equals(" ") || s.trim().equals("")) {
            return 0;
        }

        int last = s.lastIndexOf(' ');

        int len = s.length() - s.lastIndexOf(" ") - 1;
        if (len > 0) {
            return len;
        }

        int sum = 0;
        for (int i = last - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                sum++;
            } else if (s.charAt(i) == ' ' && sum != 0) {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }
}

/**
 * 66. 加一
 */
class Solution66 {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int j = len - 1; j >= 0; j--) {
            if (digits[j] != 9) {
                digits[j]++;
                return digits;
            }
            digits[j] = 0;
        }

        int[] newDigits = new int[len + 1];
        newDigits[0] = 1;
        return newDigits;

    }

    public static void main(String[] args) {
        for (int i : plusOne(new int[]{9})) {
            System.out.print(i + ",");
        }
    }
}