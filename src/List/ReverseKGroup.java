package List;

/**
 * @author lihui
 */
public class ReverseKGroup {
    /**
     * 25. K 个一组翻转链表
     *
     * @param head 头结点
     * @param k    正整数，小于或等于链表的长度
     * @return 每 k 个节点一组进行翻转，请你返回修改后的链表。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        // 记录待翻转子链表的前驱结点和后继节点
        ListNode precursor = dummyHead;
        ListNode successor = dummyHead;
        // 记录待翻转子链表的开始节点和结束节点
        ListNode start = dummyHead;
        ListNode end = dummyHead;

        while (end.next != null) {
            // 寻找 k 个节点，不够 k 个则返回
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummyHead.next;
                }
            }
            start = precursor.next;

            // 记录后继
            successor = end.next;
            // 断开连接
            end.next = null;
            // 翻转链表
            precursor.next = reverseList(start);
            // 建立连接
            start.next = successor;
            // 下一次循环的初始变量
            precursor = start;
            end = precursor;
        }
        return dummyHead.next;
    }

    private ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
