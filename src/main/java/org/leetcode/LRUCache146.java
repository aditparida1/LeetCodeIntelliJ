package org.leetcode;

import java.util.HashMap;

public class LRUCache146
{
    DoubleLinkedList head, tail;
    HashMap<Integer, DoubleLinkedList> cache;
    int currSize;
    int capacity;
    public LRUCache146(int capacity)
    {
        this.capacity = capacity;
        currSize = 0;
        cache = new HashMap<>();
        head = new DoubleLinkedList();
        tail = new DoubleLinkedList();
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key)
    {
        if(!cache.containsKey(key))
        {
            return -1;
        }
        DoubleLinkedList node = cache.get(key);
        makeHead(node);
        return node.value;
    }

    public void put(int key, int value)
    {
        if(!cache.containsKey(key))
        {
            currSize++;
            if(currSize > capacity)
            {
                removeTail();
                currSize = capacity;
            }
            DoubleLinkedList node =  new DoubleLinkedList();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            makeHead(node);
        }
        else
        {
            DoubleLinkedList node = cache.get(key);
            node.value = value;
            makeHead(node);
        }
    }
    private void makeHead(DoubleLinkedList node)
    {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void addToTail(DoubleLinkedList node)
    {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
    private void removeTail()
    {
        DoubleLinkedList toRem = tail.prev;
        toRem.prev.next = tail;
        tail.prev = toRem.prev;
        toRem.prev = null;
        toRem.next = null;
    }
}
class DoubleLinkedList
{
    int key, value;
    DoubleLinkedList next, prev;
}

