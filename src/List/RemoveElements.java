package List;

/**
 * @author Li Hui
 */
public class RemoveElements {
    /**
     * 203. 移除链表元素
     *
     * @param head 头节点
     * @param val  整数
     * @return 删除链表中所有满足 Node.val == val 的节点，并返回新的头节点
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(6);
        RemoveElements re = new RemoveElements();
        re.removeElements(node, 6);
    }
}
