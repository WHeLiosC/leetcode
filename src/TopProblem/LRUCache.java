package TopProblem;

import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * @author lihui
 */
public class LRUCache {
    /**
     * 双向链表的节点类
     */
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> cache;
    private Node dummyHead;
    private Node dummyTail;
    private int size;
    private final int maxCapacity;
    private ScheduledExecutorService scheduledExecutorService;

    public LRUCache(int capacity) {
        size = 0;
        maxCapacity = capacity;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        cache = new HashMap<>(maxCapacity);
        scheduledExecutorService = new ScheduledThreadPoolExecutor(3);
    }

    public synchronized int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public synchronized void put(int key, int value) {
        Node node = cache.get(key);
        // 如果已经存在，则更新放到头部
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node toInsertNode = new Node(key, value);
            // 如果缓存已满，要先移除尾节点
            if (size >= maxCapacity) {
                Node toDeleteNode = removeTail();
                cache.remove(toDeleteNode.key);
                --size;
            }
            cache.put(key, toInsertNode);
            addToHead(toInsertNode);
            ++size;
        }
    }

    public synchronized void putWithExpireTime(int key, int value, long expireTime) {
        Node node = cache.get(key);
        // 如果已经存在，则更新放到头部
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node toInsertNode = new Node(key, value);
            // 如果缓存已满，要先移除尾节点
            if (size >= maxCapacity) {
                Node toDeleteNode = removeTail();
                cache.remove(toDeleteNode.key);
                --size;
            }
            cache.put(key, toInsertNode);
            // 超过预定时间移除
            if (expireTime > 0) {
                removeAfterExpireTime(key, expireTime);
            }
            addToHead(toInsertNode);
            ++size;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private Node removeTail() {
        Node node = dummyTail.prev;
        removeNode(node);
        return node;
    }

    private void removeAfterExpireTime(int key, long expireTime) {
        scheduledExecutorService.schedule(() -> {
            removeNode(cache.remove(key));
        }, expireTime, TimeUnit.MILLISECONDS);
    }

    public int size() {
        return size;
    }
}
