package logicTesting;

import java.io.Serializable;

public class Synapse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int usageWeight;
	public int[] location = new int[4];

	public Synapse(int x1, int y1, int x2, int y2) {
		location[0] = x1;
		location[1] = y1;
		location[2] = x2;
		location[3] = y2;

		usageWeight = 1;
	}

	public void sendSignal() {
		Network.nodes[location[2]][location[3]].nextStateBuffer++;
		if (usageWeight >= 2 && Network.rewardValue) {
			usageWeight--;
		} else if (!Network.rewardValue) {
			usageWeight++;
		}
	}
}
