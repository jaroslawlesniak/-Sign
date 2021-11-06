package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uSign.SceneManager;

public class Homepage {
	@FXML
    public Pane signInPane;
	
	@FXML
    public Pane documentsPane;

	public void openDocumentsList() {
		SceneManager manager = new SceneManager();

		manager.openScene(documentsPane, "/fxml/DocumentsList.fxml");
	}
	
	public void openSignInDocument() {
		SceneManager manager = new SceneManager();

		manager.openScene(documentsPane, "/fxml/NewSign.fxml");
	}
}
