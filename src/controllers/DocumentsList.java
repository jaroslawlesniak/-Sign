package controllers;

import java.io.File;
import java.util.ArrayList;

import blockchain.Block;
import blockchain.BlockchainService;
import enums.Scenes;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import uSign.SceneManager;

public class DocumentsList {
	@FXML
	Label start;
	
	@FXML
	VBox signedDocuments;
	
	@FXML
	protected void initialize() {
		ArrayList<Block> blocks = BlockchainService.blockchain;
		
		generateDocumentsList(blocks, signedDocuments);
	}
	
	public void backToHomepage() {
		SceneManager manager = new SceneManager();
		
		manager.openScene(start, Scenes.HOMEPAGE);
	}
	
	public void openPreview() {
		SceneManager manager = new SceneManager();
		
		manager.openScene(start, Scenes.DOCUMENT_PREVIEW);
	}
	
	private void generateDocumentsList(ArrayList<Block> blocks, VBox signedDocuments) {
		for (Block block : blocks) {
			AnchorPane container = new AnchorPane();

			Label title = new Label(block.hash);
			Label metaInformation = new Label("Dodano: " + block.timeStamp + " * od: " + block.data.author);
			ImageView status = new ImageView(getClass().getResource("/resources/padlock-green.png").toExternalForm());
			
			container.getStyleClass().add("document");
			title.getStyleClass().add("header");
			metaInformation.getStyleClass().add("info");
			
			VBox.setMargin(container, new Insets(25,0,0,0));
			
			AnchorPane.setRightAnchor(status, 0.0);
			AnchorPane.setTopAnchor(status, 20.0);
			
			AnchorPane.setTopAnchor(title, 0.0);
			AnchorPane.setLeftAnchor(title, 0.0);
			
			AnchorPane.setTopAnchor(metaInformation, 40.0);
			AnchorPane.setLeftAnchor(metaInformation, 0.0);
			
			container.getChildren().add(title);
			container.getChildren().add(metaInformation);
			container.getChildren().add(status);
			
			status.setFitWidth(20);
			status.setFitHeight(20);
			
			signedDocuments.getChildren().add(container);
		}
	}
}
