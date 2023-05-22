import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d %s\n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s!\n", userName);
        int numAhead = customers.size();
        System.out.printf("There are %d people in front of you.\n", numAhead);
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        double discount = 0.50;
        for (int quantity = 1; quantity <= maxQuantity; quantity++) {
            double totalPrice = price * quantity;
            System.out.printf("%d - %s\n", quantity, formatCurrency(totalPrice));
            price -= discount;
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d %s -- %s\n", i, menuItems.get(i), formatCurrency(prices.get(i)));
        }

        return true;
    }

    public void addCustomers() {
        ArrayList<String> customers = new ArrayList<>();
        String input;
        do {
            System.out.println("Please enter customer name (or 'q' to quit):");
            input = System.console().readLine();
            if (!input.equalsIgnoreCase("q")) {
                customers.add(input);
            }
        } while (!input.equalsIgnoreCase("q"));

        System.out.println("Customers entered: " + customers);
    }

    private String formatCurrency(double amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormat.format(amount);
    }
}
