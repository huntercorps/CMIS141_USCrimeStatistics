package smith;
/* File: smith.USCrimeClass.java
* Author: Hunter Smith
* Date: October 13,2017
* Purpose: A Java class named HeadPhone to represent a headphone set.
*/

import java.util.*;

public class USCrimeClass {
    //declare static ArrayList to store temp smith.USCrimeClass objects
    static List<USCrimeClass> usCrimeArrayList = new  ArrayList<>();
    //Declare smith.USCrimeClass fields
    private int year;
    private int population;
    private int violentCrime;
    private double violentCrimeRate;
    private int murderAndManslaughter;
    private double murderAndManslaughterRate;
    private int rape;
    private double rapeRate;
    private int robbery;
    private double robberyRate;
    private int aggravatedAssualt;
    private double aggravatedAssualtRate;
    private int propertyCrime;
    private double propertyCrimeRate;
    private int burglary;
    private double burglaryRate;
    private int larcenyTheft;
    private double larcenyTheftRate;
    private int motorVehicleTheft;
    private double motorVehicleTheftRate;

    /*Constructor*/
    public USCrimeClass(String[] args){
        year=Integer.parseInt(args[0]);
        population = Integer.parseInt(args[1]);
        violentCrime =Integer.parseInt(args[2]);
        violentCrimeRate =Double.parseDouble(args[3]);
        murderAndManslaughter =Integer.parseInt(args[4]);
        murderAndManslaughterRate =Double.parseDouble(args[5]);
        rape=Integer.parseInt(args[6]);
        rapeRate=Double.parseDouble(args[7]);
        robbery=Integer.parseInt(args[8]);
        robberyRate=Double.parseDouble(args[9]);
        aggravatedAssualt=Integer.parseInt(args[10]);
        aggravatedAssualtRate=Double.parseDouble(args[11]);
        propertyCrime=Integer.parseInt(args[12]);
        propertyCrimeRate=Double.parseDouble(args[13]);
        burglary=Integer.parseInt(args[14]);
        burglaryRate=Double.parseDouble(args[15]);
        larcenyTheft=Integer.parseInt(args[16]);
        larcenyTheftRate=Double.parseDouble(args[17]);
        motorVehicleTheft=Integer.parseInt(args[18]);
        motorVehicleTheftRate=Double.parseDouble(args[19]);
    }//End Constructor

    /* Getter methods*/
    public int getYear(){
        return year;
    }

    public String getPopulation() {
        return String.format("%,d", population);
    }

    public String getViolentCrime() {
        return String.format("%,d", violentCrime);
    }

    public double getViolentCrimeRate() {
        return violentCrimeRate;
    }

    public String getMurderAndManslaughter() {
        return String.format("%,d", murderAndManslaughter);
    }

    public double getMurderAndManslaughterRate() {
        return murderAndManslaughterRate;
    }

    public String getRape() {
        return String.format("%,d", rape);
    }

    public double getRapeRate() {
        return rapeRate;
    }

    public String getRobbery() {
        return String.format("%,d", robbery);
    }

    public double getRobberyRate() {
        return robberyRate;
    }

    public String getAggravatedAssualt() {
        return String.format("%,d", aggravatedAssualt);
    }

    public double getAggravatedAssualtRate() {
        return aggravatedAssualtRate;
    }

    public String getPropertyCrime() {
        return String.format("%,d", propertyCrime);
    }

    public double getPropertyCrimeRate() {
        return propertyCrimeRate;
    }

    public String getBurglary() {
        return String.format("%,d", burglary);
    }

    public double getBurglaryRate() {
        return burglaryRate;
    }

    public String getLarcenyTheft() {
        return String.format("%,d", larcenyTheft);
    }

    public double getLarcenyTheftRate() {
        return larcenyTheftRate;
    }

    public String getMotorVehicleTheft() {
        return String.format("%,d", motorVehicleTheft);
    }

    public double getMotorVehicleTheftRate() {
        return motorVehicleTheftRate;
    }

