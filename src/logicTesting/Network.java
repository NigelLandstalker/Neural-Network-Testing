package logicTesting;

public class Network {
	
	public static Node[][] nodes;
	public static final int distance = 1;
	
	public Network(int size){
		nodes = new Node[size][size];
		createNodes(size);
		createSynapses(size, distance);
	}
	
	private static void createNodes(int size){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				nodes[i][j] = new Node(i, j);
			}
		}
	}
	private static void createSynapses(int size, int distance){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(i + distance < size && j + distance < size){
					nodes[i][j].addSynapse(i + distance, j + distance);
				}
				if(i - distance > 0 && j + distance < size){
					nodes[i][j].addSynapse(i - distance, j + distance);
				}
				if(i + distance < size && j - distance > 0){
					nodes[i][j].addSynapse(i + distance, j - distance);
				}
				if(i - distance > 0 && j - distance > 0){
					nodes[i][j].addSynapse(i - distance, j - distance);
				}
			}
		}
	}
	public static void tick(){
		
	}
}
