package blockchain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class BlockchainService {
	public static ArrayList<Block> blockchain = new ArrayList<Block>() {};
	
	public static Block selectedBlock;

	public static int difficultyLevel = 3;

	public static Block addToChain(BlockDto data) {
		Block block = new Block(data, blockchain.size() == 0 ? "" : blockchain.get(blockchain.size() - 1).hash, new Date().getTime());
		
		block.mineBlock(difficultyLevel);

		blockchain.add(block);
		
		saveToFile();
		
		return block;
	}
	
	public static void saveToFile() {
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("C:\\Users\\Jarek\\AppData\\Roaming\\uSign\\chain");
	        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	        objectOut.writeObject(blockchain);
	        objectOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void loadFromFile() {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Jarek\\AppData\\Roaming\\uSign\\chain");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            blockchain = (ArrayList<Block>) ois.readObject();
 
            ois.close();
            fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
