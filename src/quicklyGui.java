import javax.swing.JOptionPane;
/**
 * Created by Aksana on 19.05.2017.
**/

public class quicklyGui {
    String inputGuess;

     public void dialog() {
         inputGuess = JOptionPane.showInputDialog("Guess the name");

     }

    public void dialog(String a) {
        inputGuess = JOptionPane.showInputDialog(a);
    }

    public void message(String a) {
        JOptionPane.showMessageDialog(null,a);
    }

}
