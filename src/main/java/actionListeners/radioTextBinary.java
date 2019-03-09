package actionListeners;

import DEM.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class radioTextBinary implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.radioText.isSelected()) {
			Main.radioBinary.setSelected(false);
			Main.resultLabel.setText("You have chosen text translation in binary");
			Main.textBinary.setEditable(true);
		}else if(!(Main.radioBinary.isSelected() && Main.radioText.isSelected())) {
			Main.resultLabel.setText("Choose a translation mode");
		}
	}

}
