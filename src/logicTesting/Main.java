package logicTesting;

public class Main {
	public static void main(String[] args) {
		Network network = new Network(4);
		IO.intInput(IO.getUserInput());
		network.tick(3);
	}
}
