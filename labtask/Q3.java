public class Q3 {
    public static void main(String[] args) {
        int[][] arr = {
                {-34, 56, 20, 33, -18},
                {89, 35, 67, -2, -54},
                {44, 42, 56, -76, 90},
                {-56, 78, -14, 79, 11}
        };

        System.out.println("Row-wise largest negative & sum:");
        for (int i=0;i<arr.length;i++) {
            int largest=-9999;
            int sum=0;

            for (int j=0;j<arr[0].length;j++) {
                if(arr[i][j]<0) {
                    sum+=arr[i][j];
                    if(arr[i][j]>largest) {
                        largest=arr[i][j];
                    }
                }
            }
            if(sum==0)
                System.out.println("Row "+i+" --> No negative numbers");
            else
                System.out.println("Row "+i+" --> Largest = "+largest+", Sum = "+sum);
        }

        System.out.println("\nColumn-wise largest negative & sum:");
        for (int j=0;j<arr[0].length;j++) {
            int largest=-9999;
            int sum=0;

            for (int i=0;i<arr.length;i++) {
                if(arr[i][j]<0) {
                    sum+=arr[i][j];
                    if(arr[i][j]>largest) {
                        largest=arr[i][j];
                    }
                }
            }

            if (sum==0)
                System.out.println("Column "+j+" --> No negative numbers |sum="+sum);
            else
                System.out.println("Column "+j+" --> Largest = "+largest+", Sum = " + sum);
        }
    }
}
