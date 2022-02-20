package List;

/**
 * @author Li Hui
 * <p>
 * 707. 设计链表
 */
public class MyLinkedList {
    private ListNode dummyHead;
    private int size;

    public MyLinkedList() {
        dummyHead = new ListNode();
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            ListNode pointer = dummyHead;
            int counter = 0;
            while (counter <= index) {
                pointer = pointer.next;
                ++counter;
            }
            return pointer.val;
        }
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        ++size;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode pointer = dummyHead;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = newNode;
        ++size;
    }

    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index <= 0) {
            addAtHead(val);
        } else if (index < size) {
            ListNode newNode = new ListNode(val);
            ListNode pointer = dummyHead;
            int counter = 0;
            while (counter < index) {
                pointer = pointer.next;
                ++counter;
            }
            newNode.next = pointer.next;
            pointer.next = newNode;
            ++size;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            ListNode pre = dummyHead;
            ListNode cur = dummyHead.next;
            int counter = 0;
            while (counter < index) {
                pre = cur;
                cur = cur.next;
                ++counter;
            }
            pre.next = cur.next;
            --size;
        }
    }

    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        //链表变为1-> 2-> 3
        linkedList.addAtIndex(1,2);
        //返回2
        linkedList.get(1);
        //现在链表是1-> 3
        linkedList.deleteAtIndex(1);
        //返回3
        linkedList.get(1);
    }
}
