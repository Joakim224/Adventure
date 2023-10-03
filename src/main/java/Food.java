public class Food extends Item {
    private int healpoints;

   public Food(String itemName, String itemDescription, int healpoints) {
       super(itemName, itemDescription);
       this.healpoints = healpoints;
   }

    public int getHealpoints(){
        return healpoints;
    }

    @Override
    public String toString() {
        return "Food { " + super.toString() +
                " - heals for " + healpoints + " points of health" +
                " }";
    }
}
