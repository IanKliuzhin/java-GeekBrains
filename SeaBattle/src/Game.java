import java.util.Random;
import java.util.Scanner;

/**
 * Created by Clown on 12.07.2015.
 */
public class Game {
    String winner;
    boolean isManualCreatingShips;
    boolean isManualShooting;
    Player shooter;
    Field target;

    public Game() {
    }

    String play() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Добро пожаловать в игру «Морской бой»!\nВведите ваше имя: ");
        String humanName = scanner.nextLine();
        System.out.print("Как будем расставлять корабли (1 - вручную, любая другая цифра - рандомно)?\n");
        isManualCreatingShips = (Integer.parseInt(scanner.nextLine()) == 1);
        System.out.print("Как будем стрелять (1 - вручную, любая другая цифра - рандомно)?\n");
        isManualShooting = (Integer.parseInt(scanner.nextLine()) == 1);
        Player human = new Player(humanName, isManualCreatingShips, isManualShooting);
        Player computer = new Player("Компьютер", false, false);

//        Field humanField = new Field();
//        humanField.initCells();
//        humanField.initShips();
//        humanField.showCells(human.name);
//
//        Field computerField = new Field();
//        computerField.initCells();
//        computerField.initShips();
//        computerField.showCells(computer.name);

        int i = 0;
        System.out.println("Игра началась!");
        do {
            shooter = (i % 2 == 0) ? human : computer;
            target = (i % 2 == 0) ? computer.field : human.field;

            shooter.doShoot(target);

            if (target.isAllShipsDrawn()) {
                winner = shooter.name;
            }

            i++;
        } while (winner == null);

        return winner;
    }
}
