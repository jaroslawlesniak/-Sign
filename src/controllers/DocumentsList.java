package controllers;

import java.util.ArrayList;

import blockchain.Block;
import blockchain.BlockchainService;
import enums.Scenes;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
			Label title = new Label();
			Label metaInformation = new Label("Dodano: " + block.timeStamp + " * od: " + block.data.author);
			ImageView status = new ImageView();
			Button resend = new Button("Przeœlij/Wyœlij");
			
			
			
			container.getChildren().add(title);
			container.getChildren().add(metaInformation);
			container.getChildren().add(status);
			container.getChildren().add(resend);
			
			signedDocuments.getChildren().add(container);
		}
	}
}
