/*	Author: Malachy Crossan
	Date: 9/16/24
	Assignment1
	Receipt generator
*/
package assignment1;

import java.util.Scanner;
import java.util.Random;

public class Crossan_Malachy {
	//Entry point
	public static void main(String[] args) {
        Random random = new Random(); // Initializes the random number object
        try (Scanner scanner = new Scanner(System.in)) {
			int receiptNumber = 1000 + random.nextInt(1000); // Random receipt number [1000,2000)
			String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			String month = months[random.nextInt(12)]; //Random Month from array
			int day = 1 + random.nextInt(28); // Random day [1,28]
			int year = 1900 + random.nextInt(200); // Random year [1900,2100)

			// Print receipt header
			System.out.println("******************************");
			System.out.println("**Reciept for Malachy's Store**");
			System.out.println("******************************");
			System.out.printf("receipt number      %d%n", receiptNumber);
			System.out.printf("%s %d %d%n", month, day, year);

			int itemCount = 0;
			double totalSum = 0.0;

			
			// Main loop
			while (true) {
			    System.out.print("Item: "); // Prompt for string
			    String itemName = scanner.nextLine();
			    if (itemName.equals("DONE")) break; // Case that breaks the loop

			    itemCount++;
			    System.out.print("Price: "); // Prompt for Double
			    double price = scanner.nextDouble();
			    scanner.nextLine();  // clear

			    double taxRate = (itemName.equals("food") || itemName.equals("Food") ) ? 0 : 0.3; // evaluates tax rate based on item name
			    double finalPrice = price + (price * taxRate);
			    finalPrice = Math.round(finalPrice);

			    itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1); // Capitalizes the first letter no matter what
			    System.out.printf("item number %d %s %.1f%n", itemCount, itemName, finalPrice);

			    totalSum += finalPrice; // keeps track of total
			}

			System.out.printf("%d items      total %.1f%n", itemCount, totalSum); // outputs total amounts
		}

        System.out.println("******************************");
        
    }
}
