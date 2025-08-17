import java.util.*;

public class Market {
    private final Map<String, Stock> stocks = new HashMap<>();
    private final Random rng = new Random();

    public Market() {
        // Starter market (symbols + INR prices)
        add(new Stock("AAPL", "Apple Inc.", 150.00));
        add(new Stock("TSLA", "Tesla Inc.", 220.50));
        add(new Stock("AMZN", "Amazon.com Inc.", 185.75));
        add(new Stock("TCS", "Tata Consultancy Services", 3800.00));
        add(new Stock("INFY", "Infosys Ltd", 1600.00));
    }

    private void add(Stock s) {
        stocks.put(s.getSymbol(), s);
    }

    public Stock get(String symbol) {
        if (symbol == null)
            return null;
        return stocks.get(symbol.toUpperCase());
    }

    public Collection<Stock> all() {
        return stocks.values();
    }

    public void display() {
        System.out.println("\n📊 Market Watch");
        System.out.println("---------------------------");
        for (Stock s : stocks.values())
            System.out.println("• " + s);
    }

    // Simulate live price changes ±5%
    public void refreshPrices() {
        for (Stock s : stocks.values()) {
            double pct = 0.95 + (0.10 * rng.nextDouble()); // 0.95–1.05
            double newPrice = Math.max(1.0, s.getPrice() * pct);
            s.setPrice(round2(newPrice));
        }
        System.out.println("🔄 Prices refreshed!");
    }

    private double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
