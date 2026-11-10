package rewards.lschej.data;

import java.time.LocalDate;

public class MemberRewards {

    private int pointsTotal;
    private LocalDate expiryDate;

    public MemberRewards() {
        pointsTotal = 0;
        expiryDate = LocalDate.now();
    }

    public void updatePoints(int pointsTotal, LocalDate expiryDate) {
        this.pointsTotal = pointsTotal;
        this.expiryDate = expiryDate;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
