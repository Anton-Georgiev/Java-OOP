package WildFarm;

public class Tiger extends Felime{
    String livingRegion;
    public Tiger(String animalType, String animalName, double animalWeight, int foodEaten, String livingRegion) {
        super(animalType, animalName, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable){
            throw new IllegalArgumentException( getAnimalType()+" are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
