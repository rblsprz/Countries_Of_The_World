
package ProyectoPaíses;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class InsertarTablas {
    
      CreaYLeeArchivos cyla;
      Country c;
    
    //Retorna un Vbox con la tabla países  
    public VBox mostarTablaPaises(){
        
      
        
        
        Label lB_Report = new Label("INFORMACIÓN DE LOS PAÍSES");
        lB_Report.setFont(new Font("Cambria",20)); //Fuente de letra
        lB_Report.setTextFill(Color.YELLOWGREEN); //Colores Letras
       
        TableView <Country> tabla = new TableView<>();
        tabla.setPrefWidth(450);
        tabla.setPrefHeight(300);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //Quitar Columnas Sobrantes
        tabla.setStyle("-fx-font-size:130%"); //Cambio de Letra
        
        
        cyla = new CreaYLeeArchivos();
      

        //Crear columna país
        TableColumn tC_NameCountry = new TableColumn("PAÍS");
        tC_NameCountry.setCellValueFactory(new PropertyValueFactory<>("nameCountry"));
        
        //Crear columna continente
        TableColumn tC_Continent = new TableColumn("CONTINENTE");
        tC_Continent.setCellValueFactory(new PropertyValueFactory<>("continent"));
        
        //Crear columna capital
        TableColumn tC_Capital = new TableColumn("CAPITAL");
        tC_Capital.setCellValueFactory(new PropertyValueFactory<>("capital"));
        
        //Crear columna idioma
        TableColumn tC_Language = new TableColumn("IDIOMA");
        tC_Language.setCellValueFactory(new PropertyValueFactory<>("language"));
        
        //Crear columna población
        TableColumn tC_Population = new TableColumn("POBLACIÓN");
        tC_Population.setCellValueFactory(new PropertyValueFactory<>("population"));
        
        //Crear columna descripción
        TableColumn tC_Description = new TableColumn("DESCRIPCIÓN");
        tC_Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        
         tabla.getColumns().addAll(tC_NameCountry, tC_Continent, tC_Capital, tC_Language, tC_Population, tC_Description);
         
        
        ObservableList<Country> datos = getListaPaises(); //Mostrar los datos de las filas
        tabla.setItems(datos);
        
           
        
        
        VBox vbox = new VBox();
        
        GridPane gp_Main = new GridPane();
        gp_Main.setHgap(10);
        gp_Main.setVgap(10);
        
        Button btn_Exit = new Button("");
        btn_Exit.setGraphic(new ImageView("Back.png")); //Asigna Imagen al Button
        gp_Main.add(btn_Exit, 5, 3);
        btn_Exit.setOnAction((e) -> {
        vbox.getChildren().clear();
        });//End btn_Exit
        
        vbox.getChildren().addAll(lB_Report,tabla,btn_Exit);
        
    return vbox;
    }//End mostrarTablaPaises
    
    //Retorna un ObservableList de países
    public ObservableList<Country> getListaPaises(){
        
        
        ArrayList array = new ArrayList();
        
        Country temp[] = cyla.leePaisesArchivo();
        
        for(Country c: temp){
            array.add(c);
        }//End for
        ObservableList<Country> listadoPaises = FXCollections.observableArrayList(array);
        
    return listadoPaises;
    }//End getListaPaises
    
   
     public VBox PaisesporContinente() {

        VBox vb_paisesporContinente = new VBox();
        
        Label lB_Message = new Label("PAÍSES POR CONTINENTE");
        lB_Message.setFont(new Font("Cambria",20)); //Fuente de letra
        lB_Message.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        GridPane gp_Main = new GridPane();
        gp_Main.setHgap(10);
        gp_Main.setVgap(10);
        
        ComboBox cB_ContinentperCountry = new ComboBox();
        
        cB_ContinentperCountry.setValue("SELECCIONE UN CONTINENTE");
        cB_ContinentperCountry.getItems().addAll("África","América","Asia","Europa","Oceanía");
        gp_Main.add(cB_ContinentperCountry, 1, 3);
        
        Button btn_Search =new Button("");
        btn_Search.setGraphic(new ImageView("Search.png")); //Asigna Imagen al Button
        gp_Main.add(btn_Search, 3, 3);           
        
        
        Button btn_Exit = new Button("");
        btn_Exit.setGraphic(new ImageView("Back.png")); //Asigna Imagen al Button
        gp_Main.add(btn_Exit, 5, 3);
        
        Label lbl_report = new Label();
        EventHandler<ActionEvent> event = 
                  new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
               lbl_report.setText(cB_ContinentperCountry.getValue() +""); 
            } 
        }; 
         lbl_report.setFont(new Font("Cambria",20)); //Fuente de letra
         lbl_report.setTextFill(Color.YELLOWGREEN); //Colores Letras
         cB_ContinentperCountry.setOnAction(event); 
        
        btn_Exit.setOnAction((e) -> {
        vb_paisesporContinente.getChildren().clear();
        });
           
        TextArea txf_mostrar= new TextArea();
        txf_mostrar.setEditable(false);
        
        btn_Search.setOnAction((e) -> {
            Country c [] = cyla.leePaisesArchivo();  //MARCA UN ERROR
            String output = "";
        
        for (int i = 0; i < c.length; i++) {
           for (int j = 0; j < c.length; j++) {
                if(c[i].getContinent().equalsIgnoreCase(lbl_report.getText())){
                    output += c[i].getNameCountry()+ "\n";
                }//End If   
           break; 
           }//End for
        }//End For
        
        txf_mostrar.setText(output);  
        });//End bt
               
        vb_paisesporContinente.getChildren().addAll(lB_Message,gp_Main,lbl_report,txf_mostrar);     
        
        return vb_paisesporContinente;
    }//End PaisesporContinente
}//End InsertarTablas
