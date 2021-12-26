package blockchain;

public class BlockDto {
	public String author;
	
	public String comment;
	
	public String fileBase64;
	
	public BlockDto(String author, String fileBase64) {
		this.author = author;
		this.fileBase64 = fileBase64;
	}
	
	public BlockDto(String author, String fileBase64, String comment) {
		this.author = author;
		this.fileBase64 = fileBase64;
		this.comment = comment;
	}
	
	@Override
    public String toString() {
        return String.format(author + "; " + fileBase64 +  ";" + comment);
    }
}
