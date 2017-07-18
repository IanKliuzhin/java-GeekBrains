import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Clown on 12.07.2015.
 */
public class Field {
    static final int ROWS_AMOUNT = 10;
    static final int COLUMNS_AMOUNT = 10;

    public static final int AIRCRAFT_CARRIERS_AMOUNT = 1;
    public static final int BATTLESHIPS_AMOUNT = 2;
    public static final int CRUISERS_AMOUNT = 3;
    public static final int DESTROYERS_AMOUNT = 4;
    public static final int SHIPS_AMOUNT = AIRCRAFT_CARRIERS_AMOUNT + BATTLESHIPS_AMOUNT + CRUISERS_AMOUNT + DESTROYERS_AMOUNT;

    public static final int AIRCRAFT_CARRIERS_DECKS_AMOUNT = 4;
    public static final int BATTLESHIPS_DECKS_AMOUNT = 3;
    public static final int CRUISERS_DECKS_AMOUNT = 2;
    public static final int DESTROYERS_DECKS_AMOUNT = 1;

    //    public static final char EMPTY_CELL = '\u25a1'; //то же самое, что 9633
//    public static final char EMPTY_CELL = 9633;
    public static final char EMPTY_CELL = 11036;
//    public static final char SHIP_CELL = '\u25a0';
    public static final char SHIP_CELL = 9973;
    public static final char A = 1040;
    public static final char Be = 1041;
    //    public static final char MISSED_CELL = 903;
    //    public static final char MISSED_CELL = 9899;
//    public static final char MISSED_CELL = '\u2022';
    public static final char MISSED_CELL = 9900;
//    public static final char MISSED_CELL = 110           37;
    //    public static final char WOUNDED_CELL = '\u00D7';
//    public static final char WOUNDED_CELL = '\u0058';
    public static final char WOUNDED_CELL = 9760;

    char[][] cells;
    String ownerName;
    ArrayList<Ship> ships;

    Field(String ownerName) {
        cells = new char[COLUMNS_AMOUNT][ROWS_AMOUNT];
        ships = new ArrayList<>(SHIPS_AMOUNT);
        this.ownerName = ownerName;
    }

    void initCells() {
        for (char[] row : cells) {
            for (int j = 0; j < row.length; j++) {
                row[j] = EMPTY_CELL;
            }
        }
    }

