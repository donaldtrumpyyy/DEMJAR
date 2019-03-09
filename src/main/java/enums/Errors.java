package enums;

import audio.Audio;

import javax.swing.*;

public enum Errors {
	
	errorIP("Your connection is not strong enough to connect"),
	errorTraduct("Choose a translation mode"),
	errorMorse("This translation mode is not yet available"),
	errorQuestion("You must put your command"),
	errorFloor("You have just miscalculated");
	
	private String text;
	
	Errors(String text) {
		this.text = text;
	}
	
	@SuppressWarnings("static-access")
	public String getError() {
		Audio.playSound("failure.wav");
		JOptionPane error = new JOptionPane();
		error.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE);
		return text;
	}

}
