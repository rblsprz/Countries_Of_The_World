package ProyectoPaíses;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class BuscarPaises {
    CreaYLeeArchivos cL = new CreaYLeeArchivos();
     public GridPane searchInterface() {

        GridPane gp_search = new GridPane();

        gp_search.setHgap(10);
        gp_search.setVgap(10);
        
        Button btn_Exit = new Button("");
        btn_Exit.setGraphic(new ImageView("Back.png")); //Asigna Imagen al Button
        btn_Exit.setFont(Font.font(18));
        gp_search.add(btn_Exit,6,10);
        btn_Exit.setOnAction((e) -> {
        gp_search.getChildren().clear();
        });//End btn_Exit
       

        Label lb_searchCountry = new Label("INTRODUZCA EL PAÍS A BUSCAR");
        lb_searchCountry.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_searchCountry.setTextFill(Color.YELLOWGREEN); //Colores Letras
        gp_search.add(lb_searchCountry, 0, 0);
        
        

        TextField txt_searchCountry = new TextField("");
        gp_search.add(txt_searchCountry, 1, 0);

        Button btn_search = new Button("");
        btn_search.setGraphic(new ImageView("Search.png")); //Asigna Imagen al Button
        gp_search.add(btn_search, 2, 0);

        Label lb_nameCountry = new Label("PAÍS");
        lb_nameCountry.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_nameCountry.setTextFill(Color.YELLOWGREEN); //Colores Letras
        lb_nameCountry.setVisible(false);
        gp_search.add(lb_nameCountry, 0, 1);

         Label tF_nameCountry = new Label();
        tF_nameCountry.setFont(new Font("Cambria",20)); 
        tF_nameCountry.setTextFill(Color.WHITE); 
        tF_nameCountry.setVisible(false);
        gp_search.add(tF_nameCountry, 1, 1);

        Label lb_nameContinent = new Label("CONTINENTE");
        lb_nameContinent.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_nameContinent.setTextFill(Color.YELLOWGREEN); //Colores Letras
        lb_nameContinent.setVisible(false);
        gp_search.add(lb_nameContinent, 0, 2);

       Label  tf_nameContinent = new Label ();
        tf_nameContinent.setFont(new Font("Cambria",20)); 
        tf_nameContinent.setTextFill(Color.WHITE); 
        tf_nameContinent.setVisible(false);
        gp_search.add(tf_nameContinent, 1, 2);
        
        Label lb_Capital = new Label("CAPITAL");
        lb_Capital.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_Capital.setTextFill(Color.YELLOWGREEN); //Colores Letras
        lb_Capital.setVisible(false);
        gp_search.add(lb_Capital, 0, 5);

      Label  tf_Capital = new   Label();
        tf_Capital.setFont(new Font("Cambria",20)); 
        tf_Capital.setTextFill(Color.WHITE); 
        tf_Capital.setVisible(false);
        gp_search.add(tf_Capital, 1, 5);

        Label lb_language = new Label("IDIOMA");
        lb_language.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_language.setTextFill(Color.YELLOWGREEN); //Colores Letras
        lb_language.setVisible(false);
        gp_search.add(lb_language, 0, 3);
        
        Label tf_language = new   Label();
          tf_language.setFont(new Font("Cambria",20)); 
          tf_language.setTextFill(Color.WHITE); 
        tf_language.setVisible(false);
        gp_search.add(tf_language, 1, 3);
        
        Label lb_Population = new Label("POBLACIÓN");
        lb_Population.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_Population.setTextFill(Color.YELLOWGREEN); //Colores Letras
        lb_Population.setVisible(false);
        gp_search.add(lb_Population, 0, 6);

              Label tF_Population = new   Label();
        tF_Population.setVisible(false);
        tF_Population.setFont(new Font("Cambria",20)); 
        tF_Population.setTextFill(Color.WHITE); 
        gp_search.add(tF_Population, 1, 6);

        Label lb_Description = new Label("DESCRIPCIÓN");
        lb_Description.setFont(new Font("Cambria",20)); //Fuente de letra
        lb_Description.setTextFill(Color.YELLOWGREEN); //Colores Letras
        lb_Description.setVisible(false);
        gp_search.add(lb_Description, 0, 4);

       Label tF_Description = new   Label();
          tF_Description.setFont(new Font("Cambria",20)); 
          tF_Description.setTextFill(Color.WHITE); 
        tF_Description.setVisible(false);
        gp_search.add(tF_Description, 1, 4);
        
        
         btn_search.setOnAction((event) -> {
            
            lb_nameCountry.setVisible(true);
            tF_nameCountry.setVisible(true);
            lb_nameContinent.setVisible(true);
            tf_nameContinent.setVisible(true);
            lb_language.setVisible(true);
            tf_language.setVisible(true);
            lb_Description.setVisible(true);
            tF_Description.setVisible(true);
            lb_Capital.setVisible(true);
            tf_Capital.setVisible(true);
            lb_Population.setVisible(true);
            tF_Population.setVisible(true);

            Country c[] = cL.leePaisesArchivo();
            for (int i = 0; i < c.length; i++) {
                if (c[i].getNameCountry().equalsIgnoreCase(txt_searchCountry.getText())) {

                    tF_nameCountry.setText(c[i].getNameCountry());
                    tf_nameContinent.setText(c[i].getContinent());
                    tf_language.setText(c[i].getLanguage());
                    tF_Description.setText(c[i].getDescription());
                    tf_Capital.setText(c[i].getCapital());
                    tF_Population.setText(c[i].getPopulation());
                    
                }
            }//End for
            txt_searchCountry.setText("");
        });//End btn_search
        return gp_search;
    }//End searchInterface
}//End BuscarPaises
