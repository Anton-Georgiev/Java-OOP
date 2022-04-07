package WildFarm;

public class Mammal extends Animal{
    private String livingRegion;
    protected Mammal(String animalType, String animalName, double animalWeight, int foodEaten, String livingRegion) {
        super(animalType, animalName, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }
}
