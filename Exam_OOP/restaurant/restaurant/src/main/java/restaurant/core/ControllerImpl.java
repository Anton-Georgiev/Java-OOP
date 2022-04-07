package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.BeverageRepositoryImpl;
import restaurant.repositories.HealthFoodRepositoryImpl;
import restaurant.repositories.TableRepositoryImpl;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.BEVERAGE_EXIST;
import static restaurant.common.ExceptionMessages.FOOD_EXIST;
import static restaurant.common.OutputMessages.FOOD_ADDED;

public class ControllerImpl implements Controller {
    private HealthFoodRepositoryImpl healthFoodRepository;
    private BeverageRepositoryImpl beverageRepository;
    private TableRepositoryImpl tableRepository;

    public ControllerImpl(
            HealthFoodRepository<HealthyFood> healthFoodRepository
            , BeverageRepository<Beverages> beverageRepository
            , TableRepository<Table> tableRepository) {

        healthFoodRepository = new HealthFoodRepositoryImpl();
        beverageRepository = new BeverageRepositoryImpl();
        tableRepository = new TableRepositoryImpl();
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = null;
        switch (type){
            case "Salad" -> food = new Salad(name,price);
            case "VeganBiscuits" -> food = new VeganBiscuits(name,price);
        }
        if (healthFoodRepository.foodByName(name) != null){
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }
        healthFoodRepository.add(food);
        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        Beverages beverage = null;

        switch (type){
            case "Fresh" -> beverage = new Fresh(name,counter,brand);
            case "Smoothie" -> beverage = new Smoothie(name,counter,brand);
        }
        if (beverageRepository.beverageByName(name,brand) != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }
        beverageRepository = new BeverageRepositoryImpl();
        return String.format(OutputMessages.BEVERAGE_ADDED, beverage.getClass().getSimpleName(), brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;

        switch (type) {
            case "Indoors":
                table = new Indoors(tableNumber, capacity);

                break;

            case "InGarden":
                table = new InGarden(tableNumber, capacity);

                break;
        }

        if(tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.TABLE_EXIST,
                    tableNumber
            ));
        }

        tableRepository.add(table);

        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = tableRepository.getAllEntities()
                .stream()
                .filter((t) -> {
                    return  !t.isReservedTable() && t.getSize() >= numberOfPeople;
                })
                .findFirst().orElse(null);

        if(table == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE,
                    numberOfPeople);
        }

        table.reserve(numberOfPeople);

        return String.format(OutputMessages.TABLE_RESERVED,
                table.getTableNumber() ,numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);

        if(table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if(food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(food);

        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);

        //todo: if's

        Beverages beverage = beverageRepository.beverageByName(name,brand);
        table.orderBeverages(beverage);

        //todo String return
    }

    @Override
    public String closedBill(int tableNumber) {
        //TODO:
        return null;
    }


    @Override
    public String totalMoney() {
        //TODO:
        return null;
    }
}
