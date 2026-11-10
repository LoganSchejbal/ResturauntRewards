package rewards.lschej.data;

public class Settings {

    private double pointsToTotalRatio = 10;
    private int pointsLifespan = 180;

    public double getPointsToTotalRatio() {
        return pointsToTotalRatio;
    }

    public void setPointsTotToalRatio(double ratio) {
        pointsToTotalRatio = ratio;
    }

    public int getPointsLifespan() {
        return pointsLifespan;
    }

    public void setPointsLifespan(int pointsLifespan) {
        this.pointsLifespan = pointsLifespan;
    }
}
