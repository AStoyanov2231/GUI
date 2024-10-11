import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);


        /////////////////////////////////////////////////////////////////
        RoundedPanel chatBoxPanel = new RoundedPanel(45);
        chatBoxPanel.setBackground(Color.GRAY);

        JPanel FriendListPanel = new JPanel();
        FriendListPanel.setBackground(Color.cyan);
        FriendListPanel.setPreferredSize(new Dimension(50,0));

        // Title bar panel
        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.LIGHT_GRAY);
        titleBar.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));

        FrameDragListener frameDragListener = new FrameDragListener(frame);
        titleBar.addMouseListener(frameDragListener);
        titleBar.addMouseMotionListener(frameDragListener);

        // Create minimize panel
        JPanel minimizePanel = new JPanel();
        minimizePanel.setPreferredSize(new Dimension(40, 40));
        JLabel minimizeLabel = new JLabel("-");
        minimizeLabel.setHorizontalAlignment(JLabel.CENTER);
        minimizeLabel.setVerticalAlignment(JLabel.CENTER);
        minimizeLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
        minimizePanel.add(minimizeLabel);
        minimizePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel exitPanel = new JPanel();
        exitPanel.setPreferredSize(new Dimension(40, 40));
        JLabel exitLabel = new JLabel("X");
        exitLabel.setHorizontalAlignment(JLabel.CENTER);
        exitLabel.setVerticalAlignment(JLabel.CENTER);
        exitLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
        exitPanel.add(exitLabel);
        exitPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        exitPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exitPanel.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitPanel.setBackground(Color.white);
            }
        });

        minimizePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                minimizePanel.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimizePanel.setBackground(Color.white);
            }
        });

        titleBar.add(minimizePanel);
        titleBar.add(exitPanel);

        frame.add(titleBar, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        mainPanel.setLayout(new BorderLayout());

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new GridBagLayout());
        wrapperPanel.setBackground(Color.BLUE);

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.GREEN);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

        innerPanel.add(Box.createVerticalGlue());

        // Create inner buttons
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        innerPanel.add(button1);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(button2);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(button3);
        innerPanel.add(Box.createVerticalGlue());

        innerPanel.setPreferredSize(new Dimension(80, 200));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        wrapperPanel.add(innerPanel, gbc);

        // Create a new panel to place between yellow and blue panels
        JPanel separatorPanel = new JPanel();
        separatorPanel.setBackground(Color.LIGHT_GRAY); // You can change the color if needed
        separatorPanel.setPreferredSize(new Dimension(10, 0)); // Set width (10 pixels) and height (0 for default)

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(chatBoxPanel, BorderLayout.CENTER);
        centerPanel.add(separatorPanel, BorderLayout.WEST);

        // Add the separator panel to the mainPanel between outerChatBox and wrapperPanel
        mainPanel.add(wrapperPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(FriendListPanel, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static class FrameDragListener extends MouseAdapter {
        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
}
