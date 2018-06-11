package me.wjx.stack;

import java.util.EmptyStackException;

/**
 * @author wjx 以数组为基础的栈
 * @date 2018/6/7 10:11
 */
public class OrderStack<T> implements Stack<T> {
    /**
     * 初始容量
     */
    T[] objects;
    private int capacity = 10;
    /**
     * 栈顶索引
     */
    private int top = -1;
    /**
     * 保存数组实际长度
     */
    private int size;
    @Override
    public int size(){
        return this.size;
    }

    public OrderStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity can't be lower 1");
        }
        objects = (T[]) new Object[capacity];
    }

    public OrderStack() {
        objects = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public void push(T data) {
        //栈顶
        if (objects.length == size) {
            ensureCapacity(size * 2 + 1);
        }
        objects[++top] = data;
        size++;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return objects[top];
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            new EmptyStackException();
        }
        size--;
        return objects[top--];
    }

    private void ensureCapacity(int capacity) {
        if (capacity < size) {
            return;
        }
        T[] old=objects;
        objects= (T[]) new Object[capacity];
        System.arraycopy(old,0,objects,0,size);
    }

}
