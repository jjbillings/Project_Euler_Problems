import java.math.BigInteger;

public class Main2 {

    static final int MAX_EXP = 1000;
    //IT WORKS! SOLUTION: 153.
    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf(3);
        BigInteger den = BigInteger.valueOf(2);

        int result = 0;

        for(int i = 1; i < 1000; ++i) {
            num = num.add(den.multiply(BigInteger.valueOf(2)));
            den = num.subtract(den);
            System.out.println(num + "/" + den);

            System.out.println(num.toString().length());
            if(num.toString().length() > den.toString().length()) {
                result++;
            }
        }
        System.out.println("RESULT: " + result);
    }
}
