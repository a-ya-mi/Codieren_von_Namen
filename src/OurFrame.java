import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JOptionPane;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Created by Aksana on 11.05.2017.
 */
public class OurFrame extends JFrame {
    //Ausgabe
    JLabel outputFromProgramm;
    //Ausgabe 2
    JLabel outputFromProgramm2;
    //Eingabe
    JTextField inputGuessFromUser;
    //count how many guesses
    JLabel count;
    //Button next Wort
    JButton nextWort;
    //Button hintPleas
    JButton randomHint;
    Word word;




    //Konstruktor
    public OurFrame() {
        setTitle("Use menu to choose the game art");


        setSize(500, 250);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(500, 500);
        setResizable(false);
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Game");

        JMenu newGame = new JMenu("New game");
        fileMenu.add(newGame);

        JMenuItem guessTheName = new JMenuItem("Guess the name");
        newGame.add(guessTheName);
        guessTheName.addActionListener(new StartName());

        JMenuItem guessTheName2 = new JMenuItem("Guess the name 2");
        newGame.add(guessTheName2);
        guessTheName2.addActionListener(new StartName2());

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);


        outputFromProgramm = new JLabel("");
        nextWort = new JButton();
        outputFromProgramm2 = new JLabel("");

        setVisible(true);
    }


    private void GuessTheNameGUI(){
        word = new Word();

        this.setVisible(false);

        outputFromProgramm.setText("Press any button to start");
        outputFromProgramm.setBounds(25, 10, 200, 35);
        add(outputFromProgramm);

        outputFromProgramm2.setText("Guess and press Enter");
        outputFromProgramm2.setBounds(25, 50, 200, 35);
        // outputFromProgramm.addActionListener()
        add(outputFromProgramm2);

        //eventbyEntehere TODO
        inputGuessFromUser = new JTextField(10);
        inputGuessFromUser.setBounds(20, 150, 200, 35);
        inputGuessFromUser.addCaretListener(new CursorInMove());
        inputGuessFromUser.addActionListener(new OurListener());
        add(inputGuessFromUser);

        nextWort.setText("Next Wort with Name1");
        nextWort.setBounds(250, 20, 200, 25);
        //xywh
        nextWort.addActionListener(new NextWord());
        add(nextWort);

        randomHint = new JButton("Hint");
        randomHint.setBounds(250, 60, 200, 25);
        //xywh
        randomHint.setEnabled(false);
        randomHint.setToolTipText("the first letter");
        randomHint.addActionListener(new HintListener());
        add(randomHint);

        count = new JLabel("So many times you tried");
        count.setBounds(250, 100, 200, 25);
        add(count);
        setVisible(true);
    }

    private void guessTheName2GUI(){
        word = new Word();

        this.setVisible(false);

        outputFromProgramm.setText("Press any button to start");
        outputFromProgramm.setBounds(25, 10, 200, 35);
        add(outputFromProgramm);

        outputFromProgramm2.setText("Guess and press Enter");
        outputFromProgramm2.setBounds(25, 50, 200, 35);
        // outputFromProgramm.addActionListener()
        add(outputFromProgramm2);

        inputGuessFromUser = new JTextField(10);
        //eventbyEntehere TODO
        inputGuessFromUser.setBounds(20, 150, 200, 35);
        inputGuessFromUser.addCaretListener(new CursorInMove());
        inputGuessFromUser.addActionListener(new OurListener());
        add(inputGuessFromUser);

        nextWort.setText("Next Wort with Name2!");
        nextWort.setBounds(250, 20, 200, 25);
        //xywh
        nextWort.addActionListener(new NextWordName2());
        add(nextWort);

        randomHint = new JButton("Hint");
        randomHint.setBounds(250, 60, 200, 25);
        //xywh
        randomHint.setEnabled(false);
        randomHint.setToolTipText("the first letter");
        randomHint.addActionListener(new HintListener());
        add(randomHint);

        count = new JLabel("So many times you tried");
        count.setBounds(250, 100, 200, 25);
        add(count);
        setVisible(true);
    }



    private class StartName implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
                GuessTheNameGUI();
            }
    }


    private class StartName2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            guessTheName2GUI();
        }
    }


    private class OurListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String out = inputGuessFromUser.getText();
            boolean a = word.check(word.name, out);
            int c = word.counter++;
            count.setText("you have tried "+c+" times");
            String strAnswer="You are wrong. You can try more";
            if(a==true){
                strAnswer="You are right";
            }
            outputFromProgramm2.setText(strAnswer);
        }
    }



    private class HintListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String s = word.name;
            s=s.substring(0,1);
            outputFromProgramm2.setText("Hint: first letter is "+s);
        }
    }



    private class NextWord implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            word = new Word();
            String s = word.nameWithCaesar;
            outputFromProgramm.setText(s);
        }
    }


    private class NextWordName2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            word = new Word();
            String s = word.nameWithROT1;
            outputFromProgramm.setText(s);
        }
    }



 private class CursorInMove implements CaretListener {
                @Override
                public void caretUpdate(CaretEvent arg0){
                    String s = inputGuessFromUser.getText();
                    if (s.isEmpty()){
                        randomHint.setEnabled(false);
                    }
                    else {
                        randomHint.setEnabled(true);
                    }
                }
            }

    }
