package controllers;

import java.io.File;
import java.util.List;

import blockchain.BlockchainService;
import enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import services.FileService;
import uSign.SceneManager;

public class DocumentPreview {
	@FXML
	Label start;
	
	@FXML
	VBox imagesPreview;
	
	@FXML
	protected void initialize() {	
		try {
			List<WritableImage> previewImages = FileService.getPreview(new File("C:\\Users\\Jarek\\Desktop\\signed\\" + BlockchainService.selectedBlock.timeStamp + "-" + BlockchainService.selectedBlock.data.fileName));

		    for (WritableImage generated : previewImages) {
	    		ImageView previewImage = new ImageView();
	    		previewImage.setImage(generated);
	    		previewImage.fitWidthProperty().bind(imagesPreview.widthProperty()); 
	    		previewImage.setPreserveRatio(true);
	    		
	    		imagesPreview.getChildren().add(previewImage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void backToHomepage() {
		SceneManager manager = new SceneManager();
		
		manager.openScene(start, Scenes.HOMEPAGE);
	}
}
