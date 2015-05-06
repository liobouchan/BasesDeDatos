/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.awt.event.KeyEvent;

/**
 *
 * @author lio
 */
public class SoloLetras extends javax.swing.text.PlainDocument{

    public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws javax.swing.text.BadLocationException {
        StringBuffer buf = new StringBuffer(str);
        int size = buf.length();
        char c;
        for (int i = 0; i < size; i++) {
            c = buf.charAt(i);
            if ((c<'a' || c>'z') && (c<'A' || c>'Z')            
    && c !='á' //Minúsculas            
    && c !='é'            
    && c !='í'            
    && c !='ó'          
    && c !='ú'  
    && c !='Á' //Mayúsculas            
    && c !='É'            
    && c !='Í'            
    && c !='Ó'          
    && c !='Ú'            
    && (c!=(char)KeyEvent.VK_SPACE)) {
                buf.deleteCharAt(i);
            }
        }
        super.insertString(offs, buf.toString(), a);
    }
}
