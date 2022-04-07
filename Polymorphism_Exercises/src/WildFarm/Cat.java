package WildFarm;

public class Cat extends Felime{
    String breed;
    public Cat(String animalType, String animalName, double animalWeight, int foodEaten, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, foodEaten, livingRegion);
        this.breed = breed;
    }

    @Override
        public void makeSound() {
        System.out.println("Meowww");
    }


}
