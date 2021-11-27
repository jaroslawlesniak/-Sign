package blockchain;

public class BlockDto {
	public String author;
	
	public String comment;
	
	public BlockDto(String author) {
		this.author = author;
	}
	
	public BlockDto(String author, String comment) {
		this.author = author;
		this.comment = comment;
	}
	
	@Override
    public String toString() {
        return String.format(author + "; " + comment);
    }
}
