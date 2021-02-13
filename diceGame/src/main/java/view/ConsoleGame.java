package view;

import model.DiceGame;

public class ConsoleGame {
    public void playGame(DiceGame g) {
        System.out.println("Welcome to Dice Game");
        System.out.println("Any key to play 'q' to quite");
        while (getInputChar() != 'q') {
            if (g.play()) {
                System.out.println("Win:" + g.getDice1Value() + " " + g.getDice2Value());
            } else {
                System.out.println("Loose:" + g.getDice1Value() + " " + g.getDice2Value());
            }
        }

    }

    private int getInputChar() {
        int c = 0;
        try {
            c = System.in.read();
            while (c == '\n' || c == '\r') {
                c = System.in.read();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return c;
    }
}