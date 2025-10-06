package labtask;
public class SalesReport {
    public static void main(String[] args) {
        int[][] sales = {
                {123, 980, 0, 489, 500},
                {456, 1350, 546, 454, 0},
                {789, 567, 466, 0, 564},
                {583, 3500, 1054, 456, 0},
                {945, 1350, 650, 0, 654}
        };
        int[] quarterTotal=new int[4];
int maxSalesPersonID=0;
        int maxSalesAmount=0;
        System.out.println("--------------------------- Annual Sales Report -------------------------------");
        System.out.println("ID\t\tQT1\t\tQT2\t\tQT3\t\tQT4\t\t\tTotal");
        for (int i=0;i<sales.length; i++) {
            int id=sales[i][0];
            int total=0;
           for (int j=1;j<=4;j++) {
                total += sales[i][j];
                quarterTotal[j - 1]+=sales[i][j];
            }
            System.out.println(id + "\t\t"+sales[i][1]+"\t\t"+sales[i][2] + "\t\t" +
                    sales[i][3]+"\t\t"+sales[i][4]+"\t\t"+ total);
            if (total>maxSalesAmount) {
                maxSalesAmount=total;
                maxSalesPersonID=id;
            }
        }
        System.out.println("Total\t\t"+quarterTotal[0]+"\t\t" + quarterTotal[1] + "\t\t" +
                quarterTotal[2]+"\t\t"+quarterTotal[3]);

        int maxQuarterSale=quarterTotal[0];
        int maxQuarterIndex=0;

        for (int i=1;i<4;i++) {
            if (quarterTotal[i]>maxQuarterSale) {
                maxQuarterSale=quarterTotal[i];
                maxQuarterIndex=i;
            }
        }

        String maxQuarterName="QT"+ (maxQuarterIndex + 1);

        System.out.println("\nMax Sale by Sales Person: ID ="+maxSalesPersonID +
                ", Amount = Rs. " + maxSalesAmount);
        System.out.println("Max Sale by Quarter: \t" + maxQuarterName +
                ", Amount =\t Rs. " + maxQuarterSale);
    }
}
