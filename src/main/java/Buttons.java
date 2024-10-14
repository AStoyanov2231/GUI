import javax.swing.*;
import java.awt.*;

public class Buttons {

    private JButton button1;
    private JButton button2;
    private JButton button3;

    public void createAndAddButtons(JPanel innerPanel, ImageIcon button1Icon, ImageIcon button2Icon, ImageIcon button3Icon) {

        button1 = createButton(button1Icon);
        button2 = createButton(button2Icon);
        button3 = createButton(button3Icon);

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        innerPanel.add(button1);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(button2);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(button3);
        innerPanel.add(Box.createVerticalGlue());
    }

    private JButton createButton(ImageIcon icon) {
        JButton button = new JButton();
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        ImageIcon scaledIcon = new ImageIcon(getScaledImage(icon.getImage()));
        button.setIcon(scaledIcon);
        return button;
    }

    private Image getScaledImage(Image srcImg) {
        return srcImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }
}
