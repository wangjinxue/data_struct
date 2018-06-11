package me.wjx.stack;

/**
 * @author wjx
 * @date 2018/6/7 11:28
 */
public class LinkedStack<T> implements Stack<T> {
    private Node top;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null || top.data == null;
    }

    @Override
    public void push(T data) {
        if (top == null) {
            top = new Node(data, null);
        } else if (top.data == null) {
            top.data = data;
        } else {
            Node node = new Node(data, top);
            top = node;

        }
        size++;
    }

    @Override
    public T peek() {
        return top.data;
    }

    @Override
    public T pop() {
        T data = top.data;
        //移除当前的top
        top = top.next;
        return data;
    }
}
