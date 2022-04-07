package viceCity.models.guns;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    boolean canFire;
    private int currentBulletsInBarrel = bulletsPerBarrel;
    private int fireBulletsAtOnceCount;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
    }

    protected void setFireBulletsAtOnceCount(int num) {
        this.fireBulletsAtOnceCount = num;
    }
    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setName(String name){
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
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        canFire = currentBulletsInBarrel > fireBulletsAtOnceCount;
        return currentBulletsInBarrel > fireBulletsAtOnceCount;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

    @Override
    public int fire() {
        if (canFire()){
            currentBulletsInBarrel -=fireBulletsAtOnceCount;
            return fireBulletsAtOnceCount;
        } else {
            if (totalBullets< bulletsPerBarrel){
                currentBulletsInBarrel += totalBullets;
                totalBullets =0;
            }
            totalBullets -= bulletsPerBarrel - currentBulletsInBarrel;
            currentBulletsInBarrel = bulletsPerBarrel;
            currentBulletsInBarrel-= fireBulletsAtOnceCount;
            return fireBulletsAtOnceCount;
        }
    }
}
