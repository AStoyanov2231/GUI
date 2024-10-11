import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class test {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(test::createAndShowGUI);
    }
    private static void createAndShowGUI(){
        JFrame frame = initializeFrame();
        Border border = createBorder();

        JPanel chatBoxHolder = createChatBoxHolder();
        JTextArea messageArea = createMessageArea();
        JScrollPane scrollPane = createScrollPane(messageArea);
        JTextField inputField = new JTextField();
        chatBoxHolder.add(scrollPane, BorderLayout.CENTER);
        chatBoxHolder.add(inputField, BorderLayout.SOUTH);

        JPanel chatBoxPanel = createPanel(Color.GRAY, chatBoxHolder);
        JPanel settingsPanel = createPanel(Color.WHITE, new JLabel("Settings panel"));
        JPanel otherPanel = createPanel(Color.WHITE, new JLabel("Other Panel"));
        JPanel friendListPanel = createPanel(Color.CYAN, new JLabel("Friend List"));

        JPanel titleBar = createTitleBar(frame, border);
        frame.add(titleBar, BorderLayout.NORTH);

        JPanel mainPanel = createMainPanel(chatBoxPanel, settingsPanel, otherPanel, friendListPanel);
        frame.add(mainPanel);

        frame.setVisible(true);
    }

    private static JFrame initializeFrame(){
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private static Border createBorder() {
        return BorderFactory.createLineBorder(Color.black, 3);
    }

    private static JPanel createChatBoxHolder() {
        JPanel chatBoxHolder = new RoundedPanel(45);
        chatBoxHolder.setBackground(Color.LIGHT_GRAY);
        chatBoxHolder.setPreferredSize(new Dimension(600, 550));
        chatBoxHolder.setLayout(new BorderLayout());
        return chatBoxHolder;
    }

    private static JTextArea createMessageArea() {
        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setBackground(new Color(0, 0, 0, 0));
        messageArea.setForeground(Color.BLACK);
        messageArea.setOpaque(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        return messageArea;
    }

    private static JScrollPane createScrollPane(JTextArea messageArea) {
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        return scrollPane;
    }

    private static JPanel createPanel(Color color, Component component) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.add(component);
        return panel;
    }

    private static JPanel createTitleBar(JFrame frame, Border border) {
        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.LIGHT_GRAY);
        titleBar.setLayout(new FlowLayout(FlowLayout.RIGHT));

        FrameDragListener frameDragListener = new FrameDragListener(frame);
        titleBar.addMouseListener(frameDragListener);
        titleBar.addMouseMotionListener(frameDragListener);

        titleBar.add(createMinimizePanel(frame, border));
        titleBar.add(createExitPanel());

        return titleBar;
    }

    private static JPanel createMinimizePanel(JFrame frame, Border border) {
        JPanel minimizePanel = createControlPanel("-", border);
        minimizePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }
        });
        return minimizePanel;
    }

    private static JPanel createExitPanel() {
        JPanel exitPanel = createControlPanel("X", createBorder());
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
                exitPanel.setBackground(Color.WHITE);
            }
        });
        return exitPanel;
    }

    private static JPanel createControlPanel(String labelText, Border border) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(40, 40));
        JLabel label = new JLabel(labelText);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        panel.setBorder(border);
        panel.add(label);
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return panel;
    }

    private static JPanel createMainPanel(JPanel chatBoxPanel, JPanel settingsPanel, JPanel otherPanel, JPanel friendListPanel) {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        mainPanel.setLayout(new BorderLayout());

        JPanel wrapperPanel = new JPanel(new GridBagLayout());
        wrapperPanel.setBackground(Color.BLUE);

        JPanel innerPanel = createInnerPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        wrapperPanel.add(innerPanel, gbc);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(chatBoxPanel, BorderLayout.CENTER);
        centerPanel.add(createSeparatorPanel(), BorderLayout.WEST);

        mainPanel.add(wrapperPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(friendListPanel, BorderLayout.EAST);

        setButtonActions(innerPanel, centerPanel, chatBoxPanel, settingsPanel, otherPanel);

        return mainPanel;
    }

    private static JPanel createInnerPanel() {
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.GREEN);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setPreferredSize(new Dimension(80, 200));

        innerPanel.add(Box.createVerticalGlue());
        innerPanel.add(createButton("1"));
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(createButton("2"));
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(createButton("3"));
        innerPanel.add(Box.createVerticalGlue());

        return innerPanel;
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    private static JPanel createSeparatorPanel() {
        JPanel separatorPanel = new JPanel();
        separatorPanel.setBackground(Color.LIGHT_GRAY);
        separatorPanel.setPreferredSize(new Dimension(10, 0));
        return separatorPanel;
    }

    private static void setButtonActions(JPanel innerPanel, JPanel centerPanel, JPanel chatBoxPanel, JPanel settingsPanel, JPanel otherPanel) {
        for (Component component : innerPanel.getComponents()) {
            if (component instanceof JButton button) {
                button.addActionListener(e -> {
                    JPanel newPanel = switch (button.getText()) {
                        case "1" -> chatBoxPanel;
                        case "2" -> settingsPanel;
                        case "3" -> otherPanel;
                        default -> throw new IllegalStateException("Unexpected value: " + button.getText());
                    };
                    switchPanel(centerPanel, newPanel);
                });
            }
        }
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