package HashTable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author lihui
 */
public class IntersectionArray {
    /**
     * 349. 两个数组的交集
     *
     * @param nums1 数组
     * @param nums2 数组
     * @return 返回两个数组的交集
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        return set1.stream().mapToInt(i -> i).toArray();
    }
}
