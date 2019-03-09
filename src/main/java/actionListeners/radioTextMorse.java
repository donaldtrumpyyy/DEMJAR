package actionListeners;

import DEM.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class radioTextMorse implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.radioTextMorse.isSelected()) {
			Main.radioMorseText.setSelected(false);
			//Main.labelMorse.setText("Vous avez choisi la traduction de texte en morse");
			Main.textMorse.setEditable(false);
		}else if(!(Main.radioTextMorse.isSelected() && Main.radioMorseText.isSelected())) {
			//Main.labelMorse.setText(Errors.errorTraduct.getError());
			Main.textMorse.setEditable(false);
		}
	}

}
