package blockchain;

import java.util.ArrayList;

public class BlockchainService {
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public static void main(String[] args)
    {
		blockchain.add(new Block(new BlockDto("Jan Kowalski"), "0"));
		blockchain.add(new Block(new BlockDto("Jan Nowak"), blockchain.get(blockchain.size() - 1).hash));
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
