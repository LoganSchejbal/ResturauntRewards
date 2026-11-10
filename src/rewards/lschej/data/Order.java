package rewards.lschej.data;

import java.time.LocalDate;

public class Order {

    private int orderNumber;
    private LocalDate orderDate;
    private double orderTotal;
    private int pointsAwarded;
    private int pointsUsed;

    public Order(int orderNumber, LocalDate orderDate, double orderTotal, DataController dataController) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        pointsAwarded = (int) (orderTotal * dataController.settings.getPointsToTotalRatio());
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public int getPoints() {
        return pointsAwarded - pointsUsed;
    }

    public int usePoints(int pointsUsed) {
        this.pointsUsed += pointsUsed;
        return -(this.pointsAwarded - this.pointsUsed);
    }
}
