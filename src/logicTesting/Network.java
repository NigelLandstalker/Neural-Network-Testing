package logicTesting;

public class Network {

	public static Node[][] nodes;
	private int size;
	public static final int distance = 1;

	public Network(int size) {
		this.size = size;
		nodes = new Node[size][size];
		createNodes();
		createSynapses(distance);
	}

	private void createNodes() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				nodes[i][j] = new Node(i, j);
				System.out.println("Node " + i + ", " + j + " created");
			}
		}
	}

	private void createSynapses(int distance) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i + distance < size && j + distance < size) {
					nodes[i][j].addSynapse(i + distance, j + distance);
					System.out.println("Synapse between " + i + ", " + j + " and " + (i + distance)
							+ ", " + (j + distance) + " created");
				}
				if (i - distance >= 0 && j + distance < size) {
					nodes[i][j].addSynapse(i - distance, j + distance);
					System.out.println("Synapse between " + i + ", " + j + " and " + (i - distance)
							+ ", " + (j + distance) + " created");
				}
				if (i + distance < size && j - distance >= 0) {
					nodes[i][j].addSynapse(i + distance, j - distance);
					System.out.println("Synapse between " + i + ", " + j + " and " + (i + distance)
							+ ", " + (j - distance) + " created");
				}
				if (i - distance >= 0 && j - distance >= 0) {
					nodes[i][j].addSynapse(i - distance, j - distance);
					System.out.println("Synapse between " + i + ", " + j + " and " + (i - distance)
							+ ", " + (j - distance) + " created");
				}
			}
		}
	}

	public void tick(int iterations) {
		for (int k = 0; k < iterations; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					nodes[i][j].acceptInput();
				}
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					nodes[i][j].output();
				}
			}
			System.out.println("Tick " + (k + 1) + " complete!");
		}
	}
}
