package ex0ArrayList;

import java.util.ArrayList;

/**
 * Created by MPotekhina on 21.06.15.
 */
public class Field {
    static ArrayList ships = new ArrayList();

    public static void main(String[] args) {
        ships.add(12);
        ships.add("hello");
        ships.add(new Ship());

        System.out.println(ships);
    }
}
