package logicTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	public static Network network = new Network(3); // have this load from a file. If the file
													// doesn't exist
	// then have the main method create it.
	public File outputStream;

	public static void main(String[] args) {
		Main main = new Main();
		IO.intInput(IO.getUserInput());
		network.tick(3);
		try {
			main.saveNetwork("MyNetwork");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveNetwork(String networkName) throws IOException {
		outputStream = new File("src/" + networkName + ".ser");
		outputStream.createNewFile();
		FileOutputStream fout = new FileOutputStream(outputStream.getAbsolutePath());
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(network);
		oos.writeObject(network.nodes);
		fout.close();

	}

	public void loadNetwork(String networkName) throws IOException {
		FileInputStream fin = new FileInputStream(outputStream.getAbsolutePath());
		ObjectInputStream ois = new ObjectInputStream(fin);
		try {
			network = (Network) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
