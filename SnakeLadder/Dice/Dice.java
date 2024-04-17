public class Dice {
    private int noOfDices;

    public void setDices(int dices){
        noOfDices=dices;
    }

    public int getDices(){
        return noOfDices;
    }

    public int rollDice(){
        return (int)(Math.random()*(noOfDices*6)+1);
    }
}
