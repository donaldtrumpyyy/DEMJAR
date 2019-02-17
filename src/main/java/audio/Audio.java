package audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

	private static Clip clip;
	
	public Audio(String son) {
			
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
		} catch (Exception e) {}
	}
						
	public static Clip getClip() {
		return clip;
	}
	
	@SuppressWarnings("static-access")
	public static void playSound(String son) {
		try {
			Audio s = new Audio(son);
			s.clip.start();
		} catch(Exception e) {
			System.out.println(son + " est un audio corrompu.");
		}
	}
	
}
