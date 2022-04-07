package Model;

public class Enemy implements GameObject{
    private int hp;
    private int damage;

    public Enemy(int hp, int damage) {

    }

    @Override
    public void update() {
        System.out.println("Enemy updated!");
    }

    @Override
    public void draw() {
        System.out.println("Enemy drawn!");
    }
}
