package foodOrderingSystem.Classes;

import javax.swing.*;
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
        button.setFocusable(true);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBackground(Color.white);
        button.setForeground(Color.orange);
        button.setIcon(hoverIcon);
    }

    public static void applyDefaultStyle(JButton button, Icon defaultIcon) {
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setFocusable(false);
        button.setForeground(Color.white);
        button.setIcon(defaultIcon);
    }
}
