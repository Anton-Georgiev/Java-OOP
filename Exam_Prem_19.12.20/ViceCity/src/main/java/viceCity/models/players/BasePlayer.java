package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import static viceCity.common.ExceptionMessages.NAME_NULL;

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private GunRepository gunRepository;

    public BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        gunRepository = new GunRepository();
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException();
        }
        this.lifePoints = lifePoints;
    }

    private void setName(String name) {
        if (name == null || name.equals(" ")) {
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public boolean isAlive() {
        if (lifePoints >0){
            return true;
        }
        return false;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        lifePoints -= points;
    }
}
