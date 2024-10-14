import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelFactory {
    private final JFrame frame;

    public PanelFactory(JFrame frame){
        this.frame = frame;
    }

    public JPanel createChatBoxPanel(){
        RoundedPanel chatBoxHolder = new RoundedPanel(45);
        chatBoxHolder.setBackground(Color.lightGray);
        chatBoxHolder.setPreferredSize(new Dimension(600, 550));
        chatBoxHolder.setLayout(new BorderLayout());

        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setBackground(new Color(0, 0, 0, 0));
        messageArea.setForeground(Color.BLACK);
        messageArea.setOpaque(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        chatBoxHolder.add(scrollPane, BorderLayout.CENTER);

        JTextField inputField = new JTextField();
        chatBoxHolder.add(inputField, BorderLayout.SOUTH);

        JPanel chatBoxPanel = new JPanel();
        chatBoxPanel.setBackground(Color.GRAY);
        chatBoxPanel.add(chatBoxHolder);

        return chatBoxPanel;
    }

    public JPanel createSettingsPanel() {
        JPanel settingsPanel = new JPanel();
        settingsPanel.setBackground(Color.white);
        settingsPanel.add(new JLabel("Settings panel"));
        return settingsPanel;
    }

    public JPanel createOtherPanel() {
        JPanel otherPanel = new JPanel();
        otherPanel.setBackground(Color.white);
        otherPanel.add(new JLabel("Other Panel"));
        return otherPanel;
    }

    public JPanel createFriendListPanel() {
        JPanel friendListPanel = new JPanel();
        friendListPanel.setBackground(Color.gray);
        friendListPanel.setPreferredSize(new Dimension(50, 0));
        return friendListPanel;
    }

    public JPanel createTitleBar() {
        Border border = BorderFactory.createLineBorder(Color.black, 3);

        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.LIGHT_GRAY);
        titleBar.setLayout(new FlowLayout(FlowLayout.RIGHT));

        Main.FrameDragListener frameDragListener = new Main.FrameDragListener(frame);
        titleBar.addMouseListener(frameDragListener);
        titleBar.addMouseMotionListener(frameDragListener);

        JPanel minimizePanel = createMinimizePanel(border);
        JPanel exitPanel = createExitPanel(border);

        titleBar.add(minimizePanel);
        titleBar.add(exitPanel);

        return titleBar;
    }

    private JPanel createMinimizePanel(Border border) {
        JPanel minimizePanel = new JPanel();
        minimizePanel.setPreferredSize(new Dimension(40, 40));
        JLabel minimizeLabel = new JLabel("-");
        minimizeLabel.setHorizontalAlignment(JLabel.CENTER);
        minimizeLabel.setVerticalAlignment(JLabel.CENTER);
        minimizeLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
        minimizePanel.setBorder(border);
        minimizePanel.add(minimizeLabel);
        minimizePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        minimizePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                minimizePanel.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimizePanel.setBackground(Color.white);
            }
        });

        return minimizePanel;
    }

    private JPanel createExitPanel(Border border) {
        JPanel exitPanel = new JPanel();
        exitPanel.setPreferredSize(new Dimension(40, 40));
        JLabel exitLabel = new JLabel("X");
        exitLabel.setHorizontalAlignment(JLabel.CENTER);
        exitLabel.setVerticalAlignment(JLabel.CENTER);
        exitLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
        exitPanel.setBorder(border);
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

        return exitPanel;
    }
}