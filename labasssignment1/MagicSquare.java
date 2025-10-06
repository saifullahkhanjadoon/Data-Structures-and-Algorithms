
package labtask;
import java.util.Scanner;

class MagicSquare {
    int n;
    Scanner in = new Scanner(System.in);

    void genMatx() {
        System.out.print("Enter size of Matix (ODD): ");
        n = in.nextInt();

        if (n % 2 == 0) {
            System.out.println("Even Matrix Not Allowed");
            return;
        }

        int[][] matrix = new int[n][n];

        int num = 1;
        int i = 0;
        int j = n / 2;

        while (num <= n * n) {
            matrix[i][j] = num;
            num++;

            int newRow = i - 1;
            int newCol = j + 1;
            if (newRow < 0 && newCol == n) {
                newRow = i + 1;
                newCol = j;
            }
            else if (newRow < 0) {
                newRow = n - 1;
            }
            else if (newCol == n) {
                newCol = 0;
            }

            if (matrix[newRow][newCol] != 0) {
                newRow = i + 1;
                newCol = j;
            }

            i = newRow;
            j = newCol;
        }

        System.out.println("\nMagic Square of size " + n + ":");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        int rowSum=0;
        int colSum=0;

        int dig = 0;
        for(int k = 0; k < n ; k++) {
            rowSum = 0;
            colSum = 0;
            for(int l = 0; l <n ;l++) {
                if(k == l) {
                    dig+=matrix[k][l];
                }
                rowSum += matrix[k][l];
                colSum += matrix[l][k];
            }
        }
            System.out.println("The Sum of each Row  is " + rowSum);
            System.out.println("The Sum of each Col is " + colSum);

        System.out.println("The Sum of Diagonal is -->" + dig);

    }


    public static void main(String[] argc) {
        MagicSquare ob = new MagicSquare();
        ob.genMatx();
    }
}

