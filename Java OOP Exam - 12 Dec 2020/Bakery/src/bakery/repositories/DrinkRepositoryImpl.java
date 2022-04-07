package bakery.repositories;

import bakery.entities.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        models = new ArrayList<>();
    }


    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return models.stream().filter(e -> e.getBrand().equals(drinkBrand) && e.getName().equals(drinkName)).findFirst().orElse(null);
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Drink drink) {
        models.add(drink);
    }
}
