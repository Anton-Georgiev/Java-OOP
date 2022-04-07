package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private static int size = 3;
    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(size);
    }


    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void eat() {
        int addition = getSize() + 3;
        setSize(addition);
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}
