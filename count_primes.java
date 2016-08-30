/**
 * Created by Vegeta on 8/30/16.
 */
public class PrimeCount {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                cnt++;
                for (int j = 2; i * j < n; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String args[]) {
        PrimeCount pc = new PrimeCount();
        int r = pc.countPrimes(1500000);
        System.out.println(r);
    }
}
