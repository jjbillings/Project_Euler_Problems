import java.math.*;
public class Main{

    public static void main(String[] args) {

        int seqLength = 0;
        int div = -1;

        for(int i = 2; i < 1000; ++i) {
            int[] sequence = new int[i];

            int value = 1;
            int position = 0;

            while(sequence[value] == 0 && value != 0) {
                sequence[value] = position;
                value *= 10;
                value = value % i;
                position++;
            }

            if(position - sequence[value] > seqLength) {
                seqLength = position - sequence[value];
                div = i;
            }
        }

        System.out.println(div);
    }
}
