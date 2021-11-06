package controllers;

import enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import uSign.SceneManager;

public class NewSign {
	@FXML
	Label start;
	
	@FXML
	Button sign;
	
	public void backToHomepage() {
		SceneManager manager = new SceneManager();
		
		manager.openScene(start, Scenes.HOMEPAGE);
	}
	
	public void openFileDialog() {
		Stage stage = SceneManager.GetCurrentStage(sign);

		FileChooser fileChooser = new FileChooser();
		ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("Dokumenty PDF", "*.pdf");

		fileChooser.setTitle("Wybierz dokument do podpisania");
		fileChooser.getExtensionFilters().add(fileExtensions);

		fileChooser.showOpenDialog(stage);
	}
}
