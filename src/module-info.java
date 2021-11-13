module uSign {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires ghost4j;
	
	opens uSign to javafx.graphics, javafx.fxml;
	opens controllers to javafx.fxml;
}
