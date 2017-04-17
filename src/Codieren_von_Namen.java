/**
 * Created by Aksana on 17.04.2017.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Codieren_von_Namen {
    public static void main(String[] args) {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        //name und Index f?r Codierung von Tastatur lesen
        try{
            System.out.println("Geben Sie bitte Ihre Name an");
            String name = br.readLine();
            System.out.println("Geben Sie bitte eine Zahl an");
            int index = Integer.parseInt(br.readLine());
            isr.close();
            //TO DO toLowerCase was sometime not Korrekt why??
            name=name.toLowerCase();
            String outputString = caesar(name, index);
            System.out.println(outputString);

        }
        catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public static String caesar(String name, int index){
        String caesarName="";

        char[] meinABC ={ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        //gegebene Name in ein ArrayList speichern

        char[] charsName = name.toCharArray();

        //iterieren durch gegebenen Alphabet und Name
        for (int j = 0; j < charsName.length; j++){
            for(int i=0; meinABC.length>i; i++){
                if(meinABC[i]==charsName[j]){
                    if((i+index)<meinABC.length){
                        caesarName=caesarName+meinABC[i+index];
                    }
                    //TO DO after "circle" the Letters are in mirror order
                    else{
                        caesarName=caesarName+meinABC[meinABC.length-(i+index)+index+1];
                    }
                }
            }
        }

        return caesarName;
    }





}
