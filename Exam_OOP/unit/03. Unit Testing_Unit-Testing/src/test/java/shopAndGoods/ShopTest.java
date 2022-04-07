package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;
    private Goods goods;

    @Before
    public void prepData(){
        String goodsName = "coffee";
        String goodsCode = "667";
        shop = new Shop();
        goods = new Goods(goodsName,goodsCode);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addGoodsShouldthrowIfNoSuchShelve() throws OperationNotSupportedException {
        shop.addGoods("Shelvesss1",goods);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addGoodsShouldThrowIfAlreadyTaken() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", new Goods("hlqb", "123"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowWhenItemAddedElseWhere() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test
    public void add() throws OperationNotSupportedException {
       Assert.assertEquals(shop.addGoods("Shelves2", goods),String.format("Goods: %s is placed successfully!",goods.getGoodsCode()));
    }
    //moje oshte edin add()

    @Test (expected = IllegalArgumentException.class)
    public void removeGoodsShouldThrowIfMissing() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves234", new Goods("missing", "12"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeThrowInThatShelve() throws OperationNotSupportedException {
      //  Assert.assertNull(shop.getShelves().entrySet().stream()..get("Shelves1").getGoodsCode());
        shop.addGoods("Shelves1", goods);
        Assert.assertEquals(shop.getShelves().get("Shelves1").getGoodsCode(), goods.getGoodsCode());
        shop.removeGoods("Shelves2", goods);
    }

    @Test
    public void remove() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }
}