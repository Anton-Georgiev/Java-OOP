package bakery;

import bakery.core.ControllerImpl;
import bakery.core.EngineImpl;
import bakery.core.interfaces.Controller;
import bakery.entities.interfaces.BakedFood;
import bakery.entities.interfaces.Drink;
import bakery.entities.interfaces.Table;

import bakery.io.ConsoleReader;
import bakery.io.ConsoleWriter;
import bakery.repositories.DrinkRepositoryImpl;
import bakery.repositories.FoodRepositoryImpl;
import bakery.repositories.TableRepositoryImpl;
import bakery.repositories.interfaces.DrinkRepository;
import bakery.repositories.interfaces.FoodRepository;
import bakery.repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {

//        String a = " ";
//        int a1 = a.length();
        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
