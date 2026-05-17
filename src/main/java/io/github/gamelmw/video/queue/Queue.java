package io.github.gamelmw.video.queue;

public interface Queue<E> {
    //入队
    //e: 入队元素
    //return: 入队成功返回true，栈满返回false
    boolean offer(E e);

    //出队
    //return: 出队元素，栈为空返回null
    E poll();

    //队首元素
    //return: 队首元素，栈为空返回null
    E peek();

    //是否为空
    //return: 为空返回true，否则返回false
    boolean isEmpty();

    //是否已满
    //return: 已满返回true，否则返回false
    boolean isFull();
}
