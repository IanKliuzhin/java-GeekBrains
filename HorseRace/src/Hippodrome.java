import java.util.Random;

/**
 * Created by Clown on 27.06.2015.
 */
public class Hippodrome {
    public static final int TRACK_LENGTH = 3000;
    public static final int HORSES_AMOUNT = 10; //не больше количества имён, иначе создание лошадей зациклится: имена не должны повторяться
    public Horse[] stable = new Horse[HORSES_AMOUNT];

    public void initHorses() {
        Random random = new Random();
        boolean isNameOccupied;
        for (int i = 0; i < HORSES_AMOUNT; i++) {
            stable[i] = new Horse();
            do {
                isNameOccupied = false;
                for (int j = 0; j < i; j++) {
                    if (stable[i].name.equals(stable[j].name)) {
                        isNameOccupied = true;
                    }
                }
                if (isNameOccupied) {
                    stable[i] = new Horse();
                }
            } while (isNameOccupied);
            stable[i].minSpeed = TRACK_LENGTH / 4 + random.nextInt(TRACK_LENGTH / 12);
            stable[i].maxSpeed = TRACK_LENGTH / 3 + random.nextInt(TRACK_LENGTH / 12);
        }
    }

    public static void showPositions(Horse[] horses) {
        for (int i = 0; i < horses.length; i++) {
            Horse horse = horses[i];
            if (horse.coveredDistance == TRACK_LENGTH) {
                if (horse.isMale) {
                    System.out.printf("%d\t%s\tприбыл к финишу за %d мин. %d сек.\t%d место\n", i + 1, horse.name, (int) horse.finishTime, (int) ((horse.finishTime - (int) horse.finishTime) * 60), horse.place);
                } else {
                    System.out.printf("%d\t%s\tприбыла к финишу за %d мин. %d сек.\t%d место\n", i + 1, horse.name, (int) horse.finishTime, (int) ((horse.finishTime - (int) horse.finishTime) * 60), horse.place);
                }
            } else {
                if (horse.isMale) {
                    System.out.printf("%d\t%s\tпробежал за последнюю минуту  %d м.\tвсего пробежал %d из %d м.\n", i + 1, horse.name, horse.currentSpeed, horse.coveredDistance, TRACK_LENGTH);
                } else {
                    System.out.printf("%d\t%s\tпробежала за последнюю минуту %d м.\tвсего пробежала %d из %d м.\n", i + 1, horse.name, horse.currentSpeed, horse.coveredDistance, TRACK_LENGTH);
                }
            }
        }
    }
}
