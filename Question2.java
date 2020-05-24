// Raja Hammad Mehmood 

// Author: Chris Fietkiewicz
// Starter code for HW #9, problem #2. See instructions.

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class Question2 {
	public static void printBoard(HashMap<Integer, LinkedList<GameNumber>> board, int SIZE) {
		int[][] grid = new int[SIZE][SIZE]; // Empty grid filled with zeros (automatically)
		for (Integer key : board.keySet()) { // "for each key in the map's key set"
			LinkedList<GameNumber> value = board.get(key);
			for (GameNumber x : value) {
				grid[x.getRow()][x.getColumn()] = x.getValue();
			}
		}

		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				if (grid[row][column] != 0) {
					System.out.print(grid[row][column] + " ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int N = 10; // Width and height of grid
		HashMap<Integer, LinkedList<GameNumber>> board = new HashMap<>(); // Map
		ArrayList<Integer> count = new ArrayList<>();
		// Initialize counts to zeros
		for (int i = 0; i < 10; i++)
			count.add(0);

		// Initialize board
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {
				GameNumber number = new GameNumber(row, column);
				count.set(number.getValue(), count.get(number.getValue()) + 1);
				if (board.get(number.getValue()) == null) {
					LinkedList<GameNumber> object = new LinkedList<GameNumber>();
					board.put(number.getValue(), object);
					object.add(number);
				} else {
					board.get(number.getValue()).add(number);
				}

			}
		}

		// Find number with maximum count
		int maxNumber = 0;
		for (int i = 1; i < 10; i++)
			if (count.get(i) > count.get(maxNumber))
				maxNumber = i;

		// FOR TESTING: Prints all of the counts and the answer. This would be removed
		// for regular users to play.
		count.forEach((n) -> System.out.print(n + " "));
		System.out.println();
		System.out.println("maxNumber = " + maxNumber);

		// User input loop
		int choice = 0;
		while (choice >= 0) {
			printBoard(board, N);
			System.out.print("\nEnter your guess for most frequent number (negative to quit): ");
			choice = TextIO.getlnInt();
			if (choice >= 0) {
				if (choice == maxNumber) { // User chose correctly
					System.out.println("Congratulations! You won!");
					return;
				} else { // User did not choose correctly
					System.out.println("Incorrect. I'm removing that number. Next player please.");
					board.remove(choice); // Remove entire LinkedList for user's incorrect choice
				}
			}
		}
		System.out.println("Goodbye.");
	}
}
