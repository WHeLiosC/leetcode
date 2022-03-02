package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lihui
 */
public class FourSumCount {
    /**
     * 454. 四数相加 II
     *
     * @param nums1 整数数组
     * @param nums2 整数数组
     * @param nums3 整数数组
     * @param nums4 整数数组
     * @return 有多少个元组 (i, j, k, l) 能满足和为 0
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 暴力超时
//        int count = 0;
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                for (int k = 0; k < nums3.length; k++) {
//                    for (int l = 0; l < nums4.length; l++) {
//                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
//                            ++count;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        // 先计算前两个数组的和
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // 在后两个数组中找相反数
        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                int sum = nums3[k] + nums4[l];
                if (map.containsKey(-sum)){
                    count += map.get(-sum);
                }
            }
        }
        return count;
    }
}
