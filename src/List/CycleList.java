package List;

/**
 * @author lihui
 */
public class CycleList {
    /**
     * 141. 环形链表
     *
     * @param head 头节点
     * @return 如果链表中存在环，则返回 true。 否则，返回 false。
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // slow走一步
            slow = slow.next;
            // fast走两步
            fast = fast.next.next;
            // 相遇则有环
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // 闹着玩
    public boolean hasCycle2(ListNode head) {
        long maxNodeNum = 10000;
        for (int i = 0; i < maxNodeNum + 1; i++) {
            if (head == null) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 142. 环形链表 II
     *
     * @param head 头节点
     * @return 返回链表开始入环的第一个节点。如果链表无环，则返回 null。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // slow走一步
            slow = slow.next;
            // fast走两步
            fast = fast.next.next;
            // 相遇则有环
            if (fast == slow) {
                // 将两个指针中的任意一个指向链表头，同步运动，再次相遇即为环入口
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
