package WildFarm;

public abstract class Felime extends Mammal{
    protected Felime(String animalType, String animalName, double animalWeight, int foodEaten, String livingRegion) {
        super(animalType, animalName, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }
}
