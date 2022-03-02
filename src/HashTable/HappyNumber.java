package HashTable;

/**
 * @author lihui
 */
public class HappyNumber {
    /**
     * 202. 快乐数
     * @param n 正整数
     * @return 判断一个数 n 是不是快乐数
     */
    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        // 这里使用与寻找环形链表相同的方法
        // 另外可以使用哈希表来记录出现过的数字，来判断是否存在循环
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int next = 0;
        while (n > 0){
            int d = n % 10;
            n = n / 10;
            next += d * d;
        }
        return next;
    }
}
