package blockchain;

import java.io.Serializable;

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
		return BlockchainCryptography.sha256(previousHash + Long.toString(timeStamp) + data.toString() + nonce);
	}
	
	public void mineBlock(int prefix) {
	    String prefixString = new String(new char[prefix]).replace('\0', '0');

	    while (!hash.substring(0, prefix).equals(prefixString)) {
	        nonce++;
	        hash = calculateHash();
	    }
	}
}
