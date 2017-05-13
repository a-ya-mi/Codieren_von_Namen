import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Created by Aksana on 11.05.2017.
 */
public class OurFrame extends JFrame {
    JLabel outputFromProgramm;
    JButton buttonCheck;
    JButton buttonNewName;
    JButton buttonLevelUp;
    JLabel inputGuessFromUser;

    public OurFrame() {
        setVisible(true);
        setSize(500, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(500, 500);
        setTitle("Guess the name");
        setResizable(false);
        setLayout(null);

        outputFromProgramm = new JLabel("Here will be name");
        outputFromProgramm.setBounds(120, 10, 500, 35);
        add(outputFromProgramm);

        buttonCheck = new JButton("Klick and check your answer");
        buttonCheck.setBounds(250, 10, 200, 25);
        //xywh
        buttonCheck.addActionListener(new OurListener());
        add(buttonCheck);

        buttonNewName = new JButton("Guess next name");
        buttonNewName.setBounds(250, 40, 200, 25);
        //xywh
        buttonNewName.addActionListener(new OurListener());
        add(buttonNewName);


        buttonLevelUp = new JButton("Next level");
        buttonLevelUp.setBounds(250, 70, 200, 25);
        //xywh
        buttonLevelUp.addActionListener(new OurListener());
        add(buttonLevelUp);

    }

    private class OurListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            outputFromProgramm.setText("Right or not Right");
        }


    }
}