package io.github.gamelmw.video.array.dynamic_arrays;

/*
 * 动态数组
 * */

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;//逻辑大小
    private int capacity = 8;//容量
    private int[] array = {};//初始数组


    //末尾添加
    //element: 添加的元素
    public void addLast(int element) {
        add(size, element);
    }


    //指定位置添加
    //index: 索引
    //element: 添加的元素
    public void add(int index, int element) {
        checkAndGrow();

        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    //扩容
    private void checkAndGrow() {
        //容量检查
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            //进行扩容，扩容为原来的1.5倍
            capacity += capacity >> 1;
            int newArray[] = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }


    //获取
    //index: 索引
    public int get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("index:" + index + " size:" + size);
        }
    }


    //遍历
    //consumer: 遍历的消费者
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
            consumer.accept(array[i]);
        }
    }

    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int i = 0;

            @Override
            public boolean hasNext() {//有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() {//返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }

    //流遍历
    public IntStream stream() {
        return IntStream.of(array).limit(size);
    }


    //删除
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1,
                    array, index, size - index - 1);
        }
        size--;
        return removed;
    }
}
