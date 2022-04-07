package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{
    private static final int OXYGEN_VALUE = 50;
    public Geodesist(String name) {
        super(name, OXYGEN_VALUE);
    }
}
