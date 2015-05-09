package logicTesting;

public class Main {
	public static void main(String[] args) {
		Network network = new Network(2);
		Network.nodes[0][0].nextStateBuffer = 1;
		network.tick(3);
	}
}
