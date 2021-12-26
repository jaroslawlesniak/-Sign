package blockchain;

import java.util.ArrayList;
import java.util.Date;

public class BlockchainService {
	public static ArrayList<Block> blockchain = new ArrayList<Block>() {};

	public static int difficultyLevel = 5;

	public static void addToChain(BlockDto data) {
		Block block = new Block(new BlockDto("Jan Nowak", ""), blockchain.size() == 0 ? "" : blockchain.get(blockchain.size() - 1).hash, new Date().getTime());
		
		block.mineBlock(difficultyLevel);

		blockchain.add(block);
	}
	
	public static Boolean isChainValid()
	{
	    Block currentBlock;
	    Block previousBlock;
	 
	    for (int i = 1; i < blockchain.size(); i++) {
	        currentBlock = blockchain.get(i);
	        previousBlock = blockchain.get(i - 1);
	 
	        if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
	            System.out.println("Hashes are not equal");
	            return false;
	        }
	 
	        if (!previousBlock.hash.equals(currentBlock.previousHash)) {
	            System.out.println("Previous Hashes are not equal");
	            return false;
	        }
	    }

	    return true;
	}
}
