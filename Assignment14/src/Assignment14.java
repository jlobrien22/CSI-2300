import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Assignment14 extends Application {

    private TextField inputField;
    private Label outputLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label inputLabel = new Label("Enter your query:");
        GridPane.setConstraints(inputLabel, 0, 0);

        inputField = new TextField();
        GridPane.setConstraints(inputField, 1, 0);

        Button convertButton = new Button("Convert");
        GridPane.setConstraints(convertButton, 2, 0);

        outputLabel = new Label();
        GridPane.setConstraints(outputLabel, 0, 1, 3, 1);

        grid.getChildren().addAll(inputLabel, inputField, convertButton, outputLabel);

        convertButton.setOnAction(e -> convert());

        Scene scene = new Scene(grid, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convert() {
        String userInput = inputField.getText();

        if (userInput.equalsIgnoreCase("exit") || userInput.equals("-1")) {
            System.exit(0); // Exiting the application
        }

        try {
            String[] parts = userInput.split(" ");
            double value = Double.parseDouble(parts[0]);
            String fromUnit = parts[1];
            String toUnit = parts[3];

            double result = 0;

            if (fromUnit.equalsIgnoreCase("kg") && toUnit.equalsIgnoreCase("lb")) {
                result = kgToLb(value);
            } else if (fromUnit.equalsIgnoreCase("g") && toUnit.equalsIgnoreCase("oz")) {
                result = gToOz(value);
            } else if (fromUnit.equalsIgnoreCase("km") && toUnit.equalsIgnoreCase("mile")) {
                result = kmToMile(value);
            } else if (fromUnit.equalsIgnoreCase("mm") && toUnit.equalsIgnoreCase("inch")) {
                result = mmToInch(value);
            } else {
                outputLabel.setText("Conversion not supported. Please check supported units.");
                return;
            }

            outputLabel.setText(value + " " + fromUnit + " = " + result + " " + toUnit);
        } catch (Exception e) {
            outputLabel.setText("Invalid input format. Please try again.");
        }
    }

    // Conversion methods
    private double kgToLb(double kg) {
        return kg * 2.20462;
    }

    private double gToOz(double g) {
        return g * 0.035274;
    }

    private double kmToMile(double km) {
        return km * 0.621371;
    }

    private double mmToInch(double mm) {
        return mm * 0.0393701;
    }
}
