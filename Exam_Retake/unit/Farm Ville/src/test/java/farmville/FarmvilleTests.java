package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class FarmvilleTests {
    private static Farm farm;
    private static Animal animal;

    @Before
    public void prepData(){
        String farmName = "haskovo";
        int capacity = 2;
        farm = new Farm(farmName,capacity);
        animal = new Animal("kon", 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfCapacityIsFull(){
        farm.add(animal);
        farm.add(new Animal("krava",2));
        farm.add(new Animal("bivol",3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfAnimalExists(){
        farm.add(animal);
        farm.add(animal);
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(0, farm.getCount());
        farm.add(animal);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testRemoveShouldThrowIfDoesntExist(){
        farm.remove("zebra");
    }
    @Test
    public void testRemove(){
        farm.add(animal);
        Assert.assertEquals(1, farm.getCount());
        Assert.assertTrue(farm.remove(animal.getType()));
        Assert.assertEquals(0, farm.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameEmpty(){
        farm = new Farm(null,2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShoutThorwIfBelow0(){
        farm = new Farm("hs",-3);
    }
    @Test
    public void getName(){
        Assert.assertEquals(farm.getName(), "haskovo");
    }
}

