package algorithm.sort;

import java.util.Arrays;

/**
 * 给定一个正整数，实现一个方法来求出离该整数最近的大于自身的“换位数”。
 * 什么是换位数呢？就是把一个整数各个数位的数字进行全排列，从而得到新的整数。例如53241和23541。
 * 小灰也不知道这种经过换位的整数应该如何称呼，所以姑且称其为“换位数”。
 * 题目要求写一个方法来寻找最近的且大于自身的换位数。比如下面这样：
 * <p>
 * 输入12345，返回12354
 * <p>
 * 输入12354，返回12435
 * <p>
 * 输入12435，返回12453
 * https://mp.weixin.qq.com/s/xyEX-_V6EPmo_X1xl6ZMaw
 */
public class SwitchNumber {
    public static int[] findNerestNumber(int[] numbers) {
        int[] numberCopy = Arrays.copyOf(numbers,numbers.length);
        int index = findeTransferPoint(numberCopy);
        return numberCopy;
    }

    private static int findeTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 1; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

}
