public class Q2 {
    public static void main(String[] args){
        int[][] arr = {
                {34, 56, 20, 33, 18},
                {89, 35, 67, 23, 54},
                {67, 42, 56, 76, 90},
                {56, 78, 14, 79, 11}
        };
        int sum1=0;
        int sum2=0;
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(j>i) {
                    sum1+=arr[i][j];
                }else if(j<i) {
                    sum2+=arr[i][j];
                }
            }
        }

        System.out.println("Sum of elements above diagonal: " + sum1);
        System.out.println("Sum of elements below diagonal: " + sum2);



    }

}
