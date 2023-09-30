import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;



public class PlayerTest {


    @Test
    public void takeItem_ItemReturnedFromRoomIsNull_DoNotAddToInventory(){

        // Arrange
        Room room = new Room("testroom", "test");

        // test

        Player player = new Player();
        player.setCurrentRoom(room);

        // Act
        player.takeItem("Sword");

        // Assert
        ArrayList<Item> items =  player.getInventory();
        Assert.assertEquals(0, items.size());
    }

    @Test
    public void takeItem_itemfroomroom_Addtoinventory(){
        //Arange
        Room room = new Room("testRoom", "test");
        room.addItem("Knife", "Sharp");

        Player player = new Player();
        player.setCurrentRoom(room);

        //Act
        player.takeItem("Knife");

        //Assert
        ArrayList<Item> items = player.getInventory();
        Assert.assertEquals(1, items.size());
    }

}