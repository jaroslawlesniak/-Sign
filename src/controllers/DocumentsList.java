package controllers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import services.DateService;
import uSign.SceneManager;

public class DocumentsList {
	@FXML
	Label start;
	
	@FXML
	VBox signedDocuments;
	
	SceneManager manager = new SceneManager();
	
	@FXML
	protected void initialize() {
		ArrayList<Block> blocks = BlockchainService.blockchain;
		
		generateDocumentsList(blocks, signedDocuments);
	}
	
	public void backToHomepage() {
		manager.openScene(start, Scenes.HOMEPAGE);
	}
	
	public void openPreview() {
		manager.openScene(start, Scenes.DOCUMENT_PREVIEW);
	}
	
	private void generateDocumentsList(ArrayList<Block> blocks, VBox signedDocuments) {
		for (Block block : blocks) {
			AnchorPane container = new AnchorPane();

			Label title = new Label(block.data.fileName);
			Label metaInformation = new Label("Dodano: " + DateService.toDate(block.timeStamp));
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

			container.setOnMouseClicked(event -> {
				BlockchainService.selectedBlock = block;
				manager.openScene(start, Scenes.DOCUMENT_PREVIEW);
			});

			signedDocuments.getChildren().add(container);
		}
	}
}
