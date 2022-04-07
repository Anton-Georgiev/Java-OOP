package bakery.entities.tables;

import bakery.entities.interfaces.BakedFood;
import bakery.entities.interfaces.Drink;
import bakery.entities.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        foodOrders = new ArrayList<>();
        drinkOrders = new ArrayList<>();
    }


    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }


    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        price = numberOfPeople + pricePerPerson;
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
        price = numberOfPeople + pricePerPerson;
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill = 0;

        for (BakedFood foodOrder : foodOrders) {
            bill += foodOrder.getPrice();
        }
        for (Drink drinkOrder : drinkOrders) {
            bill += drinkOrder.getPrice();
        }
        return bill;
    }

    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        isReserved = false;
        price = 0;
        numberOfPeople = 0;
    }

    @Override
    public String getFreeTableInfo() {
        return String.format("Table: %d%n" +
                        "Type: %s%n" +
                        "Capacity: %d%n" +
                        "Price per Person: %f%n"
                , tableNumber, this.getClass().getSimpleName().trim(), capacity, pricePerPerson);
    }
}
