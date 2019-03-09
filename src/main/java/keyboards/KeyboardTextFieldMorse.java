package keyboards;

import DEM.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static jdk.internal.dynalink.support.NameCodec.encode;

public class KeyboardTextFieldMorse implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.radioTextMorse.isSelected()) {

		}else if(Main.radioMorseText.isSelected()) {
			String[] englishString = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
					"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
					"y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
					",", ".", "?"
			};

			String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
					".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
					"...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
					"..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
					"-----", "--..--", ".-.-.-", "..--.." };

			for(int i = 0; i < morse.length; i++) {
				for(int j = 0; j < englishString.length; j++) {
					Main.textMorse.setText(Main.textMorse.getText().replace(morse[i], englishString[j]));
				}
			}
		}else{
			Main.textMorse.setEditable(false);
		}
	}

	private String stringToMorse(String text) {

		String newText = "";
		String selectedChar;
		String convertedChar;
		for (int i = 0; i < text.length(); i++) {

			selectedChar = text.charAt(i) + "";

			convertedChar = encode(selectedChar);

			if (convertedChar.equals(" ")) {
				newText = newText + "| ";
			}else{
				newText = newText + convertedChar;
				if (!convertedChar.equals(" ")) {
					newText = newText + " ";
				}
			}
		}

		return newText;
	}

}
