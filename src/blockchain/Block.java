package blockchain;

import java.util.Date;

public class Block {
	public String hash;
	
	public String previousHash;
	
	private BlockDto data;
	
	private long timestamp;
	
	public Block(BlockDto data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = new Date().getTime();
		this.hash = this.calculateHash();
	}
	
	public String calculateHash() {
		return BlockchainCryptography.sha256(previousHash + Long.toString(timestamp) + data.toString());
	}
}