    void showCells() {
        System.out.printf("\t\t\tПоле игрока %s\n", ownerName);
        System.out.printf("\t%c\t%c\tВ\tГ\tД\tЕ\tЖ\tЗ\tИ\tК\n", A, Be);
//        System.out.println("\tA   Be   C   D   E   F   H   I   J");
//        System.out.println("  A  Be C  D E  F G H  I J");
//        System.out.println("  a  b c  d e f  g h  i j");
//            for (int i = 0; i < cells.length; i++) {
//            System.out.printf("%d\t", i + 1);
//            for (char cell : cells[i]) {
//                System.out.print(cell + "\t");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < cells[0].length; i++) {
            System.out.printf("%d\t", i + 1);
//            for (char cell : cells[i]) {
//                System.out.print(cell + "\t");
//            }
            for (int j = 0; j < cells.length; j++) {
                System.out.print(cells[j][i] + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    void initShips(boolean isManualCreatingShips) {
        int creatingShipDecksAmount = AIRCRAFT_CARRIERS_DECKS_AMOUNT;
        do {
            createNotIntersectingShip(creatingShipDecksAmount, isManualCreatingShips);
//            Ship currentShip = ships.get(ships.size() - 1);
//            System.out.printf("Создан %d-палубный %s корабль, нач. позиция: %c%d\nОкружение с %c%d до %c%d\n", currentShip.decksAmount, (currentShip.isHorizontal) ? "горизонтальный" : "вертикальный", (currentShip.headColumn + 1 + 1039 == 1049) ? 'К' : currentShip.headColumn + 1 + 1039, currentShip.headRow + 1, (currentShip.surroundingAreaFirstColumn + 1 + 1039 == 1049) ? 'К' : currentShip.surroundingAreaFirstColumn + 1 + 1039, currentShip.surroundingAreaFirstRow + 1, (currentShip.surroundingAreaLastColumn + 1 + 1039 == 1049) ? 'К' : currentShip.surroundingAreaLastColumn + 1 + 1039, currentShip.surroundingAreaLastRow + 1);
            if (ships.size() == AIRCRAFT_CARRIERS_AMOUNT) {
                creatingShipDecksAmount = BATTLESHIPS_DECKS_AMOUNT;
            }
            if (ships.size() == AIRCRAFT_CARRIERS_AMOUNT + BATTLESHIPS_AMOUNT) {
                creatingShipDecksAmount = CRUISERS_DECKS_AMOUNT;
            }
            if (ships.size() == AIRCRAFT_CARRIERS_AMOUNT + BATTLESHIPS_AMOUNT + CRUISERS_AMOUNT) {
                creatingShipDecksAmount = DESTROYERS_DECKS_AMOUNT;
            }
        } while (ships.size() < SHIPS_AMOUNT);
//        System.out.printf("Все %d кораблей созданы.\n", SHIPS_AMOUNT);
    }

    void createNotIntersectingShip(int decksAmount, boolean isManualCreatingShips) {
        boolean isIntersect;
        boolean isHorizontal;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        do {
            isIntersect = false;
            if (isManualCreatingShips) {
                showCells();
                System.out.printf("Создаём %d-палубный корабль. 1 – сделать горизонтальным, любое другое число – вертикальным\n", decksAmount);
                isHorizontal = (Integer.parseInt(scanner.nextLine()) == 1);
            } else {
                isHorizontal = random.nextBoolean();
            }
            ships.add(new Ship(decksAmount, isHorizontal));
            Ship newShip = ships.get(ships.size() - 1);
//            if (newShip.isHorizontal) {
//                newShip.headColumn = random.nextInt(COLUMNS_AMOUNT - newShip.decksAmount + 1);
//                newShip.headRow = random.nextInt(ROWS_AMOUNT);
//            } else {
//                newShip.headColumn = random.nextInt(COLUMNS_AMOUNT);
//                newShip.headRow = random.nextInt(ROWS_AMOUNT - newShip.decksAmount + 1);
//            }
            if (isManualCreatingShips) {
                System.out.printf("Введите координаты самой %s палубы корабля\n", (isHorizontal) ? "левой" : "верхней");
                String headCoordinates = scanner.nextLine();
                if (isHorizontal) {
                    newShip.headColumn = (headCoordinates.charAt(0) > COLUMNS_AMOUNT - newShip.decksAmount + 1 + 1039)  ? COLUMNS_AMOUNT - newShip.decksAmount : headCoordinates.charAt(0) - 1 - 1039;
                    newShip.headRow = (headCoordinates.length() > 2) ? 10 - 1 : Character.digit(headCoordinates.charAt(1), 10) - 1;
                } else {
                    newShip.headColumn = (headCoordinates.charAt(0) > 1049) ? 1049 - 1 - 1039 : headCoordinates.charAt(0) - 1 - 1039;
                    newShip.headRow = (Integer.valueOf(headCoordinates.substring(1)) > ROWS_AMOUNT - newShip.decksAmount) ? ROWS_AMOUNT - newShip.decksAmount : Integer.valueOf(headCoordinates.substring(1)) - 1;
                }
            } else {
                newShip.headColumn = random.nextInt(COLUMNS_AMOUNT - ((isHorizontal) ? newShip.decksAmount + 1 : 0));
                newShip.headRow = random.nextInt(ROWS_AMOUNT - ((isHorizontal) ? 0 : newShip.decksAmount + 1));
            }
            newShip.initSurroundingArea();
            for (int i = 0; i <= ships.indexOf(newShip) - 1; i++) {
                for (int j = newShip.surroundingAreaFirstColumn; j <= newShip.surroundingAreaLastColumn; j++) {
                    for (int k = newShip.surroundingAreaFirstRow; k <= newShip.surroundingAreaLastRow; k++) {
                        if (cells[j][k] == SHIP_CELL) {
                            isIntersect = true;
                            ships.remove(newShip);
                        }
                    }
                }
            }
            if (isManualCreatingShips && isIntersect) {
                System.out.println("Корабль пересекается с другим.");
            }
        } while (isIntersect);
        drawShip(ships.get(ships.size() - 1));
    }

    void drawShip(Ship ship) {
//        drawSurroundingArea(ship);
        if (ship.isHorizontal) {
            for (int i = ship.headColumn; i < ship.headColumn + ship.decksAmount; i++) {
                cells[i][ship.headRow] = SHIP_CELL;
            }
        } else {
            for (int i = ship.headRow; i < ship.headRow + ship.decksAmount; i++) {
                cells[ship.headColumn][i] = SHIP_CELL;
            }
        }
    }

    //    void drawSurroundingArea(Ship ship) {
//        for (int j = ship.surroundingAreaFirstColumn; j <= ship.surroundingAreaLastColumn; j++) {
//            for (int k = ship.surroundingAreaFirstRow; k <= ship.surroundingAreaLastRow; k++) {
//                cells[j][k] = MISSED_CELL;
//            }
//        }
//    }
    boolean shoot(int shootColumn, int shootRow) {
        //todo упростить: например, выделить не~ действия в отдельные методы
        boolean isReShoot = false;
        switch (cells[shootColumn][shootRow]) {
            case SHIP_CELL:
                for (Ship ship : ships) {
                    for (int i = ship.surroundingAreaFirstColumn; i <= ship.surroundingAreaLastColumn; i++) {
                        for (int j = ship.surroundingAreaFirstRow; j <= ship.surroundingAreaLastRow; j++) {
                            if (i == shootColumn && j == shootRow) {
                                ship.lives--;
                                cells[shootColumn][shootRow] = WOUNDED_CELL;
                                if (ship.lives == 0) {
                                    for (int k = ship.surroundingAreaFirstColumn; k <= ship.surroundingAreaLastColumn; k++) {
                                        for (int l = ship.surroundingAreaFirstRow; l <= ship.surroundingAreaLastRow; l++) {
                                            cells[k][l] = MISSED_CELL;
                                        }
                                    }
                                    if (ship.isHorizontal) {
                                        for (int m = ship.headColumn; m < ship.headColumn + ship.decksAmount; m++) {
                                            cells[m][ship.headRow] = WOUNDED_CELL;
                                        }
                                    } else {
                                        for (int n = ship.headRow; n < ship.headRow + ship.decksAmount; n++) {
                                            cells[ship.headColumn][n] = WOUNDED_CELL;
                                        }
                                    }
                                    System.out.println("Корабль потоплен!" + ((isAllShipsDrawn()) ? "" : "Ещё один ход."));
                                } else {
                                    System.out.println("Корабль ранен! Ещё один ход.");
                                }
                            }
                        }
                    }
                }
                isReShoot = (!isAllShipsDrawn());
                break;
            case WOUNDED_CELL:
                System.out.println("Здесь уже есть потопленная палуба, выберите другое поле.");
                isReShoot = true;
                break;
            case MISSED_CELL:
                System.out.println("Поле уже обстреляно, выберите другое.");
                isReShoot = true;
                break;
            case EMPTY_CELL:
                cells[shootColumn][shootRow] = MISSED_CELL;
                System.out.println("Мимо!");
                break;
//            default:
//                System.out.println("Ошибочные координаты");
        }
        return isReShoot;
    }

    boolean isAllShipsDrawn() {
        for (Ship ship : ships) {
            if (ship.lives > 0) {
                return false;
            }
        }
        return true;
    }
}
