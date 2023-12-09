package com.codsofttask1.main;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int lowerRange = 1;
		int higherRange = 100;
		
		int numberOfAttempts = 10;
		int score = 0;
		
		System.out.println("Welcome to the Number Game!");
		
		do {
			int targetNumber = random.nextInt(higherRange - lowerRange + 1) + lowerRange;
			int attempts = 0;
			boolean guessCorrectly = false;
			
			System.out.println("\nI have selected a number between "+ lowerRange + " and " + higherRange + ". Can u guess it?");
			
			while(attempts < numberOfAttempts) {
				System.out.print("Enter your guess : ");
				int userGuess = sc.nextInt();
				attempts++;
				
				if(userGuess == targetNumber) {
					System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
					guessCorrectly = true;
					score += numberOfAttempts - attempts + 1;
					break;
				}
				else if(userGuess < targetNumber) {
					System.out.println("Too low! Try again.");
				}
				else {
					System.out.println("Too high! Try again.");
				}
			}
			
			if(!guessCorrectly) {
				System.out.println("Sorry, you have run out of attempts. The correct number was: " + targetNumber);
			}
			
			System.out.print("Do you want to play again? (yes/no): ");
			String playAgain = sc.next().toLowerCase();
			
			if(!playAgain.equals("yes")) {
				break;
			}
		}
		
		while(true);
		
		System.out.println("Thanks for playing! Your total score is: " + score);
		sc.close();
	}
}