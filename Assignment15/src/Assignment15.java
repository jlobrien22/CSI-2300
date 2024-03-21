import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Assignment15 extends Application {

    private static final int SIZE = 5;
    private static final int WIN_COUNT = 5;
    private Button[][] buttons = new Button[SIZE][SIZE];
    private boolean playerXTurn = true;

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button button = new Button();
                button.setMinSize(80, 80);
                button.setOnAction(event -> {
                    if (!((Button) event.getSource()).getText().equals("")) {
                        return;
                    }
                    if (playerXTurn) {
                        ((Button) event.getSource()).setText("X");
                    } else {
                        ((Button) event.getSource()).setText("O");
                    }
                    if (checkForWin()) {
                        String winner = playerXTurn ? "Player X" : "Player O";
                        showAlert("Game Over", winner + " wins!");
                        primaryStage.close();
                    } else if (checkForDraw()) {
                        showAlert("Game Over", "It's a draw!");
                        primaryStage.close();
                    } else {
                        playerXTurn = !playerXTurn;
                    }
                });
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane, 450, 450);
        primaryStage.setTitle("Modified Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean checkForWin() {
        String symbol = playerXTurn ? "X" : "O";
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            int rowCount = 0;
            int colCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().equals(symbol)) {
                    rowCount++;
                } else {
                    rowCount = 0;
                }
                if (buttons[j][i].getText().equals(symbol)) {
                    colCount++;
                } else {
                    colCount = 0;
                }
                if (rowCount == WIN_COUNT || colCount == WIN_COUNT) {
                    return true;
                }
            }
        }
        // Check diagonals
        for (int i = 0; i <= SIZE - WIN_COUNT; i++) {
            for (int j = 0; j <= SIZE - WIN_COUNT; j++) {
                int diag1Count = 0;
                int diag2Count = 0;
                for (int k = 0; k < WIN_COUNT; k++) {
                    if (buttons[i + k][j + k].getText().equals(symbol)) {
                        diag1Count++;
                    } else {
                        diag1Count = 0;
                    }
                    if (buttons[i + k][j + WIN_COUNT - 1 - k].getText().equals(symbol)) {
                        diag2Count++;
                    } else {
                        diag2Count = 0;
                    }
                    if (diag1Count == WIN_COUNT || diag2Count == WIN_COUNT) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkForDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
