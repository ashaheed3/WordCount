# WordCount

## Purpose
The purpose of the progam is to count the number of words, lines, alphanumeric characters. sentences, vowels, and punctuation contained in a file supplied by the user. The program then print the results out on screen and to an output file titled "output.txt".

## Solution
The program must be able to open an external file; count the number of words, lines, alphanumeric characters, sentences, vowels, and punctuation; create an output file; and print out text. 

To simplify the task, the overall problem is divided into 9 smaller problems and assigned to nine separate methods

1. [openInputFile](#openInputFile) 
2. [openOutputFile](#openOutputFile)  
3. [countWords](#countWords) 
4. [countLines](#countLines)  
5. [countCharacters](#countCharacters)  
6. [countVowels](#countVowels) 
7. [countSentences](#countSentences) 
8. [countPunctuation](#countPunctuation) 
9. [writeToFile](#writeToFile) 

### openInputFile
 OpenInputFile provides the program with a file to read text from. Without an inputfile or text to read from, the program is useless. Therefore, the method needs to check if the input file actually exists and if it contains text. After being supplied with a file name, openFileInput reads a byte of data from the input stream. If  there is no data to read from the program terminates. Also the method checks to see it the file exists by catching the FileNotFoundException when it occurs and printing out an error message before terminating.

### openOutputFile
 OpenOutputFile simply creates the output file.

### countWords
CountWords utilizes a while loop to go move through the string of text from the input file word by word. The while loop increments the word counter everytime a word is encountered until the end of the string of the string is reached. At that point the while loop terminates itself and the word count is returned.

### countLines
CountLines utilizes the same algorithm as CountWords.The while loop increments the line counter everytime a end of line character is encountered until the end of the string of the string is reached. At that point the while loop terminates itself and the line count is returned.

### countCharacters
CountCharacters reads the entire text file at once as a string object. The method then trims all the spaces in the string. Finally, the method returns the length of the string.

### countVowels
CountVowels starts by converting the all the letters in the string 
object, derived from the input file, into lowercase letters. Then the method uses a for loop that runs the length of the string to count the vowels. If the character "a", "e", "i", or "u" is encountered at position i, the vowel counter is incremented.

### countSentences
### countPunctuation
 CountSentences and CountPunctuation utilizes the same algorithm countVowel uses with a few minor differences. The string is not converted to lower case for countSentences and countPunctuation.

CountSentences only increments its counter when a ".", "!", or "?" is found while countPunctuation increments its counter when a ".", "!", "?", "(", ")", """, ",", ";", ":", "'", "-" is found. 

### writeToFile
 WriteToFile simply opens an output file and prints out to it.

 ## Data Structures
none
 
 ## Use
 When prompted, the user will enter the name of the file, including the extension, of the file they wish to program to read from. For example, if the user wants the program to read from a text file names test, they will enter "test.txt" when prompted for a file name. The file must be located in the same folder as the source code of the program or else, the program will throw a FileNotFoundException and terminate. Once a valid file name has been suppplied, the program prints out the  number of words, lines, alphanumeric characters, sentences, vowels, and punctuation the file has both on the screen and in the output file.
