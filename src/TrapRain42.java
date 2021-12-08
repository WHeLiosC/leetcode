import java.util.*;

/**
 * @author lihui
 */
public class TrapRain42 {
    /**
     * 42. 接雨水 (11-3-21)
     *
     * @param height 柱子高度
     * @return 雨水数
     */
    public int trap(int[] height) {
        int len = height.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(i, height[i]);
        }
        Arrays.sort(height);
        int max = height[0];
        int left = 0, right =0;
        while(left > 0 && right < len){

        }
        return -1;
    }
}
