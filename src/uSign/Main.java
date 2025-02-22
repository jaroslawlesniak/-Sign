package uSign;
	
import blockchain.BlockchainService;
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
			
			stage.setMaximized(true);
			stage.setTitle("�Sign | Podpisywanie dokument�w");
			
			BlockchainService.loadFromFile();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
