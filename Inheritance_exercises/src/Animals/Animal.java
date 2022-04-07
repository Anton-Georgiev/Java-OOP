package Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;


    public Animal(String name, int age, String gender){
            setName(name);
            setGender(gender);
            setAge(age);
        }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
//        try{
//            this.name = name;
//        } catch (IllegalArgumentException ex){
//            System.out.println("Invalid input!");
//        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public void setAge(int age) {
//        try{
//            this.age = age;
//        } catch (IllegalArgumentException ex){
//            System.out.println("Invalid input!");
//        }

        if (age <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
    public String produceSound(){
        return  null;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), this.getName(), this.getAge(), this.getGender(), this.produceSound());
    }
}
