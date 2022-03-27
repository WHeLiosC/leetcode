package DynamicProgramming;

import java.util.Scanner;

/**
 * @author lihui
 */
public class KnapsackProblem {
    /**
     * 2. 01背包问题 (acwing)
     * <p>
     * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
     * 第 i 件物品的体积是 vi，价值是 wi。
     * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     * <p>
     * 输入格式：
     * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
     * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
     *
     * @return 输出一个整数，表示最大价值。
     */
    public int zeroOneKnapsack() {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();
        int[] value = new int[n];
        int[] volume = new int[n];
        for (int i = 0; i < n; i++) {
            volume[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        int[] maxValue = new int[v + 1];
        for (int i = 0; i < n; i++) {
            for (int j = v; j >= volume[i]; j--) {
                // 二维递推公式为 f[i][j] = max(f[i-1][j],f[i-1][j-v[i]]+w[i])
                // 在更新的时候，第 i 层的 j 背包容量更新用到了第 i-1 层 j-v[i] 的最大价值
                // 改为一维数组后，相当于把第 i-1 层的值复制到第 i 层
                // 因此更新一维数组时，需要逆序遍历（保证了每个物品只使用一次）
                maxValue[j] = Math.max(maxValue[j], maxValue[j - volume[i]] + value[i]);
            }
        }
        return maxValue[v];
    }

    /**
     * 3. 完全背包问题 (acwing)
     * <p>
     * 有 N 件物品和一个容量是 V 的背包。每种物品都有 无限件 可用。
     * 第 i 件物品的体积是 vi，价值是 wi。
     * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
     * <p>
     * 输入格式：
     * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
     * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。
     *
     * @return 输出一个整数，表示最大价值。
     */
    public int completeKnapsack() {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();
        int[] value = new int[n];
        int[] volume = new int[n];
        for (int i = 0; i < n; i++) {
            volume[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        int[] maxValue = new int[v + 1];
        for (int i = 0; i < n; i++) {
            for (int j = volume[i]; j <= v; j++) {
                // f[i , j ] = max( f[i-1,j] , f[i-1,j-v]+w ,  f[i-1,j-2*v]+2*w , f[i-1,j-3*v]+3*w , .....)
                // f[i , j-v]= max(            f[i-1,j-v]   ,  f[i-1,j-2*v] + w , f[i-1,j-3*v]+2*w , .....)
                // 由上两式，可得出如下递推关系:
                // 二维递推公式为 f[i][j] = max(f[i-1][j],f[i][j-v[i]]+w[i])
                // 在更新的时候，第 i 层的 j 背包容量更新用到了第 i 层 j-v[i] 的最大价值
                // 因此更新一维数组时，需要先更新前面的值，需要正序遍历（保证了每个物品可以多次使用）
                maxValue[j] = Math.max(maxValue[j], maxValue[j - volume[i]] + value[i]);
            }
        }
        return maxValue[v];
    }

    /**
     * 4. 多重背包问题 I (acwing)
     * <p>
     * 有 N 种物品和一个容量是 V 的背包。
     * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
     * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
     * <p>
     * 输入格式：
     * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
     * 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
     *
     * @return 输出一个整数，表示最大价值。
     */
    public int multipleKnapsack() {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();
        int[] value = new int[n];
        int[] volume = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            volume[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
            nums[i] = scanner.nextInt();
        }

        int[] maxValue = new int[v + 1];
        for (int i = 0; i < n; i++) {
            for (int j = v; j >= volume[i]; j--) {
                // 遍历物品数量，每一次放进 k 件物品或者不放，相当于01背包问题
                for (int k = 1; k * volume[i] <= j && k <= nums[i]; k++) {
                    maxValue[j] = Math.max(maxValue[j], maxValue[j - k * volume[i]] + k * value[i]);
                }
            }
        }
        return maxValue[v];

        // 或者直接将每一件物品放入其对应数量次，变成一个01背包问题
    }

    public static void main(String[] args) {
        KnapsackProblem kp = new KnapsackProblem();
        System.out.println(kp.zeroOneKnapsack());
    }
}
