package blockchain;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import helpers.FileConverter;

public class Block implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String hash;
	
	public String previousHash;
	
	public BlockDto data;
	
	public long timeStamp;
	
	public int nonce = 0;
	
	public Block(BlockDto data, String previousHash, long timeStamp) {
		this.hash = "9999999999";
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = timeStamp;
	}

	public String calculateHash() {
		return BlockchainCryptography.sha256(previousHash + Long.toString(timeStamp) + data.fileBase64 + data.toString() + nonce);
	}
	
	public String calculateHash(String fileBase64) {
		return BlockchainCryptography.sha256(previousHash + Long.toString(timeStamp) + fileBase64 + data.toString() + nonce);
	}
	
	public void mineBlock(int prefix) {
	    String prefixString = new String(new char[prefix]).replace('\0', '0');

	    while (!hash.substring(0, prefix).equals(prefixString)) {
	        nonce++;
	        hash = calculateHash();
	    }
	}
	
	public String getFileName() {
		return timeStamp + "-" + data.fileName;
	}
	
	public boolean isValid() throws IOException {
		Block currentBlock;
	    Block previousBlock;

	    ArrayList<Block> blockchain = getValidatableBlocks();

	    for (int i = 1; i < blockchain.size(); i++) {
	        currentBlock = blockchain.get(i);
	        previousBlock = blockchain.get(i - 1);

	        if (!currentBlock.hash.equals(currentBlock.calculateHash(FileConverter.toBase64(new File("C:\\Users\\Jarek\\Desktop\\signed\\" + currentBlock.getFileName()))))) {
	            return false;
	        }
	 
	        if (!previousBlock.hash.equals(currentBlock.previousHash)) {
	            return false;
	        }
	    }

	    return true;
	}
	
	private ArrayList<Block> getValidatableBlocks() {
		ArrayList<Block> blocks = new ArrayList<>();
		
		for (Block block : BlockchainService.blockchain) {
			blocks.add(block);
			
			if (this.hash.equals(block.hash)) {
				return blocks;
			}
		}
		
		return blocks;
	}
}
