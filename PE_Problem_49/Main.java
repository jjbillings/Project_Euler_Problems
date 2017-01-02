public class Main {

    public static void main(String[] args) {
        boolean[] composite = new boolean[9999];
        composite[0] = true;
        composite[1] = true; // They're not actually lol

        //just ignore 0/1
        for(int i = 2; i < 9999; ++i) {
            if(composite[i]) {
                continue;
            }

            if(!composite[i]) {
                for(int k = 2*i; k < 9999; k += i) {
                    composite[k] = true;
                }
            }
        }

        //At this point composite[j] is false if prime and true if composite.

        for(int i = 1000; i < composite.length-2; ++i) {
            if(composite[i]) {continue;}

            //otherwise we have a prime.
            for(int j = i+1; j < composite.length-1; ++j) {
                if(composite[j]) {continue;}

                //Compute the next term in the sequence.
                int k = j + (j-i);

                if(k >= 9999 || composite[k]) {continue;}

                //This is a valid sequence of increasing primes

                //Check to see if they're permutations of each other
                if(isPermutation(i,j) && isPermutation(i,k)) {
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }

    }

    public static boolean isPermutation(int i, int k) {
        int[] iDigits = new int[4];
        int[] kDigits = new int[4];

        for(int c = 0; c < 4; ++c) {
            iDigits[c] = i % 10;
            kDigits[c] = k % 10;
            i /= 10;
            k /= 10;
        }

        for(int c = 0; c < 4; ++c) {
            for(int d = 0; d < 4; ++d) {
                if(iDigits[c] == kDigits[d] && iDigits[c] != -1 && kDigits[d] != -1) {
                    iDigits[c] = -1;
                    kDigits[d] = -1;
                }
            }
        }

        for(int c = 0; c < 4; ++c) {
            if(iDigits[c] != -1 || kDigits[c] != -1) {
                return false;
            }
        }


        return true;
    }
}
