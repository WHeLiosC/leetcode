package List;

import java.util.PriorityQueue;

/**
 * @author lihui
 */
public class MergeTwoLists {
    /**
     * 21. 合并两个有序链表
     *
     * @param list1 升序链表
     * @param list2 升序链表
     * @return 合并后的新的升序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode pre = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        pre.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }

    /**
     * 23. 合并K个升序链表
     *
     * @param lists 链表数组,每个链表都已经按升序排列
     * @return 将所有链表合并到一个升序链表中，返回合并后的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode tmp = null;
        for (int i = 0; i < lists.length; i++) {
            tmp = mergeTwoLists(tmp, lists[i]);
        }
        return tmp;
    }

    // 优先队列方法
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }
        while (!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            p.next = node;
            if(node.next != null){
                priorityQueue.add(node.next);
            }
            p = p.next;
        }
        return dummyHead.next;
    }
}
