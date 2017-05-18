import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * Created by Aksana on 11.05.2017.
 */
public class OurFrame extends JFrame {
    JLabel outputFromProgramm;
    JTextField inputGuessFromUser;
    JButton buttonCheck;
    JButton buttonNewName;
    JButton buttonLevelDown;
    JButton buttonLevelUp;
    JPanel buttonsPanel;


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
        inputGuessFromUser.setBounds(20, 50, 200, 35);
        inputGuessFromUser.addCaretListener(new CursorInMove());
        add(inputGuessFromUser);


        buttonCheck = new JButton("Klick and check your answer");
        buttonCheck.setBounds(250, 10, 200, 25);
        //xywh
        buttonCheck.addActionListener(new OurListener());
        buttonCheck.setEnabled(false);
        add(buttonCheck);

        buttonNewName = new JButton("Guess next name");
        buttonNewName.setBounds(250, 40, 200, 25);
        //xywh
        add(buttonNewName);


        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(null);
        buttonsPanel.setBounds(10, 100, 200, 160);
        add(buttonsPanel);

        buttonLevelDown = new JButton("Level down");
        buttonLevelDown.setBounds(10, 100, 100, 25);
        //xywh
        buttonLevelDown.setToolTipText("schwer");
        buttonsPanel.add(buttonLevelDown);

        buttonLevelUp = new JButton("Level up");
        buttonLevelUp.setBounds(100, 100, 100, 25);
        //xywh
        buttonLevelUp.setToolTipText("sehr schwer");
        buttonsPanel.add(buttonLevelUp);


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
                        buttonCheck.setEnabled(false);
                    }
                    else {
                        buttonCheck.setEnabled(true);
                    }
                }
            }

    }