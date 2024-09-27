import javax.swing.*;
import java.awt.*;

class RoundedTextField extends JTextField {
    private int arcWidth;
    private int arcHeight;

    public RoundedTextField(int columns, int arcWidth, int arcHeight){
        super(columns);
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);
        setPreferredSize(new Dimension(300,30));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
        g2.dispose();
    }

    public Insets getInserts(){
        return new Insets(10,15,10,15);
    }
}
