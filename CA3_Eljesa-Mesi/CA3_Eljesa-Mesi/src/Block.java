public class Block {
    int qty;
    int price;
    double cost;

    public Block(int qty, int price) {
        this.qty = qty;
        this.price = price;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getCost() {
        return price * qty;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
