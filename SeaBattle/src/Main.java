/**
 * Created by Clown on 12.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
        System.out.printf("Игра окончена! Победитель – %s!", game.winner);
    }
}
