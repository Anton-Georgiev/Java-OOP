package MilitaryElite.Soldiers;

import MilitaryElite.Corps;
import MilitaryElite.Interfaces.SpyImpl;

public class Spy extends SpecialisedSoldier implements SpyImpl {

    String codeNumber;

    public Spy(Corps corp) {
        super(corp);
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }
}
