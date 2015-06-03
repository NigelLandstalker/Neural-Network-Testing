package logicTesting;

import java.util.Scanner;

public abstract class IO {
	public static int[] getUserInput() { // This is bad. Change this
		Scanner scanner = new Scanner(System.in);
		String userInputString = scanner.nextLine();
		int[] userInput = new int[userInputString.length()];
		for (int i = 0; i < userInputString.length(); i++) {
			userInput[i] = Integer.parseInt(userInputString.substring(i, i + 1));
		}
		scanner.close();
		return userInput;
	}

	public static void intInput(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			Network.nodes[0][i].nextStateBuffer = inputArray[i];
		}
	}

	public static int[] intOutput() {
		int[] outputBuffer = new int[Network.size];
		for (int i = 0; i < Network.size; i++) {
			outputBuffer[i] = Network.nodes[Network.size][i].nextStateBuffer;
		}
		return outputBuffer;
	}
}
