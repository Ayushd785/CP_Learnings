import java.io.*;
import java.util.StringTokenizer;

public class CSES1 {
    public static void main(String[] args) throws IOException {
        // Faster input handling
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n + 1]; // 1-based indexing
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // Compute prefix sum
        long[] pre = new long[n + 1]; // Use long to prevent overflow
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }
        
        // Process queries
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(pre[b] - pre[a - 1]).append("\n");
        }
        
        // Output results at once
        System.out.print(sb.toString());
    }
}
