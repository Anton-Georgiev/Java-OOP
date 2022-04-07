package WildFarm;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private double animalWeight;
    private int foodEaten;

    protected  Animal(String animalType, String animalName, double animalWeight, int foodEaten){
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = foodEaten;
    }

    protected String getAnimalType(){
        return this.animalType;
    }

    public abstract void makeSound();

    public void eat( Food food){
        this.foodEaten += food.getQuantity();
    }
}
