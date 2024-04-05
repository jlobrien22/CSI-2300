import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatApp extends Application {

    private TextArea chatArea;
    private TextField inputField;
    private String username; // User's username

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox chatContainer = new VBox();
        chatArea = new TextArea();
        chatArea.setEditable(false);
        inputField = new TextField();
        Button sendButton = new Button("Send");

        sendButton.setOnAction(e -> sendMessage());

        // Dialog for entering username
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Username");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter your username:");

        // Get username from dialog input
        dialog.showAndWait().ifPresent(name -> {
            username = name.trim();
            primaryStage.setTitle("JavaFX Chat App - " + username);
        });

        chatContainer.getChildren().addAll(chatArea, inputField, sendButton);
        chatContainer.setSpacing(10);
        chatContainer.setPadding(new Insets(10));

        root.setCenter(chatContainer);

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            appendMessage(username + " (" + getCurrentTime() + "): " + message);
            inputField.clear();
        }
    }

    private void appendMessage(String message) {
        Platform.runLater(() -> chatArea.appendText(message + "\n"));
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
