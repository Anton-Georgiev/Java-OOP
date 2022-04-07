package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {



    @Override
    public void explore(State state, List<Explorer> explorers) {
//        List<Explorer> explorerList = explorers
//                .stream()
//                .filter(Explorer::canSearch).collect(Collectors.toList());

        List<String> exhibits = new ArrayList<>(state.getExhibits());
        boolean noMoreExhibits = false;
        for (int i = 0; i < explorers.size(); i++) {
            Explorer currExplorer = explorers.get(i);

            for (int j = 0; j < exhibits.size(); j++) {
                String currExhibit = exhibits.get(j);
                if (i == exhibits.size()-1){
                    noMoreExhibits = true;
                }
                if (currExplorer.canSearch()) {
                    currExplorer.search();
                   currExplorer.getSuitcase().getExhibits().add(currExhibit);
                    state.getExhibits().remove(currExhibit);

                } else break;
            }
            if (noMoreExhibits){
                break;
            }
        }
    }
}
