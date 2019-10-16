/***********************************************************************
*
*	This program intended to determine how fast the user will need to
*	drive to get up to certain sections of I- 95 in a given time.
*
***********************************************************************/

import java.util.Scanner;	// Needed for the Scanner class

public class SpeedMachine
{

	public static void main (String[] args)
	{
		//Declare variables.
		final int 	stopTime = 5;																//Constant stop time of 5 minutes
		double 		givenTime, 
					distance,
					numOfStops, 
					speed,
					actualDrivingTime,
					finalSpeed;																	//The given time, the given distance, number of stops, speed and final speed including rest stop deductions.
		boolean 	exceedsSpeedLimit = false;													//Variable for exceeding the speed limit.
		
		//Create a Scanner object to read input.
		Scanner keyboard = new Scanner (System.in);
		
		//Call the method that provides the user with instructions.
		userMessages();
		
		
		//Retrieve the user input.
		distance = keyboard.nextDouble();
		givenTime = keyboard.nextDouble();
		
	
		//Calculate the time for stops. 
		//The program must allow rest stops of 5 minutes for every 100 miles (part there-of) traveled.
		numOfStops = distance / 100;
		
		if (distance != 0)
		{
			numOfStops++;
		}
		
		//Calculate the speed for travel.
		speed = distance / givenTime;
		
		//Calculate the time for travel.
		actualDrivingTime = givenTime - (numOfStops * stopTime * 1.0 / 60);
		
		//Calculate the final speed.
		finalSpeed = distance / actualDrivingTime;
		
		//Determine if the user if speeding via boolean variable.
		if (speed > 65)
		{
			exceedsSpeedLimit= true;
		}
		
		//Call the method that provides the user with output.
		displayOutput();
		
	}
	public static void userMessages()
		{
			
		//Welcome the user into the program.
		System.out.println("Welcome to the I95 Speed Machine");
		
		//Skip a line.
		System.out.println();
		
		//Prompt the user for information.
		System.out.println("You will have to supply:");
		System.out.println("+ The distance you want to travel, in miles");
		System.out.println("+ The time you have available, in hours");
		System.out.print("Enter the distance to travel\t\t: ");
		System.out.println("Enter time available\t\t: ");
		
		}
		
	public static void displayOutput(finalSpeed,exceedsSpeedLimit)
		{
			
		//Provide the user with the output
		System.out.println("You will have to travel at" + finalSpeed + "mph");
		System.out.println("Over the speed limit\t\t: " + exceedsSpeedLimit);	
		}
}