package List;

/**
 * @author Lihui
 */
public class AddTwoNumbers {
    /**
     * 2. 两数相加
     *
     * @param l1 非空的链表
     * @param l2 非空的链表
     * @return 它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。将两个数相加，并以相同形式返回一个表示和的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, pre = l2;
        int sum = 0, curBit = 0, carryBit = 0;

        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carryBit;
            curBit = sum % 10;
            p2.val = curBit;
            carryBit = sum / 10;
            p1 = p1.next;
            pre = p2;
            p2 = p2.next;
        }

        ListNode p = p1 == null ? p2 : p1;
        pre.next = p;
        while (p != null) {
            sum = p.val + carryBit;
            curBit = sum % 10;
            p.val = curBit;
            carryBit = sum / 10;
            pre = p;
            p = p.next;
        }

        if (carryBit == 1) {
            pre.next = new ListNode(carryBit);
        }

        return l2;
    }
}
