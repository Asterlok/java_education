import java.util.Random;
import java.util.Scanner;


public class Ivanushkin {
    public static void main(String[] args) {
        Random rand = new Random();
        int num = rand.nextInt(99);
        System.out.println("\tBinary Tree");
        System.out.print("\n>> Size of the Binary Tree (n): ");
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        BinaryTree binTree = new BinaryTree(num);
        for (int i = 1; i < size; i++) {
            binTree.addValue(rand.nextInt(99));
        }
        System.out.println("Choose operation: \n1. Show Tree\n2. Insert element\n" +
                "3. Delete element\n4. Search element [x:y] by BFS \n5. Exit");
        int ch = 0;
        while (ch != 5) {
            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case (1):
                    System.out.println("Binary Tree");
                    binTree.printTree(binTree.root, null, false);
                    System.out.print("\n>> Enter new command: ");
                    break;
                case (2):
                    System.out.print("Insert element [x]: ");
                    int element = Integer.parseInt(sc.nextLine());
                    binTree.addValue(element);
                    System.out.print("\n>> Enter new command: ");
                    break;
                case (3):
                    System.out.print("Delete element [x]: ");
                    int trash = Integer.parseInt(sc.nextLine());
                    binTree.delete_value(trash);
                    System.out.print("\n>> Enter new command: ");
                    break;
                case (4):
                    System.out.print("Find an elements into range. Enter a range [x:y]. \nFrom [x]: ");
                    int x = Integer.parseInt(sc.nextLine());
                    System.out.print("to [y]: ");
                    int y = Integer.parseInt(sc.nextLine());
                    binTree.breadth_first_search(x, y);
            }
        }
    }
}