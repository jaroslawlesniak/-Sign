package controllers;

import java.io.File;
import java.util.List;

import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.SimpleRenderer;

import enums.Scenes;
import helpers.ImageConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import uSign.SceneManager;

public class NewSign {
	@FXML
	Label start;
	
	@FXML
	Button sign;
	
	@FXML
	Pane info;
	
	@FXML
	ScrollPane preview;
	
	@FXML
	VBox previewElements;
	
	@FXML
	VBox imagesPreview;
	
	@FXML
	GridPane success;
	
	public void backToHomepage() {
		SceneManager manager = new SceneManager();
		
		manager.openScene(start, Scenes.HOMEPAGE);
	}
	
	public void openFileDialog() {
		try {
			Stage stage = SceneManager.GetCurrentStage(sign);

			FileChooser fileChooser = new FileChooser();
			ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("Dokumenty PDF", "*.pdf");

			fileChooser.setTitle("Wybierz dokument do podpisania");
			fileChooser.getExtensionFilters().add(fileExtensions);

			fileChooser.showOpenDialog(stage);
	
			PDFDocument document = new PDFDocument();
		    document.load(new File("C:/Users/Jarek/Downloads/dummy.pdf"));
		    SimpleRenderer renderer = new SimpleRenderer();
		    renderer.setResolution(300);

		    List<java.awt.Image> images = renderer.render(document);
		    
		    info.setVisible(false);
		           
	        previewElements.setSpacing(25);
	        imagesPreview.setSpacing(25);
	        
		    preview.setVisible(true);
		    
		    for (java.awt.Image generated : images) {
				var writable = ImageConverter.convertFromAwtToWritableImage(generated);
		    	 
	    		ImageView previewImage = new ImageView();
	    		previewImage.setImage(writable);
	    		previewImage.fitWidthProperty();
	    		
	    		imagesPreview.getChildren().add(previewImage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void signDocument() {
		success.setVisible(true);
		preview.setVisible(false);
	}
}
