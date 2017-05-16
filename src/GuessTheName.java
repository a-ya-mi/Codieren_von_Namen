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

            JFrame jf = new OurFrame();


            try {
                //random name with diffikult lavel 1
                String name=randomNameForEncrypting(1);

                //encrypting with caesar withthe random key
                String nameWithCaesar = caesar(name, randomZahl());
                System.out.println("Whhich name is ist?  --- " + nameWithCaesar + " ---");

                //name suggestion from user
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String nameTry = br.readLine();

                if (check(name, nameTry)==true){
                    System.out.println("You are right!");
                }
                else{
                    System.out.println("You are wrong!");
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


    public static String randomNameForEncrypting(int level){
        ArrayList<String> arrayWithNames = new ArrayList<String>();


        //differend Level 1 for difficult and 2 for VERY difficult
        String names="";
        switch (level) {
            case 1:
                names = "names.txt";

            case 2:
                names = "namesDifficult.txt";
        }

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