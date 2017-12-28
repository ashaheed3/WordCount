/* Ayanna Shaheed
 *Purpose: The purpose of the progam is to count the number of words, lines,
 *         alphanumeric characters, sentences, vowels, and punctuation contained
 *         in a file supplied by the user. The program then print the results out 
 *         on screen and to an output file titled "output.txt".
 *______________________________________________________________________________
 *Solution: The program must be able to open an external file; count the number 
 *          of words, lines, alphanumeric characters, sentences, vowels, and 
 *          punctuation; create an output file; and print out text. To simplify 
 *          the task, the overall problem is divided into 9 smaller problems and 
 *          assigned to nine separate methods such as, openInputFile, 
 *          openOutputFile, countWords, countLines, countCharacters, countVowels,
 *          countSentences, countPunctuation, and writeToFile.
 *          OpenInputFile provides the program with a file to read text from.
 *          Without an inputfile or text to read from, the program is useless.
 *          Therefore, the method needs to check if the input file actually
 *          exists and if it contains text. After being supplied with a file 
 *          name, openFileInput reads a byte of data from the input stream. If 
 *          there is no data to read from the program terminates. Also the 
 *          method checks to see it the file exists by catching the 
 *          FileNotFoundException when it occurs and printing out an error 
 *          message before terminating.
 *          OpenOutputFile simply creates the output file.
 *          CountWords utilizes a while loop to go move through the string of text 
 *          from the input file word by word. The while loop increments the word  
 *          counter everytime a word is encountered until the end of the string 
 *          of the string is reached. At that point the while loop terminates 
 *          itself and the word count is returned.
 *          CountLines utilizes the same algorithm as CountWords.The while loop 
 *          increments the line counter everytime a end of line character is
 *          encountered until the end of the string of the string is reached. 
 *          At that point the while loop terminates itself and the line count is 
 *          returned.
 *          CountCharacters reads the entire text file at once as a string object. 
 *          The method then trims all the spaces in the string. Finally, the 
 *          method returns the length of the string.
 *          CountVowels starts by converting the all the letters in the string 
 *          object, derived from the input file, into lowercase letters. Then 
 *          the method uses a for loop that runs the length of the string to  
 *          count the vowels. If the character "a", "e", "i", or "u" is 
 *          encountered at position i, the vowel counter is incremented.
 *          CountSentences and CountPunctuation utilizes the same algorithm 
 *          countVowel uses with a few minor differences. The string is not
 *          converted to lower case for countSentences and countPunctuation.
 *          CountSentences only increments its counter when a ".", "!", or "?" 
 *          is found while countPunctuation increments its counter when a 
 *          ".", "!", "?", "(", ")", """, ",", ";", ":", "'", "-" is found. 
 *          WriteToFile simply opens an output file and prints out to it. 
 *______________________________________________________________________________
 *Data Structures: none
 *______________________________________________________________________________
 *Use: When prompted, the user will enter the name of the file, including the 
 *     extension, of the file they wish to program to read from. For example, if
 *     the user wants the program to read from a text file names test, they will 
 *     enter "test.txt" when prompted for a file name. The file must be located
 *     in the same folder as the source code of the program or else, the program 
 *     will throw a FileNotFoundException and terminate. Once a valid file name 
 *     has been suppplied, the program prints out the  number of words, lines, 
 *     alphanumeric characters, sentences, vowels, and punctuation the file has
 *     both on the screen and in the output file.
 *
 *
 *
 */

package wordcount;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Ayanna
 */
public class wordcount {
    
    private static String fileName;
    private static String line;
    
