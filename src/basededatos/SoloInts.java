/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

/**
 *
 * @author lio
 */
public class SoloInts extends javax.swing.text.PlainDocument {
    public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws javax.swing.text.BadLocationException {
        StringBuffer buf = new StringBuffer(str);
        int size = buf.length();
        char c;
        for (int i = 0; i < size; i++) {
            c = buf.charAt(i);
            if (!Character.isDigit(c)) {
                buf.deleteCharAt(i);
            }
        }
        super.insertString(offs, buf.toString(), a);
    }
}
