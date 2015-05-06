import basededatos.AgregarValores;
import basededatos.DefinirTablas;
import basededatos.SoloInts;
import basededatos.SoloLetras;
import basededatos.manejoDeArchivos;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author lio
 */
public class BaseDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final manejoDeArchivos manejo = new manejoDeArchivos();
        final JTextField[] arregloTexts = new JTextField[10000] ;
        DefinirTablas definir = new DefinirTablas();
        definir.setVisible(true);
        final JFrame frame = new JFrame("CargarDatos");
        frame.setLayout(new GridLayout(0, 1));

        frame.add(new JButton(new AbstractAction("Cargar Artículo") {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String archivo = "Articulo";
                        manejo.generarFormulario(archivo, frame, arregloTexts);
                    }
                });
            }
        }));

        frame.add(new JButton(new AbstractAction("Cargar Vendedor") {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String archivo = "Vendedor";
                        manejo.generarFormulario(archivo, frame, arregloTexts);
                    }
                });
            }
        }));
        
        frame.add(new JButton(new AbstractAction("Cargar Ventas") {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String archivo = "Ventas";
                        manejo.generarFormulario(archivo, frame, arregloTexts);
                    }
                });
            }
        }));

        frame.add(new JButton(new AbstractAction("Guardar"){
            public void actionPerformed(ActionEvent e){
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Hola Mundo");
                        String primerLinea;
                        String palabraActual;
                        int tokens=0;
                        int atributoCounter = 0;
                        int n = 50;
                        String atributo;
                        String tipo;
                        String tamaño;
                        String contenidoDelArreglo = "";
                        System.out.println(arregloTexts[atributoCounter].getText());
                        try{
                        for(int i=0 ; i<=100; i++){
                            if(arregloTexts[i] != null){
                                contenidoDelArreglo = arregloTexts[i].getText() + "@";
                                File archivo = new File("/home/lio/Code/BasesDeDatos/AlumnoDatos.txt");
                                FileWriter escribir = new FileWriter(archivo, true);
                                escribir.write(contenidoDelArreglo);
                                escribir.close();
                            }
                        }                            
                        } catch (IOException ex) {
                            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        }));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
                frame.setVisible(true);
            }
        });
        }
}
