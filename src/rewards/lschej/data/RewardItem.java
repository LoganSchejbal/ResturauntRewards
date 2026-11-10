package rewards.lschej.data;

import javax.swing.ImageIcon;

public class RewardItem {

    public static final ImageIcon DEFAULT_IMAGE = new ImageIcon(RewardItem.class.getResource("/rewards/lschej/data/1077596-200.png"));
    private ImageIcon image;
    private String name;
    private int price;

    public RewardItem() {
        image = null;
        name = "";
        price = 0;
    }

    public RewardItem(String imagePath, String name, int price) {
        if (!imagePath.equals("")) {
            image = new ImageIcon(imagePath);
        } else {
            image = null;
        }
        this.name = name;
        this.price = price;
    }

    public ImageIcon getImage() {
        if (image == null) {
            return DEFAULT_IMAGE;
        } else {
            return image;
        }
    }

    public void setImage(String imagePath) {
        if (!imagePath.equals("")) {
            image = new ImageIcon(imagePath);
        }
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
