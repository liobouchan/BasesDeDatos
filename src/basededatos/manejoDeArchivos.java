package basededatos;


import basededatos.DefinirTablas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lio
 */
public class manejoDeArchivos {
    
    public void asignarCrearTabla(String nombreTabla, JLabel labelTabla){
        
        String nuevoArchivo;
        nuevoArchivo = "/home/lio/Code/BasesDeDatos/"+nombreTabla+".txt";

        File archivo = new File(nuevoArchivo);
        labelTabla.setText(nombreTabla);
        
        try{
            if(archivo.createNewFile()){
                System.out.println("Archivo Creado Con Éxito");
            }
        }catch(IOException ex){
            Logger.getLogger(DefinirTablas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("El Archivo"+nuevoArchivo+" no se ha podido crear");
        }
    }
    
    public void agregarAtributo(String nombreDeTabla,String atributo, String tipoDeDato, String tamañoDelDato){
        try{
            File archivo = new File("/home/lio/Code/BasesDeDatos/"+nombreDeTabla+".txt");
            FileWriter escribir = new FileWriter(archivo, true);
            escribir.write(atributo+tipoDeDato+tamañoDelDato);
            escribir.close();
            System.out.println("Atributo " + atributo + " Agregado");
        }catch(IOException ex){
            Logger.getLogger(DefinirTablas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al agregar " + atributo);
        }
    }

    public void leerArchivoCompleto(JTextArea textDatos){
        String primerLinea;
        String palabraActual;
        String contenidoDelArreglo = "";
        int tokens=0;


        try {
            // TODO add your handling code here:
            BufferedReader bufferedReader = new BufferedReader (new FileReader ("/home/lio/Code/BasesDeDatos/a.txt"));
            primerLinea = bufferedReader.readLine();
            
            StringTokenizer stringTokenizer = new StringTokenizer(primerLinea, "@");
            String[] datos = new String[100000];
            while (stringTokenizer.hasMoreTokens()){
                palabraActual = String.valueOf(stringTokenizer.nextToken());
                datos[tokens] = palabraActual;
                tokens++;
            //System.out.println ("    Palabra " + tokens + " es: " + s2);
            }
            for(int i=0 ; i<=tokens; i++){
                if(datos[i] != null){
                    contenidoDelArreglo += datos[i] + ",";
                    textDatos.setText(contenidoDelArreglo);
                    System.out.println(datos[i]);
                }
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AgregarValores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AgregarValores.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void generarFormulario(String archivo , JFrame frame, JTextField[] arregloTexts){
        String primerLinea;
        String palabraActual;
        int tokens = 0;
        int atributoCounter = 0;
        String atributo;
        String tipo;
        String tamaño;

        try{
            BufferedReader bufferedReader = new BufferedReader (new FileReader ("/home/lio/Code/BasesDeDatos/"+archivo+".txt"));
            primerLinea = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(primerLinea, "@");
            
            while (stringTokenizer.hasMoreTokens()){
                if(tokens == 0){
                    palabraActual = stringTokenizer.nextToken();
                    atributo = palabraActual;
                    JLabel label = new JLabel(atributo);
                    JTextField textField = new JTextField(atributo);
                
                    textField.setName(atributo);
                    arregloTexts[atributoCounter] = textField;
                    frame.add(label);
                    frame.add(textField);
                    frame.revalidate();
                    frame.repaint();
                    frame.pack();
                }if(tokens == 1){
                    palabraActual = stringTokenizer.nextToken();
                    tipo = palabraActual;
                }if(tokens == 2){
                    palabraActual = stringTokenizer.nextToken();
                    tamaño = palabraActual;
                    tokens = -1;
                }
                tokens++;
                atributoCounter++;
            }
            }catch (FileNotFoundException ex) {
                Logger.getLogger(AgregarValores.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex) {
                Logger.getLogger(AgregarValores.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
