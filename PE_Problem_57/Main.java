public class Main{
    static final int NUM_EXP = 1000;
    public static void main(String[] args) {
        long[] nums = new long[NUM_EXP+1];
        long[] denoms = new long[NUM_EXP+1];

        nums[0] = 3;
        denoms[0] = 2;

        long n1;
        long d1;
        int res = 0;
        for(int i = 1; i < NUM_EXP; ++i) {
            d1 = nums[i-1] + denoms[i-1];
            n1 = denoms[i-1];
            n1 += d1;

            nums[i] = n1;
            denoms[i] = d1;


            while(n1 > 0 && d1 > 0) {
                n1/=10;
                d1/=10;
            }

            if(n1 > d1) {
                res++;
            }
            System.out.println("i: " + i + " | " + nums[i] + "/" + denoms[i] + " | R: " + res);
        }
        System.out.println(res);
    }
}
