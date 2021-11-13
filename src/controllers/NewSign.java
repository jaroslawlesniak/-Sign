package controllers;

import java.io.File;
import java.util.List;

import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.SimpleRenderer;

import enums.Scenes;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
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
	FlowPane preview;
	
	@FXML
	ImageView img;
	
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
//		    List<Image> images = renderer.render(document);
		    
//		    final ScrollPane scroll = new ScrollPane();
//
//	        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    // Horizontal scroll bar
//	        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    // Vertical scroll bar
//	        scroll.setContent(preview);
//	        scroll.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
//	            @Override
//	            public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
//	            	preview.setPrefWidth(bounds.getWidth());
//	                preview.setPrefHeight(bounds.getHeight());
//	            }
//	        });
//
//	        //flow.setPrefWrapLength(170); // preferred width allows for two columns
		    
		    info.setVisible(false);
		    preview.setVisible(true);
		    
	        Image image = new Image("https://p.calameoassets.com/190204115339-8f950dc015a8434c67b5064d0731a1d6/p1.jpg");
	        System.out.println("Is loaded: " + image.isError());
		    
	        img.setImage(image);
//	        preview.().bind(vBox.heightProperty());
	        
//		    img.setImage("");
		    
//		    for (Image image : images) {
//				javafx.scene.image.Image img = new javafx.scene.image.Image();
//		    	 
//		        // simple displays ImageView the image as is
//	    		ImageView iv1 = new ImageView();
//		        iv1.setImage(img);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
