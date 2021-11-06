package enums;

public enum Scenes {
	HOMEPAGE("/fxml/Homepage.fxml"),
	DOCUMENTS("/fxml/DocumentsList.fxml"),
	NEW_SIGN("/fxml/NewSign.fxml");
	
	public String path;
	
	private Scenes(String path) {
		this.path = path;
	}
}
