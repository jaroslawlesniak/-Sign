package controllers;

import enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import uSign.SceneManager;

public class DocumentsList {
	@FXML
	Label start;
	
	public void backToHomepage() {
		SceneManager manager = new SceneManager();
		
		manager.openScene(start, Scenes.HOMEPAGE);
	}
}
