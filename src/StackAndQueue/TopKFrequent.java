package StackAndQueue;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Lihui
 */
public class TopKFrequent {
    /**
     * 347.前 K 个高频元素
     * @param nums 非空的整数数组
     * @param k 正整数
     * @return 返回数组中出现频率前 k 高的元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 优先级队列，默认情况下数值越小优先级越高
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((Comparator.comparingInt(Map.Entry::getValue)));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
}
