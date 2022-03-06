package StackAndQueue;

import java.util.*;

/**
 * @author Lihui
 */
public class MaxSlidingWindow {
    /**
     * 239. 滑动窗口最大值
     *
     * @param nums 整数数组
     * @param k    大小为 k 的滑动窗口
     * @return 返回滑动窗口中的最大值的集合
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        int index = 0;
        result[index++] = maxInWindow(nums, 0, k);

        for (int i = 0; i < length - k; i++) {
            if (nums[i + k] >= result[index - 1]) {
                result[index++] = nums[i + k];
            } else {
                if (nums[i] < result[index - 1]) {
                    result[index] = result[index - 1];
                    ++index;
                } else {
                    result[index++] = maxInWindow(nums, i + 1, i + k + 1);
                }
            }
        }

        return result;
    }

    private int maxInWindow(int[] nums, int left, int right) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (left < right) {
            pq.offer(nums[left++]);
        }
        return pq.peek();
    }

    // 超时
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        int index = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        result[index++] = pq.peek();

        for (int i = k; i < length; i++) {
            pq.remove(nums[i - k]);
            pq.offer(nums[i]);
            result[index++] = pq.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
        m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
