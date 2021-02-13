package model;

/**
 * A DiceGame contains two dices
 */
public class DiceGame {
    private Dice md1;//Association relation
    private Dice md2;

    public DiceGame()
    {
        md1=new Dice();
        md2=new Dice();
    }
    public boolean play()
    {
        md1.roll();
        md2.roll();
        return md1.getValue()+md2.getValue()==7;
    }
    public int getDice1Value(){return md1.getValue();}
    public int getDice2Value(){return md2.getValue();}
}
/* Dice class */
final class Dice {
    private int value;
    public void roll()
    {
        value=(int)(Math.random()*171717.0)%6+1;
    }
    public int getValue(){
        return value;
    }
}
