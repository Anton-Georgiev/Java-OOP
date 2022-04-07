package WildFarm;

public class Mouse extends Mammal{
    protected Mouse(String animalType, String animalName, double animalWeight, int foodEaten, String livingRegion) {
        super(animalType, animalName, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat){
            throw new IllegalArgumentException( getAnimalType()+" are not eating that type of food!");
        }
        super.eat(food);
    }
}
