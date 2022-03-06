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

        // 维护一个单调队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            if (i - k + 1 >= 0) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    /**
     * 在 maxSlidingWindow2 中使用优先级队列时，左边界元素每次滑动后弹出超时；
     * 将优先级队列改为记录值和下标的形式，当堆顶下标不满足时，再调整
     *
     * @param nums 整数数组
     * @param k    大小为 k 的滑动窗口
     * @return 返回滑动窗口中的最大值的集合
     */
    public int[] maxSlidingWindowEnhance(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        int index = 0;

        // 优先级队列中，下标0对应数组下标，下标1对应值
        // 数值相同则按下标排序，否则按照数值排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1] == arr2[1] ? arr2[0] - arr1[0] : arr2[1] - arr1[1]);

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{i, nums[i]});
        }
        result[index++] = pq.peek()[1];

        for (int i = k; i < length; i++) {
            pq.offer(new int[]{i, nums[i]});
            while (pq.peek()[0] <= i - k) {
                pq.poll();
            }
            result[index++] = pq.peek()[1];
        }

        return result;
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

    // 超时
    public int[] maxSlidingWindow3(int[] nums, int k) {
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

    // TODO: 分块 + 预处理
    public int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
        m.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
