public class Q4 {
    public static void main(String[] args) {
        int[][] arr={
                {34, 56, 20, 33, 18},
                {89, 35, 67, 23, 54},
                {67, 42, 56, 76, 90},
                {56, 78, 14, 79, 11}
        };


        int[] rowMax=new int[arr.length];
        int[] colMin=new int[arr[0].length];

        for(int i=0;i<arr.length; i++) {
            int max=arr[i][0];
            for (int j=1;j<arr[0].length; j++) {
                if(arr[i][j]>max) {
                    max=arr[i][j];
                }
            }
            rowMax[i]=max;
        }

        for (int j=0;j<arr[0].length; j++) {
            int min=arr[0][j];
            for (int i=1;i<arr.length; i++) {
                if (arr[i][j]<min) {
                    min=arr[i][j];
                }
            }
            colMin[j]=min;
        }
        System.out.println("\t\t\t\t\t\t Max");
        for (int i=0;i<arr.length; i++) {
            System.out.print("    ");
            for (int j=0;j<arr[0].length; j++) {

                System.out.print(" "+arr[i][j] + " ");

            }
            System.out.print("| ");
            System.out.println(rowMax[i]);
        }


        System.out.println("     ___________________");
        System.out.print("Min ");
        for (int j=0;j<arr[0].length; j++) {
//            System.out.print(" ");
            System.out.print(" "+colMin[j] + " ");
        }
    }
}
