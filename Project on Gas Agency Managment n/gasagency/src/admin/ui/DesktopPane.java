package admin.ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class DesktopPane extends JDesktopPane {

    private Image backimage;

    public DesktopPane() {
        try {
            ImageIcon icon;
            icon = new ImageIcon(getClass().getResource("/admin.ui/images(1).jpg"));
            backimage = icon.getImage();
        } catch (Exception ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (backimage == null) {
            super.paintComponent(g);
        } else {
            g.drawImage(backimage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
