package ivanushkin;

import java.util.Arrays;

public class Stack {
    private int[] elements;
    private int size = 0;
    public Stack(int capacity) {
        elements = new int[capacity];
    }

    public void push(int e) {
        resize();
        elements[size++] = e;
    }

    public Object pop() {
        int result = elements[--size];
        elements[size] = 0; // Устранение устаревшей ссылки
        return result;
    }

    /**
     * Убеждаемся, что в стеке есть место хотя бы для одного * элемента; если нет - удваиваем емкость массива.
     */
    private void resize() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public void showSize() {
        System.out.println("\nSize is: " + size);
    }
    public void showStack() {
        System.out.println("Stack: ");
        System.out.println("tail value - " + elements[0]);
        for (int a : elements) {
            if (a != 0) {
                System.out.print(a + "  ");
            }
        }
    }
}
