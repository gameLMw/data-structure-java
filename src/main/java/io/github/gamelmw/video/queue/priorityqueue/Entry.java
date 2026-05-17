package io.github.gamelmw.video.queue.priorityqueue;

public class Entry implements Priority {
    private int value;
    private int priority;

    public Entry(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "value=" + value +
                ", priority=" + priority +
                '}';
    }
}
