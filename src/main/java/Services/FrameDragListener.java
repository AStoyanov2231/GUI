package Services;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameDragListener extends MouseAdapter {
    private final JFrame frame;
    private Point mouseDownCompCords = null;

    public FrameDragListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseDownCompCords = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDownCompCords = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mouseDownCompCords != null) {
            Point currCords = e.getLocationOnScreen();
            frame.setLocation(currCords.x - mouseDownCompCords.x, currCords.y - mouseDownCompCords.y);
        }
    }
}