import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonPanel extends JPanel {

    public ButtonPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(220, 220, 220));

        JButton userButton = CustomButton.createButton("src/main/java/Images/user.png", "User Settings");
        JButton groupButton = CustomButton.createButton("src/main/java/Images/group.png", "Group Management");
        JButton settingsButton = CustomButton.createButton("src/main/java/Images/settings.png", "Settings");

        userButton.addActionListener(e -> System.out.println("User Button Clicked"));
        groupButton.addActionListener(e -> System.out.println("Group Button Clicked"));
        settingsButton.addActionListener(e -> System.out.println("Settings Button Clicked"));

        userButton.setBounds(0, 220, 90, 50); // Set position and size
        groupButton.setBounds(0, 280, 90, 50); // Adjust position as needed
        settingsButton.setBounds(0, 340, 90, 50); // Adjust position as needed

        addHoverEffect(userButton, "src/main/java/Images/user_selected.png", "src/main/java/Images/user.png", 50, 50);
        addHoverEffect(groupButton, "src/main/java/Images/group_selected.png", "src/main/java/Images/group.png", 50, 50);
        addHoverEffect(settingsButton, "src/main/java/Images/settings_selected.png", "src/main/java/Images/settings.png", 50, 50);

        add(userButton);
        add(groupButton);
        add(settingsButton);
    }

    private void addHoverEffect(JButton button, String hoverIconPath, String defaultIconPath, int width, int height) {

        Icon defaultIcon = ImageResizer.resizeIcon(defaultIconPath, width, height);
        Icon hoverIcon = ImageResizer.resizeIcon(hoverIconPath, width, height);

        button.setIcon(defaultIcon);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(hoverIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(defaultIcon);
            }
        });
    }

}
