public class Reverse {
    int n;
    int m;

    public Reverse(int n, int m) {
        this.n = n;
        this.m = m;
    }

    private int wayTo() {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("\t" + matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix[n - 1][m - 1];
    }

    public void totalWay() {
        System.out.println("Total different ways: " + wayTo());
    }
}