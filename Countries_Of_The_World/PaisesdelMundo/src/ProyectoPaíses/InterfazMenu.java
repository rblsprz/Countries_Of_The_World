package ProyectoPaíses;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;


public class InterfazMenu {
    Mantenimiento mant;
    VBox vb_ventanas;
    InsertarTablas it;
    CreaYLeeArchivos cyla;
    ActualizarPaises ac;
    BuscarPaises bP;
    
    //Retorna la escena
    public Scene menuInterfaz(){
      
        Scene scene = new Scene(new VBox(), 800, 640); //Tamaño de la Interfaz
        vb_ventanas = new VBox(); //Administra las ventanas
        vb_ventanas.setMinSize(800, 650);
        String image = "FondoProyecto.gif";
        vb_ventanas.setStyle("-fx-background-image: url('" + image + "'); "
           +"-fx-background-position: left top, center;"
           +"-fx-background-repeat: no-repeat;"
           +"-fx-background-size: cover, auto;");         
        
        
        MenuBar mb_Menu = new MenuBar();  //Barra de Menú
       

        mb_Menu.getMenus().addAll(menuSistema(), menuPaises(),menuReportes(),menuMantenimiento());
        
       
        ((VBox)scene.getRoot()).getChildren().addAll(mb_Menu, vb_ventanas);
        
    return scene;
    }//menuInterfaz
   
    //Crea menu sistema
    public Menu menuSistema(){
        
        Menu menuSistema = new Menu("Sistema");
        
        menuSistema.setMnemonicParsing(true);
       
        menuSistema.getItems().addAll(getAcercaDeItem(), getCreditosItem(), getSalirItem());
    
    return menuSistema;
    }//Fin menuSistema

    //Agrega el acerca de 
    public MenuItem getAcercaDeItem(){
        
        MenuItem acercaDeItem = new MenuItem("Acerca de", new ImageView(new Image("acerca.png")));
        acercaDeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        
        Label lb_sistemaAcercaDe = new Label("\nAPLICACIÓN DE LOS PAÍSES DEL MUNDO \nDESARROLLADO EN NETBEANS 8.2 \nLENGUAJE DE PROGRAMACIÓN JAVA \nUNIVERSIDAD DE COSTA RICA");
        lb_sistemaAcercaDe.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_sistemaAcercaDe.setTextFill(Color.YELLOWGREEN); //Colores Letras
       
        Button btn_Exit = new Button("");
        btn_Exit.setGraphic(new ImageView("Back.png")); //Asigna Imagen al Button
        btn_Exit.setFont(Font.font(12));
        btn_Exit.setOnAction((e) -> {
        vb_ventanas.getChildren().clear();
        });//End btn_Exit
        
        VBox vbox =  new VBox();
        vbox.getChildren().addAll(lb_sistemaAcercaDe,btn_Exit);
        
        acercaDeItem.setOnAction(e -> {
            
            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().add(vbox);    
        });//End acercaDeItem
        
    return acercaDeItem;
    }//Fin getAcercaDeItem
    
    //Agrega créditos
    public MenuItem getCreditosItem(){
         MenuItem creditosItem = new MenuItem("Creditos", new ImageView(new Image("creditos.png")));
        creditosItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        Label lb_sistemaCreditos = new Label("\nREALIZADO POR: \nDAVID ROBLES PÉREZ B96552 \nMELISSA MENA CALDERON B94732 \nMARIAM MURILLO BONILLA B95450 ");
        lb_sistemaCreditos.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_sistemaCreditos.setTextFill(Color.YELLOWGREEN); //Colores Letras
       
        
         Button btn_Exit = new Button("");
         btn_Exit.setGraphic(new ImageView("Back.png")); //Asigna Imagen al Button
         btn_Exit.setFont(Font.font(12));
        btn_Exit.setOnAction((e) -> {
        vb_ventanas.getChildren().clear();
        });//End btn_Exit
        
       VBox vbox =  new VBox();
       vbox.getChildren().addAll(lb_sistemaCreditos,btn_Exit);
      
        creditosItem.setOnAction(e -> {
            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().add(vbox);
        });//End creditosItem
    return creditosItem;
    }//Fin getCreditosItem
    
    //Cierra ventana
    public MenuItem getSalirItem(){
         MenuItem salirItem = new MenuItem("Salir", new ImageView(new Image("salir.png")));
        salirItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        salirItem.setOnAction(e -> {Platform.exit();});
    return salirItem;
    }//Fin getSalirItem
    
    
   //Crea menu países
    public Menu menuPaises(){
        
        Menu menuPaises = new Menu("Países");
        
        //menuPaises.setMnemonicParsing(true);
       
        menuPaises.getItems().addAll(getPaisesInsertarItem(),getPaisBorrarItem(),getPaisesActualizarItem(),getPaisesBuscarItem());
    return menuPaises;
    }//End menuPaíses
    
