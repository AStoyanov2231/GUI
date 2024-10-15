import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUILogic {
    private JFrame frame;
    private JPanel centerPanel;
    private JPanel chatBoxPanel;
    private JPanel settingsPanel;
    private JPanel otherPanel;

    public GUILogic(){
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);

        ImageIcon button1Icon = new ImageIcon("src/main/java/Images/user.png");
        ImageIcon button2Icon = new ImageIcon("src/main/java/Images/group.png");
        ImageIcon button3Icon = new ImageIcon("src/main/java/Images/settings.png");

        PanelFactory panelFactory = new PanelFactory(frame);

        // Create panels
        chatBoxPanel = panelFactory.createChatBoxPanel();
        settingsPanel = panelFactory.createSettingsPanel();
        otherPanel = panelFactory.createOtherPanel();
        JPanel friendListPanel = panelFactory.createFriendListPanel();
        JPanel titleBar = panelFactory.createTitleBar();

        // Set up the frame layout
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

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(chatBoxPanel, BorderLayout.CENTER);

        mainPanel.add(wrapperPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(friendListPanel, BorderLayout.EAST);

        frame.add(mainPanel);

        buttons.getButton1().addActionListener(e -> switchPanel(chatBoxPanel));
        buttons.getButton2().addActionListener(e -> switchPanel(settingsPanel));
        buttons.getButton3().addActionListener(e -> switchPanel(otherPanel));

        frame.setVisible(true);
    }

    private void switchPanel(JPanel newPanel) {
        centerPanel.removeAll();
        centerPanel.add(newPanel, BorderLayout.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }
}