package viceCity.models.guns;

public class Rifle extends BaseGun{
    private static int bulletsPerBarrel =50;
    private static int totalBullets =500;
    public Rifle(String name) {
        super(name, bulletsPerBarrel, totalBullets);
        setFireBulletsAtOnceCount(5);
    }
}
