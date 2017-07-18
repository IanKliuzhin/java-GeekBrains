import java.util.Scanner;

/**
 * Created by MPotekhina on 21.06.15.
 */
public class Player {

    int getShootPoint() {
        System.out.println("Куда стрелять?");
        Scanner scanner = new Scanner(System.in);

        String s;
        s = scanner.nextLine();

        System.out.printf("Вы ввели: %s\n", s);

        int shoot = Integer.parseInt(s) - 1;

        return shoot;

    }
}