    /*toString method*/
    @Override
    public String toString() {
        return "Year: \t\t\t\t\t\t"+getYear()+
                "\nPopulation: \t\t\t\t" +getPopulation()+
                "\nViolent crime: \t\t\t\t"+getViolentCrime()+ "  ("+getViolentCrimeRate()+" / 10,000)"+
                "\nMurder & non-negligent"+
                "\nmanslaughter: \t\t\t\t"+ getMurderAndManslaughter()+"  ("+ getMurderAndManslaughterRate()+" / 10,000)"+
                "\nRape: \t\t\t\t\t\t"+getRape()+"  ("+getRapeRate()+" / 10,000)"+
                "\nRobbery: \t\t\t\t\t"+getRobbery()+"  ("+getRobberyRate()+" / 10,000)"+
                "\nAggravated assault: \t\t"+getAggravatedAssualt()+"  ("+getAggravatedAssualtRate()+" / 10,000)"+
                "\nProperty crime: \t\t\t"+getPropertyCrime()+ "  ("+getPropertyCrimeRate()+" / 10,000)"+
                "\nBurglary: \t\t\t\t\t"+getBurglary()+"  ("+getBurglaryRate()+" / 10,000)"+
                "\nLarceny-theft: \t\t\t\t"+getLarcenyTheft()+"  ("+getLarcenyTheftRate()+" / 10,000)"+
                "\nMotor vehicle theft: \t\t"+getMotorVehicleTheft()+"  ("+getMotorVehicleTheftRate()+" / 10,000)";
    }// End toString method

    /*------Static smith.USCrimeClass Methods----------*/

    /*Method to create temp smith.USCrimeClass obj and assign to ArrayList*/
    static void buildList(String[] crimeStatItems){
        USCrimeClass USCrimeInstance = new USCrimeClass(crimeStatItems);
        USCrimeClass.usCrimeArrayList.add(USCrimeInstance);
    }// End buildList method

    /*Method to create and return a string on population growth*/
    static String populationGrowthPercentage(){
        //Declare variables
        int currentPop;
        int previousPop;
        double growthPercent;
        StringBuilder stringBuilder =new StringBuilder("Year\t\tPopulation Growth\n");
        stringBuilder.append("-----------------------------\n");
        for (int i = 1; i < usCrimeArrayList.size(); i++) {
            currentPop = usCrimeArrayList.get(i).population;
            previousPop = usCrimeArrayList.get(i-1).population;
            stringBuilder.append(usCrimeArrayList.get(i).year).append("-").append(usCrimeArrayList.get(i-1).year);
            growthPercent = ((currentPop-previousPop)/(double)previousPop)*100;
            stringBuilder.append("\t\t").append(String.format("%.4f",growthPercent)).append("%\n");
        }// End for loop
        return stringBuilder.toString();
    }// End populationGrowthPercentage method

    static int getMaxMurderYear(){
        int max = usCrimeArrayList.get(0).murderAndManslaughter;
        int year=usCrimeArrayList.get(0).year;
        for (USCrimeClass myUsCrimeArrayList : usCrimeArrayList) {
            if (myUsCrimeArrayList.murderAndManslaughter > max) {
                max = myUsCrimeArrayList.murderAndManslaughter;
                year = myUsCrimeArrayList.year;
            }// End if statement
        }// End foreach loop
        return year;
    }// End getMaxMurderYear method

    static int getMinMurderYear(){
        int min = usCrimeArrayList.get(0).murderAndManslaughter;
        int year=usCrimeArrayList.get(0).year;
        for (USCrimeClass myUsCrimeArrayList : usCrimeArrayList) {
            if (myUsCrimeArrayList.murderAndManslaughter < min) {
                min = myUsCrimeArrayList.murderAndManslaughter;
                year = myUsCrimeArrayList.year;
            }// End if statement
        }// End foreach loop
        return year;
    }// End getMinMurderYear method

    static int getMaxRobberyYear(){
        int max = usCrimeArrayList.get(0).robbery;
        int year=usCrimeArrayList.get(0).year;
        for (USCrimeClass myUsCrimeArrayList : usCrimeArrayList) {
            if (myUsCrimeArrayList.robbery > max) {
                max = myUsCrimeArrayList.robbery;
                year = myUsCrimeArrayList.year;
            }// End if statement
        }// End foreach loop
        return year;
    }// End getMaxRobberyYear method

    static int getMinRobberyYear(){
        int min = usCrimeArrayList.get(0).robbery;
        int year=usCrimeArrayList.get(0).year;
        for (USCrimeClass myUsCrimeArrayList : usCrimeArrayList) {
            if (myUsCrimeArrayList.robbery < min) {
                min = myUsCrimeArrayList.robbery;
                year = myUsCrimeArrayList.year;
            }// End if statement
        }// End foreach loop
        return year;
    }// End getMinRobberyYear method
}// End smith.USCrimeClass
