package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
//			GridPane root = new GridPane();
//			root.setAlignment(Pos.CENTER);
//			root.setVgap(10);
//			root.setHgap(10);
//			
//			Label greeting = new Label("Welcome to JavaFX");
//			greeting.setTextFill(Color.FIREBRICK);
//			greeting.setFont(Font.font(null, FontWeight.BOLD, 40));
//		//	greeting.setFont(Font.font("Times New Roman",FontWeight.BOLD, 40));
//			
//			root.getChildren().add(greeting);
//			
			Scene scene = new Scene(root,700,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Hello JavaFX!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
