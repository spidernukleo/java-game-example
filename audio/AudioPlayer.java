package audio;

import java.io.IOException;
import java.net.URL;
//import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    //songs ids
    public static int MENU_1 = 0;
    public static int LEVELTEST = 1;
    //effects ids
    public static int SHOOT_1 = 0;

    private Clip[] songs, effects;
    private int currentSongId;
    private float volume=0.5f;
    private boolean songMute, effectMute;
    //private Random rand = new Random(); //this might be needed to have random osts in levels
    public AudioPlayer(){
        String[] songNames={"menu", "leveltest"}; //import songs
        songs = new Clip[songNames.length];
        for(int i=0;i<songs.length;i++)
            songs[i]=getClip(songNames[i]);

        String[] effectNames={}; //import effects
        effects= new Clip[effectNames.length];
        for (int i = 0; i < effects.length; i++)
			effects[i] = getClip(effectNames[i]);
        

        playSong(MENU_1);
        
    }

    private Clip getClip(String name){ //get the file
        URL url = getClass().getResource(name + ".wav");
		AudioInputStream audio;

		try {
			audio = AudioSystem.getAudioInputStream(url);
			Clip c = AudioSystem.getClip();
			c.open(audio);
			return c;

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

			e.printStackTrace();
		}

		return null;
    }

    //methods to handle songs and effects
    public void stopSong(){
        if (songs[currentSongId].isActive())
            songs[currentSongId].stop();
    }
    public void playEffect(int effect){
        if (effects[effect].getMicrosecondPosition() > 0)
			effects[effect].setMicrosecondPosition(0);
        effects[effect].start();
    }
    public void playSong(int song){
        stopSong();
        currentSongId=song;
        songs[currentSongId].setMicrosecondPosition(0);
        songs[currentSongId].loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void setVolume(float volume) {
		this.volume = volume;
		updateSongVolume();
		updateEffectsVolume();
	}
    //volume related methods will be used in gameoptions state (editing settings)
    private void updateSongVolume() {

		FloatControl gainControl = (FloatControl) songs[currentSongId].getControl(FloatControl.Type.MASTER_GAIN);
		float range = gainControl.getMaximum() - gainControl.getMinimum();
		float gain = (range * volume) + gainControl.getMinimum();
		gainControl.setValue(gain);

	}
    private void updateEffectsVolume() {
		for (Clip c : effects) {
			FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
			float range = gainControl.getMaximum() - gainControl.getMinimum();
			float gain = (range * volume) + gainControl.getMinimum();
			gainControl.setValue(gain);
		}
	}
    public void toggleSongMute(){
        this.songMute = !songMute;
		for (Clip c : songs) {
			BooleanControl booleanControl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
			booleanControl.setValue(songMute);
		}
    }
    public void toggleEffectMute(){
        this.effectMute = !effectMute;
		for (Clip c : effects) {
			BooleanControl booleanControl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
			booleanControl.setValue(effectMute);
		}
		//if (!effectMute)
			//playEffect(JUMP); for effects handle here
    }
}
