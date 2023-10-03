import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {


    @Test
    public void takeItem_ItemReturnedFromRoomIsNull_DoNotAddToInventory() {

        // Arrange
        Room room = new Room("testroom", "test");

        Player player = new Player(100);
        player.setCurrentRoom(room);

        // Act
        player.takeItem("Sword");

        // Assert
        ArrayList<Item> items = player.getInventory();
        Assert.assertEquals(0, items.size());
    }

    @Test
    public void takeItem_itemFroomRoom_AddToInventory() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createItem("Knife", "Sharp");

        Player player = new Player(100);
        player.setCurrentRoom(room);

        //Act
        player.takeItem("Knife");

        //Assert
        ArrayList<Item> items = player.getInventory();
        Assert.assertEquals(1, items.size());
    }

    @Test
    public void dropItem_itemFroomRoom_removeFromInventory() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createItem("Knife", "Sharp");

        Player player = new Player(100);
        player.setCurrentRoom(room);

        //Act
        player.takeItem("Knife");
        player.dropItem("Knife");

        //Assert
        ArrayList<Item> items = player.getInventory();
        Assert.assertEquals(0, items.size());
    }

    @Test
    public void test_eat_something() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createFood("Apple", "gives 10 health points",10);

        //Act
        Player player = new Player(100);
        player.setCurrentRoom(room);
        player.takeItem("Apple");

        //Assert
        ReturnMessage result = player.eatFood("Apple");
        Assert.assertEquals(ReturnMessage.OK, result);
    }

    @Test
    public void eat_something_not_in_room() {
        //Anrange
        Room room = new Room("testRoom", "test");
        Player player = new Player(100);

        //Act
        player.setCurrentRoom(room);

        //Assert
        ReturnMessage result = player.eatFood("apple");
        Assert.assertEquals(ReturnMessage.NOT_FOUND, result);
    }

    @Test
    public void eat_something_not_in_inventory() {
       //Arange
        Room room = new Room("testRoom", "test");
        room.createItem("Sword", "Deals 10 dmg");

        //Act
        Player player = new Player(100);
        player.setCurrentRoom(room);
        player.takeItem("Sword");

        //Assert
        ReturnMessage result = player.eatFood("Sword");
        Assert.assertEquals(ReturnMessage.CANT, result);
    }
    @Test
    public void test_updated_health() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createFood("Apple", "gives 10 health points", 10);

        //Act
        Player player = new Player(100);
        player.setCurrentRoom(room);
        player.takeItem("Apple");
        player.eatFood("Apple");
        //Assert

        Assert.assertEquals(110,player.getHealth());
    }
}