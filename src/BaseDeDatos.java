import basededatos.DefinirTablas;
import java.io.FileWriter;
import java.io.PrintWriter;

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
        /**
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("/home/lio/Code/BaseDeDatos/src/prueba.txt",true);
            pw = new PrintWriter(fichero);
            pw.print("hola9");
            System.out.println("HOLA");
        }catch (Exception e) {
            System.out.print("1er Try");
        }finally{
            try{
            // Nuevamente aprovechamos el finally para
            // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }**/
        DefinirTablas definir = new DefinirTablas();
        definir.setVisible(true);
    }
}
