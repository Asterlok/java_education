package ivanushkin;

public class Queue {

    private int start;
    private int[] my_queue;
    private int end;
    private int count = 0;

    public Queue() {
        start = -1;
        end = 0;
        my_queue = new int[1];

    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int value) {
        if (size() == my_queue.length) {
            end = my_queue.length;
            resize(2 * my_queue.length);
        }
        if (isEmpty())
            start = end;
        my_queue[end] = value;
        end = (end + 1) % my_queue.length;
        count++;
    }

    public int pop() {
        assert (start >= 0);
        int item = my_queue[start];
        count--;
        my_queue[start] = 0;
        start = (start + 1) % my_queue.length;
        if (count == my_queue.length / 4) {
            System.out.println("resize");
            resize(my_queue.length / 2);
            end = my_queue.length / 2;
        }
        System.out.println("Remove:" + item);
        return item;
    }

    public void resize(int new_size) {
        int[] new_array = new int[new_size];
        int old_size = my_queue.length;
        int i = start;
        int limit = (start < end) ? end : old_size;
        for (i = start; i < limit; i++) {
            new_array[i - start] = my_queue[i];
        }
        if (end < start) {
            for (int j = 0; j < end; j++) {
                new_array[i] = my_queue[j];
                i++;
            }
        }
        start = 0;
        my_queue = new_array;
    }

    public void printQueue() {
        System.out.println();
        int g = 0;
        System.out.println("front index --> 0");
        for (int s : my_queue) {
            if (s != 0) {
                System.out.print(s + " ");
                g++;
            }
        }
        int len = my_queue.length;
        System.out.println("\ntail index --> " + (g - 1));
    }
}