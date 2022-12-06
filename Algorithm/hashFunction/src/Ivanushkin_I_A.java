import java.io.IOException;
import java.util.Scanner;

public class Ivanushkin_I_A {
    public static void main(String[] args) throws IOException {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of hash table: ");
        size = Integer.parseInt(sc.nextLine());
        System.out.print("Enter initial number of items: ");
        n = Integer.parseInt(sc.nextLine());
        // Создание таблицы
        HashTable theHashTable = new HashTable(size);
        for (int j = 0; j < n; j++)         // Вставка данных
        {
            aKey = (int) (java.lang.Math.random() *
                    keysPerCell * size);
            aDataItem = new Link(aKey);
            theHashTable.insert(aDataItem);
        }
        while (true) {
            System.out.println("\n\t1. Show; \t2. Insert; \t3. Delete; \t4. Find; ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    theHashTable.displayTable();
                    break;
                case 2:
                    System.out.print(">> Enter value to insert: ");
                    aKey = Integer.parseInt(sc.nextLine());
                    aDataItem = new Link(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 3:
                    System.out.print(">> Enter key value to delete: ");
                    aKey = Integer.parseInt(sc.nextLine());
                    theHashTable.delete(aKey);
                    break;
                case 4:
                    System.out.print(">> Enter key value to find: ");
                    aKey = Integer.parseInt(sc.nextLine());
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null)
                        System.out.println("Found " + aKey);
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }
}

