import java.util.Scanner;

public class StockApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();
        Portfolio pf = new Portfolio();

        System.out.println("📈 Welcome to the Java Stock Trading Platform!");
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n---------------------------");
                System.out.println("1) View Market");
                System.out.println("2) Refresh Prices");
                System.out.println("3) Buy Stock");
                System.out.println("4) Sell Stock");
                System.out.println("5) View Portfolio");
                System.out.println("6) View Total Value");
                System.out.println("7) Exit");
                System.out.print("Choose an option: ");

                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1 -> market.display();
                    case 2 -> market.refreshPrices();
                    case 3 -> {
                        System.out.print("Enter stock symbol to BUY (e.g., AAPL): ");
                        String sym = sc.nextLine().trim();
                        System.out.print("Enter quantity: ");
                        int qty = Integer.parseInt(sc.nextLine().trim());
                        pf.buy(market, sym, qty);
                    }
                    case 4 -> {
                        System.out.print("Enter stock symbol to SELL (e.g., AAPL): ");
                        String sym = sc.nextLine().trim();
                        System.out.print("Enter quantity: ");
                        int qty = Integer.parseInt(sc.nextLine().trim());
                        pf.sell(market, sym, qty);
                    }
                    case 5 -> pf.view(market);
                    case 6 ->
                        System.out.println("💰 Total Value = ₹" + String.format("%.2f", pf.getTotalValue(market)));
                    case 7 -> {
                        System.out.println("👋 Exiting… Happy trading!");
                        running = false;
                    }
                    default -> System.out.println("❌ Invalid choice. Try again.");
                }

            } catch (NumberFormatException ex) {
                System.out.println("❌ Please enter a valid number.");
            } catch (Exception ex) {
                System.out.println("⚠️ Unexpected error: " + ex.getMessage());
            }
        }

        sc.close();
    }
}
