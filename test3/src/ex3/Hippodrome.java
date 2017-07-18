package ex3;

/**
 * Created by Clown on 14.06.2015.
 */
public class Hippodrome {
    public static void main(String[] args) {
        Horse[] horses = new Horse[10];

        for (int i = 0; i < horses.length; i++) {
            Horse horse = new Horse();
            horses[i] = horse;
            horses[i].name = "Буцефал " + i;

        }
    }
}
