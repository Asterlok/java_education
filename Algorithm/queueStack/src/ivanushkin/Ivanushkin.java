package ivanushkin;

import java.util.Scanner;

public class Ivanushkin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();

        /** ОЧЕРЕДЬ */

        System.out.println("\tQUEUE");
        System.out.println(">> How much to INSERT: ");
        int size_ins = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size_ins; i++) {
            q.push(i + 10);
        }
        q.printQueue();

        System.out.println(">> How much to DELETE: ");
        int size_del = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size_del; i++) {
            q.pop();
        }
        q.printQueue();

        System.out.println(">> How much to INSERT: ");
        int size_ins2 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < size_ins2; i++) {
            q.push(i + 100);
        }
        q.printQueue();

        System.out.print("\nSize is: ");
        System.out.println(q.size());

        /** СТЭК */

        System.out.println("\n\tSTACK\t");
        System.out.println(">> Size of Stack: ");
        int size_stack = Integer.parseInt(sc.nextLine());
        Stack s = new Stack(size_stack);

        // заполняю стэк
        for (int i = 20; i < size_stack + 20; i++) {
            s.push(i);
        }
        s.showStack();
        s.showSize();

        System.out.println("\n>> How much elements to DELETE: ");
        int total_del = Integer.parseInt(sc.nextLine());
        // удаляю элементы
        for (int j = 0; j < total_del; j++) {
            s.pop();
        }
        s.showStack();
        s.showSize();

        System.out.println("\n>> How much elements to INSERT: ");
        int total_insert = Integer.parseInt(sc.nextLine());
        for (int j = 1; j <= total_insert; j++) {
            s.push(j);
        }
        s.showStack();
        s.showSize();
    }
}