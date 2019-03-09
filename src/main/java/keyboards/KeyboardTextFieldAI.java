package keyboards;

import DEM.JME;
import DEM.Main;
import audio.Audio;
import enums.Errors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Timer;

public class KeyboardTextFieldAI implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {}

	public static String prefix = ".";
	
	private JTextField text = new JTextField();
	private JButton button = new JButton("Retry");

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {

			String[] answers = {"Hello !"};
			String[] answers1 = {"Very good and you ?", "I'm fine and you ?"};
			String[] answers2 = {"I play accordion !", "Something...", "Maybe the same as you !", "I help you", "I'm trying to help you"};
			String[] answers3 = {"I am a robot who is here to help you", "Someone...", "A robot to help you"};
			String[] answers4 = {"Sorry ?", "Why ?", "Are you sure ?"};
			String[] answers5 = {"You can talk to me"};
			String[] answers6 = {"Me too", "Thank you !", "It's a pleasure !"};
			String[] answers7 = {"42.", "I will say to the North", "This way ? Or there ?"};
			String[] answers8 = {"Afraid of what ?", "Why ?", "Why be afraid ?"};
			String[] answers9 = {"Because.", "Why and how ?", "I don't know"};
			String[] answers10 = {"I'm sorry, but this is not accessible", "I can not give you that", "You don't have permission for this !"};
			String[] answers12 = {"Goodbye !", "See you !", "Have a good day !"};
			String[] answers13 = {"I know how to help you", "I know how to do things"};

			String args = Main.search.getText();

			if(args.toLowerCase().contains("hey") || args.toLowerCase().contains("hi") || args.toLowerCase().contains("hej") || args.toLowerCase().contains("hallo") || args.toLowerCase().contains("hello")) {
				setRandom(answers);
			}else if(args.toLowerCase().contains("how r u") || args.toLowerCase().contains("how are you")) {
				setRandom(answers1);
			}else if(args.toLowerCase().contains("what are you doing") || args.toLowerCase().contains("what") && args.toLowerCase().contains("doing")) {
				setRandom(answers2);
			}else if(args.toLowerCase().contains("you") && args.toLowerCase().contains("who")) {
				setRandom(answers3);
			}else if(args.toLowerCase().contains("you") && args.toLowerCase().contains("bad") || args.toLowerCase().contains("you") && args.toLowerCase().contains("sucks")) {
				setRandom(answers4);
			}else if(args.toLowerCase().contains("you") || args.toLowerCase().contains("address as vous")) {
				setRandom(answers5);
			}else if(args.toLowerCase().contains("i") && args.toLowerCase().contains("you") && args.toLowerCase().contains("love") || args.toLowerCase().contains("i") && args.toLowerCase().contains("love")) {
				setRandom(answers6);
			}else if(args.toLowerCase().contains("meaning") && args.toLowerCase().contains("life")) {
				setRandom(answers7);
			}else if(args.toLowerCase().contains("i") && args.toLowerCase().contains("afraid")) {
				setRandom(answers8);
			}else if(args.toLowerCase().contains("why")) {
				setRandom(answers9);
			}else if(args.toLowerCase().contains("logs") || args.toLowerCase().contains("console")) {
				setRandom(answers10);
			}else if(args.toLowerCase().contains("good bye") || args.toLowerCase().contains("ciao") || args.toLowerCase().contains("good") && args.toLowerCase().contains("bye") || args.toLowerCase().contains("good") && args.toLowerCase().contains("night")) {
				setRandom(answers12);

				Timer t = new Timer();

				t.schedule(new TimerTask() {
					@Override
					public void run() {
						Main.frame.setVisible(false);
					}
				}, 1000);
			}else if(args.toLowerCase().contains("generate") && args.toLowerCase().contains("password") || args.toLowerCase().contains("generate") && args.toLowerCase().contains("pwd")) {
				setRandom();

				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setRandom();
					}
				});

				Main.frame.getContentPane().add(button);

				button.setBounds(200, 350, 100, 40);
				button.setVisible(true);
			}else if(args.toLowerCase().contains("que") && args.toLowerCase().contains("sais") && args.toLowerCase().contains("tu") && args.toLowerCase().contains("faire")) {
				setRandom(answers13);
			}else if(args.toLowerCase().startsWith(prefix + "google")) {
				if(args.toLowerCase().contains("translate")) {
					if(args.toLowerCase().contains("ja")) {
						setSearch("https://translate.google.fr/?hl=fr&tab=wT#view=home&op=translate&sl=ja&tl=fr&text=" + args.replace(prefix + "google", "").replace("translate", "").replace("ja", "").replaceAll(" ", "%20"));
					}else if(args.toLowerCase().contains("de")) {
						setSearch("https://translate.google.fr/?hl=fr&tab=wT#view=home&op=translate&sl=de&tl=fr&text=" + args.replace(prefix + "google", "").replace("translate", "").replace("de", "").replaceAll(" ", "%20"));
					}else if(args.toLowerCase().contains("en")) {
						setSearch("https://translate.google.fr/?hl=fr&tab=wT#view=home&op=translate&sl=en&tl=fr&text=" + args.replace(prefix + "google", "").replace("translate", "").replace("de", "").replaceAll(" ", "%20"));
					}else if(args.toLowerCase().contains("ru")) {
						setSearch("https://translate.google.fr/?hl=fr&tab=wT#view=home&op=translate&sl=ru&tl=fr&text=" + args.replace(prefix + "google", "").replace("translate", "").replace("de", "").replaceAll(" ", "%20"));
					}else if(args.toLowerCase().contains("es")) {
						setSearch("https://translate.google.fr/?hl=fr&tab=wT#view=home&op=translate&sl=es&tl=fr&text=" + args.replace(prefix + "google", "").replace("translate", "").replace("de", "").replaceAll(" ", "%20"));
					}else{
						setSearch("https://translate.google.fr/?hl=fr&tab=wT#view=home&op=translate&sl=en&tl=fr&text=" + args.replace(prefix + "google", "").replace("translate", "").replaceAll(" ", "%20"));
					}
				}else if(args.toLowerCase().contains("youtube")) {
					setSearch("https://www.youtube.com/results?search_query=" + args.replace(prefix + "google", "").replace("youtube", "").replaceAll(" ", "%20"));
				}else{
					setSearch("https://www.google.fr/#q=" + args.replace(prefix + "google", "").replaceAll(" ", "%20"));
				}
			}else if(args.toLowerCase().contains(prefix + "wikipedia")) {
				setSearch("https://fr.wikipedia.org/wiki/Special:Search?search=" + args.replace(prefix + "wikipedia", "").replaceAll(" ", "%20"));
			}else if(args.toLowerCase().contains(prefix + "free3d")) {
				if(args.toLowerCase().contains("c4d")) {
					setSearch("https://free3d.com/3d-models/cinema-4d-" + args.replace(prefix + "free3d", "").replace("c4d", "").replaceAll(" ", "%20"));
				}else if(args.toLowerCase().contains("blender")) {
					setSearch("https://free3d.com/3d-models/blender-" + args.replace(prefix + "free3d", "").replace("blender", "").replaceAll(" ", "%20"));
				}else if(args.toLowerCase().contains("3ds")) {
					setSearch("https://free3d.com/3d-models/3ds-max-" + args.replace(prefix + "free3d", "").replace("3ds", "").replaceAll(" ", "%20"));
				}else{
					setSearch("https://free3d.com/3d-models/" + args.replace(prefix + "free3d", "").replaceAll(" ", "%20"));
				}
			}else if(args.toLowerCase().contains(prefix + "convert")) {
				String toFloor = args.toLowerCase().replace(prefix + "convert", "").replace("m/s", "").replace("farenheit", "").replace("g", "").replace("cl", "");
				double floor = Double.parseDouble(toFloor);

				if(args.toLowerCase().contains("farenheit")) {
					setConvert((floor - 32) / 1.8, "°C");
				}else if(args.toLowerCase().contains("m/s")) {
					setConvert(floor * 3.6, "km/h");
				}else if(args.toLowerCase().contains("g")) {
					setConvert(floor / 1000, "kg");
				}else if(args.toLowerCase().contains("cl")) {
					setConvert(floor / 100, "L");
				}
			}else if(args.toLowerCase().contains(prefix + "degrees")) {
				setFrameFarenheit();
			}else if(args.toLowerCase().contains(prefix + "calc")) {
				JFrame frame = new JFrame();

				JLabel test = new JLabel();

				text.setBounds(150, 70, 200, 40);
				text.setEditable(false);
				text.setVisible(true);

				JButton un = new JButton("1");
				addAction(un, "1");
				un.setBounds(145, 140, 60, 60);
				un.setVisible(true);

				JButton deux = new JButton("2");
				addAction(deux, "2");
				deux.setBounds(225, 140, 60, 60);
				deux.setVisible(true);

				JButton trois = new JButton("3");
				addAction(trois, "3");
				trois.setBounds(305, 140, 60, 60);
				trois.setVisible(true);

				JButton quatre = new JButton("4");
				addAction(quatre, "4");
				quatre.setBounds(145, 210, 60, 60);
				quatre.setVisible(true);

				JButton cinq = new JButton("5");
				addAction(cinq, "5");
				cinq.setBounds(225, 210, 60, 60);
				cinq.setVisible(true);

				JButton six = new JButton("6");
				addAction(six, "6");
				six.setBounds(305, 210, 60, 60);
				six.setVisible(true);

				JButton sept = new JButton("7");
				addAction(sept, "7");
				sept.setBounds(145, 280, 60, 60);
				sept.setVisible(true);

				JButton huit = new JButton("8");
				addAction(huit, "8");
				huit.setBounds(225, 280, 60, 60);
				huit.setVisible(true);

				JButton neuf = new JButton("9");
				addAction(neuf, "9");
				neuf.setBounds(305, 280, 60, 60);
				neuf.setVisible(true);

				JButton zéro = new JButton("0");
				addAction(zéro, "0");
				zéro.setBounds(225, 350, 60, 60);
				zéro.setVisible(true);


				JButton plus = new JButton("+");
				addAction(plus, "+");
				plus.setBounds(20, 420, 50, 50);
				plus.setVisible(true);

				JButton moins = new JButton("-");
				addAction(moins, "-");
				moins.setBounds(90, 420, 50, 50);
				moins.setVisible(true);

				JButton multiplier = new JButton("*");
				addAction(multiplier, "*");
				multiplier.setBounds(160, 420, 50, 50);
				multiplier.setVisible(true);

				JButton diviser = new JButton("/");
				addAction(diviser, "/");
				diviser.setBounds(230, 420, 50, 50);
				diviser.setVisible(true);

				JButton virgule = new JButton(",");
				addAction(virgule, ".");
				virgule.setBounds(300, 420, 50, 50);
				virgule.setVisible(true);

				JButton puissance = new JButton("^");
				addAction(puissance, "^");
				puissance.setBounds(370, 420, 50, 50);
				puissance.setVisible(true);

				JButton pi = new JButton("π");
				addAction(pi, "π");
				pi.setBounds(440, 420, 50, 50);
				pi.setVisible(true);

				JButton cancel = new JButton("CA");
				resetField(cancel);
				cancel.setBounds(100, 72, 40, 40);
				cancel.setVisible(true);

				JButton end = new JButton("=");
				end.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ScriptEngineManager mgr = new ScriptEngineManager();
					    ScriptEngine engine = mgr.getEngineByName("Nashorn");
					    String toFloor = text.getText();

						try {
							if(toFloor.contains("^")) {
								toFloor = toFloor.replaceAll("([-+]?\\d*\\.?\\d+)\\^([-+]?\\d*\\.?\\d+)", "Math.pow($1, $2)");
							}else if(toFloor.contains("π")) {
								toFloor = toFloor.replaceAll("π", "Math.PI");
							}

							text.setText(text.getText() + " = " + engine.eval(toFloor));
						} catch (ScriptException e1) {
							Errors.errorFloor.getError();
							Main.search.setText("");
							e1.printStackTrace();
						}
					}
				});
				end.setBounds(365, 72, 40, 40);
				end.setVisible(true);

				frame.getContentPane().add(text);
				frame.getContentPane().add(un);
				frame.getContentPane().add(deux);
				frame.getContentPane().add(trois);
				frame.getContentPane().add(quatre);
				frame.getContentPane().add(cinq);
				frame.getContentPane().add(six);
				frame.getContentPane().add(sept);
				frame.getContentPane().add(huit);
				frame.getContentPane().add(neuf);
				frame.getContentPane().add(zéro);

				frame.getContentPane().add(plus);
				frame.getContentPane().add(moins);
				frame.getContentPane().add(multiplier);
				frame.getContentPane().add(diviser);
				frame.getContentPane().add(virgule);
				frame.getContentPane().add(puissance);
				frame.getContentPane().add(pi);

				frame.getContentPane().add(cancel);
				frame.getContentPane().add(end);

				frame.getContentPane().add(test);

				frame.setResizable(false);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				button.setVisible(false);
			}else if(args.toLowerCase().contains(prefix + "solarsystem")) {
				//JME jme = new JME();
				//jme.start();

				JOptionPane attention = new JOptionPane();
				attention.showMessageDialog(null, "The solar system are in beta actually", "Attention", JOptionPane.INFORMATION_MESSAGE);

				new JME();
			}else if(args.toLowerCase().contains(prefix + "version")) {
				Main.labelProject.setText("Version of DEM : " + Main.version);
			}else if(args.toLowerCase().contains(prefix + "licence")) {
				Main.labelProject.setText("MIT Licence for Donald_Trumpyyy");
			}else{
				Errors.errorQuestion.getError();
				button.setVisible(false);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@SuppressWarnings("static-access")
	private void setSearch(String url) {
		Desktop d = Desktop.getDesktop();
		
		try {
			d.browse(new URI(url));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		Audio.playSound("ok.wav");
		JOptionPane success = new JOptionPane();
		success.showMessageDialog(null, "The site launches on your default browser", "Success", JOptionPane.INFORMATION_MESSAGE);

		button.setVisible(false);
		Main.search.setText("");
	}

	private void resetField(JButton button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("");
			}
		});
	}

	private void addAction(JButton button, String action) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(text.getText().contains("=")) {
					text.setText("");
					text.setText(text.getText() + action);
				}else{
					text.setText(text.getText() + action);
				}
			}
		});
	}

	private void setRandom() {
		String[] characters = {
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
				"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
				"-", "_", "=", "/", "+", "-", "*", "."
		};

		Random random = new Random();

		String result = characters[random.nextInt(characters.length)];
		String result1 = characters[random.nextInt(characters.length)];
		String result2 = characters[random.nextInt(characters.length)];
		String result3 = characters[random.nextInt(characters.length)];
		String result4 = characters[random.nextInt(characters.length)];
		String result5 = characters[random.nextInt(characters.length)];
		String result6 = characters[random.nextInt(characters.length)];
		String result7 = characters[random.nextInt(characters.length)];
		String result8 = characters[random.nextInt(characters.length)];
		String result9 = characters[random.nextInt(characters.length)];
		String result10 = characters[random.nextInt(characters.length)];
		String result11 = characters[random.nextInt(characters.length)];
		String result12 = characters[random.nextInt(characters.length)];
		String result13 = characters[random.nextInt(characters.length)];
		String result14 = characters[random.nextInt(characters.length)];

		String total = result + result1 + result2 + result3 + result4 + result5 + result6 + result7 + result8 + result9 + result10 + result11 + result12 + result13 + result14;

        StringSelection stringSelection = new StringSelection(total);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        Audio.playSound("ok.wav");
        JOptionPane copy = new JOptionPane();
        copy.showMessageDialog(null, "Your password has just been copied to the clipboard", "Copied text", JOptionPane.INFORMATION_MESSAGE);

        clipboard.setContents(stringSelection, null);

		Main.search.setText("");
		Main.search.setText("There you go : " + total);
	}

	private void setConvert(double math, String convert) {
		double floor = Math.floor(math);

		Main.search.setText("");
		button.setVisible(false);
		Main.labelProject.setText("There you go : " + floor + " " + convert);
	}

	private void setRandom(String[] board) {
		Random random = new Random();
		String result = board[random.nextInt(board.length)];

		button.setVisible(false);
		Main.search.setText("");
		Main.labelProject.setText(result);
	}

	private void setFrameFarenheit() {
		JFrame frame = new JFrame(prefix + "degrees");

		JTabbedPane tabbedPane = new JTabbedPane();


		JLabel label = new JLabel("Value : ", JLabel.CENTER);

		JSlider slider = new JSlider();

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label.setText("Value : " + slider.getValue() + " °F");
			}
		});
		slider.setBounds(200, 150, 150, 25);
		slider.setMaximum(100);
		slider.setMinimum(0);
		slider.setValue(30);

		JButton button = new JButton("Calculate");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double floor = Math.floor((slider.getValue() - 32) / 1.8);

				label.setText("Result : " + floor + " °F");
			}
		});
		button.setVisible(true);



		JLabel label1 = new JLabel("Value : ", JLabel.CENTER);

		JSlider slider1 = new JSlider();

		slider1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label1.setText("Value : " + slider1.getValue() + " °C");
			}
		});
		slider1.setBounds(200, 150, 150, 25);
		slider1.setMaximum(37);
		slider1.setMinimum(0);
		slider1.setValue(20);

		JButton button1 = new JButton("Calculate");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double floor = Math.floor((slider1.getValue() * 9 / 5) + 32);

				label1.setText("Result : " + floor + " °F");
			}
		});
		button1.setBounds(200, 180, 100, 50);
		button1.setVisible(true);


		JPanel panel = new JPanel();
		panel.add(slider1);
		panel.add(button1);
		panel.add(label1);


		JPanel panel1 = new JPanel();
		panel1.add(slider);
		panel1.add(button);
		panel1.add(label);

		tabbedPane.add("Celsius to Farenheit", panel);
		tabbedPane.add("Farenheit to Celsius", panel1);

		frame.getContentPane().add(tabbedPane);

		frame.setResizable(false);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
