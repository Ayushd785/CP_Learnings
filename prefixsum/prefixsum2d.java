import java.util.*;

public class prefixsum2d{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0 ;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int [][] pre = new int[n][n];
        // first we construct the prefix sum matrix
        // formula is = pre[i][j] = arr[i][j]+ pre[i][j-1] + pre[i-1][j] - pre[i-1][j-1];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                pre[i][j] = arr[i][j];
                if(i>0){
                    pre[i][j] += pre[i-1][j];
                }
                if(j>0){
                    pre[i][j]+= pre[i][j-1];
                }
                if(i>0 && j>0){
                    pre[i][j] += pre[i-1][j-1];
                }
            }
        }
        // now we are supposed to tell the prefix sum of a query (l1,r1) to (l2,r2);
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();

        // formula = sum = pre[l1-1][r1-1] - pre[l1-1][r2] - pre[l2][r1-1]+ pre[l2][r2];
        int sum = pre[l1-1][r1-1] - pre[l1-1][r2] - pre[l2][r1-1]+ pre[l2][r2];
        System.out.println(sum);

    }
}