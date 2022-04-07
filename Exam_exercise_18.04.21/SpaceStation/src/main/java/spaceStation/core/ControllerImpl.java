package spaceStation.core;

import spaceStation.common.Command;
import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int exploredPlanetsCount;


    public ControllerImpl(){
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }
    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type){
            case "Biologist" -> astronaut = new Biologist(astronautName);
            case "Geodesist" -> astronaut = new Geodesist(astronautName);
            case "Meteorologist" -> astronaut = new Meteorologist(astronautName);
            default -> throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (this.astronautRepository.getModels().stream().noneMatch(a -> a.getName().equals(astronautName))){
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(this.astronautRepository.findByName(astronautName));
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> suitableAstronauts = this.astronautRepository
                .getModels()
                .stream()
                .filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());
        if (suitableAstronauts.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        Planet planet = planetRepository.findByName(planetName);
        int initialAstrNum = suitableAstronauts.size();
        mission.explore(planet, suitableAstronauts);
        int deadAstronauts = initialAstrNum - suitableAstronauts.size();
        exploredPlanetsCount++;
              return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        long count = astronautRepository.getModels().stream().filter(a -> a.getBag().getItems().size() == 0).count();

        StringBuilder builder = new StringBuilder();
//        if (count == astronautRepository.getModels().size()) {
//            builder.append("none");
//        } else {
            builder.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanetsCount)).append(System.lineSeparator())
                    .append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());

            this.astronautRepository.getModels().stream().forEach(a -> {
                builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, a.getName())).append(System.lineSeparator())
                        .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, a.getOxygen())).append(System.lineSeparator());

                if (a.getBag().getItems().size() == 0) {
                    builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
                } else {
                    Collection<String> items = a.getBag().getItems();
                    builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, String.join(",", items)))
                            .append(System.lineSeparator());
                }
            });
        //}


            return builder.toString();
        }
}
