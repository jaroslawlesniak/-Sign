package uSign;
	
import enums.Scenes;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			SceneManager manager = new SceneManager();
			
			manager.openScene(primaryStage, Scenes.HOMEPAGE);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
