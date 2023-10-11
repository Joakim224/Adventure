import com.sun.net.httpserver.Authenticator;
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
        room.createFood("Apple", "gives 10 health points", 10);

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
        Player player = new Player(90);
        player.setCurrentRoom(room);
        player.takeItem("Apple");
        player.eatFood("Apple");
        //Assert

        Assert.assertEquals(100, player.getHealth());
    }

    @Test
    public void test_equip_weapon_from_inventory() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createMeleeWeapon("Sword", "Sharp", 10);

        //Act
        Player player = new Player(100);
        player.setCurrentRoom(room);
        player.takeItem("Sword");


        //Assert
        ReturnMessage result = player.equipWeapon("Sword");
        Assert.assertEquals(ReturnMessage.OK, result);
    }

    @Test
    public void test_unEquip_weapon_from_inventory() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createMeleeWeapon("Sword", "Sharp", 10);


        //Act
        Player player = new Player(100);
        player.setCurrentRoom(room);
        player.takeItem("Sword");
        player.equipWeapon("Sword");
        player.unEquipWeapon();

        //Assert
        ReturnMessage result = player.unEquipWeapon();
        Assert.assertEquals(ReturnMessage.OK, result);
    }

    @Test
    public void test_attack_enemy_with_melee_weapon() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createMeleeWeapon("Sword", "Sharp", 40);
        room.createEnemy("Gromp", "big ass frog", 45, new MeleeWeapon("Claws", "Deals 20 dmg", 20), room);

        //Act
        Player player = new Player(100);
        Enemy enemy = new Enemy("Gromp", "big ass frog", 45, new MeleeWeapon("Claws", "Deals 20 dmg", 20), room);
        player.setCurrentRoom(room);
        player.takeItem("Sword");
        player.equipWeapon("Sword");

        //Assert
        ReturnMessage result = player.attack("Gromp");
        Assert.assertEquals(ReturnMessage.OK, result);
    }

    @Test
    public void test_attack_enemy_health_after_melee_attack() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createMeleeWeapon("Sword", "Sharp", 40);
        room.createEnemy("Gromp", "big ass frog", 45, new MeleeWeapon("Claws", "Deals 20 dmg", 20), room);

        //Act
        Player player = new Player(100);
        Enemy enemy = new Enemy("Gromp", "big ass frog", 45, new MeleeWeapon("Claws", "Deals 20 dmg", 20), room);
        player.setCurrentRoom(room);
        player.takeItem("Sword");
        player.equipWeapon("Sword");
        player.attack("Gromp");

        //Assert
        ReturnMessage result;
        Assert.assertEquals(5, room.searchEnemies("Gromp").getHealth());
    }

    @Test
    public void test_player_health_after_enemy_attack() {
        //Arange
        Room room = new Room("testRoom", "test");
        room.createMeleeWeapon("Sword", "Sharp", 40);
        room.createEnemy("Gromp", "big ass frog", 45, new MeleeWeapon("Claws", "Deals 20 dmg", 20), room);

        //Act
        Player player = new Player(100);
        Enemy enemy = new Enemy("Gromp", "big ass frog", 45, new MeleeWeapon("Claws", "Deals 20 dmg", 20), room);
        player.setCurrentRoom(room);
        player.takeItem("Sword");
        player.equipWeapon("Sword");
        player.attack("Gromp");

        //Assert
        ReturnMessage result;
        Assert.assertEquals(80, player.getHealth());
    }
}