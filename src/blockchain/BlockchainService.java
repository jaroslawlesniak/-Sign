package blockchain;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class BlockchainService {
	public static ArrayList<Block> blockchain = new ArrayList<Block>() {};

	public static int difficultyLevel = 5;

	public static void addToChain(BlockDto data) {
		Block block = new Block(new BlockDto("Jan Nowak", ""), blockchain.size() == 0 ? "" : blockchain.get(blockchain.size() - 1).hash, new Date().getTime());
		
		block.mineBlock(difficultyLevel);

		blockchain.add(block);
		
		saveToFile();
	}
	
	public static Boolean isChainValid()
	{
	    Block currentBlock;
	    Block previousBlock;
	 
	    for (int i = 1; i < blockchain.size(); i++) {
	        currentBlock = blockchain.get(i);
	        previousBlock = blockchain.get(i - 1);
	 
	        if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
	            return false;
	        }
	 
	        if (!previousBlock.hash.equals(currentBlock.previousHash)) {
	            return false;
	        }
	    }

	    return true;
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
			FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Jarek\\\\AppData\\\\Roaming\\\\uSign\\\\chain");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            blockchain = (ArrayList<Block>) ois.readObject();
 
            ois.close();
            fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
