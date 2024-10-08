import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setTitle("UI Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1,50,100));

        panel.setBackground(Color.red);

        Button button1 = new Button("Button");
        panel.add(button1);
        Button button2 = new Button("Button");
        panel.add(button2);
        Button button3 = new Button("Button");
        panel.add(button3);

        frame.add(panel, BorderLayout.WEST);

        frame.setVisible(true);
    }
}
