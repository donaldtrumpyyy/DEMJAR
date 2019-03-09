package actionListeners;

import DEM.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class radioBinaryText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.radioBinary.isSelected()) {
			Main.radioText.setSelected(false);
			Main.resultLabel.setText("You have chosen the translation of binary into text");
			Main.textBinary.setEditable(false);
		}else if(!(Main.radioBinary.isSelected() && Main.radioText.isSelected())) {
			Main.resultLabel.setText("Choose a translation mode");
		}
	}

}
