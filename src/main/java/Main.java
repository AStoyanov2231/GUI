import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);

        ImageIcon button1Icon = new ImageIcon("src/main/java/Images/user.png");
        ImageIcon button2Icon = new ImageIcon("src/main/java/Images/group.png");
        ImageIcon button3Icon = new ImageIcon("src/main/java/Images/settings.png");

        PanelFactory panelFactory = new PanelFactory(frame);

        JPanel chatBoxPanel = panelFactory.createChatBoxPanel();
        JPanel settingsPanel = panelFactory.createSettingsPanel();
        JPanel otherPanel = panelFactory.createOtherPanel();
        JPanel friendListPanel = panelFactory.createFriendListPanel();
        JPanel titleBar = panelFactory.createTitleBar();

        frame.add(titleBar, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        mainPanel.setLayout(new BorderLayout());

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new GridBagLayout());
        wrapperPanel.setBackground(Color.gray);

        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.gray);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setPreferredSize(new Dimension(80, 200));

        Buttons buttons = new Buttons();
        buttons.createAndAddButtons(innerPanel, button1Icon, button2Icon, button3Icon);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        wrapperPanel.add(innerPanel, gbc);

        JPanel separatorPanel = new JPanel();
        separatorPanel.setBackground(Color.LIGHT_GRAY);
        separatorPanel.setPreferredSize(new Dimension(10, 0));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(chatBoxPanel, BorderLayout.CENTER);
        centerPanel.add(separatorPanel, BorderLayout.WEST);

        mainPanel.add(wrapperPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(friendListPanel, BorderLayout.EAST);

        frame.add(mainPanel);

        buttons.getButton1().addActionListener(e -> switchPanel(centerPanel, chatBoxPanel));
        buttons.getButton2().addActionListener(e -> switchPanel(centerPanel, settingsPanel));
        buttons.getButton3().addActionListener(e -> switchPanel(centerPanel, otherPanel));

        frame.setVisible(true);
    }

    private static void switchPanel(JPanel centerPanel, JPanel newPanel) {
        centerPanel.removeAll();
        centerPanel.add(newPanel, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
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