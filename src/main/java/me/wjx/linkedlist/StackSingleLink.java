package me.wjx.linkedlist;

/**
 * @author wjx
 * @date 2018/6/5 15:15
 */
public class StackSingleLink<T> {
    private SingleLinkedList<T> link;

    public StackSingleLink() {
        link = new SingleLinkedList<>();
    }

    public void push(T t) {
        link.addHead(t);
    }

    public T pop() {
        return link.deleteHead();
    }

    public void display(){
        link.display();
    }

    public boolean isEmpty(){
        return link.isEmpty();
    }

    public int size() {
        return link.size();
    }
}
