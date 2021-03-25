package ProyectoPaíses;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainInterface extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {   
        
        InterfazMenu im = new InterfazMenu();
        primaryStage.setTitle("DICCIONARIO DE LOS PAÍSES DEL MUNDO");
        primaryStage.setScene(im.menuInterfaz());
        primaryStage.show();
        primaryStage.setResizable(false);

    }

   
    public static void main(String[] args) {
        launch(args);
    }
}
