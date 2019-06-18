package tklibs;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

/**
 * Created by ThanhBeoNe on 8/20/2016.
 */
public class AudioUtils {
    public static Clip getSound(String audioUrl){
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(soundFile);
            Clip clip= AudioSystem.getClip();
            clip.open(audioInputStream);
            return  clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void reply(Clip clip){
        clip.setFramePosition(0);
        clip.start();
    }
    public static void play(Clip clip){
        clip.start();
    }
    public static void pause(Clip clip){
        clip.stop();
    }
    public static void loopForever(Clip clip){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
