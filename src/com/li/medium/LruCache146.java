package com.li.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * · LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * · int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * · void put(int key, int value)
 *   如果关键字 key 已经存在，则变更其数据值 value ；
 *   如果不存在，则向缓存中插入该组 key-value 。
 *   如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 10^5
 * 最多调用 2 * 10^5 次 get 和 put
 */
public class LruCache146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 [1=1]
        lRUCache.put(2, 2); // 缓存是 [1=1, 2=2]
        System.out.print(lRUCache.get(1) + " ");    // 返回 1
        lRUCache.put(3, 3); //该操作会使得关键字 2 作废，缓存是 [1=1, 3=3]
        System.out.print(lRUCache.get(2) + " ");    // 返回 -1 (未找到)
        lRUCache.put(4, 4); //该操作会使得关键字 1 作废，缓存是 [4=4, 3=3]
        System.out.print(lRUCache.get(1) + " ");    // 返回 -1 (未找到)
        System.out.print(lRUCache.get(3) + " ");    // 返回 3
        System.out.print(lRUCache.get(4) + " ");    // 返回 4
    }
}
/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/**
 * 官方：哈希表+双向链表
 */
class LRUCache {

    /**
     * 双向链表-数据结构
     */
    static class DLinkedNode {
        /**
         * 节点key
         */
        private Integer key;
        /**
         * 节点值
         */
        private Integer val;
        /**
         * 节点的上一个节点
         */
        private DLinkedNode prev;
        /**
         * 节点的下一个节点
         */
        private DLinkedNode next;


        public DLinkedNode(Integer key, Integer val) {
            this.next = null;
            this.prev = null;
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 当前待放置位置
     */
    private int size;
    /**
     * 容量
     */
    private int capacity;
    /**
     * 数值链表头部
     */
    private DLinkedNode head;
    /**
     * 数值链表尾部
     */
    private DLinkedNode tail;
    /**
     * 值映射
     */
    private Map<Integer, DLinkedNode> keyMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DLinkedNode(-1, -1);
        this.tail = new DLinkedNode(-2, -1);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public int get(int key) {
        if (keyMap.containsKey(key)) {
            DLinkedNode valueNode = keyMap.get(key);
            removeToHead(valueNode);
            return valueNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            DLinkedNode valueNode = keyMap.get(key);
            valueNode.val = value;
            removeToHead(valueNode);
        } else {
            DLinkedNode valueNode = new DLinkedNode(key, value);
            if (size < capacity) {
                insertToHead(valueNode);
                size++;
            } else {
                DLinkedNode removeTail = deleteTail();
                keyMap.remove(removeTail.key);
                insertToHead(valueNode);
            }
            keyMap.put(key, valueNode);
        }
    }

    private void insertToHead(DLinkedNode valueNode) {
        DLinkedNode headNext = head.next;
        head.next = valueNode;
        valueNode.prev = head;
        valueNode.next = headNext;
        headNext.prev = valueNode;
    }

    private void removeToHead(DLinkedNode node) {
        DLinkedNode pre = node.prev;
        DLinkedNode next = node.next;
        pre.next = next;
        next.prev = pre;

        insertToHead(node);
    }

    private DLinkedNode deleteTail() {
        DLinkedNode tailNode = tail.prev;
        DLinkedNode prevTail = tailNode.prev;
        prevTail.next = tail;
        tail.prev = prevTail;
        return tailNode;
    }
}


