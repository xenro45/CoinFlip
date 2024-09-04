import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonEffects {
    public ButtonEffects(JButton flipbutton) {
        flipbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Left");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                SoundPlayer.playsound("resources/rollover2.wav");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                SoundPlayer.playsound("resources/rollover2.wav");
            }
        });
    }
}
