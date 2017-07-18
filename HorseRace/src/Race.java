import java.util.Scanner;

/**
 * Created by Clown on 27.06.2015.
 */
public class Race {
    int leader;

    public void doJumpAndFindWinner(Horse[] horses, int choice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------Забег начался!---------");
        int time;
        time = 0;
        int leaderDistance = 0;
        int countFinishedHorses = 0;
        float winnerTime;
        winnerTime = Float.MAX_VALUE;
        do {
            for (int i = 0; i < horses.length; i++) {
                Horse horse = horses[i];
                if (horse.coveredDistance < Hippodrome.TRACK_LENGTH) {
                    horse.currentSpeed = horse.setCurrentSpeed(horse.minSpeed, horse.maxSpeed);
                    if (horse.coveredDistance + horse.currentSpeed > Hippodrome.TRACK_LENGTH) {
                        horse.finishTime = time + (float) (Hippodrome.TRACK_LENGTH - horse.coveredDistance) / horse.currentSpeed;
                        horse.coveredDistance = Hippodrome.TRACK_LENGTH;
                        horse.setPlaces(horses);
                        countFinishedHorses++;
                    } else {
                        horse.coveredDistance += horse.currentSpeed;
                    }
                    if (horse.coveredDistance >= leaderDistance) {
                        leaderDistance = horse.coveredDistance;
                        if (horse.finishTime <= winnerTime) {
                            leader = i;
                            winnerTime = horse.finishTime;
                        }
                    }
                }
            }
            time++;
            System.out.printf("Минута %d\n", time);
            Hippodrome.showPositions(horses);
            if (countFinishedHorses < horses.length) {
                if (countFinishedHorses > 0) {
                    if (horses[leader].isMale) {
                        System.out.printf("№%d %s прибыл к финишу первым за %d мин. %d сек.\n", leader + 1, horses[leader].name, (int) horses[leader].finishTime, (int) ((horses[leader].finishTime - (int) horses[leader].finishTime) * 60));
                    } else {
                        System.out.printf("№%d %s прибыла к финишу первой за %d мин. %d сек.\n", leader + 1, horses[leader].name, (int) horses[leader].finishTime, (int) ((horses[leader].finishTime - (int) horses[leader].finishTime) * 60));
                    }
                    if (choice == leader) {
                        System.out.printf("Терпение, дождитесь последней лошади!\n");
                    } else {
                        if (horses[choice].coveredDistance == Hippodrome.TRACK_LENGTH) {
                            System.out.printf("Ваша лошадь тоже финишировала, но только за %d мин. %d сек.\n", (int) horses[choice].finishTime, (int) ((horses[choice].finishTime - (int) horses[choice].finishTime) * 60));
                        } else {
                            System.out.printf("А Ваша лошадь №%d %s пока пробежала только %d из %d м.\n", choice + 1, horses[choice].name, horses[choice].coveredDistance, Hippodrome.TRACK_LENGTH);
                        }
                    }
                } else {

                    if (horses[leader].isMale) {
                        System.out.printf("Лидирует №%d %s, пробежавший к этой минуте %d из %d м.", leader + 1, horses[leader].name, horses[leader].coveredDistance, Hippodrome.TRACK_LENGTH);
                    } else {
                        System.out.printf("Лидирует №%d %s, пробежавшая к этой минуте %d из %d м.", leader + 1, horses[leader].name, horses[leader].coveredDistance, Hippodrome.TRACK_LENGTH);
                    }
                    if (choice == leader) {
                        System.out.printf(", и вы ставили на эту лошадь!\n");
                    } else {
                        System.out.printf("\nВаша лошадь №%d %s пробежала %d из %d м. и пока отстаёт.\n", choice + 1, horses[choice].name, horses[choice].coveredDistance, Hippodrome.TRACK_LENGTH);
                    }
                }
                System.out.print("Для перехода к следующей минуте нажмите Enter");
                scanner.nextLine();
            }
        } while (countFinishedHorses < horses.length);
        if (horses[leader].isMale) {
            System.out.printf("Победил №%d %s, пробежавший дистанцию за %d мин. %d сек.\n", leader + 1, horses[leader].name, (int) horses[leader].finishTime, (int) ((horses[leader].finishTime - (int) horses[leader].finishTime) * 60));
        } else {
            System.out.printf("Победила №%d %s, пробежавшая дистанцию за %d мин. %d сек.\n", leader + 1, horses[leader].name, (int) horses[leader].finishTime, (int) ((horses[leader].finishTime - (int) horses[leader].finishTime) * 60));
        }
    }
}