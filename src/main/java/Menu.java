import javax.swing.*;
import java.awt.*;

public class Menu {

    public void createAndShowGUI(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050,700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.setMinimumSize(new Dimension(700,500));

        frame.setLayout(new GridLayout(1,2));

        TextPanel textPanel = new TextPanel();

        ButtonPanel buttonPanel = new ButtonPanel();

        frame.add(buttonPanel);
        frame.add(textPanel.getPanel());

        frame.setVisible(true);
    }
}