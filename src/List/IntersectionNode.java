package List;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author lihui
 */
public class IntersectionNode {
    /**
     * 面试题 02.07. 链表相交
     *
     * @param headA 头节点
     * @param headB 头节点
     * @return 找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 算法空间复杂度大，不满足O(1)要求
        ListNode dummyHeadA = new ListNode();
        dummyHeadA.next = headA;
        ListNode dummyHeadB = new ListNode();
        dummyHeadB.next = headB;

        Deque<ListNode> dequeA = new LinkedList<>();
        Deque<ListNode> dequeB = new LinkedList<>();
        for (ListNode tmp = dummyHeadA; tmp != null; tmp = tmp.next) {
            dequeA.push(tmp);
        }
        for (ListNode tmp = dummyHeadB; tmp != null; tmp = tmp.next) {
            dequeB.push(tmp);
        }

        ListNode intersectionNodePre;
        while (!dequeA.isEmpty() && !dequeB.isEmpty()) {
            intersectionNodePre = dequeA.peek();
            if (dequeA.pop() != dequeB.pop()) {
                return intersectionNodePre.next;
            }
        }

        return null;
    }

    // Best：可以让p1遍历完链表A之后开始遍历链表B，让p2遍历完链表B之后开始遍历链表A，
    // 这样相当于「逻辑上」两条链表接在了一起，可以同时到达公共部分
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // 或者将两个链表的尾部对齐
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        int sizeA = 0, sizeB = 0;
        while (pA != null) {
            ++sizeA;
            pA = pA.next;
        }
        while (pB != null) {
            ++sizeB;
            pB = pB.next;
        }

        // 让headA指向较长的链表，便于后续操作
        if (sizeB > sizeA) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }

        int diff = Math.abs(sizeA - sizeB);
        while (diff > 0) {
            headA = headA.next;
            --diff;
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
