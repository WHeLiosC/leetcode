package DynamicProgramming;

/**
 * @author lihui
 */
public class Fibonacci {
    /**
     * 509. 斐波那契数 (递归)
     *
     * @param n 整数
     * @return 第 n 个斐波那契数
     */
    public int fib(int n) {
        if (n <= 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 509. 斐波那契数 (迭代)
     *
     * @param n 整数
     * @return 第 n 个斐波那契数
     */
    public int fibR(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }
}
