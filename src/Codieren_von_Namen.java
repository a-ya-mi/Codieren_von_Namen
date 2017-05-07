/**
 * Created by Aksana on 17.04.2017.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.security.SecureRandom;

//encrypting for names with and without key from user
public class Codieren_von_Namen {
    public static void main2(String[] args) {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        //name and Index(Key) from user
        try{
            System.out.println("Geben Sie bitte Ihre Name an");
            String name = br.readLine();
            System.out.println("Geben Sie bitte eine Zahl zwischen 0 und " + (Integer.MAX_VALUE-26) +" an");
            int key = Integer.parseInt(br.readLine());
            isr.close();

            name=name.toLowerCase();
            String outputString = caesar(name, key);

            //there are call with random Key
            //String outputString = caesar(name, randomZahl());
            System.out.println(outputString);

        }
        catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public static String caesar(String name, int key){
        String caesarName="";

        char[] meinABC ={ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

        //gegebene Name in ein ArrayList speichern
        char[] charsName = name.toCharArray();

        //iterieren durch gegebenen Alphabet und Name
        for (int j = 0; j < charsName.length; j++){
            for(int i=0; meinABC.length>i; i++){
                if(meinABC[i]==charsName[j]){
                    int k = (i+key)%meinABC.length;
                        caesarName=caesarName+meinABC[k];
                }
            }
        }
        return caesarName;
    }


public static int randomZahl (){
    SecureRandom random = new SecureRandom();
    //TODO java.security.SecureRandom can be much better
    int i = random.nextInt((Integer.MAX_VALUE-26));
    return i;
}


}
