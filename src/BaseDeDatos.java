import basededatos.AgregarValores;
import basededatos.DefinirTablas;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

        DefinirTablas definir = new DefinirTablas();
        definir.setVisible(true);
        final JFrame frame = new JFrame("Test");
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Cargar") {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String primerLinea;
                        String palabraActual;
                        int tokens=0;
                        int atributoCounter = 0;
                        int n = 50;
                        String atributo;
                        String tipo;
                        String tamaño;
                
                        try {
                            // TODO add your handling code here:
                            BufferedReader bufferedReader = new BufferedReader (new FileReader ("/home/lio/Code/BasesDeDatos/Alumno.txt"));
                            primerLinea = bufferedReader.readLine();
            
                            StringTokenizer stringTokenizer = new StringTokenizer(primerLinea, "@");
                            while (stringTokenizer.hasMoreTokens()){
                                if(tokens == 0){
                                    palabraActual = stringTokenizer.nextToken();
                                    atributo = palabraActual;
                                    JLabel label = new JLabel(atributo);
                                    JTextField textField[] = new JTextField[n];
                                    textField[atributoCounter] = new JTextField();
                                    textField[atributoCounter].setText(atributo);
                                    frame.add(label);
                                    frame.add(textField[atributoCounter]);
                                    frame.revalidate();
                                    frame.repaint();
                                    frame.pack();

                                    String s1 = "labelAtributo"+atributoCounter;
                                    System.out.println("Atributo"+atributo+atributoCounter);
                                    atributoCounter ++;
                    
                                }if(tokens == 1){
                                    palabraActual = stringTokenizer.nextToken();
                                    tipo = palabraActual;
                                    System.out.println("Tipo"+tipo);
                                }if(tokens == 2){
                                    palabraActual = stringTokenizer.nextToken();
                                    tamaño = palabraActual;
                                    System.out.println("Tam"+tamaño);
                                    tokens = -1;
                                }
                                tokens++;
                            }
            
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AgregarValores.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AgregarValores.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                
                        try {
                            // TODO add your handling code here:
                            BufferedReader bufferedReader = new BufferedReader (new FileReader ("/home/lio/Code/BasesDeDatos/Alumno.txt"));
                            primerLinea = bufferedReader.readLine();
            
                            StringTokenizer stringTokenizer = new StringTokenizer(primerLinea, "@");
                            while (stringTokenizer.hasMoreTokens()){
                                if(tokens == 0){
                                    palabraActual = stringTokenizer.nextToken();
                                    atributo = palabraActual;
                                    JTextField textField[] = new JTextField[n];
                                    String s1 = String.valueOf(textField[atributoCounter].getText());
                                    System.out.println("Atributo"+atributo+atributoCounter);
                                    System.out.println(s1);
                                    atributoCounter ++;
                    
                                }if(tokens == 1){
                                    palabraActual = stringTokenizer.nextToken();
                                    tipo = palabraActual;
                                    System.out.println("Tipo"+tipo);
                                }if(tokens == 2){
                                    palabraActual = stringTokenizer.nextToken();
                                    tamaño = palabraActual;
                                    System.out.println("Tam"+tamaño);
                                    tokens = -1;
                                }
                                tokens++;
                            }
            
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AgregarValores.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(AgregarValores.class.getName()).log(Level.SEVERE, null, ex);
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
