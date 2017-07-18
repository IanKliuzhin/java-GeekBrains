import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Clown on 14.06.2015.
 */
public class Main5Array {
    public static void main(String[] args) {
        boolean[] booleans = {true, false, false, true, true};
        String[] months = {"january", "february", "march", "april"};
        int a = 10;
        //               0, 1, 2,  3
        int[] numbers = {1, 2, 21, 23};

        int humanNumberOfMonths = 2;
        System.out.println(months[humanNumberOfMonths - 1]);
        String s = Arrays.toString(months);
        System.out.println(s);

        for (int i = 0; i < months.length; i++) {
            String m = months[i];
            System.out.println("Месяц: " + m);
        }


//        for (int k = 0; k < booleans.length; k++) {
//            boolean b = booleans[k];
//            System.out.println(b);
//        }
        for (String m : months) {
            System.out.println(m);
        }

        for (String month : months) {
            System.out.println(month);
        }


    }
}
