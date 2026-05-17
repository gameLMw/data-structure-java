package io.github.gamelmw.video.stack;

public interface Stack<E> {
    // 入栈
    // e: 入栈元素
    // return: 入栈成功返回true，栈满返回false
    boolean push(E e);

    // 出栈
    // return: 出栈元素，栈为空返回null
    E pop();

    // 栈顶元素
    // return: 栈顶元素，栈为空返回null
    E peek();

    // 栈是否为空
    // return: 栈为空返回true，否则返回false
    boolean isEmpty();

    // 栈是否已满
    // return: 栈已满返回true，否则返回false
    boolean isFull();
}
