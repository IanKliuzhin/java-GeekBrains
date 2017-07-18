/**
 * Created by Clown on 14.06.2015.
 */
public class Main5Array2 {
    public static void main(String[] args) {

        int i;
        i = 10;

        int[] stable;

        stable = new int[100];
        System.out.println(stable);

        stable[1] = 123;
        stable[2] = 555;
        stable[20] = 987654321;

//        for (int i1 : stable) {
//            System.out.println(i1);
//        }

        for (int j = 0; j < stable.length; j++) {
            int i1 = stable[j];
            System.out.println(j + ":" +i1);
        }


    }
}
