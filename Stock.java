public class Stock {
    private final String symbol;
    private final String name;
    private double price; // current market price

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol.toUpperCase();
        this.name = name;
        this.price = price;
    }

    public String getSymbol() { return symbol; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return symbol + " (" + name + ") - ₹" + String.format("%.2f", price);
    }
}
