package uSign;

import enums.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	public <T extends Node> void openScene(T node, Scenes scene) {
		Stage stage = (Stage) node.getScene().getWindow();
		
		this.setScene(stage, scene);
	}
	
	public void openScene(Stage stage, Scenes scene) {	
		this.setScene(stage, scene);
	}
	
	public <T extends Node, Q> void openScene(T node, Scenes scene, Q data) {
		Stage stage = (Stage) node.getScene().getWindow();
		
		this.setScene(stage, scene);
	}
	
	public <T> void openScene(Stage stage, Scenes scene, T data) {
		this.setScene(stage, scene);
	}
	
	public static <T extends Node> Stage GetCurrentStage(T node) {
		return (Stage) node.getScene().getWindow();
	}
	
	public double getWindowWidth(Stage stage) {
		return stage.getScene().getWindow().getWidth();
	}
	
	public double getWindowHeight(Stage stage) {
		return stage.getScene().getWindow().getHeight();
	}

	private void setScene(Stage stage, Scenes sceneUrl) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(sceneUrl.path));
			Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());

			scene.getStylesheets().add(getClass().getResource("/uSign/application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
