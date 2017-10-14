package smith;
/* File: FileScanner.java
*  Author: Hunter Smith
*  Date: 13Oct2017
*  Purpose: program to read csv file, provide stats on crime, and track elapsed time of program runtime.
*/

public class TestUSCrimeClass {

    public static void main(String[] args) throws InterruptedException {
        //check pre-conditions for program
        // End else if statement
        if (args.length == 0){
            System.out.println("Please use the command line arguments pass in crime.csv");
            System.exit(0);
        }// End if statement
        //Check if correct file
        else {
            if (!args[0].equals("Crime.csv")) {
                System.out.println("Incorrect file provided");
                System.exit(0);
            }// End else if statement

        }
        //Pre-conditions met continue program

        //start timer
        long startTime = System.currentTimeMillis();

        //Instantiate objects
        FileScanner fileScan = new FileScanner();
        MenuHandler menuHandler = new MenuHandler();

        //pass arguments to FileScanner and call MenuHandler
        fileScan.OpenFile(args[0]);
        menuHandler.menu();

        //calculate runtime and display
        long runTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.printf("Elapsed time in seconds was: %d", runTime);
    }
}
