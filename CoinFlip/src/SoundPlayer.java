import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {
    public static void playsound(String path) {
        URL soundFile = SoundPlayer.class.getResource(path);
        if (soundFile == null) {
            System.out.println("Error, Invalid Sound File");
            return;
        }
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}