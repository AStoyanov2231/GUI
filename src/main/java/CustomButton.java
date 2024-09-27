import javax.swing.*;
import java.awt.*;

public class CustomButton {

    public static JButton createButton(String iconPath, String toolTip) {
        ImageIcon icon = new ImageIcon(iconPath);
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Resize to 50x50
        ImageIcon resizedIcon = new ImageIcon(img);

        JButton button = new JButton(resizedIcon);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setToolTipText(toolTip);

        return button;
    }
}