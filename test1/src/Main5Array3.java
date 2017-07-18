import java.util.Arrays;

/**
 * Created by Clown on 14.06.2015.
 */
public class Main5Array3 {
    public static void main(String[] args) {
//        char[] cells = {'X', '0', 'X'};
//
////        cells = new char[3];
////        cells[1] = 'X';
//        System.out.println(cells);
        char[][] cells;
        cells = new char[3][4];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                cells[i][j] = '.';

            }
        }
        
//        String plainArray = Arrays.deepToString((cells));
//        System.out.println(plainArray);

        cells[1][1] = 'O';
        cells[2][1] = 'X';

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[j][i] + " ");
            }
            System.out.println();
            
        }
        
    }
}
