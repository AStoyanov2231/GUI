import javax.swing.*;
import java.awt.*;

public class ImageResizer {
    public static ImageIcon resizeIcon(String iconPath, int width, int height) {
        ImageIcon icon = new ImageIcon(iconPath);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
