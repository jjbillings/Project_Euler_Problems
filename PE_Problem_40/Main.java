public class Main {
    //It Works! product is 210 = 1*1*5*3*7*2*1
    //TODO: Maybe try finding a way to compute just those digits, without building a huge number
    public static void main(String[] args) {

        String decexp = "";
        int i = 1;

        while(decexp.length() < 1000000) {
            decexp += i;
            i++;
        }

        int result = 1;
        for(int k = 1; k <= 1000000; k*=10) {
            result *= Integer.parseInt(Character.toString(decexp.charAt(k-1)));
        }
        System.out.println(result);
    }
}
