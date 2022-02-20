package List;

/**
 * @author Li Hui
 * <p>
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    List.ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, List.ListNode next) {
        this.val = val;
        this.next = next;
    }
}
