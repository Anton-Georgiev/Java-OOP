package Model;

public class Stone implements GameObject{
    @Override
    public void update() {
        System.out.println("I'm stone nad i do nothing!");
    }

    @Override
    public void draw() {
        System.out.println("see stone");
    }
}
