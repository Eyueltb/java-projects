import model.DiceGame;
import view.ConsoleGame;

public class MainGame {
    public static void main(String[] args) {
        DiceGame g=new DiceGame();
        ConsoleGame ui=new ConsoleGame();
        ui.playGame(g);
    }
}
