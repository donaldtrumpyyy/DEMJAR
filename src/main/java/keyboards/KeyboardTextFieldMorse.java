package keyboards;

import DEM.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyboardTextFieldMorse implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.radioTextMorse.isSelected()) {
			char[] english = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
	                  'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
	                  'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
	                  ',', '.', '?' };

			String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
	                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
	                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
	                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
	                "-----", "--..--", ".-.-.-", "..--.." };
			
		    String userInput = Main.textMorse.getText();

		    char[] chars = userInput.toCharArray();

		    String str = "";
		    
		    for (int i = 0; i < chars.length; i++) {
		        for (int j = 0; j < english.length; j++) {
		            if(j == i) {
		                str = str + morse[j] + " ";
		                
		                Main.textMorse.setText(str);
		                Main.labelMorse.setText("Votre traduction s'est bien effectuée");
		            }
		        }
		    }
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
		    
			try {
				for(int i = 0; i < morse.length; i++) {
			    	for(int j = 0; j < englishString.length; j++) {
			    		Main.textMorse.setText(Main.textMorse.getText().replace(morse[i], englishString[j]));
			    	}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else{
			Main.textMorse.setEditable(false);
		}
	}

}
