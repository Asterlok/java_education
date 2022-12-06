package Algos;

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Alko_rhythm s = new Alko_rhythm();
        int[] mySet;
        System.out.println("\tTEST SETS");
        int[] test1 = {10, 16, 15, 2, 3, 14, 4, 18, 8, 11, 7};
        int testTarget1 = 30;
        System.out.print("\t1. Test array: ");
        for (int a : test1) {
            System.out.print(a + "  ");
        }
        System.out.println("\nTarget: " + testTarget1);
        System.out.println(s.targetSum(test1, testTarget1) + "\n");


        int[] test2 = {34, 54, 11, 26, 49, 51, 66, 8, 2, 44, 55, 33, 29, 32, 12, 28, 5, 9};
        int testTarget2 = 100;
        System.out.print("\t2. Test array: ");
        for (int a : test2) {
            System.out.print(a + "  ");
        }
        System.out.println("\nTarget: " + testTarget2);
        System.out.println(s.targetSum(test2, testTarget2) + "\n");


        int[] test3 = {5, 2, 3, 1, 11, 6, 4, 7, 15, 16, 20};
        int testTarget3 = 15;
        System.out.print("\t3. Test array: ");
        for (int a : test3) {
            System.out.print(a + "  ");
        }
        System.out.println("\nTarget: " + testTarget3);
        System.out.println(s.targetSum(test3, testTarget3) + "\n");

        System.out.print(">> Random size of array: ");
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        mySet = new int[length];
        System.out.print("\tRandom array: ");
        for (int i = 0; i < length; i++) {
            int num = rand.nextInt(20);
            System.out.print(num + "  ");
            mySet[i] = num;
        }
        System.out.print("\n>> Target: ");
        int target = Integer.parseInt(sc.nextLine());
        System.out.println(s.targetSum(mySet, target));
    }
}