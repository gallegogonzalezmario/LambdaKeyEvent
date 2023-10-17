package es.ieslosmontecillos.lambdakeyevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LambdaKey extends Application {

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 200, 50);
        Text text = new Text(20, 20, "A");

        text.setOnKeyPressed(event -> {
            // Recoge el valor de la tecla
            KeyCode key = event.getCode();
            double deltaX = 0;
            double deltaY = 0;

            // Dependiendo de la tecla que se pulse, se tomará una acción
            // Teclas de dirección -> Mueve 10 posiciones hacia la dirección indicada
            if (key == KeyCode.DOWN) {
                deltaY = 10;
            } else if (key == KeyCode.UP) {
                deltaY = -10;
            } else if (key == KeyCode.RIGHT) {
                deltaX = 10;
            } else if (key == KeyCode.LEFT) {
                deltaX = -10;
            } else if (key.isLetterKey() || key.isDigitKey()) { // Tecla de valor numérico o alfabético
                text.setText(text.getText() + event.getText());
            }

            // Cambia la posición del texto
            text.setLayoutX(text.getLayoutX() + deltaX);
            text.setLayoutY(text.getLayoutY() + deltaY);
        });

        text.setFocusTraversable(true); // Habilita la utilidad de los eventos del teclado

        root.getChildren().add(text);
        stage.setTitle("KeyEvent Lambda Event");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}