   //Agrega insertar país
    public MenuItem getPaisesInsertarItem(){
        mant = new Mantenimiento();
        MenuItem paisesInsertarItem = new MenuItem("Ingresar País", new ImageView(new Image("insertar.png")));
        paisesInsertarItem.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
        paisesInsertarItem.setOnAction(e -> {
            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().add(mant.paisInsertar());
        });
    return paisesInsertarItem;
    }//Fin getClientesInsertarItem
    
    //Agrega borrar país
    public MenuItem getPaisBorrarItem(){
        MenuItem paisesBorrarItem = new MenuItem("Borrar País", new ImageView(new Image("borrar.png")));
        paisesBorrarItem.setAccelerator(KeyCombination.keyCombination("Ctrl+B"));
        paisesBorrarItem.setOnAction(e -> {
            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().add(mant.borrarPaises());
        });
    return paisesBorrarItem;
    }//Fin getPaisBorrorItem
    
    //Agrega actualiza países
    public MenuItem getPaisesActualizarItem(){
       
        MenuItem paisesActualizarItem = new MenuItem("Actualizar País", new ImageView(new Image("actualizar.png")));
        paisesActualizarItem.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
        
        ac = new ActualizarPaises();
        
        paisesActualizarItem.setOnAction(e -> {
            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().add(ac.actualizarPais());
        });
    return paisesActualizarItem;
    }//Fin getPaisesActualizarItem
        
       
     //Agrega búsqueda de países 
    public MenuItem getPaisesBuscarItem(){
       
        MenuItem paisesBuscarItem = new MenuItem("Buscar País", new ImageView(new Image("buscar.png")));
        paisesBuscarItem.setAccelerator(KeyCombination.keyCombination("Ctrl+P"));
        
        bP =  new BuscarPaises();
        
        paisesBuscarItem.setOnAction(e -> {
            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().add(bP.searchInterface());
        });//End paisesBuscarItem
    return paisesBuscarItem;
    }//Fin getPaísesBuscarItem
        
    
    //Crea menu reportes 
    public Menu menuReportes(){
        Menu menuReportes = new Menu("Reportes");
         
        menuReportes.getItems().addAll(getListadoPaisesItem(),getListadoPaisesporContinenteItem());
    
    return menuReportes;
    }//End menu reportes
    
    //Agrega tabla países
    public MenuItem getListadoPaisesItem(){
        MenuItem listadoPaisesItem = new MenuItem("Ver países", new ImageView(new Image("verpaises.png")));
        listadoPaisesItem.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        
        it = new InsertarTablas();
        listadoPaisesItem.setOnAction(e -> {

            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().add(it.mostarTablaPaises());    
        });
    return listadoPaisesItem;
    }//Fin getListadoPaisesItem 
    
    //Agrega tabla países por continente
    public MenuItem getListadoPaisesporContinenteItem(){
        MenuItem listadoPaisesporContinenteItem = new MenuItem("Países por Continente", new ImageView(new Image("paisesporcontinente.png")));
        listadoPaisesporContinenteItem.setAccelerator(KeyCombination.keyCombination("Ctrl+K"));
        listadoPaisesporContinenteItem.setOnAction(e -> {

            vb_ventanas.getChildren().clear();
            vb_ventanas.getChildren().add(it.PaisesporContinente());    
        });
    return listadoPaisesporContinenteItem;
    }//End getListadoPaisesporContinente
    
    
    
    
    
    //Crea menu mantenimiento
    public Menu menuMantenimiento(){
        Menu menuMantenimiento = new Menu("Mantenimiento");
        
        MenuItem mI_Empty = new MenuItem("Vaciar Aplicación ",new ImageView(new Image("vaciar.png"))); //MenuItem Países
        mI_Empty.setOnAction((event)->{
            int i =JOptionPane.showConfirmDialog(null, "¿ESTÁ SEGUR@ QUÉ DESEA ELIMINAR TODOS LOS DATOS DE LA APLICACIÓN?");
            if(i==0){
            try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("paises.txt")); //Stream de Escritura de Archivos
            bw.write(""); //Escribe una línea vacía sobre código
            bw.close(); //Vaciar Aplicación
            }//End try
              catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null,"Problemas de Archivo");
            }//End catch
            catch(IOException io){
            JOptionPane.showMessageDialog(null,"Problemas de Archivo");
            }//End catch
            }//End if
        });//End mI_Empty
        
        menuMantenimiento.getItems().addAll(mI_Empty);
    return menuMantenimiento;
    }//Fin menuMantenimiento
    
}//End InterfazMenu