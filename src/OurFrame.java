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

/**
 * Created by Aksana on 11.05.2017.
 */
public class OurFrame extends JFrame {
    //Ausgabe
    JLabel outputFromProgramm;
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
        word = new Word();

        setSize(500, 250);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(500, 500);
        setTitle("Guess the name");
        setResizable(false);
        setLayout(null);

        outputFromProgramm = new JLabel("Look and guess");
        outputFromProgramm.setBounds(25, 10, 200, 35);
       // outputFromProgramm.addActionListener()
        add(outputFromProgramm);

        inputGuessFromUser = new JTextField(10);
        //eventbyEntehere TODO
        inputGuessFromUser.setBounds(20, 150, 200, 35);
        inputGuessFromUser.addCaretListener(new CursorInMove());
        inputGuessFromUser.addActionListener(new OurListener());
        add(inputGuessFromUser);

        nextWort = new JButton("Next Wort");
        nextWort.setBounds(250, 20, 200, 25);
        //xywh
        nextWort.addActionListener(new NextWord());
        add(nextWort);

        randomHint = new JButton("Random hint");
        randomHint.setBounds(250, 60, 200, 25);
        //xywh
        randomHint.setEnabled(false);
        randomHint.setToolTipText("schwer");
        add(randomHint);

        count = new JLabel("So many times you tried");
        count.setBounds(250, 100, 200, 25);
        add(count);

        setVisible(true);
    }

    private class OurListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String s = inputGuessFromUser.getText();
            String a = word.gameAnswer(s);

            outputFromProgramm.setText(a);
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
