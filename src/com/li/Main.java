package com.li;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //System.out.println(" "+'b'+1);
        String[] i = {"0", "2", "5", "7"};
        //System.out.println(i[0]+i[1]+i[2] +i[3]);
        int seg = (int) (Math.random() * 3);
        System.out.println(seg);

    }
}


class A {
    private int a;

    private int getA() {
        return a;
    }

}

class B extends A {

    public int b;

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

    {
        i = 2;
        s = "实例初始化";
        System.out.println(s);
    }

    public TestABC() {
        i = 3;
        s = "构造方法";
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

class Test {
    Object o = new Object();
    String s = new String();
    StringBuffer sbuf = new StringBuffer();
    StringBuilder sbui = new StringBuilder();
}


