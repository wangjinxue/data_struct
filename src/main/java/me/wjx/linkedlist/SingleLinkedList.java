package me.wjx.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author wjx
 * @date 2018/6/4 17:50
 * 单项链表 只是从头往下进行遍历
 */
public class SingleLinkedList<T> implements Iterable<T> {
    private int size;
    private Node head;

    public int size() {
        return this.size;
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public T addHead(T obj) {
        Node newHead = new Node(obj);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    /**
     * 删除头
     * @return
     */
    public T deleteHead(){
        if(isEmpty()){
            return null;
        }
        T obj=head.data;
        if(size==1){
            head=null;
        }else{
            head=head.next;
        }
        size--;
        return obj;
    }

    /**
     * 查找
     *
     * @param obj
     * @return
     */
    public Node find(T obj) {
        Node current = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            }
            current = current.next;
            tempSize--;
        }
        return null;
    }

    public boolean delete(T value) {
        if (size == 0) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == head) {
            head = current.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.print("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                //判断是否是头节点
                if (node.equals(head)) {
                    System.out.print("[" + node.data + ">");
                } else if (node.next == null) {
                    //判断当前节点是否是结尾
                    System.out.print(node.data + "]");
                } else {
                    //中间节点
                    System.out.print(node.data + "->");
                }
                //当前节点赋值给下一个节点
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {
            System.out.print("[]");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr(head);
    }

    private class Itr implements Iterator {
        private Node head;

        public Itr(Node head) {
            this.head = head;
        }

        @Override
        public Object next() {
            if(head==null){
                throw new NoSuchElementException("NoSuchElementException");
            }
            T t = head.data;
            head = head.next;
            return t;
        }

        /**
         * 判断是否有节点
         *
         * @return
         */
        @Override
        public boolean hasNext() {

            if (head==null) {
                return false;
            } else {
//                System.out.println("head.data:"+head.data+",header.next:"+head.next);
                return true;
            }
        }
    }
}
