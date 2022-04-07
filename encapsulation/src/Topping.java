public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }
    private void setToppingType(String toppingType) {

        switch (toppingType){
            case "Meat":
            case "Veggies:":
            case "Cheese:":
            case "Sauce":
                this.toppingType = toppingType;
            default: throw new IllegalArgumentException("Cannot place " +
                   toppingType +" on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight >0 && weight <=50){
            this.weight = weight;
        }
        else throw new IllegalArgumentException("%s weight should be in range [1..50].");
    }

    public double calculateCalories() {
        double toppingTypeModifier = getToppingTypeModifier(this.toppingType);
        return 2*this.weight*toppingTypeModifier;
    }

    private double getToppingTypeModifier(String toppingType) {
        switch (toppingType){
            case "Meat": return 1.2;
            case "Veggies:": return 0.8;
            case "Cheese:": return 1.1;
            case "Sauce": return 0.9;
            default: return 0;
        }
    }
}
