package DEM;

import actionListeners.*;
import enums.Errors;
import javaConsoleAPI.Frame;
import keyboards.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class Main {

    public static JLabel labelProject = new JLabel("");
    public static JTextField search = new JTextField();
    public static JFrame frame = new JFrame();

    public static String version = "BETA 1.2";

    public static void main(String[] args) {
        openMenu();
    }

    public static void openMenu() {
            frame = new JFrame();

            JLabel test = new JLabel();

            JMenuBar menuBar = new JMenuBar();

            JMenu menu = new JMenu("Home");

            JMenuItem menuItem = new JMenuItem("IP");
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Frame.setFrame(new JFrame(), "IP", 350, 100, 0, new JLabel(), "" + InetAddress.getLocalHost(), false, null);
                    } catch (UnknownHostException e1) {
                        Errors.errorIP.getError();
                        e1.printStackTrace();
                    }
                }
            });
            menuItem.setVisible(true);

            menu.add(menuItem);

            JMenu menu1 = new JMenu("Services");

            JMenuItem itemBinary = new JMenuItem("Binary translator");
            setItemBinary(itemBinary, new JFrame(), "Binary translator", "Click on the button to access the translator");

            JMenuItem itemMorse = new JMenuItem("Morse translator");
            setItemMorse(itemMorse, new JFrame(), "Morse translator", "Click on the button to access the translator");

            JMenuItem itemMoyenne = new JMenuItem("Average calculator");
            setItemMoyenne(itemMoyenne, new JFrame(), "Average calculator", "Click on the button to access the calculator");

            menu1.add(itemBinary);
            menu1.add(itemMorse);
            menu1.add(itemMoyenne);

            menuBar.add(menu);
            menuBar.add(menu1);
            menuBar.setEnabled(true);
            menuBar.setVisible(true);

            labelProject = new JLabel();
            labelProject.setBounds(150, 100, 450, 40);
            labelProject.setVisible(true);

            JButton help = new JButton("Help");
            help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame();

                    JLabel test = new JLabel();

                    JLabel label = new JLabel("Available orders : ");
                    label.setBounds(100, 100, 200, 25);
                    label.setVisible(true);

                    JLabel commandGoogle = new JLabel(KeyboardTextFieldAI.prefix + "google <translate, youtube, wikipedia> <arguments>");
                    commandGoogle.setBounds(20, 150, 350, 25);
                    commandGoogle.setVisible(true);

                    JLabel commandFree3D = new JLabel(KeyboardTextFieldAI.prefix + "free3d <c4d, blender, 3ds> <arguments>");
                    commandFree3D.setBounds(75, 180, 300, 25);
                    commandFree3D.setVisible(true);

                    JLabel commandConvert = new JLabel(KeyboardTextFieldAI.prefix + "convert <farenheit, m/s, g, cL> <arguments>");
                    commandConvert.setBounds(50, 210, 300, 25);
                    commandConvert.setVisible(true);

                    JLabel commandFloor = new JLabel(KeyboardTextFieldAI.prefix + "calc");
                    commandFloor.setBounds(180, 240, 300, 25);
                    commandFloor.setVisible(true);

                    JButton more = new JButton("More informations");
                    more.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Desktop d = Desktop.getDesktop();

                            try {
                                d.browse(new URI("https://demcommunity.netlify.com/help.html"));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            } catch (URISyntaxException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
                    more.setBounds(125, 300, 150, 25);
                    more.setVisible(true);

                    frame.getContentPane().add(label);
                    frame.getContentPane().add(commandGoogle);
                    frame.getContentPane().add(commandFree3D);
                    frame.getContentPane().add(commandConvert);
                    frame.getContentPane().add(commandFloor);
                    frame.getContentPane().add(more);

                    frame.getContentPane().add(test);

                    frame.setResizable(false);
                    frame.setSize(400, 400);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
            help.setBounds(195, 270, 100, 40);
            help.setVisible(true);

            search = new JTextField("Enter your command");

            search.setEditable(true);
            search.setBounds(50, 150, 400, 30);
            search.addKeyListener(new KeyboardTextFieldAI());
            search.setEnabled(true);

            frame.getContentPane().add(labelProject);
            frame.getContentPane().add(search);
            frame.getContentPane().add(help);

            frame.getContentPane().add(test);

            frame.setJMenuBar(menuBar);

            frame.setResizable(false);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }

    public static void setItemBinary(JMenuItem item, JFrame name, String title, String text) {
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBinary();
            }
        });
        item.setEnabled(true);
    }

    public static void setItemMorse(JMenuItem item, JFrame name, String title, String text) {
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMorse();
            }
        });
        item.setEnabled(true);
    }

    public static void setItemMoyenne(JMenuItem item, JFrame name, String title, String text) {
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMoyenne();
            }
        });
        item.setEnabled(true);
    }

    public static JRadioButton radioTextMorse = new JRadioButton("Text -> Morse");
    public static JRadioButton radioMorseText = new JRadioButton("Morse -> Text");
    public static JLabel labelMorse = new JLabel("You are on the translation of text into Morse");
    public static JTextField textMorse = new JTextField();

    public static void setMorse() {
        frame = new JFrame();
        setHome(frame);

        JLabel test = new JLabel();

        textMorse.addActionListener(new KeyboardTextFieldMorse());
        textMorse.setBounds(70, 180, 350, 25);

        labelMorse.setBounds(110, 100, 350, 25);

        radioTextMorse.addActionListener(new radioTextMorse());
        radioTextMorse.setBounds(110, 125, 150, 50);
        radioTextMorse.setSelected(true);
        radioTextMorse.setVisible(true);

        radioMorseText.addActionListener(new radioMorseText());
        radioMorseText.setBounds(250, 125, 150, 50);
        radioMorseText.setVisible(true);

        frame.getContentPane().add(textMorse);
        frame.getContentPane().add(labelMorse);
        frame.getContentPane().add(radioMorseText);
        frame.getContentPane().add(radioTextMorse);

        frame.getContentPane().add(test);

        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static JTextField textBinary = new JTextField("Enter your text to decode");
    public static JRadioButton radioBinary = new JRadioButton("Binary -> Text");
    public static JRadioButton radioText = new JRadioButton("Text -> Binary");
    public static JLabel resultLabel = new JLabel();

    public static void setBinary() {
        frame = new JFrame();
        setHome(frame);

        JLabel test = new JLabel();

        resultLabel.setBounds(85, 250, 400, 25);

        radioBinary.addActionListener(new radioBinaryText());
        radioBinary.setBounds(250, 140, 350, 25);
        radioBinary.setSelected(false);

        radioText.addActionListener(new radioTextBinary());
        radioText.setBounds(90, 140, 350, 25);
        radioText.setSelected(true);

        textBinary.addKeyListener(new KeyboardTextFieldBinary());
        textBinary.setBounds(70, 190, 350, 25);

        frame.getContentPane().add(textBinary);
        frame.getContentPane().add(resultLabel);
        frame.getContentPane().add(radioBinary);
        frame.getContentPane().add(radioText);
        frame.getContentPane().add(test);

        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void setMoyenne() {
        JFrame frame = new JFrame();

        JLabel test = new JLabel();

        JLabel label1 = new JLabel("Enter <end> to calculate the total");
        label1.setBounds(130, 150, 300, 25);

        JLabel label = new JLabel("");
        label.setBounds(200, 250, 150, 25);

        JTextField field = new JTextField("Enter your notes here");

        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            List<String> list = new ArrayList<>();

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(field.getText().toLowerCase().contains("end")) {
                        ScriptEngineManager mgr = new ScriptEngineManager();
                        ScriptEngine engine = mgr.getEngineByName("Nashorn");
                        String toFloor = list.toString().replace("[", "(").replace("]", ")").replace(" ", "").replace(",", "+");

                        try {
                            Object result = engine.eval(toFloor.concat("/" + list.size()));

                            field.setText("");
                            list.clear();
                            System.out.println(list);

                            label.setText("There you go : " + result);
                        } catch (ScriptException e1) {
                            e1.printStackTrace();
                        }
                    }else{
                        list.add(field.getText());
                        field.setText("");
                        label.setText("");

                        System.out.println(list.size());
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        field.setBounds(100, 200, 300, 25);
        field.setVisible(true);

        frame.getContentPane().add(field);
        frame.getContentPane().add(label);
        frame.getContentPane().add(label1);

        frame.getContentPane().add(test);

        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void setHome(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Home");

        JMenuItem menuItem = new JMenuItem("IP");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    javaConsoleAPI.Frame.setFrame(new JFrame(), "IP", 350, 100, 0, new JLabel(), "" + InetAddress.getLocalHost(), false, null);
                } catch (UnknownHostException e1) {
                    Errors.errorIP.getError();
                    e1.printStackTrace();
                }
            }
        });
        menuItem.setVisible(true);
        menuItem.setEnabled(true);

        menuBar.add(menu);
        menuBar.setVisible(true);
        menuBar.setEnabled(true);

        menu.add(menuItem);
        menu.setVisible(true);
        menu.setEnabled(true);

        frame.setJMenuBar(menuBar);
    }

}
