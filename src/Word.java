import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;


//TODO  getters and setters
/**
 * Created by Aksana on 01.06.2017.
 */
public class Word {
    int counter;
    String name;
    String nameWithCaesar;

    public  Word() {
        counter = 1;

            name = randomNameForEncrypting();

            //encrypting with caesar with
            // the random key
            nameWithCaesar = caesar(name, randomZahl());

    }

    /*public String gameAnswer (String nameTry){

        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //nameTry = br.readLine();
            nameTry = this.nameTry;
            nameTry.toLowerCase();

            boolean count = false;

            while (count != true) {
                if (check(name, nameTry) == true) {
                    count = true;
                    return "You are right!";

                } else {
                    String s = "One more try! --- " + nameWithCaesar + " ---";
                    counter++;
                    count = false;
                    return s;
                    //nameTry = br.readLine();
                }
            }
        }
        catch (Exception e){
            return "mistake";
        }

        return "mistake2";
    }*/


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
