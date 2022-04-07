package viceCity.models.guns;

public class Pistol extends BaseGun{
    private static int bulletsPerBarrel =10;
    private static int totalBullets =100;
    private static int bulletsInBarrelCount = bulletsPerBarrel;

    public Pistol(String name) {
        super(name, bulletsPerBarrel, totalBullets);
        setFireBulletsAtOnceCount(1);
    }

}




