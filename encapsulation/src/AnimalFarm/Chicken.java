package AnimalFarm;

public class Chicken {
    private String name;
    private int age;


    public Chicken(String name, int age){
        setAge(age);
        setName(name);
    }
    @Override
    public String toString() {
        return String.format("AnimalFarm.Chicken %s (age %d) can produce %.2f eggs per day.",name , age, productPerDay());
    }

    public double productPerDay(){
        return  calculateProductPerDay();
    }

    private double calculateProductPerDay(){
     if (age <6){
         return 2;
     } else if (age < 12){
         return 1;
     }
     else  return 0.75;
    }
//+ productPerDay (): double
//+ toString(): Override
//- calculateProductPerDay() : double

    private void setAge(int age){
        if (age<0 ||age>15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        else {
            this.age =age;
        }
    }

    private void setName(String name){
        if (name.length() < 1){
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }
}
