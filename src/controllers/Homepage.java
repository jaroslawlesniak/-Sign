package controllers;

import enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import uSign.SceneManager;

public class Homepage {
	@FXML
    public Pane signInPane;
	
	@FXML
    public Pane documentsPane;

	public void openDocumentsList() {
		SceneManager manager = new SceneManager();

		manager.openScene(documentsPane, Scenes.DOCUMENTS);
	}
	
	public void openSignInDocument() {
		SceneManager manager = new SceneManager();

		manager.openScene(documentsPane, Scenes.NEW_SIGN);
	}
}
