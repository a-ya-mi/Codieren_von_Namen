import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JOptionPane;

/**
 * Created by Aksana on 11.05.2017.
 */
public class OurFrame extends JFrame {
    //Ausgabe
    JLabel outputFromProgramm;
    //Eingabe
    JTextField inputGuessFromUser;
    //Button next Wort
    JButton nextWort;
    //Button hintPleas
    JButton randomHint;
    //Menu Zeile (mit Sprache, neues Kodieren Verfahren

    
    public OurFrame() {



        setSize(500, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(500, 500);
        setTitle("Guess the name");
        setResizable(false);
        setLayout(null);

        outputFromProgramm = new JLabel("Here will be name");
        outputFromProgramm.setBounds(20, 0, 200, 35);
        add(outputFromProgramm);

        inputGuessFromUser = new JTextField();
        //eventbyEnter here TODO
        inputGuessFromUser.setBounds(20, 50, 200, 35);
        inputGuessFromUser.addCaretListener(new CursorInMove());
        add(inputGuessFromUser);


        nextWort = new JButton("Next Wort");
        nextWort.setBounds(250, 10, 200, 25);
        //xywh
        nextWort.addActionListener(new OurListener());
        add(nextWort);

        randomHint = new JButton("Random hint");
        randomHint.setBounds(10, 100, 100, 25);
        //xywh
        randomHint.setEnabled(false);
        randomHint.setToolTipText("schwer");


        setVisible(true);
    }

    private class OurListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String s = inputGuessFromUser.getText();
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
