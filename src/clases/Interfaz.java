package clases;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
       chulo.setVisible(false);
       admir.setVisible(false);
        this.setMinimumSize(new Dimension(370, 228)); 
        this.setLocationRelativeTo(null);
        txt_expresion.setText("{3*(7-6)-{3*7}-[6-3]}");

        this.setLocationRelativeTo(null);
        setResizable(false); //<- Impedimos que la ventana pueda estirarse o cambiar de tamaño
        setIconImage(new ImageIcon(getClass().getResource("/img/Escudo_Unilibre3.png")).getImage()); //<- Estableciendo icono de ventana

        setTitle("Analizador"); //<- Texto de ventana   
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        chulo = new javax.swing.JLabel();
        admir = new javax.swing.JLabel();
        txt_expresion = new javax.swing.JTextField();
        Btn_validar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        chulo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos Peñaranda\\Pictures\\Png's\\chulo4.png")); // NOI18N
        getContentPane().add(chulo);
        chulo.setBounds(310, 110, 30, 26);

        admir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos Peñaranda\\Pictures\\Png's\\error1.png")); // NOI18N
        getContentPane().add(admir);
        admir.setBounds(310, 110, 30, 30);

        txt_expresion.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        getContentPane().add(txt_expresion);
        txt_expresion.setBounds(30, 110, 310, 30);

        Btn_validar.setText("Validar");
        Btn_validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_validarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_validar);
        Btn_validar.setBounds(30, 160, 80, 23);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("ANALIZADOR SINTÁCTICO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 20, 244, 35);

        logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos Peñaranda\\Pictures\\Png's\\Escudo_Unilibre3.png")); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(290, 10, 53, 54);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 370, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_validarActionPerformed
       chulo.setVisible(false);
       admir.setVisible(false);
        if (ValidarExpresion()) {
            chulo.setVisible(true);
            //JOptionPane.showMessageDialog(null, "La formula esta escrita correctamente.");
        } else {
           // JOptionPane.showMessageDialog(null, "¡ERROR!, la formula NO esta escrita correctamente.");
            admir.setVisible(true);
        }
    }//GEN-LAST:event_Btn_validarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_validar;
    private javax.swing.JLabel admir;
    private javax.swing.JLabel chulo;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField txt_expresion;
    // End of variables declaration//GEN-END:variables

    public boolean ValidarExpresion() {
        Pila pila = new Pila();
        String cadena = txt_expresion.getText();

        for (int i = 0; i < cadena.length(); i++) {
            //CharAt permite recuperar un caracter dependiendo de la posicion
            if (cadena.charAt(i) == '(' || cadena.charAt(i) == '[' || cadena.charAt(i) == '{') {
                pila.Insertar(cadena.charAt(i)); //Inserta el caracter
            } else {

                if (cadena.charAt(i) == ')') {

                    if (pila.extraer() != '(') { // si no empieza con ( no lo toma
                        return false;
                    }

                } else {
                    if (cadena.charAt(i) == ']') {

                        if (pila.extraer() != '[') { // si no empieza con [ no lo toma
                            return false;
                        }

                    } else {

                        if (cadena.charAt(i) == '}') {
                            if (pila.extraer() != '{') {// si no empieza con { no lo toma
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return pila.PilaVacia(); //retorna true si esta vacia
    }
}
