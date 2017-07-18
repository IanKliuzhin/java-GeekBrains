import java.util.Scanner;

/**
 * Created by Clown on 27.06.2015.
 */
public class Player {
    int choice;

    public int doChoice(Horse[] horses) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать на ипподром!");
        System.out.printf("Список лошадей:\n");
        for (int i = 0; i < horses.length; i++) {
            Horse horse = horses[i];
            System.out.printf("%d\t%s\t\tmin. скорость %d м/мин\t\tmax. скорость %d м/мин\n", i + 1, horse.name, horse.minSpeed, horse.maxSpeed);
        }
        System.out.printf("Длина дистанции: %d метров\n", Hippodrome.TRACK_LENGTH);
        System.out.print("Выберите номер лошади, на которую хотите поставить: ");
        String s;
        s = scanner.nextLine();
        this.choice = Integer.parseInt(s) - 1;
        System.out.println();
        System.out.printf("Вы выбрали лошадь №%d %s\n", choice + 1, horses[choice].name);
        return choice;
    }

    public void congratulationOrConsolation(Horse[] horses, int winner) {
        String string;
        if (choice == winner) {
            string = "Вы ставили на эту лошадь. Поздравляем с победой!\n";
        } else {
            string = "Ваша лошадь №%d %s финишировала на %d месте за %d мин. %d сек. Попробуйте ещё раз.";
        }
        System.out.printf(string, choice + 1, horses[choice].name, horses[choice].place, (int) horses[choice].finishTime, (int) ((horses[choice].finishTime - (int) horses[choice].finishTime) * 60));
    }
}
