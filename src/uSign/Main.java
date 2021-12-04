package uSign;
	
import enums.Scenes;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Rectangle2D bounds = Screen.getPrimary().getBounds();
			SceneManager manager = new SceneManager();
				
			manager.openScene(stage, Scenes.HOMEPAGE);

			stage.setWidth(bounds.getWidth());
			stage.setHeight(bounds.getHeight());
			
//			stage.setWidth(1500);
//			stage.setHeight(900);
			
			stage.setMaximized(true);
			stage.setTitle("µSign | Podpisywanie dokumentów");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
