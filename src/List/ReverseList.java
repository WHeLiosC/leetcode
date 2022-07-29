package List;

/**
 * @author lihui
 */
public class ReverseList {
    /**
     * 206. 反转链表
     *
     * @param head 单链表的头节点 head
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 递归法(难理解)
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 92. 反转链表 II
     *
     * @param head  单链表的头指针
     * @param left  整数
     * @param right 整数
     * @return 反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head, start = null;
        // left - 1 索引从 1 开始
        for (int i = 0; i < left - 1; i++) {
            pre = cur;
            cur = cur.next;
        }

        start = cur;

        for (int i = 0; i < right - left; i++) {
            ListNode next = start.next;
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);

        ReverseList r = new ReverseList();
        r.reverseList(n5);
    }
}
