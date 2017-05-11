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
    JButton buttonNewName;
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
        outputFromProgramm.setBounds(120, 7, 500, 15);
        add(outputFromProgramm);

        buttonNewName = new JButton("Guess one more name");
        buttonNewName.setBounds(250, 10, 200, 20);
        //xywh
        buttonNewName.addActionListener(new OurListener());
        add(buttonNewName);
    }

    private class OurListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            outputFromProgramm.setText("Right or not Right");
        }


    }
}