package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BankVaultTest {
    private static BankVault bankVault;
    private static Item item;
    @Before
    public void prepData(){
        bankVault = new BankVault();
        String ownerName = "Anton";
        String itemId = "1";
        item = new Item(ownerName,itemId);
    }

    @Test
    public void testConstructor(){
        Set<Map.Entry<String, Item>> entry = bankVault.getVaultCells().entrySet();
        for (Map.Entry<String, Item> itemEntry : entry) {
            Assert.assertNull(itemEntry.getValue());
        }
    }

    @Test
    public void testAddItems() throws OperationNotSupportedException {
        Assert.assertEquals(bankVault.addItem("A1",item), String.format("Item:%s saved successfully!", item.getItemId()));
        Assert.assertEquals(bankVault.getVaultCells().get("A1"), item);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfCellDoesntExist() throws OperationNotSupportedException {
        bankVault.addItem("invalid", item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfCellIsAlreadyTaken() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        bankVault.addItem("A1",new Item("pesho","123"));
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowIfItemIsAlreadyInCell() throws OperationNotSupportedException {
        bankVault.addItem("A1",item);
        bankVault.addItem("A2",item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowIfCellDoesntExist() throws OperationNotSupportedException {
        bankVault.removeItem("invalid", item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowIfItemInThatCellDoesntExist(){

        bankVault.removeItem("A3",item);
    }
    @Test
    public void testRemove() throws OperationNotSupportedException {
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
        bankVault.addItem("A1", item);
        Assert.assertNotNull(bankVault.getVaultCells().get("A1"));
       Assert.assertEquals(bankVault.removeItem("A1",item),String.format("Remove item:%s successfully!", item.getItemId()));
    }
}