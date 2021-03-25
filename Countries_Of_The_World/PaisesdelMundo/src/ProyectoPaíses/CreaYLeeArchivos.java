
package ProyectoPaíses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class CreaYLeeArchivos {
    
    //Agrega países a archivo
    public void agregaPaisArchivo(String nameCountry,String continent,String capital,String language,String population,String description, boolean editable){
        PrintStream ps = getPrintStream("paises.txt",editable);
        ps.println(nameCountry+"|"+continent+"|"+capital+"|"+language+"|"+population+"|"+description);
    }//End agregaPaisArchivo
    
   
    
    //Retorna un arreglo de países 
    public Country[] leePaisesArchivo(){
        ordenaArchivo("paises.txt",0);
        Country arregloPaises[] = new Country[cuentaLineasArchivo("paises.txt")];
        int indice = 0;
        BufferedReader br = getBufferedReader("paises.txt");
        try{    
            String registroActual = br.readLine();
            while(registroActual != null){
                StringTokenizer st = new StringTokenizer(registroActual, "|");
                
                String nameCountry ="", continent="", capital="",language="",population="", description="";
                int controlaTokens = 1;
                
                while(st.hasMoreTokens()){
                    if(controlaTokens == 1)
                        nameCountry = st.nextToken();
                    else if(controlaTokens == 2)
                        continent = st.nextToken();
                    else if(controlaTokens == 3)
                        capital = st.nextToken();
                    else if(controlaTokens == 4)
                        language = st.nextToken();
                    else if(controlaTokens == 5)
                        population = st.nextToken();
                    else
                        description = st.nextToken();
                    
                        
                        
                controlaTokens++;
                }//Fin while

                Country c = new Country(nameCountry,continent,capital,language,population,description);
                arregloPaises[indice] = c;
                indice++;
                registroActual = br.readLine();
            }//End while 
        }//End try
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }//End catch
    return arregloPaises;
    }//End leePaisesArchivo
    
    public boolean searchName(String nameCountry){
    
        Country c [] = leePaisesArchivo();
        for(int i=0;i<c.length;i++){
        if(c[i].getNameCountry().equalsIgnoreCase(nameCountry));
        return false;
        }//End for
        return false;
    }//End searchName
    //Retorna un printstream 
    public PrintStream getPrintStream(String nombreArchivo, boolean editable) {
     
        File archivo = new File(nombreArchivo);
        PrintStream ps = null;
        try{
            FileOutputStream fos = new FileOutputStream(archivo,editable);
            ps = new PrintStream(fos);
        }
        catch(FileNotFoundException fnfe){
            System.out.println("Problemas con el archivo");
        }
    return ps;
    }//End getPrintStream
    
    //Retorna un BufferedReader
    public BufferedReader getBufferedReader(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        BufferedReader br = null;
        try{
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
        }
        catch(FileNotFoundException fnfe){
            System.out.println("Problemas con el archivo.");
        }
    return br;
    }//End getBufferedReader
    
    //Retorna cuántas líneas tiene un archivo
    public int cuentaLineasArchivo(String archivo){
        int contador = 0;
        BufferedReader br = getBufferedReader(archivo);
        try{    
            String registroActual = br.readLine();
            
            while(registroActual != null){
                contador++;
                registroActual = br.readLine();
                
            }//End while 
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }
    return contador;
    }//End cuentaLineasArchivo
    
    //Retorna un string especifico de una linea del archivo
    public String getNombreArchivo(String archivo, int lugarNombre){
        String nombreArchivo = "";
        int contandor = 0;
        for (int i = 0; i < archivo.length() && contandor != lugarNombre+1; i++) {
            if(archivo.charAt(i)=='|')
                contandor++;
            if(contandor==lugarNombre && archivo.charAt(i)!='|')
                nombreArchivo += archivo.charAt(i);
        }
    return nombreArchivo;
    }//Fin getNombreArchivo
    
    //Retorna un arreglo con los string del archivo
    public String [] getArregloArchivo(String nombreArchivo){
        String arregloArchivo[] = new String[cuentaLineasArchivo(nombreArchivo)];
        int indice = 0;
        BufferedReader br = getBufferedReader(nombreArchivo);
        try{    
            String registroActual = br.readLine();
            
            while(registroActual != null){
                arregloArchivo[indice]= registroActual; 
                indice++;
                registroActual = br.readLine();
                
            }//Fin while 
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }
    return arregloArchivo;
    }//Fin getArregloArchivo

    //Ordena alfabeticamente los archivos de países
    public void ordenaArchivo(String nombreArchivo, int lugarNombre){
        String [] arregloArchivo = getArregloArchivo(nombreArchivo);
        String temp = "";
        for (int i = 0; i < arregloArchivo.length; i++) {
           for (int j = i+1; j < arregloArchivo.length; j++) {
                String paisPrimero = getNombreArchivo(arregloArchivo[i],lugarNombre).toLowerCase();
                String paisSegundo = getNombreArchivo(arregloArchivo[j],lugarNombre).toLowerCase();
                if(paisPrimero.compareTo(paisSegundo)>0){
                    temp = arregloArchivo[j];
                    arregloArchivo[j]=arregloArchivo[i];
                    arregloArchivo[i]=temp;
                }//End if
            }//End for
        }//End for
        PrintStream ps = getPrintStream(nombreArchivo, false);
        for(int i = 0; i < arregloArchivo.length; i++) 
            ps.println(arregloArchivo[i]);
    }//End ordenaArchivo
    
    
    //Verifica si exite país
    public boolean existePais(String identificador, String archivo){
        boolean existe = false;
        BufferedReader br = getBufferedReader(archivo);
        try{
            String registroActual = br.readLine();
            
            while(registroActual!=null && !existe){
                if(getNombreArchivo(registroActual,0).equals(identificador)){
                    existe=true;
                }//End if    
                registroActual = br.readLine();
            }//End while
        }//End try
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "Error en el archivo");
        }//End catch
    return existe;
    }//End existePaís
    
    
    //Retorna un arreglo con cada seccion de una linea del archivo
    public String[] getDatosEspecificos(String archivo, String identificador){
        int tamanoArreglo = 0;
        if(archivo.equals("paises.txt"))
            tamanoArreglo = 6;
        else
            tamanoArreglo = 7;
        String datos [] = new String[tamanoArreglo];
        String registroActual= getRegistroActual(archivo, identificador);
        String temp= "";
        int i=0,contador = 0;
        while (i<registroActual.length()) {            
            if(registroActual.charAt(i)!='|')
                temp+= registroActual.charAt(i);
            else{
                datos[contador++] = temp;
                temp = "";
            }//End else
            i++;
        }//End while
        datos[contador] = temp;
    return datos;
    }//Fin getDatosEspecificos
    
    //Retorna un string con el registro del identificador 
    public String getRegistroActual(String archivo, String identificador){
        int indice = 0;
        BufferedReader br = getBufferedReader(archivo);
        String registroActual ="";
        try{    
            registroActual = br.readLine();
            while(!getNombreArchivo(registroActual, 0).equals(identificador)){
                registroActual = br.readLine();  
            }//End while 
        }
        catch(IOException ioe){
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }
    return registroActual;
    }//End getRegistroActual
    
    //Borra países
    public void borrarPais(String archivo, String identificador){
        String [] arregloArchivo = getArregloArchivo(archivo);
        
        PrintStream ps = getPrintStream(archivo, false);
        for(int i = 0; i < arregloArchivo.length; i++){
            if(!getNombreArchivo(arregloArchivo[i], 0).equals(identificador))
                ps.println(arregloArchivo[i]);
        }//End if
    }//End borrarPais
    
    //Actualiza países
    public void actualizarPaises(String nameCountry,String continent,String capital,String language,String population,String description){
        String [] arregloArchivo = getArregloArchivo("paises.txt");

        PrintStream ps = getPrintStream("paises.txt", false);
        for(int i = 0; i < arregloArchivo.length; i++){
            
            if(!getNombreArchivo(arregloArchivo[i], 0).equals(nameCountry))
                ps.println(arregloArchivo[i]);
            else
                ps.println(nameCountry+"|"+continent+"|"+capital+"|"+language+"|"+population+"|"+description);
        }//End for
    }//End actualizarPaises
    /*public String imagen (String imagen){
    
    String [] arregloArchivo = getArregloArchivo("paises.txt");
    
    
    }//End String imagen*/
}//End CreaYLeeArchivos