package rewards.lschej.data;

import java.time.LocalDate;

public class Member {

    private String PhoneNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String emailAddress;
    private OrderHistory orderHistory;
    private MemberRewards rewards;

    public Member(String number, String fName, String lName, String birthday, String email) {
        PhoneNumber = number;
        firstName = fName;
        lastName = lName;
        int month = Integer.parseInt(birthday.substring(0, 2));
        int day = Integer.parseInt(birthday.substring(2, 4));
        int year = Integer.parseInt(birthday.substring(4, 8));
        this.birthday = LocalDate.of(year, month, day);
        emailAddress = email;
        orderHistory = new OrderHistory();
        rewards = new MemberRewards();
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private void certifyRewards() {
        while (rewards.isExpired()) {
            if (orderHistory.getOrderCount() == 0) {
                rewards.updatePoints(0, LocalDate.now().plusDays(1));
                break;
            }
            orderHistory.removeOldest();
            rewards.updatePoints(orderHistory.collectPoints(), orderHistory.getOldesDate());
        }
        rewards.updatePoints(orderHistory.collectPoints(), orderHistory.getOldesDate());
    }

    public void addOrder(Order order) {
        orderHistory.addOrder(order);
        certifyRewards();
    }

    public int getPoints() {
        certifyRewards();
        return rewards.getPointsTotal();
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public boolean hasSufficientBalance(int pointsToRedeem) {
        certifyRewards();
        return (rewards.getPointsTotal() - pointsToRedeem) >= 0;
    }

    public void redeemPoints(int points) {
        orderHistory.redeemPoints(points);
        rewards.updatePoints(orderHistory.collectPoints(), orderHistory.getOldesDate());
    }
}
