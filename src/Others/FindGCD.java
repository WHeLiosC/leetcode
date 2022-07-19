package Others;

/**
 * @author lihui
 */
public class FindGCD {
    /**
     * 1979. 找出数组的最大公约数
     *
     * @param nums 整数数组
     * @return 数组中最大数和最小数的 最大公约数 。
     */
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return gcd(min, max);
    }

    private int gcd(int x, int y) {
        // 辗转相除法
        return y == 0 ? x : gcd(y, x % y);
    }
}
