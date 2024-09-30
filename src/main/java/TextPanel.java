import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextPanel extends RoundedPanel {

    private JTextArea textArea;
    private RoundedTextField textField;
    private RoundedButton button;

    public TextPanel() {
        super(30, 30);

        // Set a preferred size for the entire panel
        setPreferredSize(new Dimension(400, 200)); // Width: 400, Height: 200

        setLayout(new BorderLayout());

        textArea = new JTextArea(5, 5);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setBackground(null);
        textArea.setForeground(Color.black);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setOpaque(false);

        GridBagConstraints gbcTextField = new GridBagConstraints();
        gbcTextField.gridx = 0;
        gbcTextField.gridy = 0;
        gbcTextField.weightx = 1;
        gbcTextField.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField.insets = new Insets(5, 5, 5, 5); // Padding

        textField = new RoundedTextField(35, 30, 40);
        textField.setMinimumSize(new Dimension(200, 30));
        textField.setPreferredSize(new Dimension(200, 30));

        inputPanel.add(textField, gbcTextField);

        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 1;
        gbcButton.gridy = 0;
        gbcButton.weightx = 0;
        gbcButton.fill = GridBagConstraints.NONE;
        gbcButton.insets = new Insets(5, 5, 5, 5); // Padding

        button = new RoundedButton("Add Text", 30, 30);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(100, 30));

        inputPanel.add(button, gbcButton);

        add(inputPanel, BorderLayout.SOUTH);

        button.addActionListener(new AddTextAction());
        textField.addActionListener(new AddTextAction());
    }

    private class AddTextAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = textField.getText().trim();
            if (!inputText.isEmpty()) {
                textArea.append(inputText + "\n");
                textField.setText("");
            }
        }
    }

    public JPanel getPanel() {
        return this;
    }
}