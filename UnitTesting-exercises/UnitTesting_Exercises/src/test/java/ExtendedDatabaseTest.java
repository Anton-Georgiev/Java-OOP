import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1,"First"),
            new Person(2,"Second"),
            new Person(3,"third")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }


    @Test
    public void testConstructorHasToCreateValidObject() throws OperationNotSupportedException {
//        Person[] databaseObjects = database.getElements();
//        Assert.assertEquals(databaseObjects.length, PEOPLE.length);
//        for (int i = 0; i < databaseObjects.length; i++) {
//            Assert.assertEquals(databaseObjects[i], PEOPLE[i]);
//        }
        Assert.assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowIfParamWithSameId() throws OperationNotSupportedException {
       // Person[] people = {new Person(1, "First"), new Person(1, "Second")};
        //Database database = new Database(people);
        database.add(new Person(2, "repeatedTest"));
//        for (int i = 0; i < database.getElements().length-1; i++) {
//            Assert.assertNotSame("Id Repeats", database.getElements()[i], database.getElements()[i + 1]);
//        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParamIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElements() throws OperationNotSupportedException {
        database.add(new Person(4, "fourth"));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemove() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowiFArgumentIsntInDatabase() throws OperationNotSupportedException {
        database.findByUsername("ima li go");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowIfArgIsNull() throws OperationNotSupportedException {
        database.findById(null);
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        database.findByUsername("Second");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowIfNoIdFound() throws OperationNotSupportedException {
        database.findById(6L);
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {
        database.findById(2L);
    }
}
