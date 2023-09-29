public class Item {
    private String itemName;
    private String description;

    public Item(String name, String description) {
        this.itemName = name;
        this.description = description;
    }

    public String getitemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setName() {
        this.itemName = itemName;
    }

    public void setDescription() {
        this.description = description;
    }

    @Override
    public String toString() {
        return itemName + " " + description;
    }
}
