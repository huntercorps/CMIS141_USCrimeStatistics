package smith;
/* File: smith.MenuHandler.java
*  Author: Hunter Smith
*  Date: 13Oct2017
*  Purpose: Class to display menus and handle user menu selections.
 */
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class MenuHandler {

    /*Method to obtain user's input and return to caller*/
    private String selector(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().toLowerCase().trim();
    }// End selector method

    /* Displays the main menu and prompts user for selection */
    void menu() throws InterruptedException {
        //Display menu
        System.out.println(
                "********** Welcome to the US Crime Statistical Application **************************");
        String input = "";
        while (!input.equals("q")){ //while loop continues to redisplay after results are returned or until Q is selected
            System.out.println(
                    "\nEnter the number of the question you want answered. Enter ‘Q’ to quit the program :\n");
            System.out.println(
                    "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
            System.out.println(
                    "2. What year was the Murder rate the highest?");
            System.out.println(
                    "3. What year was the Murder rate the lowest?");
            System.out.println(
                    "4. What year was the Robbery rate the highest?");
            System.out.println(
                    "5. What year was the Robbery rate the lowest?");
            System.out.println(
                    "6. What year were the crime statistics for a given crime?");
            System.out.println(
                    "7. What year were the crime statistics for a given year?");
            System.out.println(
                    "Q. Quit the program");
            System.out.print(
                    "\nEnter your selection: ");

            //Listen for user's selection and display results. Delays displaying menu for easier result readability
            input = selector();
            switch (input){
                case "1":  System.out.println(USCrimeClass.populationGrowthPercentage());
                    TimeUnit.MILLISECONDS.sleep(2000);
                    break;
                case "2":  System.out.printf("\nThe Murder rate the highest in %d\n",
                        USCrimeClass.getMaxMurderYear());
                    TimeUnit.MILLISECONDS.sleep(1500);
                    break;
                case "3":  System.out.printf("\nThe Murder rate the lowest in %d\n",
                        USCrimeClass.getMinMurderYear());
                    TimeUnit.MILLISECONDS.sleep(1500);
                    break;
                case "4":  System.out.printf("\nThe Robbery rate the highest in %d\n",
                        USCrimeClass.getMaxRobberyYear());
                    TimeUnit.MILLISECONDS.sleep(1500);
                    break;
                case "5":  System.out.printf("\nThe Robbery rate the lowest in %d\n",
                        USCrimeClass.getMinRobberyYear());
                    TimeUnit.MILLISECONDS.sleep(1500);
                    break;
                case "6": subMenu1();
                    TimeUnit.MILLISECONDS.sleep(2000);
                    break;
                case "7":
                    USCrimeClass selection = subMenu2();
                    if (selection != null) {
                        System.out.println("\n"+selection.toString());
                        TimeUnit.MILLISECONDS.sleep(2500);
                    }// End if statement
                    else {
                        TimeUnit.MILLISECONDS.sleep(1500);
                    }// End else statement
                    break;
                case "q":  System.out.println("\nThank you for trying the US Crimes Statistics Program.\n");
                    //TimeUnit.MILLISECONDS.sleep(1500);
                    break;
                default:  System.out.println("\nInvalid Input\n");
                    TimeUnit.MILLISECONDS.sleep(1500);
            }// End switch statement
        }//End while loop
    }// End menu method

    private void subMenu1(){
        //Display subMenu
       System.out.println("1. Violent Crime");
       System.out.println("2. Murder & non-Negligent Manslaughter");
       System.out.println("3. Rape");
       System.out.println("4. Robbery");
       System.out.println("5. Aggravated Assualt");
       System.out.println("6. Property Crime");
       System.out.println("7. Burglary");
       System.out.println("8. Larceny-Theft");
       System.out.println("9. Motor Vehicle Theft");
       System.out.print("\nEnter your selection: ");

        //Listen for user's selection and display results.
       String subInput = selector();
       //Only print Year if value is valid
       if (Integer.valueOf(subInput) >= 1 && Integer.valueOf(subInput) <= 9 ){
           System.out.print("\nYear\t");
       }// End if statement
        switch (subInput){
            case "1":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getViolentCrime());
                }// End for loop
                break;
            case "2":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getMurderAndManslaughter());
                }// End for loop
                break;
            case "3":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getRape());
                }// End for loop
                break;
            case "4":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getRobbery());
                }// End for loop
                break;
            case "5":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getAggravatedAssualt());
                }// End for loop
                break;
            case "6":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getPropertyCrime());
                }// End for loop
                break;
            case "7":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getBurglary());
                }// End for loop
                break;
            case "8":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getLarcenyTheft());
                }// End for loop
                break;
            case "9":
                System.out.print("Violent Crime\n-------------------------\n");
                for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
                    System.out.println(USCrimeClass.usCrimeArrayList.get(i).getYear()+
                            "\t"+ USCrimeClass.usCrimeArrayList.get(i).getMotorVehicleTheft());
                }// End for loop
                break;
            default:  System.out.println("\nInvalid Input\n");
        }// End switch statement
    }// End subMenu1

    private USCrimeClass subMenu2(){
        //Display subMenu2
        for (int i = 0; i < USCrimeClass.usCrimeArrayList.size(); i++) {
            System.out.println(i+1+".\t"+ USCrimeClass.usCrimeArrayList.get(i).getYear());
        }// End for loop
        USCrimeClass usCrimeInstance;
        //Get users input and check validity
        try {
            System.out.println("\nEnter your selection: ");
            int selection= Integer.parseInt(selector())-1;
            usCrimeInstance = USCrimeClass.usCrimeArrayList.get(selection);
        }// End try block
        catch (NumberFormatException | IndexOutOfBoundsException ex){
            System.out.println("Invalid input ("+ex+")");
            System.out.println("Returning to main menu... ");
            return null;
        }// End catch block
        return usCrimeInstance;
    }// End subMenu2

}// End smith.MenuHandler class
