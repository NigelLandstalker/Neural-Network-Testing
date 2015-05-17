package logicTesting;

import java.io.Serializable;
import java.util.ArrayList;

public class Node implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Synapse> outputSynapses;
	public int currentState;
	public int nextStateBuffer;
	public int x;
	public int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		currentState = 0;
		nextStateBuffer = 0;
		outputSynapses = new ArrayList<Synapse>();
	}

	public void addSynapse(int recipientNodeX, int recipientNodeY) {
		outputSynapses.add(new Synapse(x, y, recipientNodeX, recipientNodeY));
	}

	public void outputSignal() {
		for (int i = 0; i < outputSynapses.size(); i++) {
			if (currentState >= outputSynapses.get(i).usageWeight && currentState != 0) {
				outputSynapses.get(i).sendSignal();
			}
		}
	}

	public void acceptInput() {
		currentState = nextStateBuffer;
		nextStateBuffer = 0;
		System.out.println("Node " + x + ", " + y + " is " + currentState);
	}

}
