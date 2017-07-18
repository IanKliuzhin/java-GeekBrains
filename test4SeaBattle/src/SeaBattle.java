import java.util.Scanner;

/**
 * Created by Clown on 14.06.2015.
 */
public class SeaBattle {
    public static void main(String[] args) {
        //....X...

        char[] cells = new char[10];

        for (int i = 0; i < 10; i++) {
            cells[i] = '.';
        }
        int shipPosition = 4;

        cells[shipPosition] = 'X';

        do {
            System.out.println(cells);

            Scanner scanner = new Scanner(System.in);
            String s;
            s = scanner.nextLine();
            System.out.printf("Вы ввели: %s\n", s);

            int shoot = Integer.parseInt(s);

            switch (cells[shoot]) {
                case '.':
                    System.out.println("Выберите");
                    cells[shoot] = '*';
                    break;
                case 'X':
                    System.out.println("Ура, корабль потоплен!");
                    cells[shoot] = '-';
                    System.out.println(cells);
                    break;
                case '*':
                    System.out.println("Уже стреляли");
                    break;
                default:
                    System.out.println("ERROR");
            }
        } while (cells[shipPosition] == 'X');
    }
}
