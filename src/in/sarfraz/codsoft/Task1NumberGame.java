package in.sarfraz.codsoft;

import java.util.Random;
import java.util.Scanner;

public class Task1NumberGame {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int minNumber = 1;
		int maxNumber = 100;
		int numberOfAttempts = 10;
		
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("You have " + numberOfAttempts + " attempts to guess it.");
		System.out.println("You can think a number between " + minNumber + " and " + maxNumber + ".");

		int score = 0;
		do {
			int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber; // 50
			int attempts = 0;
			while (attempts < numberOfAttempts) {
				System.out.println("Enter Your Guess number");
				int userGuess = sc.nextInt();
				attempts++;
				if (userGuess > targetNumber) {
					System.out.println("To high! Try Again");
				} else if (userGuess < targetNumber) {
					System.out.println("To low!Try Again");
				} else {
					System.out.println("Congratulations! You guessed the correct number (" + targetNumber + ") in "
							+ attempts + " attempts.");
					score++;
					break;
				}
			}

			if (attempts == numberOfAttempts) {
				System.out
						.println("sorry you did not guess correct number.the correct number was=" + targetNumber + ".");
			}
			System.out.println("do you want to play again?(yes/no):");
			String againPlay = sc.next();

			if (!againPlay.equals("yes")) {
				break;
			}

		} while (true);
		System.out.println("Game Over! Your score is: " + score + " rounds won.");
		sc.close();
	}

}
