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
}