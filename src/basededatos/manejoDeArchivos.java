package basededatos;


import basededatos.DefinirTablas;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

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
}
