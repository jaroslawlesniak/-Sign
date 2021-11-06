package uSign;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	public<T extends Node> void openScene(T node, String sceneUrl) {
		Stage stage = (Stage) node.getScene().getWindow();
		
		this.setScene(stage, sceneUrl);
	}
	
	public void openScene(Stage stage, String sceneUrl) {	
		this.setScene(stage, sceneUrl);
	}
	
	private void setScene(Stage stage, String sceneUrl) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(sceneUrl));
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
