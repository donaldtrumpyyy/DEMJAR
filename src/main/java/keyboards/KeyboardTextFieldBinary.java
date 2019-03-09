package keyboards;

import DEM.Main;
import enums.Errors;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardTextFieldBinary implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(Main.radioBinary.isSelected()) {
				Main.radioText.setSelected(false);
				Main.textBinary.setText(binaryToText(Main.textBinary.getText()));
				
				Main.resultLabel.setText("Your translation was well done");
			}else if(Main.radioText.isSelected()) {
				Main.radioBinary.setSelected(false);
				Main.textBinary.setText(textToBinary(Main.textBinary.getText()));
				
				Main.resultLabel.setText("Your translation was well done");
			}else{
				Main.resultLabel.setText(Errors.errorTraduct.getError());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	public String binaryToText(String binary) {
        String s2 = "";   
        char nextChar;

        for(int i = 0; i <= binary.length() - 8; i += 8) {
            nextChar = (char) Integer.parseInt(binary.substring(i, i + 8), 2);
            s2 += nextChar;
        }
        
        return s2;
	}
	
	private static String textToBinary(String s) {
       byte[] bytes = s.getBytes();
       
       StringBuilder binary = new StringBuilder();
       
       for (byte b : bytes) {
	        int val = b;
	        for (int i = 0; i < 8; i++) {
	           binary.append((val & 128) == 0 ? 0 : 1);
	           val <<= 1;
	        }
        
        	binary.append(' ');
       }
	       
       return binary.toString();
	}  
	
}
