package counter;

import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * Create a JavaFX user interface with 1 input view and 2 observers that show
 * the counter value, so that all the views refer to the same Counter object.
 * 
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Create the Counter object (the "model" part of our app)
		Counter counter = new Counter();

		try {
			URL url = getClass().getResource("ClickUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: ClickUI.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			ClickController controller = loader.getController();

			// Dependency Injection:
			// Set the Counter object we want the view to update.
			controller.setCounter(counter);
			// Build and show the scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Click Counter");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		// Add an observer that displays the Counter value on console.
		// Dependency Injection:
		// We set a reference to the counter using the constructor.
		ConsoleView consoleView = new ConsoleView(counter);
		counter.addObserver(consoleView);
		
		CounterView counterView = new CounterView(counter);
		counter.addObserver(counterView);
		counterView.run();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
