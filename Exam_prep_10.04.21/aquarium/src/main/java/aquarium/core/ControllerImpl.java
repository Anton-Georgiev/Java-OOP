package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.LinkedHashMap;
import java.util.Map;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        decorations = new DecorationRepository();
        aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if (aquariumType.equals("FreshwaterAquarium")) {
            this.aquariums.put(aquariumName, new FreshwaterAquarium(aquariumName));
            return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            this.aquariums.put(aquariumName, new SaltwaterAquarium(aquariumName));
            return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
    }

    @Override
    public String addDecoration(String type) {
        if (type.equals("Ornament")) {
            this.decorations.add(new Ornament());
            return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
        } else if (type.equals("Plant")) {
            this.decorations.add(new Plant());
            return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration dec = decorations.findByType(decorationType);
        if (dec != null) {
            aquariums.entrySet().stream()
                    .filter(entry  -> entry.getValue().getName().equals(aquariumName))
                    .findFirst().get()
                    .getValue().addDecoration(dec);
            decorations.remove(dec);
            return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
        } else throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        if (fishType.equals("FreshwaterFish")) {
//            aquariums.entrySet().stream().filter(e -> e.getKey().equals(aquariumName))
//                    .findFirst().get()
//                    .getValue()
//                    .addFish(new FreshwaterFish(fishName, fishSpecies, price));
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
//            aquariums.entrySet().stream().filter(e -> e.getKey().equals(aquariumName))
//                    .findFirst().get()
//                    .getValue()
//                    .addFish(new SaltwaterFish(fishName, fishSpecies, price));
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else throw new IllegalArgumentException(INVALID_FISH_TYPE);

        try {
            Aquarium aquarium = aquariums.get(aquariumName);
            aquarium.addFish(fish);
        } catch (IllegalArgumentException ex){
           return ex.getMessage();
        }
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        aquariums.get(aquariumName).feed();
        int fishCount = aquariums.get(aquariumName).getFish().size();
        return String.format(FISH_FED, fishCount);
    }

    @Override
    public String calculateValue(String aquariumName) {
        double value = 0.0;
        Aquarium aquarium = aquariums.get(aquariumName);
        value += aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        value += aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        return String.format(VALUE_AQUARIUM,aquariumName, value);
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        for (Aquarium aquarium : aquariums.values()) {
           builder.append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
