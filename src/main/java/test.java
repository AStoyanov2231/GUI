import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test {
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame();
        frame.setUndecorated(true); // Remove the default title bar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Create a custom title bar
        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.DARK_GRAY); // Set the background color of the title bar
        titleBar.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align components to the right

        // Create the close button
        JButton closeButton = new JButton("X");
        closeButton.setForeground(Color.WHITE); // Set button text color
        closeButton.setBackground(Color.RED); // Set button background color
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setFocusPainted(false); // Remove focus border
        closeButton.addActionListener(e -> System.exit(0)); // Close the application

        // Create the minimize button
        JButton minimizeButton = new JButton("_");
        minimizeButton.setForeground(Color.WHITE);
        minimizeButton.setBackground(Color.ORANGE);
        minimizeButton.setBorder(BorderFactory.createEmptyBorder());
        minimizeButton.setFocusPainted(false);
        minimizeButton.addActionListener(e -> frame.setState(JFrame.ICONIFIED)); // Minimize the frame

        // Add buttons to the title bar
        titleBar.add(minimizeButton);
        titleBar.add(closeButton);

        // Create a custom MouseAdapter to handle dragging
        class TitleBarMouseAdapter extends MouseAdapter {
            private Point initialClick;

            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint(); // Capture the initial position
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // Get the current location of the frame
                int thisX = frame.getLocation().x;
                int thisY = frame.getLocation().y;

                // Determine how much the mouse has moved since the initial click
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Move the frame to the new location
                frame.setLocation(thisX + xMoved, thisY + yMoved);
            }
        }

        // Add the custom mouse adapter to the title bar
        TitleBarMouseAdapter titleBarMouseAdapter = new TitleBarMouseAdapter();
        titleBar.addMouseListener(titleBarMouseAdapter);
        titleBar.addMouseMotionListener(titleBarMouseAdapter);

        // Add the title bar to the frame
        frame.add(titleBar, BorderLayout.NORTH);

        // Add a content area to the frame
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.LIGHT_GRAY); // Set content area background color
        frame.add(contentPanel, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }
}