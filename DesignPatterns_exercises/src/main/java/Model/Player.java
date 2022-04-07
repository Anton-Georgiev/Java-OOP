package Model;

public class Player implements GameObject{
    private int hp;
    private int damage;
    public Player(int hp, int damage){
        this.hp =hp;
        this.damage =damage;
    }
    @Override
    public void update() {
        System.out.println("Player updated!");
    }

    @Override
    public void draw() {
        System.out.println("Player drawn!");
    }
}
