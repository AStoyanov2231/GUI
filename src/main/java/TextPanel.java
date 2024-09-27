import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TextPanel {

    private JPanel panel;
    private JTextArea textArea;
    private RoundedTextField textField;
    private RoundedButton button;

    public TextPanel() {
        panel = new RoundedPanel(30, 30);
        panel.setLayout(new BorderLayout());
        panel.setBounds(200, 50, 600, 550);

        initializeTextArea();
        initializeInputPanel();
    }

    private void initializeTextArea() {
        JPanel textAreaPanel = PanelFactory.createTextAreaPanel();
        textAreaPanel.setOpaque(false);

        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setBackground(Color.white);
        textArea.setForeground(Color.black);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        textAreaPanel.add(scrollPane, BorderLayout.CENTER);
        panel.add(textAreaPanel, BorderLayout.CENTER);
    }

    private void initializeInputPanel() {
        JPanel inputPanel = PanelFactory.createInputPanel();
        inputPanel.setOpaque(false);

        textField = new RoundedTextField(35, 30, 40);
        button = new RoundedButton("Show text", 30, 30);
        button.setFocusPainted(false);

        ActionListener addTextAction = e -> addText();

        button.addActionListener(addTextAction);
        textField.addActionListener(addTextAction);

        inputPanel.add(textField);
        inputPanel.add(button);
        panel.add(inputPanel, BorderLayout.SOUTH);
    }

    private void addText() {
        if (!textField.getText().isEmpty()) {
            String inputText = textField.getText();
            textArea.append(inputText + "\n");
            textField.setText("");
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
