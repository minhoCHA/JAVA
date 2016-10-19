/**
 * Temperature.java
 * Demonstrates to use the principles of object-oriented design to create appropriate classes, methods, instance data.
 * Made Temperature test program
 *
 * Minho Cha
 * Date 2016-04-04
 */

/**
 * Create four constructors to specify degrees and type
 * Create three methods to display both degrees and type, display temperature in degrees C, and display temperature in degrees F
 * Create two accessor methods to get tempaerature in degrees C, and degrees F
 * Create three mutator methods to update degree, type, and both
 * Create an "equals" method to compare temperatures in different degrees unit
 * Create an "toSring" method to determine what output is displayed
 * Create a "readinput" method to prompt user for degrees and type and then reads the values
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Temperature{

	private double degrees;
	private char type;

	Scanner scan = new Scanner(System.in);

	//constructor for two parameters
	public Temperature(double d,char t){

		degrees = d;
		type = t;
	}

	//constructor for just the degrees
	public Temperature(double d){

		type = 'C';
		degrees = d;
	}

	//constructor for just the type
	public Temperature(char t){

		type = t;
		degrees = 0.0;
	}

	// default constructor
	public Temperature(){

		type = 'C';
		degrees = 0.0;
	}

	//display both parameter values
	public void writeOutput(){

		DecimalFormat num = new DecimalFormat("0.0");
		System.out.println("Temperature = " + num.format(degrees) + " degrees "+ type +".");
	}

	//display temperature in degrees C
	public void writeC(){

		DecimalFormat num = new DecimalFormat("0.0");

		if ( type == 'C' || type == 'c' )
			System.out.println("Temperature = " + num.format(degrees) + " degrees Celsius");
		else
			System.out.println("Temperature = " + num.format((degrees-32.0)*5.0/9.0) + " degrees Celsius");
	}

	//display temperature in degrees F
	public void writeF(){

		DecimalFormat num = new DecimalFormat("0.0");

		if ( type == 'F' || type == 'f' )
			System.out.println("Temperature = " + num.format(degrees) + " degrees Fahrenheit");
		else
		    System.out.println("Temperature = " + num.format(degrees*9.0/5.0+32.0) + " degrees Fahrenheit");

	}


	//to get temperature
	public double getC(){

		if ( type == 'C' || type == 'c' )
		    return Math.round(degrees*10)/10.0;
		else
		    return Math.round(((degrees-32)*5/9)*10)/10.0;

	}

	public double getF(){

		if ( type == 'F' || type == 'f' )
			return Math.round(degrees*10)/10.0;
		else
			return Math.round((degrees*9/5+32)*10)/10.0;
	}

	//to set the parameters
	public void set(double degrees){

		this.degrees = degrees;
	}

	public void set(char type){

		this.type = type;
	}

	public void set(double degrees, char type){

		this.degrees = degrees;
		this.type = type;
	}

	//comparison method
	public boolean equals(Temperature t2){

     return this.getC() == t2.getC ();
	}

	//toString method
	public String toString(){

		return "Temperature " + degrees + "F" ;
	}

	//implement a readInput method to prompt user for degrees and type and then read the values
	public void readInput(){

		String input;
		System.out.println("Enter a temperature in degress (for example 29.6):");
		degrees = scan.nextDouble();
		System.out.println("Enter 'F'(or 'f')for Faharenheit or 'C'(or 'c')for Celsius:");
		input = scan.nextLine();
		input = scan.nextLine();
		type = input.charAt(0);
	}

}