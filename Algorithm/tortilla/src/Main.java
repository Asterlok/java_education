import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Gimme size of field [n] and [m]: ");
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        var t = new Tortilla(n, m);
        t.totalWay();
    }
}