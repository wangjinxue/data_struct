package me.wjx.stack;

/**
 * @author wjx
 * @date 2018/6/7 10:08
 */
public interface Stack<T> {
    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     *
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素
     */
    T peek();

    /**
     * 移除栈顶数据并返回
     */
    T pop();

    int size();
}
