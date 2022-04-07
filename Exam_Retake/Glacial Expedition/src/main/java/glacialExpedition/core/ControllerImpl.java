package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private List<Explorer> explorers;
    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
        explorers = new ArrayList<>();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
            explorerRepository.add(explorer);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
            explorerRepository.add(explorer);
        } else if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
            explorerRepository.add(explorer);
        }
        else throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);

        return String.format(EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName,exhibits);
        stateRepository.add(state);
        return String.format(STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName){
        Explorer explorer = explorerRepository.byName(explorerName);
        if (explorerRepository.getCollection().stream()
                .anyMatch(e -> e.getName().equals(explorerName)))
        {
            explorerRepository.remove(explorer);
            return String.format(EXPLORER_RETIRED, explorerName);
        } else throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
    }

    @Override
    public String exploreState(String stateName) {
        Mission mission = new MissionImpl();
         this.explorers = explorerRepository
                .getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        State state = stateRepository.byName(stateName);

        int explorersBeforeMissionCount = explorers.size();
        if (explorers.size()<1){
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        mission.explore(state,explorers);
        int retiredExplorersCount = explorersBeforeMissionCount - explorers.size();
        return String.format(STATE_EXPLORER,stateName,retiredExplorersCount);
    }

    @Override
    public String finalResult() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format(FINAL_STATE_EXPLORED,1));
        sb.append(System.lineSeparator());
        sb.append(FINAL_EXPLORER_INFO);
        sb.append(System.lineSeparator());

        for (Explorer explorer : explorerRepository.getCollection()) {
            String exhibitsStr = String.join(", ", explorer.getSuitcase().getExhibits());
            if (explorer.getSuitcase().getExhibits().size() ==0){
                exhibitsStr = "None";
            }

            sb.append(String.format(FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_EXPLORER_ENERGY,explorer.getEnergy())).append(System.lineSeparator());
            sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,exhibitsStr)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
