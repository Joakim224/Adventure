import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {


    @Test
    public void takeItem_ItemReturnedFromRoomIsNull_DoNotAddToInventory(){

        // Arrange
        Player player = new Player();
        player.setCurrentRoom(new Room("testroom", "test"));

        // Act
        player.takeItem("Sword");

        // Assert
        ArrayList<Item> Items =  player.getInventory();
        Assert.assertEquals(0, Items.size());
    }

}