package foodOrderingSystem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonStyler {
    private static JButton selectedButton = null;
    

    public static void applyMouseEffects(JButton button, JButton[] allButtons, Icon defaultIcon, Icon hoverIcon) {
        button.setIcon(defaultIcon);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                if (button != selectedButton) {
                    applyHoverStyle(button, hoverIcon);
                }
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (button != selectedButton) {
                    applyDefaultStyle(button, defaultIcon);
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                selectedButton = button;
            }          
        });
    }

    public static void applyHoverStyle(JButton button, Icon hoverIcon) {
        Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
        Border paddingBorder = BorderFactory.createEmptyBorder(5,15,5,10);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));
        button.setBackground(Color.white);
        button.setForeground(Color.orange);
        button.setMargin(new Insets(5, 15, 5, 10));
        button.setIcon(hoverIcon); // Set hover icon
    }

    public static void applyDefaultStyle(JButton button, Icon defaultIcon) {
        Color transparent = new Color(255, 255, 255, 0);
        Border emptyLineBorder = BorderFactory.createLineBorder(transparent, 4);
        Border paddingBorder = BorderFactory.createEmptyBorder(5, 15, 5, 10);
        button.setBorder(BorderFactory.createCompoundBorder(emptyLineBorder, paddingBorder));
        button.setContentAreaFilled(false);
        button.setForeground(Color.white);
        button.setMargin(new Insets(5, 15, 5, 10));
        button.setIcon(defaultIcon);
    }
}
