package List;

/**
 * @author Lihui
 */
public class MiddleNode {
    /**
     * 876. 链表的中间结点
     *
     * @param head 头节点
     * @return 返回链表的中间结点，如果有两个中间结点，则返回第二个中间结点
     */
    public ListNode middleNode(ListNode head) {
        // 思路同 第 142 题：环形链表 II
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // slow指针走一步
            slow = slow.next;
            // fast指针走两步
            fast = fast.next.next;
        }

        return slow;
    }
}
