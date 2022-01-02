package controllers;

import enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uSign.SceneManager;

public class DocumentPreview {
	@FXML
	Label start;
	
	@FXML
	ImageView img;

	@FXML
	protected void initialize() {
        Image image = new Image("https://templates.invoicehome.com/invoice-template-us-neat-750px.png");
	    
        img.setImage(image);
	}
	
	public void backToHomepage() {
		SceneManager manager = new SceneManager();
		
		manager.openScene(start, Scenes.HOMEPAGE);
	}
}
