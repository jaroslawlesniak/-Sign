module uSign {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens uSign to javafx.graphics, javafx.fxml;
}
