/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author LinkA
 */
public class PanelMenuPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form PanelMenuPrincipal
     */
    public PanelMenuPrincipal() {
        initComponents();
        jLabelBienvenida.setText("Bienvenido/a " + PanelLogin.usuarioIniciado.getNombre() + " " + PanelLogin.usuarioIniciado.getApellidos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBienvenida = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabelBienvenida.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabelBienvenida.setText("Bienvenido ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 947, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(381, 381, 381)
                    .addComponent(jLabelBienvenida)
                    .addContainerGap(381, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(329, 329, 329)
                    .addComponent(jLabelBienvenida)
                    .addContainerGap(329, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBienvenida;
    // End of variables declaration//GEN-END:variables
}
