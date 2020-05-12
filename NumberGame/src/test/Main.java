

package test;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {

		int randomNumber = (int) (Math.random() * 100 +1);
		boolean hasWon = false;
		
		System.out.println("I have randomly generated a number between 1 & 100");
		System.out.println("Try to guess it.");
		//System.out.println(randomNumber);
		
		Scanner scanner = new Scanner(System.in);
		for (int i=10;i > 0; i--) {
			System.out.println("Your have " + i + " guesses left. Choose again");
			int guess = scanner.nextInt();
			
			if (randomNumber < guess) {
				System.out.println("It's smaller than " + guess + ".");
			}
			else if (randomNumber > guess) {
				System.out.println("It's larger than " + guess + ".");
			} else {
				hasWon = true;
				break;
			}
		}
			//System.out.println("Your guess was: " + guess);
			if (hasWon) {
				System.out.println("Yes you won!");
			} else {
				System.out.println("Game Over!");
				System.out.println("The number was " + randomNumber);
			}
		}
	
}
