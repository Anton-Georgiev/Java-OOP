package Animals;

public class Tomcat extends Animal {
     private static final  String GENDER = "Male";
    public Tomcat(String name, int age){
        super(name, age, GENDER);
        super.setGender(GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
