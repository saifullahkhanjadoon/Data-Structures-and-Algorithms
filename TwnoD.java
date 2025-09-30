public class TwnoD {

    public  int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public  int findLargest(int[] arr) {
        int largest = arr[0];
        for (int val : arr) {
            if (val > largest) {
                largest = val;
            }
        }
        return largest;
    }

    public  int findSecondLargest(int[] arr) {
        int largest = findLargest(arr);
        int secondLargest = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x != largest && x > secondLargest) {
                secondLargest = x;
            }
        }
        return secondLargest;
    }

    public  void secondLargestInRows(int[][] arr) {
        System.out.println("Second largest in each row and digit sum:");
        for (int i = 0; i < arr.length; i++) {
            int[] row = arr[i];
            int second = findSecondLargest(row);
            int sum = digitSum(second);
            System.out.println("Row " + i + ": " + second + " → Digit Sum = " + sum);
        }
    }

    public  void secondLargestInColumns(int[][] arr) {
        System.out.println("\nSecond largest in each column and digit sum:");
        for (int j = 0; j < arr[0].length; j++) {
            int[] column = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                column[i] = arr[i][j];
            }
            int second = findSecondLargest(column);
            int sum = digitSum(second);
            System.out.println("Column " + j + ": " + second + " → Digit Sum = " + sum);
        }
    }

    public static void main(String[] args) {
        TwnoD obj=new TwnoD();
        int[][] arr = {
                {375, 845, 612, 945, 543},
                {123, 463, 354, 964, 143},
                {651, 687, 354, 465, 243},
                {342, 453, 298, 453, 934},
                {786, 285, 723, 512, 355}
        };

        obj.secondLargestInRows(arr);
        obj.secondLargestInColumns(arr);
    }
}
