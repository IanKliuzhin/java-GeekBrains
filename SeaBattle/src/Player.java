import java.util.Random;
import java.util.Scanner;

/**
 * Created by Clown on 12.07.2015.
 */
public class Player {
    String name;
    boolean isManualCreatingShips;
    boolean isManualShooting;
    Field field;

    Player(String name, boolean isManualCreatingShips, boolean isManualShooting) {
        this.name = name;
        this.isManualCreatingShips = isManualCreatingShips;
        this.isManualShooting = isManualShooting;
        field = new Field(this.name);
        field.initCells();
        field.initShips(isManualCreatingShips);
        field.showCells();
    }

    void doShoot(Field target) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String shootCoordinates;
        int shootColumn;
        int shootRow;
        target.showCells();
        do {
            if (isManualShooting) {
                System.out.printf("Стреляйте, %s: ", name);
                shootCoordinates = scanner.nextLine();
            } else {
                shootCoordinates = (char) (1040 + random.nextInt(10)) + Integer.toString(1 + random.nextInt(10));
                System.out.printf("%s стреляет по полю %s\n", name, (shootCoordinates.charAt(0) == 1049) ? "К" + shootCoordinates.substring(1) : shootCoordinates);
            }
            shootColumn = (shootCoordinates.charAt(0) > 10 + 1039) ? 9 : shootCoordinates.charAt(0) - 1 - 1039;
            shootRow = (Integer.valueOf(shootCoordinates.substring(1)) > 9) ? 9 : Integer.valueOf(shootCoordinates.substring(1)) - 1;
//        System.out.println("Столбец " + shootColumn + " Ряд " + shootRow);
        } while (target.shoot(shootColumn, shootRow));
    }
}
