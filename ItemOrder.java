public class ItemOrder {
    private Item item;
    private int amount;

    // getters
    public Item getItem() {
        return item;
    }
    public int getAmount() {
        return amount;
    }

    // setters
    public void setItem(Item item) {
        this.item = item;
        System.out.println("the item is now: " + this.item);
    }
    public void setAmount(int amount) {
        this.amount = amount;
        System.out.println("the amount is now: " + this.amount);
    }
    public ItemOrder(Item item, int amount) {
        setItem(item);
        setAmount(amount);
    }
}
