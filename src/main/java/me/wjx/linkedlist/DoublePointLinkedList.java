package me.wjx.linkedlist;

/**
 * @author wjx
 * @date 2018/6/5 16:37
 */
public class DoublePointLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public Node findFromLast(Object s) {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            if (s.equals(tail.data)) {
                return tail;
            } else {
                return null;
            }
        } else {
            Node node = tail;
            int tempSize=size;
            while(tempSize>0){
                if(node.data.equals(s)){
                    return node;
                }
                tempSize--;
                node=node.precious;
            }
        }


        return null;
    }

    public Node findFromFirst(Object s) {
        return null;
    }

    private  class Node {
        private Object data;
        private Node next;
        private Node precious;

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next.data +
                    ", precious=" + precious.data +
                    '}';
        }
    }

    public DoublePointLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void addHead(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
            head.next.precious = head;
        }
        size++;
    }

    public void addTail(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.precious=tail;
            tail = node;
        }
        size++;
    }

    public boolean deleteHead() {
        if (size == 0) {
            return false;
        }
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.println("[" + node.data + "]");
            } else {
                while (tempSize > 0) {
                    if (node.equals(head)) {
                        System.out.print("[" + node.data + "->");
                    } else if (node.next == null) {
                        System.out.print(node.data + "]");
                    } else {
                        System.out.print(node.data + "->");
                    }
                    tempSize--;
                    node = node.next;
                }
            }
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }


}
