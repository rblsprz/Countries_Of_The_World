
package ProyectoPaíses;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class ActualizarPaises {
    
     //Instancia de la Clase Global
    CreaYLeeArchivos cyla = new CreaYLeeArchivos();
    
    
    TextField tf_paisActualizar,tf_capitalActualizar,tf_idiomaActualizar,tf_poblacionActualizar,tf_descripcionActualizar;
    Label lb_mensajes,lb_pais, lb_mostrarpais,lb_continente,lb_capital,lb_idioma,lb_poblacion,lb_,lb_descripcion;
    Button btn_actualizarPais;
    String []datosArchivo;
     ComboBox cB_continent;
    //Retorna interfaz del menu actualizar
    public GridPane actualizarPais(){
        //Crea Gridpane
        GridPane gd_actualizaPaises = new GridPane();
        gd_actualizaPaises.setHgap(10);
        gd_actualizaPaises.setVgap(10);
        
        Button btn_Exit = new Button("");
        btn_Exit.setFont(Font.font(18));
        btn_Exit.setGraphic(new ImageView("Back.png")); //Asigna Imagen al Button
        gd_actualizaPaises.add(btn_Exit,6,10);
        btn_Exit.setOnAction((e) -> {
        gd_actualizaPaises.getChildren().clear();
        });//End btn_Exit
        
        //Crea labels y textfields
        Label lb_titulo = new Label("ACTUALIZAR PAÍS");
        lb_titulo.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_titulo.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        Label lb_paisActualizar = new Label("INTRODUZCA EL NOMBRE DEL PAÍS");
        lb_paisActualizar.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_paisActualizar.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        tf_paisActualizar = new TextField();
        tf_paisActualizar.setPromptText("PAÍS");

        lb_mensajes = new Label();
        lb_mensajes.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_mensajes.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        lb_pais = new Label("PAÍS");
        lb_pais.setFont(new Font("Broadway",20)); //Fuente de letra
        lb_pais.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        lb_mostrarpais = new Label();
        lb_pais.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_pais.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        lb_continente = new Label("CONTINENTE");
        lb_continente.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_continente.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
         cB_continent = new ComboBox(); 
        cB_continent.setValue("Seleccione el Continente");
        cB_continent.getItems().addAll("África","América","Asia","Europa","Oceanía"); //Agrega los continentes al ComboBox
    
        
        lb_capital = new Label("CAPITAL");
        lb_capital.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_capital.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        tf_capitalActualizar = new TextField();
        
        lb_idioma = new Label("IDIOMA");
        lb_idioma.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_idioma.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        tf_idiomaActualizar = new TextField();
        
        lb_poblacion = new Label("POBLACIÓN");
        lb_poblacion.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_poblacion.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        tf_poblacionActualizar = new TextField();
        
        
        lb_descripcion = new Label("DESCRIPCIÓN");
        lb_descripcion.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_descripcion.setTextFill(Color.YELLOWGREEN); //Colores Letras
        
        tf_descripcionActualizar = new TextField();
        
        //Oculta Labels
        ocultaComponentes(false);
        
        CreaYLeeArchivos cyla= new CreaYLeeArchivos();
        
        Button btn_verifica = new Button("");
        btn_verifica.setGraphic(new ImageView("Verify.png")); //Asigna Imagen al Button
        btn_verifica.setFont(Font.font(17));
        
        //Pregunta si el país existe y muestra los componentes
        btn_verifica.setOnAction(e -> {
            
            if(cyla.existePais(tf_paisActualizar.getText(), "paises.txt")){
                ocultaComponentes(true);
                btn_actualizarPais.setVisible(true);
                lb_mensajes.setVisible(false);
                lb_mensajes.setFont(new Font("Cambria",20)); //Fuente de letra
                lb_mensajes.setTextFill(Color.YELLOWGREEN); //Colores Letras
                
                datosArchivo = cyla.getDatosEspecificos("paises.txt", tf_paisActualizar.getText());
                
                lb_mostrarpais.setText(datosArchivo[0]);
                lb_mostrarpais.setFont(new Font("Cambria",20)); //Fuente de letra
                lb_mostrarpais.setTextFill(Color.YELLOWGREEN); //Colores Letras
                
                cB_continent.setValue(datosArchivo[1]);
                
                tf_capitalActualizar.setText(datosArchivo[2]);
                
                tf_idiomaActualizar.setText(datosArchivo[3]);
                
                tf_poblacionActualizar.setText(datosArchivo[4]);
                
                tf_descripcionActualizar.setText(datosArchivo[5]);
                
                lb_mensajes.setVisible(false);
                lb_mensajes.setFont(new Font("Cambria",20)); //Fuente de letra
                lb_mensajes.setTextFill(Color.YELLOWGREEN); //Colores Letras
            }//End if
            else{
                ocultaComponentes(false);
                lb_mensajes.setText("EL PAÍS NO EXISTE");
                lb_mensajes.setFont(new Font("Cambria",20)); //Fuente de letra
                lb_mensajes.setTextFill(Color.YELLOWGREEN); //Colores Letras
                
                btn_actualizarPais.setVisible(false);
            }//End else
        });//End btn_verifica
        
        //Agrega componentes al Gridpane
        gd_actualizaPaises.add(lb_titulo, 1, 0);
        gd_actualizaPaises.add(lb_paisActualizar, 0, 1);
        gd_actualizaPaises.add(tf_paisActualizar, 1, 1);
        gd_actualizaPaises.add(btn_verifica, 1, 2);
        gd_actualizaPaises.add(lb_pais, 0, 3);
        gd_actualizaPaises.add(lb_mensajes, 1, 3);
        gd_actualizaPaises.add(lb_mostrarpais, 1, 3);
        gd_actualizaPaises.add(lb_continente, 0, 4);
        gd_actualizaPaises.add(cB_continent, 1, 4);
        gd_actualizaPaises.add(lb_capital, 0, 5);
        gd_actualizaPaises.add(tf_capitalActualizar, 1, 5);
        gd_actualizaPaises.add(lb_idioma, 0, 6);
        gd_actualizaPaises.add(tf_idiomaActualizar, 1, 6);
        gd_actualizaPaises.add(lb_poblacion, 0, 7);
        gd_actualizaPaises.add(tf_poblacionActualizar, 1, 7);
        gd_actualizaPaises.add(lb_descripcion, 0, 8);
        gd_actualizaPaises.add(tf_descripcionActualizar, 1, 8);
        gd_actualizaPaises.add(getButtonActualizarPais(), 1, 9);
        
    return gd_actualizaPaises;
    }//Fin actualizarPaises
    
    
    public Button getButtonActualizarPais(){
        
        //Crea boton de actualizar
        btn_actualizarPais = new Button("");
        btn_actualizarPais.setFont(Font.font(17));
        btn_actualizarPais.setGraphic(new ImageView("Update.png")); //Asigna Imagen al Button
        btn_actualizarPais.setVisible(false);
        
        
        //Actualiza los datos del país
        btn_actualizarPais.setOnAction(e -> {
            CreaYLeeArchivos cyla = new CreaYLeeArchivos();
            cyla.actualizarPaises(lb_mostrarpais.getText(),cB_continent.getValue().toString(), tf_capitalActualizar.getText(),
                                   tf_idiomaActualizar.getText(), tf_poblacionActualizar.getText(), tf_descripcionActualizar.getText());
            lb_mensajes.setVisible(true);
            lb_mensajes.setText("EL PAÍS HA SIDO ACTUALIZADO CON ÉXITO");
            ocultaComponentes(false);
            tf_paisActualizar.setText("");
            btn_actualizarPais.setVisible(false);
        });//End btn_actualizarPaís
    return  btn_actualizarPais;
    }//Fin getButtonActualizarCliente
    
    //Oculta y muestra componentes dentro de la Interfaz
    public void ocultaComponentes(boolean visible){
        lb_mostrarpais.setVisible(visible);
        lb_pais.setVisible(visible);
        cB_continent.setVisible(visible);
        lb_continente.setVisible(visible);
        lb_capital.setVisible(visible);
        tf_capitalActualizar.setVisible(visible);
        lb_idioma.setVisible(visible);
        tf_idiomaActualizar.setVisible(visible);
        lb_poblacion.setVisible(visible);
        tf_poblacionActualizar.setVisible(visible);
        lb_descripcion.setVisible(visible);
        tf_descripcionActualizar.setVisible(visible);
       
        
        //Limpia componentes
        if(!visible){
            lb_mostrarpais.setText("");
            cB_continent.setValue("");
            tf_capitalActualizar.setText("");
            tf_idiomaActualizar.setText("");
            tf_poblacionActualizar.setText("");
            tf_descripcionActualizar.setText("");
        }//End if
    }//End ocultaComponentes
}//End class
