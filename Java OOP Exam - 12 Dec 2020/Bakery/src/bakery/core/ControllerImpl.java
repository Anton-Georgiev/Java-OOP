package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.interfaces.BakedFood;
import bakery.entities.interfaces.Drink;
import bakery.entities.interfaces.Table;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.repositories.interfaces.DrinkRepository;
import bakery.repositories.interfaces.FoodRepository;
import bakery.repositories.interfaces.TableRepository;

import java.security.SecureRandom;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {


    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository
            , DrinkRepository<Drink> drinkRepository
            , TableRepository<Table> tableRepository) {

        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        totalIncome = 0.0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = this.foodRepository.getByName(name);
        if (food != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }
        switch (type) {
            case "Bread":
                food = new Bread(name, price);
                break;
            case "Cake":
                food = new Cake(name, price);
                break;
        }
        this.foodRepository.add(food);

        return String.format(String.format(FOOD_ADDED, name, type));
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = this.drinkRepository.getByNameAndBrand(name,brand);
        if (drink != null){
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }

        switch (type){
            case "Tea": drink = new Tea(name,portion,brand); break;
            case "Water": drink = new Water(name,portion,brand); break;
        }
        this.drinkRepository.add(drink);
        return String.format(DRINK_ADDED,name,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        if (table != null){
            throw new IllegalArgumentException(String.format(TABLE_EXIST,tableNumber));
        }

        switch (type){
            case "InsideTable": table = new InsideTable(tableNumber,capacity); break;
            case "OutsideTable": table = new OutsideTable(tableNumber,capacity); break;
        }
        this.tableRepository.add(table);
        return String.format(TABLE_ADDED,tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
       Table table = this.tableRepository.getAll().stream()
               .filter(e -> !e.isReserved() && e.getCapacity() >= numberOfPeople)
               .findFirst()
               .orElse(null);
       if (table == null){
           return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
       }
       table.reserve(numberOfPeople);
       tableRepository.add(table);
       return String.format(TABLE_RESERVED,table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        BakedFood food = foodRepository.getByName(foodName);
        Table table = tableRepository.getByNumber(tableNumber);
        if (!table.isReserved()){
            table = null;
        }
        if (table == null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }
        if (food == null){
            return String.format(NONE_EXISTENT_FOOD,foodName);
        }

            table.orderFood(food);
            return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);

    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Drink drink = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        Table table = tableRepository.getByNumber(tableNumber);
        if (!table.isReserved()){
            table = null;
        }
        if (table == null){
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }
        if (drink == null){
            return String.format(NON_EXISTENT_DRINK,drinkName,drinkBrand);
        }
        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL,tableNumber,drinkName,drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
      Table table = tableRepository.getByNumber(tableNumber);
      double bill = table.getBill() + table.getPricePerPerson() * table.getNumberOfPeople();
      table.clear();
      this.totalIncome += bill;
      return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder builder = new StringBuilder();
        for (Table table : tableRepository.getAll()) {
            if (!table.isReserved()){
                builder.append(table.getFreeTableInfo());
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
