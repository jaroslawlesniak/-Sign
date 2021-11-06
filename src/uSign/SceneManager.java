package uSign;

import enums.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	public<T extends Node> void openScene(T node, Scenes scene) {
		Stage stage = (Stage) node.getScene().getWindow();
		
		this.setScene(stage, scene);
	}
	
	public void openScene(Stage stage, Scenes scene) {	
		this.setScene(stage, scene);
	}
	
	private void setScene(Stage stage, Scenes sceneUrl) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(sceneUrl.path));
			Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());

			scene.getStylesheets().add(getClass().getResource("/uSign/application.css").toExternalForm());

			stage.setScene(scene);
			stage.setMaximized(true);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
