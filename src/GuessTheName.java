/**
 * Created by Aksana on 07.05.2017.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.io.*;


public class GuessTheName {

    public static void main(String  []args){

            try {
                //random Name from Array (later from .txt)
                String name=randomNameForEncrypting();

                //encrypting with caesar withthe random key
                String nameWithCaesar = caesar(name, randomZahl());
                System.out.println("Whhich name is ist?");
                System.out.println(nameWithCaesar);

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


    public static String randomNameForEncrypting(){
        String[] arrayWithNames=new String[]{"Aksana", "Andreas", "Anna"};
        //TODO read names from file
        /*try{
            BufferedReader in = new BufferedReader(new FileReader("names.txt"));
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }*/
        return arrayWithNames[randomZahl(arrayWithNames.length)].toLowerCase();
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