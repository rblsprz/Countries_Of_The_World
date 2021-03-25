package ProyectoPaíses;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;



public class Mantenimiento{
    TextField tf_nombrePais,tf_capital,tf_nombre,tf_language,tf_population, tf_borrarPais;
    TextArea ta_descripcion;
    ComboBox<String> cB_Continent;
    Label lb_confirmacion,lb_datosPais,lb_PaisABorrar;
    Button btn_borrarPais;
    String []datosArchivo;
    
    CreaYLeeArchivos cyla = new CreaYLeeArchivos();
    //Ingresa país
    public GridPane paisInsertar(){
        
        GridPane gP_InterfaceCountry = new GridPane();
        gP_InterfaceCountry.setHgap(10);
        gP_InterfaceCountry.setVgap(10);
        gP_InterfaceCountry.setPadding(new Insets (20));
        
        Button btn_Exit = new Button("");
        btn_Exit.setGraphic(new ImageView("Back.png")); //Asigna Imagen al Button
        btn_Exit.setFont(Font.font(12));
        gP_InterfaceCountry.add(btn_Exit,6,10);
        btn_Exit.setOnAction((e) -> {
        gP_InterfaceCountry.getChildren().clear();
        });//End btn_Exit
        
        Label lb_nombrePais = new Label("PAÍS");
        gP_InterfaceCountry.add(lb_nombrePais,0,0);
        lb_nombrePais.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_nombrePais.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        TextField tf_nombrePais = new TextField();
        tf_nombrePais.setMinWidth(200); //Reduce o aumenta el tamaño del TextField
        gP_InterfaceCountry.add(tf_nombrePais, 1, 0);
      
        Label lB_Continent = new Label("CONTINENTE");
        gP_InterfaceCountry.add(lB_Continent,0,1);
        lB_Continent.setFont(new Font("Cambria",20)); //Fuente de letra
        lB_Continent.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        ComboBox cB_Continent = new ComboBox(); //El ComboBox muestra la lista de Continentes
        cB_Continent.setValue("Seleccione el Continente");
        cB_Continent.getItems().addAll("África","América","Asia","Europa","Oceanía"); //Agrega los continentes al ComboBox
        gP_InterfaceCountry.add(cB_Continent,1,1);
        
        Label lb_capital = new Label("CAPITAL");
        gP_InterfaceCountry.add(lb_capital,0,2);
        lb_capital.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_capital.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        TextField tf_capital = new TextField();
        gP_InterfaceCountry.add(tf_capital, 1, 2);
      
        
        Label lb_language = new Label("IDIOMA");
        gP_InterfaceCountry.add(lb_language,0,3);
        lb_language.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_language.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        TextField tf_language = new TextField();
        gP_InterfaceCountry.add(tf_language, 1, 3);
      
        
        Label lB_Population = new Label("POBLACIÓN");
        gP_InterfaceCountry.add(lB_Population,0,4);
        lB_Population.setFont(new Font("Cambria",20)); //Fuente de letra
        lB_Population.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        TextField tf_population = new TextField();
        gP_InterfaceCountry.add(tf_population, 1, 4);
      
        Label lb_bandera = new Label("BANDERA");
        gP_InterfaceCountry.add(lb_bandera,0,5);
        lb_bandera.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_bandera.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        FileChooser fc_imagen = new FileChooser();
        fc_imagen.setTitle("Seleccionador de Imágenes");
        
        Button bTN_Image = new Button("");
        bTN_Image.setGraphic(new ImageView("Image.png")); //Asigna Imagen al Button
        bTN_Image.setOnAction((event)->{
        fc_imagen.showOpenDialog(null);
        });//End fc_imagen
        gP_InterfaceCountry.add(bTN_Image,1,5);
        
        Label lb_description = new Label("DESCRIPCIÓN");
        gP_InterfaceCountry.add(lb_description,0,6);
        lb_description.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_description.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        TextArea ta_descripcion = new TextArea(); //TextArea establece un cuadro grande dentro de la interfaz.
        gP_InterfaceCountry.add(ta_descripcion, 1, 7);
        
        
        
        //Tamaños de los textfields y ComboBox
        tf_nombrePais.setMaxSize(250,250);
        cB_Continent.setMaxSize(250,250);
        tf_capital.setMaxSize(250,250);
        tf_language.setMaxSize(250,250);
        tf_population.setMaxSize(250,250);
        ta_descripcion.setMaxSize(250, 250);    
        
        
        Button btn_insertar = new Button("");
        btn_insertar.setGraphic(new ImageView("Insert.png")); //Asigna Imagen al Button
        btn_insertar.setFont(Font.font(18));
        gP_InterfaceCountry.add(btn_insertar,1,10);
        
        //Inserta el país en la TableView
        btn_insertar.setOnAction(e -> {
           
            CreaYLeeArchivos cyla = new CreaYLeeArchivos();
            String pais [] = {tf_nombrePais.getText(),cB_Continent.getValue().toString(),tf_capital.getText(),tf_language.getText()
                                ,tf_population.getText(),ta_descripcion.getText()};
            boolean flag = true;
            
            
            for (int i = 0; i < pais.length && flag; i++) 
                if(pais[i].equalsIgnoreCase(""))
                    flag = false;
            
            if(flag){
                cyla.agregaPaisArchivo(pais[0],pais[1],pais[2],pais[3],pais[4],pais[5],true);
                 tf_nombrePais.setText("");
                 cB_Continent.getValue().toString();
                 tf_capital.setText("");
                 tf_language.setText("");
                 tf_population.setText("");
                 ta_descripcion.setText("");
                 
            }//End if 
            else{
                JOptionPane.showMessageDialog(null, "¡ERROR! ¡POR FAVOR COMPLETE LOS ESPACIOS!");
                for (int i = 0; i < pais.length; i++) 
                    pais[i]="";
            }//End else    
            
                
        });//End btn_Insertar
        
    return gP_InterfaceCountry;
    }//End paisInsertar
     
