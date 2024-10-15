import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private final int borderRadius;

    public RoundedPanel(int radius) {
        this.borderRadius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
    }
}