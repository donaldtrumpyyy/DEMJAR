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
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
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
	private static JButton button = new JButton("Recommencer");

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {

			String[] answers = {"Bonjour !"};
			String[] answers1 = {"Très bien et vous ?", "Bien et vous ?"};
			String[] answers2 = {"Je fais de l'accordéon !", "Quelque chose...", "Peut-être pareil que vous !", "Je vous aide.", "Je suis en train de vous aider."};
			String[] answers3 = {"Je suis un robot qui est ici pour vous aider.", "Quelqu'un...", "Une personne imaginaire pour vous aider."};
			String[] answers4 = {"Pardon ?", "Pourquoi ?", "Ah bon ?", "Vous êtes sûr ?"};
			String[] answers5 = {"Vous pouvez me tutoyer."};
			String[] answers6 = {"Moi aussi.", "Merci !", "Ça fait plaisir !"};
			String[] answers7 = {"42.", "Je dirai au Nord.", "Par ici ? Ou par là ?"};
			String[] answers8 = {"Peur de quoi ?", "Pourquoi ?", "Pourquoi avoir peur ?"};
			String[] answers9 = {"Parce que.", "Le pourquoi du comment ?", "Je ne sais."};
			String[] answers10 = {"Désolé, mais ceci n'est pas accessible.", "Je ne peux pas vour fournir cela.", "Vous n'avez pas l'autorisation pour avoir ceci."};
			String[] answers12 = {"Aurevoir !", "À la prochaine !", "Bonne journée !"};
			String[] answers13 = {"Je sais vous aider.", "Je sais faire des chose."};

			String args = Main.search.getText();


			/*
			if(args.toLowerCase().contains("test")) {
				JFrame frame = new JFrame("testFrame");

				JLabel label = new JLabel("valeur : ", JLabel.CENTER);

				JSlider slider = new JSlider();

				slider.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent e) {
						label.setText("valeur : " + slider.getValue() + " °F");
					}
				});

				slider.setMaximum(100);
				slider.setMinimum(0);
				slider.setValue(30);

				JButton button = new JButton("test OK");
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						double floor = Math.floor((slider.getValue() - 32) / 1.8);

						label.setText("résultat : " + floor + " °C");
					}
				});
				button.setVisible(true);

				JPanel panel = new JPanel();
				panel.add(new JLabel("test OK"));

				JPanel panel1 = new JPanel();
				panel1.add(slider);
				panel1.add(button);
				panel1.add(label);


				JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel1);

				frame.getContentPane().add(split);

				frame.setResizable(false);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}else if(args.toLowerCase().contains("abc")) {
				JFrame frame = new JFrame("testFrame");

				JTabbedPane tabbedPane = new JTabbedPane();

				JPanel test = new JPanel();
				test.add(new JLabel("onglet 1"));
				tabbedPane.add("panel", test);

				JPanel test1 = new JPanel();
				test1.add(new JLabel("onglet 2"));
				tabbedPane.add("panel1", test1);

				frame.getContentPane().add(tabbedPane);

				frame.setResizable(false);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			*/

			if(args.toLowerCase().contains("bonjour") || args.toLowerCase().contains("salut") || args.toLowerCase().contains("hej") || args.toLowerCase().contains("hallo") || args.toLowerCase().contains("wesh") || args.toLowerCase().contains("wsh")) {
				setRandom(answers);
			}else if(args.toLowerCase().contains("ça va") || args.toLowerCase().contains("sa va") || args.toLowerCase().contains("comment vas-tu")) {
				setRandom(answers1);
			}else if(args.toLowerCase().contains("que fais-tu") || args.toLowerCase().contains("tu fais quoi") || args.toLowerCase().contains("tu fais")|| args.toLowerCase().contains("tfk")) {
				setRandom(answers2);
			}else if(args.toLowerCase().contains("tu") && args.toLowerCase().contains("qui") || args.toLowerCase().contains("t'") && args.toLowerCase().contains("qui")) {
				setRandom(answers3);
			}else if(args.toLowerCase().contains("tu") && args.toLowerCase().contains("nul") || args.toLowerCase().contains("tu") && args.toLowerCase().contains("naze") || args.toLowerCase().contains("t'") && args.toLowerCase().contains("nul")) {
				setRandom(answers4);
			}else if(args.toLowerCase().contains("vous") || args.toLowerCase().contains("vouvoyer")) {
				setRandom(answers5);
			}else if(args.toLowerCase().contains("je") && args.toLowerCase().contains("t'") && args.toLowerCase().contains("aime") || args.toLowerCase().contains("je") && args.toLowerCase().contains("aime")) {
				setRandom(answers6);
			}else if(args.toLowerCase().contains("sens") && args.toLowerCase().contains("vie")) {
				setRandom(answers7);
			}else if(args.toLowerCase().contains("je") && args.toLowerCase().contains("peur") || args.toLowerCase().contains("j'") && args.toLowerCase().contains("peur")) {
				setRandom(answers8);
			}else if(args.toLowerCase().contains("pourquoi")) {
				setRandom(answers9);
			}else if(args.toLowerCase().contains("logs") || args.toLowerCase().contains("console")) {
				setRandom(answers10);
			}else if(args.toLowerCase().contains("aurevoir") || args.toLowerCase().contains("ciao") || args.toLowerCase().contains("bonne") && args.toLowerCase().contains("journée") || args.toLowerCase().contains("bonne") && args.toLowerCase().contains("soirée")) {
				setRandom(answers12);

				Timer t = new Timer();

				t.schedule(new TimerTask() {
					@Override
					public void run() {
						Main.frame.setVisible(false);
					}
				}, 1000);
			}else if(args.toLowerCase().contains("génère") && args.toLowerCase().contains("mot de passe") || args.toLowerCase().contains("génère") && args.toLowerCase().contains("mdp")) {
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
				}else if(args.toLowerCase().contains("wikipedia")) {
					setSearch("https://fr.wikipedia.org/wiki/Special:Search?search=" + args.replace(prefix + "google", "").replace("wikipedia", "").replaceAll(" ", "%20"));
				}else{
					setSearch("https://www.google.fr/#q=" + args.replace(prefix + "google", "").replaceAll(" ", "%20"));
				}
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

				text.setBounds(150, 80, 200, 40);
				text.setEditable(false);
				text.setVisible(true);

				JButton un = new JButton("1");
				addAction(un, "1");
				un.setBounds(145, 150, 50, 50);
				un.setVisible(true);

				JButton deux = new JButton("2");
				addAction(deux, "2");
				deux.setBounds(225, 150, 50, 50);
				deux.setVisible(true);

				JButton trois = new JButton("3");
				addAction(trois, "3");
				trois.setBounds(305, 150, 50, 50);
				trois.setVisible(true);

				JButton quatre = new JButton("4");
				addAction(quatre, "4");
				quatre.setBounds(145, 220, 50, 50);
				quatre.setVisible(true);

				JButton cinq = new JButton("5");
				addAction(cinq, "5");
				cinq.setBounds(225, 220, 50, 50);
				cinq.setVisible(true);

				JButton six = new JButton("6");
				addAction(six, "6");
				six.setBounds(305, 220, 50, 50);
				six.setVisible(true);

				JButton sept = new JButton("7");
				addAction(sept, "7");
				sept.setBounds(145, 290, 50, 50);
				sept.setVisible(true);

				JButton huit = new JButton("8");
				addAction(huit, "8");
				huit.setBounds(225, 290, 50, 50);
				huit.setVisible(true);

				JButton neuf = new JButton("9");
				addAction(neuf, "9");
				neuf.setBounds(305, 290, 50, 50);
				neuf.setVisible(true);

				JButton zéro = new JButton("0");
				addAction(zéro, "0");
				zéro.setBounds(225, 360, 50, 50);
				zéro.setVisible(true);


				JButton plus = new JButton("+");
				addAction(plus, "+");
				plus.setBounds(20, 430, 40, 40);
				plus.setVisible(true);

				JButton moins = new JButton("-");
				addAction(moins, "-");
				moins.setBounds(90, 430, 40, 40);
				moins.setVisible(true);

				JButton multiplier = new JButton("*");
				addAction(multiplier, "*");
				multiplier.setBounds(160, 430, 40, 40);
				multiplier.setVisible(true);

				JButton diviser = new JButton("/");
				addAction(diviser, "/");
				diviser.setBounds(230, 430, 40, 40);
				diviser.setVisible(true);

				JButton virgule = new JButton(",");
				addAction(virgule, ".");
				virgule.setBounds(300, 430, 40, 40);
				virgule.setVisible(true);

				JButton puissance = new JButton("^");
				addAction(puissance, "^");
				puissance.setBounds(370, 430, 40, 40);
				puissance.setVisible(true);

				JButton pi = new JButton("π");
				addAction(pi, "π");
				pi.setBounds(440, 430, 40, 40);
				pi.setVisible(true);

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
				end.setBounds(365, 82, 35, 35);
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
				frame.getContentPane().add(end);

				frame.getContentPane().add(test);

				frame.setResizable(false);
				frame.setSize(500, 500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				button.setVisible(false);
			}else if(args.toLowerCase().contains("3d")) {
				new JME();
			}else{
				Errors.errorQuestion.getError();
				button.setVisible(false);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@SuppressWarnings("static-access")
	public static void setSearch(String url) {
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
		success.showMessageDialog(null, "Le site se lance sur votre navigateur par défaut", "Succès", JOptionPane.INFORMATION_MESSAGE);

		button.setVisible(false);
		Main.search.setText("");
	}
	
	public void addAction(JButton button, String action) {
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

	public void setRandom() {
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

		Main.search.setText("");
		Main.search.setText("Et voila : " + total);
	}

	public void setConvert(double math, String convert) {
		double floor = Math.floor(math);

		Main.search.setText("");
		button.setVisible(false);
		Main.labelProject.setText("Et voilà : " + floor + " " + convert);
	}
	
	public static void setRandom(String[] board) {
		Random random = new Random();
		String result = board[random.nextInt(board.length)];

		button.setVisible(false);
		Main.search.setText("");
		Main.labelProject.setText(result);
	}

	private void setFrameFarenheit() {
		JFrame frame = new JFrame(prefix + "degrees");

		JTabbedPane tabbedPane = new JTabbedPane();


		JLabel label = new JLabel("Valeur : ", JLabel.CENTER);

		JSlider slider = new JSlider();

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label.setText("Valeur : " + slider.getValue() + " °F");
			}
		});
		slider.setBounds(200, 150, 150, 25);
		slider.setMaximum(100);
		slider.setMinimum(0);
		slider.setValue(30);

		JButton button = new JButton("Calculer");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double floor = Math.floor((slider.getValue() - 32) / 1.8);

				label.setText("Résultat : " + floor + " °F");
			}
		});
		button.setVisible(true);



		JLabel label1 = new JLabel("Valeur : ", JLabel.CENTER);

		JSlider slider1 = new JSlider();

		slider1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				label1.setText("Valeur : " + slider1.getValue() + " °C");
			}
		});
		slider1.setBounds(200, 150, 150, 25);
		slider1.setMaximum(37);
		slider1.setMinimum(0);
		slider1.setValue(20);

		JButton button1 = new JButton("Calculer");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double floor = Math.floor((slider1.getValue() * 9 / 5) + 32);

				label1.setText("Résultat : " + floor + " °F");
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

		tabbedPane.add("Celsius en Farenheit", panel);
		tabbedPane.add("Farenheit en Celsius", panel1);

		frame.getContentPane().add(tabbedPane);

		frame.pack();
		frame.setResizable(false);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