    //Borra país
    public GridPane borrarPaises(){
        
        GridPane gd_borrarPaises = new GridPane();
        gd_borrarPaises.setHgap(10);
        gd_borrarPaises.setVgap(10);
        
        Button btn_Exit = new Button("");
        btn_Exit.setGraphic(new ImageView("Back.png")); //Asigna Imagen al Button
        btn_Exit.setFont(Font.font(12));
        gd_borrarPaises.add(btn_Exit,6,10);
        btn_Exit.setOnAction((e) -> {
        gd_borrarPaises.getChildren().clear();
        });//End btn_Exit
        
        //Instancia componentes
        Label lb_titulo = new Label("BORRAR PAÍS");
        lb_titulo.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_titulo.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        Label lb_paisBorrar = new Label("INTRODUZCA EL NOMBRE DEL PAÍS");
        lb_paisBorrar.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_paisBorrar.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        tf_borrarPais = new TextField();
        tf_borrarPais.setPromptText("PAÍS");
        
        Button btn_verifica = new Button("");
        btn_verifica.setGraphic(new ImageView("Verify.png")); //Asigna Imagen al Button
        btn_verifica.setFont(Font.font(12));
        CreaYLeeArchivos cyla = new CreaYLeeArchivos();
        
        lb_datosPais = new Label();
        lb_datosPais.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_datosPais.setTextFill(Color.WHITE); //Colores Letras
        lb_PaisABorrar = new Label("NOMBRE \n"
                                      +"CONTINENTE \n"
                                      +"CAPITAL \n"
                                      +"POBLACIÓN \n"
                                      +"DESCRIPCIÓN \n"
                                      +"IDIOMA ");
        lb_PaisABorrar.setVisible(false);
        lb_PaisABorrar.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_PaisABorrar.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        
        //Pregunta si el país existe
        btn_verifica.setOnAction(e -> {
            if(cyla.existePais(tf_borrarPais.getText(), "paises.txt")){
                
                btn_borrarPais.setVisible(true);
                
                lb_PaisABorrar.setVisible(true);
                lb_PaisABorrar.setFont(new Font("Cambria",20)); //Fuente de letra
                lb_PaisABorrar.setTextFill(Color.YELLOWGREEN); //Colores Letras
                
                datosArchivo = cyla.getDatosEspecificos("paises.txt", tf_borrarPais.getText());
                lb_datosPais.setText(datosArchivo[0]+"\n"
                                      +datosArchivo[1]+"\n"
                                      +datosArchivo[2]+"\n"
                                      +datosArchivo[4]+"\n"
                                      +datosArchivo[5]+"\n"
                                      +datosArchivo[3]);
            }//End if
            else{
                lb_datosPais.setText("EL PAÍS NO EXISTE");
                lb_datosPais.setFont(new Font("Cambria",20)); //Fuente de letra
                lb_datosPais.setTextFill(Color.YELLOWGREEN); //Colores Letras
                
                lb_PaisABorrar.setVisible(false);
                lb_PaisABorrar.setFont(new Font("Cambria",20)); //Fuente de letra
                lb_PaisABorrar.setTextFill(Color.YELLOWGREEN); //Colores Letras
                
                btn_borrarPais.setVisible(false);
            }//End else
        }); //End btn_verifica
        
        gd_borrarPaises.add(lb_titulo, 1, 0);
        gd_borrarPaises.add(lb_paisBorrar, 0, 1);
        gd_borrarPaises.add(tf_borrarPais, 1, 1);
        gd_borrarPaises.add(btn_verifica, 1, 2);
        gd_borrarPaises.add(lb_PaisABorrar, 0, 3);
        gd_borrarPaises.add(lb_datosPais, 1, 3);
        gd_borrarPaises.add(getButtonBorrarPais(), 1, 4);
        
    return gd_borrarPaises;
    }//End borrarPaises
    
    //Retorna botón que borra países
    public Button getButtonBorrarPais(){
        btn_borrarPais = new Button("");
        btn_borrarPais.setGraphic(new ImageView("Delete.png")); //Asigna Imagen al Button
        btn_borrarPais.setFont(Font.font(12));
        btn_borrarPais.setVisible(false);
        
        btn_borrarPais.setOnAction(e -> {
            CreaYLeeArchivos cyla = new CreaYLeeArchivos();
            cyla.borrarPais("paises.txt", tf_borrarPais.getText());
            
            lb_datosPais.setText("EL PAÍS HA SIDO ELIMINADO CON ÉXITO");
            lb_datosPais.setFont(new Font("Cambria",20)); //Fuente de letra
            lb_datosPais.setTextFill(Color.YELLOWGREEN); //Colores Letras
                
            btn_borrarPais.setVisible(false);
            
            lb_PaisABorrar.setVisible(false);
            lb_PaisABorrar.setFont(new Font("Cambria",20)); //Fuente de letra
            lb_PaisABorrar.setTextFill(Color.YELLOWGREEN); //Colores Letras
            
            tf_borrarPais.setText("");
        });
    return  btn_borrarPais;
    }//Fin getButtonBorrarCliente
}//End Mantenimiento
