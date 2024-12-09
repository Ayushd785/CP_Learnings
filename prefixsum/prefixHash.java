import java.util.*;

public class prefixHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();

        // Read array elements
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); 

        long count = 0;
        long presum = 0;

        for (int i = 0; i < n; i++) {
            presum += arr[i];

            if (map.containsKey(presum - x)) {
                count += map.get(presum - x);
            }

            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }

        System.out.println(count);

        sc.close();
    }
}
