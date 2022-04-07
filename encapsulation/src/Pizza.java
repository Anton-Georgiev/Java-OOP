import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizza {
  private String name;
  private  Dough dought;
    private List<Topping> toppings;

//    + Piza (String, int numberOfToppings)
//- setToppings(int) : void
//- setName(String) : void
//+ setDough(Dough) : void
//+ getName(): String
//+ addTopping (Topping) : void
//+ getOverallCalories () : double

  public Pizza(String name, int countOfToppings){
    this.setName(name);
    this.setToppings(countOfToppings);
  }
    private void setToppings(int num){
      if (num >=0 && num <= 10){
        this.toppings = new ArrayList<>(num);
      }else throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
    }

    private void setName(String name){
      if (name.length()>0 && name.length() <16){
         this.name = name;
      }
      else  throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
    }

  public void setDought(Dough dought) {
    this.dought = dought;
  }

  public String getName() {
    return name;
  }

  public void addTopping(Topping topping){
    this.toppings.add(topping);
  }

  public double getOverallCalories(){
    return this.dought.calculateCalories() + this.toppings.stream().mapToDouble(Topping:: calculateCalories).sum();
  }
}
