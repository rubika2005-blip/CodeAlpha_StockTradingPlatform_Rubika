import java.util.*;

public class Portfolio {
    private double cash = 100_000.00; // starting cash ₹
    private final Map<String, Integer> holdings = new HashMap<>(); // symbol -> qty

    public double getCash() { return cash; }

    public void buy(Market market, String symbol, int qty) {
        if (qty <= 0) { System.out.println("❌ Quantity must be > 0"); return; }
        Stock s = market.get(symbol);
        if (s == null) { System.out.println("❌ Stock not found."); return; }

        double cost = s.getPrice() * qty;
        if (cost > cash) {
            System.out.println("❌ Not enough cash. Need ₹" + fmt(cost) + " but have ₹" + fmt(cash));
            return;
        }

        cash -= cost;
        holdings.put(s.getSymbol(), holdings.getOrDefault(s.getSymbol(), 0) + qty);
        System.out.println("✅ Bought " + qty + " share(s) of " + s.getSymbol() + " at ₹" + fmt(s.getPrice()) + " each.");
    }

    public void sell(Market market, String symbol, int qty) {
        if (qty <= 0) { System.out.println("❌ Quantity must be > 0"); return; }
        symbol = symbol.toUpperCase();
        Integer owned = holdings.get(symbol);
        if (owned == null || owned < qty) {
            System.out.println("❌ Not enough shares to sell.");
            return;
        }

        Stock s = market.get(symbol);
        if (s == null) { System.out.println("❌ Stock not found."); return; }

        double proceeds = s.getPrice() * qty;
        cash += proceeds;
        int remaining = owned - qty;
        if (remaining == 0) holdings.remove(symbol);
        else holdings.put(symbol, remaining);

        System.out.println("✅ Sold " + qty + " share(s) of " + symbol + " at ₹" + fmt(s.getPrice()) + " each.");
    }

    public void view(Market market) {
        System.out.println("\n💼 Portfolio");
        System.out.println("---------------------------");
        if (holdings.isEmpty()) System.out.println("No holdings yet.");
        else {
            double totalHoldings = 0.0;
            for (String sym : holdings.keySet()) {
                int qty = holdings.get(sym);
                Stock s = market.get(sym);
                double val = (s != null ? s.getPrice() : 0.0) * qty;
                totalHoldings += val;
                System.out.println(sym + " - " + qty + " share(s) @ ₹" + fmt(s.getPrice()) + " = ₹" + fmt(val));
            }
            System.out.println("---------------------------");
            System.out.println("Holdings Value: ₹" + fmt(totalHoldings));
        }
        System.out.println("Cash: ₹" + fmt(cash));
        System.out.println("Total Value: ₹" + fmt(getTotalValue(market)));
    }

    public double getTotalValue(Market market) {
        double total = cash;
        for (String sym : holdings.keySet()) {
            Stock s = market.get(sym);
            if (s != null) total += s.getPrice() * holdings.get(sym);
        }
        return round2(total);
    }

    private String fmt(double v) { return String.format("%.2f", v); }
    private double round2(double v) { return Math.round(v * 100.0) / 100.0; }
}
