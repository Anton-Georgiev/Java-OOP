package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<Astronaut> astronautList = astronauts.stream().toList();
        int itemsSize =planet.getItems().size();
        for (int index =0; index<astronauts.size(); index++) {
            Astronaut astronaut = astronautList.get(index);

            for (int i =0; i <itemsSize;i++) {
                List<String> items = planet.getItems().stream().collect(Collectors.toList());

                String item = items.get(i);
                astronaut.getBag().getItems().add(item);
                planet.getItems().remove(item);
               // i--;
                astronaut.breath();
                if (!astronaut.canBreath()){
                    astronauts.remove(astronaut);
                  //  index--;
                    break;
                }
            }
        }
    }
}
