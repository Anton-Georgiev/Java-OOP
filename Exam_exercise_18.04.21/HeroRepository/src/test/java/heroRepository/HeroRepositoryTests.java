package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private Hero hero;
    private HeroRepository repository;

    @Before
    public  void prepData(){
        hero = new Hero("Anton", 20);
        repository = new HeroRepository();
    }

    @Test
    public void testCreateAndGetCount(){
        Assert.assertEquals(0,repository.getCount());
        repository.create(hero);
        Assert.assertEquals("doesn't create obj",1, repository.getCount());

    }
    @Test (expected = NullPointerException.class)
    public void testCreateShouldThrowWhenParamIsNull(){
        repository.create(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateShouldThrowIfHeroAlreadyExist(){
        repository.create(hero);
        repository.create(hero);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveShouldThrowIfParamIsNull(){
       repository.remove(null);
    }
    @Test (expected = NullPointerException.class)
    public void testRemoveShouldThrowIfParamIsEmpty(){
       repository.remove("");
    }

    @Test
    public void testRemove(){
        repository.create(hero);
        repository.remove(hero.getName());
    }

    @Test
    public void testGetHeroShouldReturnNullIfRepoEmpty(){
        Assert.assertNull(repository.getHero("Anton"));
    }

   @Test
    public void testGetHeroWithHighestLevelShouldReturnNullIfRepoEmpty(){
        Assert.assertNull(repository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroes(){
        repository.create(hero);
        repository.create(new Hero("joro", 19));
        repository.getHeroes();
    }
}
