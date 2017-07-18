/**
 * Created by MPotekhina on 21.06.15.
 */
public class Field {
    public static final int SHIPS_AMOUNT = 3;
    public static final int FIELD_SIZE = 10;
    char[] cells = new char[FIELD_SIZE];
    //    Ship ship;
    Ship[] ships = new Ship[SHIPS_AMOUNT];

    void init() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            cells[i] = '.';
        }

    }

//    void setShip(Ship ship) {
//        this.ship = ship;
//        cells[ship.headPosition] = 'X';
//    }

    void setShips() {
        for (int i = 0; i < SHIPS_AMOUNT; i++) {
//            ships[i] = new Ship();
            ships[i] = getCorrectShip(i);
            drawShip(ships[i]);
            System.out.printf("Корабль №%d: Голова - %d, хвост - %d. Длина %d\n", i + 1, ships[i].headPosition + 1, ships[i].tailPosition + 1, ships[i].tailPosition - ships[i].headPosition);
//            System.out.printf("Голова - %d, хвост - %d\t", ships[1].headPosition, ships[1].tailPosition);
//            System.out.printf("Голова - %d, хвост - %d\t", ships[2].headPosition, ships[2].tailPosition);
//            System.out.printf("Голова - %d, хвост - %d/t", ships[3].headPosition, ships[3].tailPosition);
        }
    }

    Ship getCorrectShip(int i) {
        Ship ship = new Ship();

        boolean isIntersect;
        do {
            isIntersect = false;
            ship.initWithRandomValues(FIELD_SIZE);
//            System.out.printf("");
            for (int j = 0; j < i; j++) {
                if (ship.isIntersectsWithSecondShip(ships[j])) {
                    isIntersect = true;
                }
            }
        } while (isIntersect);
        return ship;

    }

    void drawShip(Ship ship) {
        for (int d = ship.headPosition; d <= ship.tailPosition; d++) {
            cells[d] = 'X';
        }
    }

    boolean isNotGameOver() {
        boolean b;
        b = false;
//        return cells[ship.headPosition] == 'X';
        for (char cell : cells) {
            if (cell == 'X') {
                b = true;
            }
        }
        return b;
    }

    void show() {
        for (int i = 1; i < FIELD_SIZE + 1; i++) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
//        System.out.println(cells);
        for (char cell : cells) {
            System.out.printf("%c\t", cell);
        }
        System.out.println();

    }

    void doShoot(int shoot) {
        switch (cells[shoot]) {
            case '.':
                System.out.println("Промах");
                System.out.println();
                cells[shoot] = '*';
                show();
                break;
            case '*':
            case '-':
                System.out.println("Уже стреляли");
                System.out.println();
                show();
                break;
            case 'X':
                woundedOrDrawn(shoot);
                System.out.println();
                cells[shoot] = '-';
//                System.out.println(cells);
                show();
                break;
            default:
                System.out.println("ERROR");
                System.out.println();
        }
    }

    public void woundedOrDrawn(int hit) {
        switch (hit) {
            case 0:
                if (cells[hit + 1] == 'X') {
                    System.out.println("Корабль ранен!");
                } else {
                    System.out.println("Корабль потоплен");
                }
                break;
            case FIELD_SIZE - 1:
                if (cells[hit - 1] == 'X') {
                    System.out.println("Корабль ранен!");
                } else {
                    System.out.println("Корабль потоплен!");
                }
                break;
            default:
                if (cells[hit - 1] == 'X' || cells[hit + 1] == 'X') {
                    System.out.println("Корабль ранен!");
                } else {
                    System.out.println("Корабль потоплен!");
                }
        } //TODO если корабль >трёхпалубный и убивать палубы нелинейно (перепрыгивая через палубы), игра посчитает его потопленным. Переписать весь блок, чтоб корабль понимал, сколько у него палуб и считал жизни

    }
}
