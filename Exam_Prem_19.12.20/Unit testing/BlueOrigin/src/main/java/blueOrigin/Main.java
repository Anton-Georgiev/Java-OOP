package blueOrigin;

public class Main {
    public static void main(String[] args) {

        Spaceship spaceship = new Spaceship("jet",3);
        spaceship.add(new Astronaut("joro",45));
        spaceship.add(new Astronaut("mitko",45));
        spaceship.remove(null);
        spaceship.remove("mitko");
        System.out.println(spaceship.getCount());
    }
}
