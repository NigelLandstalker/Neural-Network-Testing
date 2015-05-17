package logicTesting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
	public static Network network = new Network(100); // eventually this will load from a file

	public static void main(String[] args) {
		Main main = new Main();
		// IO.intInput(IO.getUserInput());
		network.tick(3);
		try {
			main.saveNetwork("MyNetwork");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveNetwork(String networkName) throws IOException {
		File outputStream = new File("src/" + networkName + ".ser");
		outputStream.createNewFile();
		FileOutputStream fout = new FileOutputStream(outputStream.getAbsolutePath());
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(network);
		oos.writeObject(network.nodes);
		fout.close();

	}
}
