
package foodOrderingSystem.Classes;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonStyler {
    private static JButton selectedButton = null;

    public static void applyMouseEffects(JButton button, JButton[] allButtons) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                if (button != selectedButton) { // Only highlight if it's not already selected
                    Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
                    button.setContentAreaFilled(true);
                    button.setBorder(lineBorder);
                    button.setBackground(Color.white);
                    button.setForeground(Color.orange);
                }
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (button != selectedButton) { // Revert style only if it's not selected
                    button.setBorder(null);
                    button.setContentAreaFilled(false);
                    button.setForeground(Color.white);
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                // Set the clicked button as selected and reset others
                setSelectedButton(button, allButtons);
            }
        });
    }

    private static void setSelectedButton(JButton button, JButton[] allButtons) {
        // Update the previously selected button to default style
        if (selectedButton != null) {
            selectedButton.setBorder(null);
            selectedButton.setContentAreaFilled(false);
            selectedButton.setForeground(Color.white);
        }

        // Update the new selected button
        selectedButton = button;
        Border lineBorder = BorderFactory.createLineBorder(Color.white, 4);
        selectedButton.setContentAreaFilled(true);
        selectedButton.setBorder(lineBorder);
        selectedButton.setBackground(Color.white);
        selectedButton.setForeground(Color.orange);

        // Reset all other buttons
        for (JButton otherButton : allButtons) {
            if (otherButton != selectedButton) {
                otherButton.setBorder(null);
                otherButton.setContentAreaFilled(false);
                otherButton.setForeground(Color.white);
            }
        }
    }
}
