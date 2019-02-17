package actionListeners;

import DEM.Main;
import enums.Errors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class radioMorseText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.radioMorseText.isSelected()) {
			Main.radioTextMorse.setSelected(false);
			//Main.labelMorse.setText("Vous avez choisi la traduction de morse en texte");
			Main.labelMorse.setText(Errors.errorMorse.getError());
			Main.textMorse.setEditable(false);
		}else if(!(Main.radioMorseText.isSelected() && Main.radioTextMorse.isSelected())) {
			//Main.labelMorse.setText(Errors.errorTraduct.getError());
			Main.textMorse.setEditable(false);
		}
	}

}
