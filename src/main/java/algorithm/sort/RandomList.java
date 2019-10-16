package algorithm.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 将一个数组顺序随机打乱，每个位置出现的几率相同
 */
public class RandomList {

    public static void main(String[] args) {
        int[] input = new int[10000];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }
        long start = System.currentTimeMillis();
        System.out.println("input:" + Arrays.toString(input));
        int[] result1 = randomList(input);
        System.out.println("randomList cost:" + (System.currentTimeMillis() - start));
        System.out.println("randomList output:" + Arrays.toString(result1));
        System.out.println("input:" + Arrays.toString(input));
        start = System.currentTimeMillis();
        int[] result2 = createSolution1(input);
        System.out.println("createSolution1 cost:" + (System.currentTimeMillis() - start));
        System.out.println("createSolution1 output:" + Arrays.toString(result2));

    }

    public static int[] randomList(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        List<Integer> inputList = new LinkedList<Integer>();
        for (int i : nums) {
            inputList.add(nums[i]);
        }
        int[] result = new int[nums.length];
        Random random = new Random();
        for (int i = 0; inputList.size() > 0; i++) {
            result[i] = inputList.remove(random.nextInt(inputList.size()));
        }
        return result;
    }

    public static int[] createSolution1(int[] solutionArr) {
        int len = solutionArr.length;
        int endIndex = len / 2, ranIndex1 = 0, ranIndex2 = 0;
        Random random = new Random();
        for (int i = 0; i <= endIndex; i++) {
            ranIndex1 = random.nextInt(len);
            ranIndex2 = random.nextInt(len);
            while (ranIndex1 == ranIndex2)
                ranIndex2 = random.nextInt(len);
            swap(solutionArr, ranIndex1, ranIndex2);
        }
        return solutionArr;
    }

    public static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

}
