/**
 * Created by MPotekhina on 21.06.15.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Player player = new Player();
//        Ship ship = new Ship(4);

        field.init();
        field.setShips();

        System.out.println("---Game start---");
        field.show();


        do {
            int shoot = player.getShootPoint();
            field.doShoot(shoot);
        } while (field.isNotGameOver());

        System.out.println();
        System.out.println("Все корабли потоплены! Победа!");
    }
}

