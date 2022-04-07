package blueOrigin;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private  Spaceship spaceship;
    private Astronaut astronaut;

    @Before
    public void prepData(){
        String Aname = "Anton";
        int oxygen = 80;
        spaceship = new Spaceship("jet", 5);
        astronaut = new Astronaut(Aname,oxygen);
    }


    @Test (expected = NullPointerException.class)
    public void setName(){
        spaceship= new Spaceship(null, 5);
    }
    @Test
    public void setSpaceship(){
        spaceship = new Spaceship("Jet", 5);
    }
//    @Test
//    public void getCount(){
//        spaceship.add(astronaut);
//        assertEquals(1, spaceship.getCount());
//
//    }
//
//    @Test
//    public void getName(){
//        assertEquals(spaceship.getName(), "jet");
//    }
//
//    @Test
//    public void getCapacity(){
//        assertEquals(5, spaceship.getCapacity());
//    }

    @Test (expected = IllegalArgumentException.class)
    public void addShouldThrowWhenMaxCapacity(){
        spaceship = new Spaceship("jet", 3);
        spaceship.add(new Astronaut("a1", 70));
        spaceship.add(new Astronaut("a2", 50));
        spaceship.add(new Astronaut("a3", 30));
        spaceship.add(new Astronaut("a4", 30));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addExistingThrow(){
        spaceship = new Spaceship("jet", 3);
        spaceship.add(new Astronaut("a1", 70));
        spaceship.add(new Astronaut("a1", 70));
    }

    @Test
    public void removeNull(){
        spaceship.add(astronaut);
        spaceship.remove(astronaut.getName());
        assertEquals(0 , spaceship.getCount());
    }

//    @Test
//    public


    @Test(expected = IllegalArgumentException.class)
    public void setCapacityThrowIfBelow0(){
        spaceship = new Spaceship("jet", -8);
    }


}
