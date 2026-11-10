package rewards.lschej.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderHistory {

    private final List<Order> orders;

    public OrderHistory() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order newOrder) {
        int lowerBound = 0;
        int upperBound = orders.size();

        while (lowerBound < upperBound) {
            int middleIndex = lowerBound + ((upperBound - lowerBound) / 2);

            if (orders.get(middleIndex).getOrderDate().isAfter(newOrder.getOrderDate())) {
                upperBound = middleIndex;
            } else {
                lowerBound = middleIndex + 1;
            }
        }

        orders.add(lowerBound, newOrder);
    }

    public double returnTotals() {
        double total = 0.0;
        for (Order order : orders) {
            total += order.getOrderTotal();
        }
        return total;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public int collectPoints() {
        int points = 0;
        for (Order order : orders) {
            points += order.getPoints();
        }
        return points;
    }

    public LocalDate getOldesDate() {
        if (orders.isEmpty()) {
            return LocalDate.now().plusDays(1);
        }
        return orders.get(0).getOrderDate().plusDays(DataController.settings.getPointsLifespan());
    }

    public int getOrderCount() {
        return orders.size();
    }

    public void removeOldest() {
        orders.remove(0);
    }

    public void redeemPoints(int points) {
        int i = 0;
        while (points > 0 && i < orders.size()) {
            points = orders.get(i).usePoints(points);
            ++i;
        }
    }

    public Order findOrder(LocalDate orderDate, int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber && order.getOrderDate().isEqual(orderDate)) {
                return order;
            }
        }

        return null;
    }
}
