package enums;

import audio.Audio;

import javax.swing.*;

public enum Errors {
	
	errorIP("Votre connection n'est pas assez puissante pour se connecter"),
	errorTraduct("Choisissez un mode de traduction"),
	errorMorse("Ce mode de traduction n'est pas encore disponible"),
	errorQuestion("Vous devez mettre votre question"),
	errorFloor("Vous venez de faire un mauvais calcul");
	
	private String text;
	
	Errors(String text) {
		this.text = text;
	}
	
	@SuppressWarnings("static-access")
	public String getError() {
		Audio.playSound("failure.wav");
		JOptionPane error = new JOptionPane();
		error.showMessageDialog(null, text, "Erreur", JOptionPane.ERROR_MESSAGE);
		return text;
	}

}
