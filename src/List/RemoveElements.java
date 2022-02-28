package List;

import java.util.*;

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

    /**
     * 19. 删除链表的倒数第 N 个结点
     *
     * @param head 头结点
     * @param n    正整数
     * @return 删除链表的倒数第 n 个结点，并且返回链表的头结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;

        // 遍历得到链表的长度
        for (int i = 1; cur != null; i++, cur = cur.next) {
            map.put(i, pre);
            pre = cur;
        }

        int size = map.size();
        ListNode removeNodePre = map.get(size - n + 1);
        removeNodePre.next = removeNodePre.next.next;

        return dummyHead.next;
    }

    // 使用栈结构
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<ListNode>();
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur != null) {
            deque.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            deque.pop();
        }
        ListNode pre = deque.peek();
        pre.next = pre.next.next;
        return dummyHead.next;
    }

    // 使用快慢指针
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode fast = head;
        ListNode slow = dummyHead;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(6);
        RemoveElements re = new RemoveElements();
        re.removeElements(node, 6);
    }
}
