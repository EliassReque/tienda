package base;


public class productos {
    private String name;
    private double prize;
    private long code;
    private int quantity;

    public productos() {
        this.name = "";
        this.prize = 0;
        this.code = 0;
        this.quantity = 0;
    }

    public productos(String name, double prize, long code, int quantity) {
        this.name = name;
        this.prize = prize;
        this.code = code;
        this.quantity = quantity;
    }

    public productos(productos producto) {
        this.name = producto.name;
        this.prize = producto.prize;
        this.code = producto.code;
        this.quantity = producto.quantity;

    }

    @Override
    public String toString() {
        return "Producto --> nombre=" + name + ", precio= " + prize + ", código= " + code + ", cantidad= " + quantity ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    
}