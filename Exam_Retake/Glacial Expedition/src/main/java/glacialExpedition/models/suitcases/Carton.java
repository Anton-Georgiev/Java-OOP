package glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;

public class Carton implements Suitcase{
    private Collection<String> exhibits;

    public Carton(){
        exhibits = new ArrayList<>();
    }

    public void addToExhibits(String exhibit){
        exhibits.add(exhibit);
    }
    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }
}