    //Prompts user for input file to read from
    private static void openInputFile(String prompt){
        
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        fileName = sc.next();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int bytes = br.read();
            if (bytes == -1){
                System.out.println("File is empty");
                System.exit(-1);
            }
            sc.close();
        }catch (FileNotFoundException e){
            System.out.println("The file you entered either does not exist or "
                                    + "the name is spelled wrong.Goodbye!");
            System.exit(-1);
        }catch (IOException e){
            System.out.println(e);
        }
        finally
        {
            sc.close();
        }        
               
    }  
    
    //Opens output file called output
    private static void openOutputFile(){
        
              
         try{
             FileWriter fileOut = new FileWriter("output.txt");
             BufferedWriter bufOut = new BufferedWriter(fileOut);
             PrintWriter out = new PrintWriter(bufOut);
             
             }
         catch (IOException e){
            System.out.print(e);
        }
    }
    
    //Counts words in file
    private static int countWords(){
        int wordCount = 0;
        
        try{
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        wordCount = 0;
        
        
         while(in.hasNext())
            {
                in.next();
                wordCount++ ;
            }
        }catch (FileNotFoundException e){
            
        }
        return wordCount;
    }
    
    //Counts lines in file
    private static int countLines(){
     int lineCount = 0;
        
        try{
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        lineCount = 0;
        
        
         while(in.hasNextLine())
            {
                in.nextLine();
                lineCount++ ;
            }
        }catch (FileNotFoundException e){
            
        }
        return lineCount;   
    }
    
    //Counts characters in file
    private static int countCharacters(){
       line = "";
        
        try{
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        line = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
            
        }catch (FileNotFoundException e){
            
        }
        return line.replaceAll("\\s","").length();   
    
    }
    
    //Counts vowels in file
    private static int countVowels(){
       
       int vowelCount = 0;
       for(int i = 0; i < line.length(); i++){
           char letter = line.toLowerCase().charAt(i);
          
           switch (letter) {
               case 'a': case 'e': case'i': case 'o': case'u':
                   vowelCount++;
                   break;
           }
           
           
       }
       return vowelCount; 
    }
    
    //Counts sentences in file
    private static int countSentences(){
        int sentenceCount = 0;
       for(int i = 0; i < line.length(); i++){
           char letter = line.charAt(i);
          
           switch (letter) {
               case '.': case '?': case'!': 
                   sentenceCount++;
                   break;
           }
       }   
           return sentenceCount;
   }
    //Counts punctuation 
    private static int countPunctuation(){
        int punctuationCount = 0;
       for(int i = 0; i < line.length(); i++){
           char letter = line.charAt(i);
          
           switch (letter) {
               case '.': case '?': case'!': case '(': case ')': case '"':
               case ',': case ';': case':': case '\'': case '-': 
                   punctuationCount++;
                   break;
           }
       }   
           return punctuationCount;
   }
    
    //Prints string to output file
   private static void writeToFile(int value, String type){
        
         PrintWriter output = null;
         try
         {
            output = new PrintWriter(new FileWriter("output.txt"));
            output.println("File has " + value + type);
         }catch(IOException e)
         {
             System.out.println(e);
             System.exit(1);
         }
         finally 
         {
            output.close(); 
         } 

    
        }

        
        
    
    public static void main(String[] args) {
        //Opens input and output file
        openInputFile("Enter file name ");
        openOutputFile();
        
        //Prints out word count to file and on screen
        System.out.println(countWords()+ " words");
        writeToFile(countWords(), " words");
        
        //Prints out line count to file and on screen
        System.out.println(countLines()+ " lines");
        writeToFile(countLines(), " lines");
        
        //Prints out character count to file and on screen
        System.out.println(countCharacters()+ " characters");
        writeToFile(countCharacters(), " characters");
        
        //Prints out vowel count to file and on screen
        System.out.println(countVowels()+ " vowels");
        writeToFile(countVowels(), " vowels");
        
        //Prints out sentence count to file and on screen
        System.out.println(countSentences()+ " sentences");
        writeToFile(countSentences(), " sentences");
        
        //Prints out punctuation count to file and on screen
        System.out.println(countPunctuation() + " punctuation");
        writeToFile(countPunctuation(), " punctuation");
    }
    
}
