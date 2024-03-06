/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EmpresaMetodos;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import modelo.Empresa;

/**
 *
 * @author LinkA
 */
public class PanelEmpresa extends javax.swing.JPanel {

    Color botonSeleccionado = new Color(230, 161, 2);
    Color botonNoSeleccionado = new Color(254, 177, 3);
    EmpresaMetodos empresaMetodos = new EmpresaMetodos();
    List<Empresa> empresas = empresaMetodos
                        .rellenarListaEmpresa("select * from empresa where eliminado = FALSE ORDER BY \"idEmpresa\" ASC");
    public static Empresa empresaSeleccionada;


    public PanelEmpresa() {
        initComponents();
        tablaEmpresa = empresaMetodos.prepararRenderizadoCeldas(tablaEmpresa);
        tablaEmpresa = empresaMetodos.prepararEditadoCeldas(tablaEmpresa);

        tablaEmpresa.setRowHeight(49);
        tablaEmpresa.getColumnModel().getColumn(6).setMinWidth(113);
        tablaEmpresa.getColumnModel().getColumn(6).setMaxWidth(113);
        tablaEmpresa = empresaMetodos.rellenarTablaEmpresa(tablaEmpresa, empresas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpresa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tfBusqueda = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        tablaEmpresa.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tablaEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Cif", "Dirección", "Dueño", "Ambito", "Utilidad", "Email", "Tutor", "Email Tutor", "Telefono de contacto", "Nombre de contacto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEmpresa.setSelectionBackground(new java.awt.Color(254, 177, 3));
        tablaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpresa);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1015;
        gridBagConstraints.ipady = 570;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 11, 10);
        add(jScrollPane1, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tfBusqueda.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tfBusqueda.setForeground(new java.awt.Color(204, 204, 204));
        tfBusqueda.setText("Busque en cualquier campo");
        tfBusqueda.setBorder(null);
        tfBusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBusquedaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBusquedaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jSeparator1)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(254, 177, 3));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar (Personalizado).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 228;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        add(jPanel3, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar (Personalizado).png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 6, 0, 10);
        add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Agregar empresa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 342, 0, 0);
        add(jLabel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(254, 177, 3));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("Necesidades");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 150, 0, 0);
        add(jPanel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        new VentanaAgregarEmpresa().setVisible(true);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.out.println(empresaSeleccionada.getId());
        new VentanaNecesidad().setVisible(true);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void tablaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpresaMouseClicked
        int numFilaSeleccionada = tablaEmpresa.getSelectedRow();
        empresaSeleccionada = new Empresa();
        empresaSeleccionada.setId(Integer.parseInt(tablaEmpresa.getValueAt(numFilaSeleccionada, 0).toString()));
        empresaSeleccionada.setNombre((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 1));
        empresaSeleccionada.setNombre( (String) tablaEmpresa.getValueAt(numFilaSeleccionada, 2));
        empresaSeleccionada.setDireccion((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 3));
        empresaSeleccionada.setDuenio((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 4));
        empresaSeleccionada.setAmbito((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 5));
        empresaSeleccionada.setEmail((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 7));
        empresaSeleccionada.setTutor((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 8));
        empresaSeleccionada.setEmail_contacto((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 9));
        empresaSeleccionada.setTelefono_contacto((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 10));
        empresaSeleccionada.setNombre_contacto((String) tablaEmpresa.getValueAt(numFilaSeleccionada, 11));
    }//GEN-LAST:event_tablaEmpresaMouseClicked

   

    private void tfBusquedaFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_tfBusquedaFocusGained
        if (tfBusqueda.getText().equals("Busque por cualquier campo")) {
            tfBusqueda.setText("");
            tfBusqueda.setForeground(new Color(0, 0, 0));
        }
    }// GEN-LAST:event_tfBusquedaFocusGained

    private void tfBusquedaFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_tfBusquedaFocusLost
        if (tfBusqueda.getText().isEmpty()) {
            tfBusqueda.setText("Busque por cualquier campo");
            tfBusqueda.setForeground(new Color(204, 204, 204));
        }
    }// GEN-LAST:event_tfBusquedaFocusLost

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel2MouseEntered
        jPanel2.setBackground(botonSeleccionado);
    }// GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel2MouseExited
        jPanel2.setBackground(botonNoSeleccionado);
    }// GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel2MouseClicked
        List<Empresa> empresas = null;
        if (!tfBusqueda.getText().equals("Busque por cualquier campo")) {
            empresas = empresaMetodos.rellenarListaEmpresa(
                    "SELECT * FROM empresa WHERE CAST(\"idEmpresa\" AS TEXT) LIKE '%" + tfBusqueda.getText() 
                    +"%' "
                    + "OR \"idEmpresa\" LIKE '%" +tfBusqueda.getText() + "%' "
                    + "or nombre LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR cif LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR direccion LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR dueño LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR ambito LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR telefono LIKE '%" + tfBusqueda.getText() + "%' "       
                    + "OR email LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR tutor LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR telefono_contacto LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR nombre_contacto LIKE '%" + tfBusqueda.getText() + "%' "
                    + "OR email_contacto LIKE '%" + tfBusqueda.getText() + "%' ");
                    //+ "ORDER BY \"idEmpresa\" ASC");
            tablaEmpresa = empresaMetodos.rellenarTablaEmpresa(tablaEmpresa, empresas);
        }
    }// GEN-LAST:event_jPanel2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable tablaEmpresa;
    public static javax.swing.JTextField tfBusqueda;
    // End of variables declaration//GEN-END:variables
}