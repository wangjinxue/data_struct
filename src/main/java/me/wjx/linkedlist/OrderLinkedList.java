package me.wjx.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author wjx
 * @date 2018/6/5 17:46
 */
public class OrderLinkedList implements Iterable<Integer>{
    private Node head;
    private int size;
    private class Node {
        private int data;
        private Node next;
         Node(int data) {
            this.data = data;
        }
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public OrderLinkedList(){
        head=null;
    }
    public void insert(int value){
        Node node=new Node(value);
        Node pre=null;
        Node current=head;
        while(current!=null&&value>current.data){
            pre=current;
            current=current.next;
        }
        if(pre==null){
            head=node;
            head.next=current;
        }else{
            pre.next=node;
            node.next=current;
        }
        size++;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr(head);
    }

    private class Itr implements Iterator {
        private Node head;

        public Itr(Node head) {
            this.head = head;
        }

        @Override
        public Integer next() {
            if(head==null){
                throw new NoSuchElementException("NoSuchElementException");
            }
            Integer t = head.data;
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
