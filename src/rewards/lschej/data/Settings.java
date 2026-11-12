package rewards.lschej.data;

import java.awt.Font;

public class Settings {

    private double pointsToTotalRatio = 10;
    private int pointsLifespan = 180;

    public String fontName = "Calibri";
    public Font regularTextFont = new Font(fontName, Font.PLAIN, 14);
    public Font headerTextFont = new Font(fontName, Font.PLAIN, 24);
    public Font boldedFont = new Font(fontName, Font.BOLD, 20);
    public Font largerRegularFont = new Font(fontName, Font.PLAIN, 18);
    public Font mediumRegularFont = new Font(fontName, Font.PLAIN, 20);
    public Font largeRegularFont = new Font(fontName, Font.PLAIN, 24);
    public Font menuFont = new Font(fontName, Font.PLAIN, 16);
    public Font tabFont = new Font(fontName, Font.PLAIN, 32);
    public Font largeHeaderFont = new Font(fontName, Font.BOLD, 36);
    public Font dialogHeaderFont = new Font(fontName, Font.BOLD, 30);
    public Font titleFont = new Font(fontName, Font.BOLD, 50);

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
