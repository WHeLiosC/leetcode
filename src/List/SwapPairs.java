package List;

/**
 * @author Lihui
 */
public class SwapPairs {
    /**
     * 24. 两两交换链表中的节点
     *
     * @param head 链表头
     * @return 两两交换其中相邻的节点，返回交换后链表的头节点
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;

        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = cur;
            pre.next = tmp;
            pre = cur;
            cur = cur.next;
            if (cur == null) {
                break;
            }
        }
        return dummyHead.next;
    }

    // 递归解法
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
