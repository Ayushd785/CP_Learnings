import java.util.*;
public class CSES2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] arr = new long[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        HashMap<Long, Long> map = new HashMap<>();
        long sum = 0;
        long count = 0;
        map.put(0l,1l);
        for(int i = 0;i<n;i++){
            sum = ((sum+arr[i])%n+n)%n;
            if(map.containsKey(sum)){
                count+= map.get(sum);
            }
            map.put(sum,map.getOrDefault(sum, 0l)+1);
        }
        System.out.println(count);
    }
}
