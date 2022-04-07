package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFoods;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    boolean isReservedTable;
    private double allPeople;

    private List<HealthyFood> foodOrders;
    private List<Beverages> beverageOrders;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        setAllPeople(allPeople);
        foodOrders = new ArrayList<>();
        beverageOrders = new ArrayList<>();
    }

    private void setAllPeople(double allPeople) {
        int priceForAll=0;
        for (int i = 0; i < numberOfPeople; i++) {
            priceForAll += pricePerPerson;
        }
        this.allPeople = allPeople;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (this.numberOfPeople == numberOfPeople) {
            isReservedTable = true;
        }
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        beverageOrders.add(beverages);
    }

    @Override
    public double bill() {
        double price = 0;
        for (HealthyFood foodOrder : foodOrders) {
            price += foodOrder.getPrice();
        }
        for (Beverages beverageOrder : beverageOrders) {
            price += beverageOrder.getPrice();
        }
        return price;
    }

    @Override
    public void clear() {
        foodOrders.clear();
        beverageOrders.clear();
        isReservedTable = false;
        numberOfPeople =0;
        allPeople =0;
    }

    @Override
    public String tableInformation() {
       return String.format("Table - %d\n" +
                "Size - %d\n" +
                "Type - %s\n" +
                "All price - %f\n",getTableNumber(), size,this.getClass().getSimpleName(), bill());
    }
}
