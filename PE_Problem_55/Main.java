public class Main {

    static final int MAX_ITS = 50;
    static final int MAX_DIG = 28;

    public static void main(String[] args) {
        int[] n1 = new int[MAX_DIG];
        int[] n2 = new int[MAX_DIG];
        int[] n = new int[MAX_DIG];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        int iterations = 0;

        int[] numLychrel = new int[10000];

        n1[i1] = 1;
        n2[i2] = 1;
        n[i] = 0;

        for(int j = 1; j < 20; ++j) {
            iterations = 0;
            //Store j in n1
            i1 = 0;
            i2 = 0;
            int l = j;
            while(l > 0) {
                n1[i1++] = l%10;
                l/=10;
            }
            System.out.print("N1: ");
            for(int hh : n1) {
                System.out.print(hh);
            }
            System.out.println();

            while(iterations < 1) {

                //Reverse n1, store in n2
                for(int k = 0; k < i1; ++k) {
                    n2[i1-(k+1)] = n1[k];
                    //System.out.println(n2[i1-k]);
                }
                i2 = i1;
                System.out.print("N2: ");
                for(int hh : n2) {
                    System.out.print(hh);
                }
                System.out.println();

                //add n1+n2 and store in n.
                if(i1 > i2) {
                    for(int k = 0; k < i2; ++k) {
                        int temp = n1[k] + n2[k];
                        if(temp > 9) {
                            n[k] = temp%10;
                            n[k+1] = temp/10;
                        }else {
                            n[k] = temp;
                        }
                        i = i2;
                    }
                    for(int k = i2; k < i2 + (i1-i2); ++k) {
                        int temp = n1[k] + n2[k];
                        n[k] = temp%10;
                        if(temp > 9) {
                            n[k+1] = temp/10;
                        }
                        i = i2 + (i1-i2);
                    }
                }else {
                    for(int k = 0; k < i1; ++k) {
                        int temp = n1[k] + n2[k];
                        n[k] = temp%10;
                        if(temp > 9) {
                            n[k+1] = temp/10;
                        }
                        i = i1;
                    }
                    for(int k = i2; k < i1 + (i2-i1); ++k) {
                        int temp = n1[k] + n2[k];
                        n[k] = temp%10;
                        if(temp > 9) {
                            n[k+1] = temp/10;
                        }
                        i = i1 + (i2-i1);
                    }
                }

                for(int tt:n) {
                    System.out.print(tt);
                }
                System.out.println();


                //check to see if n is a palindrome

                iterations++;
            }
        }
    }


    public static boolean isPalindrome(int[] num) {

        return false;
    }
}
