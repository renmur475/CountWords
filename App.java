import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("words.txt"); //Read the words from the file
        Scanner reader = new Scanner(file);
       
        List<String> wordsFile = new ArrayList<String>(); //Creating an ArrayList to add the words into
        while (reader.hasNext()) {
            String word = reader.next();
            wordsFile.add(word);
        }

        reader.close();
        String[] words = wordsFile.toArray(new String[0]); //Turns the list into string array
 

        for(int i = 0; i < words.length; i++) //Converts all words into lowercase so its not case sensitive
        {
            words[i] = words[i].toLowerCase();
        }

        Map<String, Integer> hashmap = new HashMap<>();

        for (String s: words) {
    
            if (!hashmap.containsKey(s)) { //If this is the first time a word has been seen...
              hashmap.put(s, 1); //Add the word to the map and make its value 1
            }
            else { //If the word has been seen before...
              int count = hashmap.get(s); //Count the number of times it has been seen previously
              hashmap.put(s, ++count); //Increment the number of times its been seen
            }
          }

            String file2 = "output.txt"; //Create a file to write to
            BufferedWriter writer = null;

            try{
            writer = new BufferedWriter(new FileWriter(file2));
            for (Map.Entry<String, Integer> entry : //Traverse through the map
                hashmap.entrySet()) { 
                writer.write(entry.getKey() + " " + entry.getValue());  //Write the key and value to file
                writer.newLine(); 
                }
            }
            catch(IOException e) {} 
            finally{
                System.out.println("Write successful!");
                writer.close();
            }
    }

}

