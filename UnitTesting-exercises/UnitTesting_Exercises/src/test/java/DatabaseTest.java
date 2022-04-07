import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {5,8,20,46,38};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasToCreateValidObject(){
        Integer[] databaseElements = database.getElements();
        //proverka dali broq na elementitie e ednakuv
        Assert.assertEquals("Count of elements is incorrect!",NUMBERS.length,databaseElements.length);

        for (int i = 0; i < databaseElements.length; i++) {
            Assert.assertEquals("elements differ",NUMBERS[i], databaseElements[i]);
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenUsedMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);

    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionWhenParamIsNull() throws OperationNotSupportedException {
        database.add(null);

    }

    @Test
    public void testAddShouldAddElements() throws OperationNotSupportedException {
//        Integer[] numbers = new Integer[10];
//        new Database(numbers);
        database.add(7);
        Assert.assertEquals(database.getElements().length, 6);
        Assert.assertEquals(database.getElements()[5], Integer.valueOf(7));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowIfElementsAre0() throws OperationNotSupportedException {
       Integer[] numbers = new Integer[0];
       new Database(numbers);
       database.remove();
    }

    @Test
    public void testRemoveShouldDeleteLastElement() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements().length,NUMBERS.length-1);
        Assert.assertEquals(database.getElements()[database.getElements().length-1], NUMBERS[NUMBERS.length-2]);
    }
}
