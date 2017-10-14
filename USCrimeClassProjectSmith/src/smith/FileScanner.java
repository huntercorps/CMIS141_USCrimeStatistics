package smith;
/* File: smith.FileScanner.java
*  Author: Hunter Smith
*  Date: 13Oct2017
*  Purpose: Read from file and output read data.
 */

import java.io.*;
import java.util.Scanner;

class FileScanner {

    /*Method to file and call the read method*/
    void OpenFile(String crimeFile){
        Scanner fileIn = null;
        //try to open crimeFile and pass to readTextFile
        try {
            File myFile = new File(crimeFile);
            fileIn = new Scanner( new BufferedReader(new FileReader(myFile)));
            fileIn.useDelimiter(",");
            ReadFile(fileIn);
        }// End try block
        //if exception is caught display message w/exception details and exit program
        catch (FileNotFoundException exception){
            System.out.println("Could not find file ("+exception+")");
            System.exit(0);
        }// End catch block
        //close stream after trying to open and read file
        finally {
            if (fileIn != null)
            fileIn.close();
        }// End Finally block
    }//End OpenFile

    /*Method to read files and convert info into smith.USCrimeClass objects*/
    private void ReadFile(Scanner fileIn){
        //Declare variables
        String crimeStatLine; //stores individually read lines
        String[] crimeStatItems; //stores collection of read items in a line
        int counter=0; //used to bypass header in csv file
        //try to read csv file, and pass into ArrayList
        try {
            while (fileIn.hasNextLine()){
                //assign next line to crimeStatLine and split into individual crimeStatItems
                crimeStatLine = fileIn.nextLine();
                crimeStatItems = crimeStatLine.split(",");
                //ignore header in file
                if (counter>0) {
                    USCrimeClass.buildList(crimeStatItems);
                    //smith.USCrimeClass usCrimeInstance = new smith.USCrimeClass(crimeStatItems);
                    //smith.USCrimeClass.usCrimeArrayList.add(usCrimeInstance);
                }// End if statement
                counter++;
            }// End while loop
        }// End try block
        //if exception is caught display message w/exception details and exit program
        catch (Exception exception){
            System.out.println("Could not read file ("+exception+")");
            System.exit(0);
        }// End catch block
    }
}//End smith.FileScanner
