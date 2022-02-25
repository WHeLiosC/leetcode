package List;

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
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        ListNode dummyHead = new ListNode();
        dummyHead.next = list1;
        ListNode pre = dummyHead;
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val <= pointer2.val) {
                pre.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                pre.next = pointer2;
                pointer2 = pointer2.next;
            }
            pre = pre.next;
        }

        pre.next = pointer1 == null ? pointer2 : pointer1;

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
}
