package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final int OXYGEN_VALUE = 70;
    public Biologist(String name) {
        super(name,OXYGEN_VALUE);
        units = 5;
    }

}
