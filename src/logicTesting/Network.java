package logicTesting;

import java.io.Serializable;

public class Network implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Node[][] nodes;
	public static int size;
	private int synapseCount;
	public static boolean rewardValue;
	public static final int distance = 1;

	public Network(int size) {
		this.size = size;
		rewardValue = false;
		nodes = new Node[size][size];
		createNodes();
		createSynapses(distance);
	}

	private void createNodes() {
		synapseCount = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				nodes[i][j] = new Node(i, j);
				System.out.println("Node " + i + ", " + j + " created");
			}
		}
	}

	private void createSynapses(int distance) { // replace this method with something more efficient
												// later, probably a Synapse generation class
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i + distance < size) {
					nodes[i][j].addSynapse(i + distance, j);
					synapseCount++;
					System.out.println("Synapse between " + i + ", " + j + " and " + (i + distance)
							+ ", " + j + " created");
					if (j + distance < size) {
						nodes[i][j].addSynapse(i + distance, j + distance);
						synapseCount++;
						System.out.println("Synapse between " + i + ", " + j + " and "
								+ (i + distance) + ", " + (j + distance) + " created");
					}
					if (j - distance >= 0) {
						nodes[i][j].addSynapse(i + distance, j - distance);
						synapseCount++;
						System.out.println("Synapse between " + i + ", " + j + " and "
								+ (i + distance) + ", " + (j - distance) + " created");
					}
				}
				if (i - distance >= 0) {
					nodes[i][j].addSynapse(i - distance, j);
					synapseCount++;
					System.out.println("Synapse between " + i + ", " + j + " and " + (i - distance)
							+ ", " + j + " created");
					if (j + distance < size) {
						nodes[i][j].addSynapse(i - distance, j + distance);
						synapseCount++;
						System.out.println("Synapse between " + i + ", " + j + " and "
								+ (i - distance) + ", " + (j + distance) + " created");
					}
					if (j - distance >= 0) {
						nodes[i][j].addSynapse(i - distance, j - distance);
						synapseCount++;
						System.out.println("Synapse between " + i + ", " + j + " and "
								+ (i - distance) + ", " + (j - distance) + " created");
					}
				}
				if (j + distance < size) {
					nodes[i][j].addSynapse(i, j + distance);
					synapseCount++;
					System.out.println("Synapse between " + i + ", " + j + " and " + i + ", "
							+ (j + distance) + " created");
				}
				if (j - distance >= 0) {
					nodes[i][j].addSynapse(i, j - distance);
					synapseCount++;
					System.out.println("Synapse between " + i + ", " + j + " and " + i + ", "
							+ (j - distance) + " created");
				}
			}
		}
		System.out.println("Synapse count: " + synapseCount);
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
					nodes[i][j].outputSignal();
				}
			}
			System.out.println("Tick " + (k + 1) + " complete!");
		}
	}
}
