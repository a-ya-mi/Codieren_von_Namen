/**
 * Created by Aksana on 07.05.2017.
 */

import sun.java2d.pipe.OutlineTextRenderer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.io.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class GuessTheName extends JFrame{

    public static void main(String  []args){

            //entweden JFrame (stillmuch to do) or simple version of Gui for play now
            //JFrame jf = new OurFrame();
            quicklyGui qGui = new quicklyGui();

            try {
                //random name with diffikult lavel 1
                String name=randomNameForEncrypting();

                //encrypting with caesar withthe random key
                String nameWithCaesar = caesar(name, randomZahl());

                qGui.dialog("Whhich name is it?  --- " + nameWithCaesar + " ---");
                //without GUI:
                //System.out.println("Whhich name is it?  --- " + nameWithCaesar + " ---");

                //name suggestion from user without GUI:
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String nameTry;
                // nameTry = br.readLine();

                nameTry=qGui.inputGuess.toLowerCase();
                boolean count = false;
                while(count!=true){
                       if (check(name, nameTry)==true){
                            //without GUI:
                            // System.out.println("You are right!");
                            qGui.message("You are right!");
                            count=true;
                        }
                        else{
                           //without GUI:
                           //System.out.println("You are wrng!");
                           qGui.message("You are wrong!");
                           qGui.dialog("One more try! --- " + nameWithCaesar + " ---");
                           nameTry=qGui.inputGuess.toLowerCase();
                           count=false;
                        }
                }

            }
            catch (Exception e){
                System.out.println("Fehler in Main");
            }
        }

    public static int randomZahl (){
        SecureRandom random = new SecureRandom();
        //TODO java.security.SecureRandom can be much better
        int i = random.nextInt((Integer.MAX_VALUE-26));
        return i;
    }


    public static int randomZahl (int interval){
        SecureRandom random = new SecureRandom();
        //TODO java.security.SecureRandom can be much better
        int i = random.nextInt(interval);
        return i;
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


    public static String randomNameForEncrypting(){
        ArrayList<String> arrayWithNames = new ArrayList<String>();


        String names= "names.txt";

        File file = new File(names);
        BufferedReader br = null;

        if (!file.canRead() || !file.isFile()) {
            System.out.println("There is no file with names");
        }

        try{
            br = new BufferedReader(new FileReader(names));
            String line = null;
                while ((line = br.readLine()) != null) {
                    arrayWithNames.add(line);
                }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                }
        }

        //TODO Level  up with integer parameter
        return arrayWithNames.get(randomZahl(arrayWithNames.size())).toLowerCase();
    }


    public static boolean check(String name, String nameTry){
        name.toLowerCase();
        nameTry.toLowerCase();

        if(nameTry.equals(name)){
            return true;
        }
        else{
            return false;
        }
    }
}