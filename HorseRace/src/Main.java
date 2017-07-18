/**
 * Created by Clown on 27.06.2015.
 */
public class Main {
    public static void main(String[] args) {
        Hippodrome hippodrome = new Hippodrome();
        Player player = new Player();

        hippodrome.initHorses();
        player.doChoice(hippodrome.stable);

        Race race = new Race();
        race.doJumpAndFindWinner(hippodrome.stable, player.choice);
        player.congratulationOrConsolation(hippodrome.stable, race.leader);
    }
}
