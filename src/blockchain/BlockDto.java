package blockchain;

import java.io.Serializable;

public class BlockDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String fileName;
	
	public String comment;
	
	public String fileBase64;
	
	public BlockDto(String fileName, String fileBase64) {
		this.fileName = fileName;
		this.fileBase64 = fileBase64;
	}
	
	public BlockDto(String fileName, String fileBase64, String comment) {
		this.fileName = fileName;
		this.fileBase64 = fileBase64;
		this.comment = comment;
	}
	
	@Override
    public String toString() {
        return String.format(fileName + ";" + fileBase64 +  ";" + comment);
    }
}
