import javax.swing.*;
import java.awt.*;

public class Menu {

    public void createAndShowGUI(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(null);
        frame.setSize(1050,700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = PanelFactory.createMainPanel();
        mainPanel.setLayout(new BorderLayout());

        TextPanel textPanel = new TextPanel();
        mainPanel.add(textPanel.getPanel(), BorderLayout.WEST);

        ButtonPanel controlsPanel = new ButtonPanel();
        controlsPanel.setBounds(50, 220, 100, 220);
        mainPanel.add(controlsPanel, BorderLayout.WEST);

//        JPanel sidePanel = createSidePanel();
//        sidePanel.setPreferredSize(new Dimension(200, 700));  // Set fixed width for the side panel
//        mainPanel.add(sidePanel, BorderLayout.EAST);

        frame.add(mainPanel);

        frame.setVisible(true);
    }

//    private JPanel createSidePanel() {
//        JPanel sidePanel = new JPanel();
//        sidePanel.setBackground(Color.LIGHT_GRAY);  // Set background color for the side panel
//        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));  // Use vertical box layout
//
//        // Adding some example components to the side panel (e.g., labels, buttons, etc.)
//        JLabel label = new JLabel("Side Panel");
//        label.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center-align the label
//
//        JButton exampleButton1 = new JButton("Option 1");
//        exampleButton1.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center-align the button
//
//        JButton exampleButton2 = new JButton("Option 2");
//        exampleButton2.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center-align the button
//
//        // Add components to the side panel
//        sidePanel.add(Box.createRigidArea(new Dimension(0, 20)));  // Add space at the top
//        sidePanel.add(label);
//        sidePanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Spacing between components
//        sidePanel.add(exampleButton1);
//        sidePanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Spacing between components
//        sidePanel.add(exampleButton2);
//        sidePanel.add(Box.createVerticalGlue());  // Push content upwards
//
//        return sidePanel;
//    }
}