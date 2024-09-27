import javax.swing.*;
import java.awt.*;

public class PanelFactory {

    public static JPanel createPanel(Color backgroundColor, int x, int y, int width, int height, LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(backgroundColor);
        panel.setBounds(x, y, width, height);
        return panel;
    }

    public static JPanel createMainPanel() {
        return createPanel(new Color(220, 220, 220), 0, 0, 1050, 700, new BorderLayout());
    }

    public static JPanel createTextAreaPanel() {
        JPanel panel = createPanel(new Color(13, 112, 30, 74), 0, 0, 600, 550, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }

    public static JPanel createInputPanel() {
        return createPanel(new Color(0, 0, 0, 0), 0, 0, 600, 50, new FlowLayout(FlowLayout.CENTER, 10, 10));
    }
}
