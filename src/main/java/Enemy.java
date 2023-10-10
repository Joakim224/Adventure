public class Enemy {
    private String enemyName;
    private String description;
    private int enemyHealth;
    private Weapon weapon;
    private Room room;

    public Enemy(String enemyName, String description, int health, Weapon weapon, Room room){
        this.enemyName = enemyName;
        this.description = description;
        this.enemyHealth = health;
        this.weapon = weapon;
        this.room = room;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int health) {
        this.enemyHealth = enemyHealth;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public boolean enemyDead() {
        if (enemyHealth < 1) {
            room.removeEnemy(enemyName);
            room.addItem(weapon);
            System.out.println("You killed " + enemyName);
            return true;
        } else {
            return false;
        }
    }

    public void hit(int damage) {
        enemyHealth -= damage;
    }

    @Override
    public String toString() {
        return enemyName + " - " + description;
    }

    /*public void attack(Weapon weapon) {
      this.healt -= weapon.getDamage();
    }*/
}
