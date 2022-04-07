package aquarium;

import  org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private Aquarium aquarium;
    private Fish fish;

    @Before
    public void setDatabase(){
        aquarium = new Aquarium("aqua 1", 3);
        fish = new Fish("fish");
       // aquarium.add(fish);
    }

    @Test
    public void setAquariumConstructor(){

        String aquaName = "akvarium 1";
        aquarium = new Aquarium(aquaName, 10);
        Assert.assertEquals(aquarium.getName(),aquaName);
        Assert.assertEquals(aquarium.getCapacity(), 10);
      //  Assert.assertEquals("getCount fucked up",aquarium.getCount(), 1);
    }

    @Test (expected = NullPointerException.class)
    public void setAquariumShouldthrowWhenNull(){
        aquarium = new Aquarium(null, 4);
    }

    @Test (expected = NullPointerException.class)
    public void setAquariumShouldThrowWhenEmpty(){
        aquarium = new Aquarium(" ",3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setAquariumCapacityShouldFailNegative(){
        aquarium = new Aquarium("hgfd", -23);
    }



    @Test (expected = IllegalArgumentException.class)
    public void addShouldThrowWhenAquariumIsFull(){
        aquarium.add(new Fish("tosho"));
        aquarium.add(new Fish("tosho"));
        aquarium.add(new Fish("Gosho"));
        aquarium.add(new Fish("losho"));
        aquarium.add(new Fish("fail"));
    }


    @Test
    public void addShouldIncraseFishSize(){
        aquarium = new Aquarium("Anton",5);
        aquarium.add(new Fish("ribata"));
        Assert.assertEquals(1, aquarium.getCount());

    }

    @Test (expected = IllegalArgumentException.class)
    public void removeShouldThrowIfParamIsNull(){
        aquarium.remove(null);
    }

    @Test
    public void remove(){
        aquarium.add(fish);
        Assert.assertEquals(1,aquarium.getCount());
        aquarium.remove(fish.getName());
        Assert.assertEquals(0,aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void sellFishShouldThrowWhenParamIsNull(){
        aquarium.sellFish(null);
    }

    @Test
    public void sellFishh(){
        Fish riba = new Fish("vanko");
        aquarium.add(riba);
        //Assert.assertEquals(aquarium.sellFish(riba.getName()), riba);
         aquarium.sellFish(riba.getName());
    }

    @Test
    public void report(){
        aquarium = new Aquarium("aqua",5);
        aquarium.add(new Fish("kolio"));
        aquarium.add(new Fish("vanio"));
        aquarium.add(new Fish("joro"));
        aquarium.remove("kolio");

        String expected = "Fish available at aqua: vanio, joro";
        Assert.assertEquals(expected, aquarium.report());

    }
}

