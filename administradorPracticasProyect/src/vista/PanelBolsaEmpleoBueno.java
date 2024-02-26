/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.BBDD;
import controlador.BolsaTrabajoMetodos;
import elementos.Notification;
import elementos.mensaje.message.MessageDialog;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Empresa;

/**
 *
 * @author LinkA
 */
public class PanelBolsaEmpleoBueno extends javax.swing.JPanel {
    
    Color botonSeleccionado = new Color(230, 161, 2);
    Color botonNoSeleccionado = new Color(254, 177, 3);

    BolsaTrabajoMetodos bolsaMetodos = new BolsaTrabajoMetodos();
    BBDD bbdd = new BBDD();
    Alumno alumnoSeleccionado;
    Empresa empresaSeleccionada;
    
    public PanelBolsaEmpleoBueno() {
        initComponents();
        
        tablaAlumnos.setRowHeight(49);
        tablaEmpresas.setRowHeight(49);
        
        List<Empresa> empresas = bbdd.obtenerListaEmpresasBuscando();
        List<Alumno> alumnos = bbdd.obtenerListaAlumnosBuscando();
        
        DefaultTableModel modeloAlumnos = (DefaultTableModel) tablaAlumnos.getModel();
        DefaultTableModel modeloEmpresas = (DefaultTableModel) tablaEmpresas.getModel();
        
        modeloAlumnos = bolsaMetodos.rellenarTablaAlumnos(modeloAlumnos, alumnos);
        modeloEmpresas = bolsaMetodos.rellenarTablaEmpresas(modeloEmpresas, empresas);
        
        tablaAlumnos.setModel(modeloAlumnos);
        tablaEmpresas.setModel(modeloEmpresas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tfBusqueda = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        tfBusqueda1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpresas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfAlumno = new javax.swing.JTextField();
        tfEmpresa = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

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
                        .addComponent(tfBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
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
        gridBagConstraints.ipadx = 248;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tfBusqueda1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tfBusqueda1.setForeground(new java.awt.Color(204, 204, 204));
        tfBusqueda1.setText("Busque en cualquier campo");
        tfBusqueda1.setBorder(null);
        tfBusqueda1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBusqueda1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBusqueda1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tfBusqueda1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jSeparator2)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tfBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(254, 177, 3));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar (Personalizado).png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 228;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 109, 0, 10);
        add(jPanel4, gridBagConstraints);

        tablaAlumnos.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Alumno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAlumnos.setSelectionBackground(new java.awt.Color(254, 177, 3));
        tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 360;
        gridBagConstraints.ipady = 526;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 11, 0);
        add(jScrollPane1, gridBagConstraints);

        tablaEmpresas.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tablaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Empresa", "Ámbito"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEmpresas.setSelectionBackground(new java.awt.Color(254, 177, 3));
        tablaEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpresasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaEmpresas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 362;
        gridBagConstraints.ipady = 526;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 11, 10);
        add(jScrollPane2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setText("Alumno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(73, 16, 0, 0);
        add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("Empresa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(64, 16, 0, 0);
        add(jLabel4, gridBagConstraints);

        tfAlumno.setForeground(new java.awt.Color(204, 204, 204));
        tfAlumno.setText("Nombre del alumno");
        tfAlumno.setBorder(null);
        tfAlumno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfAlumnoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAlumnoFocusLost(evt);
            }
        });
        tfAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlumnoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 258;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 16, 0, 0);
        add(tfAlumno, gridBagConstraints);

        tfEmpresa.setForeground(new java.awt.Color(204, 204, 204));
        tfEmpresa.setText("Nombre de la empresa");
        tfEmpresa.setBorder(null);
        tfEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfEmpresaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEmpresaFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 258;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 16, 0, 0);
        add(tfEmpresa, gridBagConstraints);

        jPanel10.setBackground(new java.awt.Color(254, 177, 3));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("Conectar");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(62, 96, 0, 0);
        add(jPanel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 257;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 16, 0, 0);
        add(jSeparator3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 257;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 16, 0, 0);
        add(jSeparator4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tfBusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBusquedaFocusGained
        if (tfBusqueda.getText().equals("Busque en cualquier campo")) {
            tfBusqueda.setText("");
            tfBusqueda.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_tfBusquedaFocusGained

    private void tfBusquedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBusquedaFocusLost
        if (tfBusqueda.getText().isEmpty()) {
            tfBusqueda.setText("Busque en cualquier campo");
            tfBusqueda.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_tfBusquedaFocusLost

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        String valorIntroducidoAlumnos = tfBusqueda.getText();
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaAlumnos.getModel();
        if (valorIntroducidoAlumnos.equalsIgnoreCase("Busque en cualquier campo") || valorIntroducidoAlumnos.isEmpty()) {
            Notification notifiacion = new Notification((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this), Notification.Type.INFO, Notification.Location.TOP_CENTER, "El campo de búsqueda se encuentra vacío");
            notifiacion.showNotification();
            List<Alumno> alumnos = bbdd.obtenerListaAlumnosBuscando();
            tablaAlumnos.setModel(bolsaMetodos.rellenarTablaAlumnos(modeloTabla, alumnos));
        } else {
            List<Alumno> alumnos = bbdd.obtenerListaAlumnosBuscandoPorPalabra(valorIntroducidoAlumnos);
            tablaAlumnos.setModel(bolsaMetodos.rellenarTablaAlumnos(modeloTabla, alumnos));
        }
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        jPanel2.setBackground(botonSeleccionado);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jPanel2.setBackground(botonNoSeleccionado);
    }//GEN-LAST:event_jPanel2MouseExited

    private void tfBusqueda1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBusqueda1FocusGained
        if (tfBusqueda1.getText().equals("Busque en cualquier campo")) {
            tfBusqueda1.setText("");
            tfBusqueda1.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_tfBusqueda1FocusGained

    private void tfBusqueda1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBusqueda1FocusLost
        if (tfBusqueda1.getText().isEmpty()) {
            tfBusqueda1.setText("Busque en cualquier campo");
            tfBusqueda1.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_tfBusqueda1FocusLost

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        String valorIntroducidoEmpresas = tfBusqueda1.getText();
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaEmpresas.getModel();
        if (valorIntroducidoEmpresas.equalsIgnoreCase("Busque en cualquier campo") || valorIntroducidoEmpresas.isEmpty()) {
            Notification notifiacion = new Notification((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this), Notification.Type.INFO, Notification.Location.TOP_CENTER, "El campo de búsqueda se encuentra vacío");
            notifiacion.showNotification();
            List<Empresa> empresas = bbdd.obtenerListaEmpresasBuscando();
            tablaEmpresas.setModel(bolsaMetodos.rellenarTablaEmpresas(modeloTabla, empresas));
        } else {
            List<Empresa> empresas = bbdd.obtenerListaEmpresasBuscandoPorPalabra(valorIntroducidoEmpresas);
            tablaEmpresas.setModel(bolsaMetodos.rellenarTablaEmpresas(modeloTabla, empresas));
        }
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        jPanel6.setBackground(botonSeleccionado);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        jPanel6.setBackground(botonSeleccionado);
    }//GEN-LAST:event_jPanel6MouseExited

    private void tfAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAlumnoActionPerformed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        MessageDialog mensaje = new MessageDialog((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this));
        mensaje.showMessage("Confirmación de conexión", "¿Está seguro de querer crear esta conexión?");
        if (mensaje.getMessageType() == MessageDialog.MessageType.OK) {
            int numFilas = bbdd.agregarBolsa(alumnoSeleccionado, empresaSeleccionada);
            bbdd.quitarBuscandoAlumno(alumnoSeleccionado.getId());
            if (numFilas == 1) {
                DefaultTableModel modeloAlumnos = (DefaultTableModel) tablaAlumnos.getModel();
                List<Alumno> alumnos = bbdd.obtenerListaAlumnosBuscando();
                tablaAlumnos.setModel(bolsaMetodos.rellenarTablaAlumnos(modeloAlumnos, alumnos));
                Notification notificacion = new Notification((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Conexión realizada con éxito!");
                notificacion.showNotification();
            } else {
                Notification notificacion = new Notification((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this), Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Conexión no realizada");
                notificacion.showNotification();
            }
        }else{
            Notification notificacion = new Notification((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this), Notification.Type.INFO, Notification.Location.TOP_CENTER, "Se ha cancelado la conexión");
            notificacion.showNotification();
        }
        
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        jPanel10.setBackground(botonSeleccionado);
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        jPanel10.setBackground(botonNoSeleccionado);
    }//GEN-LAST:event_jPanel10MouseExited

    
    
    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
        int numeroFila = tablaAlumnos.getSelectedRow();
        if (numeroFila >= 0) {
            int id = (int) tablaAlumnos.getValueAt(numeroFila, 0);
            System.out.println(id + "de empresa");
            Alumno alumno = new Alumno();
            alumno = bbdd.obtenerAlumno(id);
            tfAlumno.setText(alumno.getNombre() + " " + alumno.getApellidos());
            tfAlumno.setForeground(Color.BLACK);
            alumnoSeleccionado = alumno;
        }
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void tablaEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpresasMouseClicked
        int numeroFila = tablaEmpresas.getSelectedRow();
        if (numeroFila >= 0) {
            int id = (int) tablaEmpresas.getValueAt(numeroFila, 0);
            System.out.println(id + "de empresa");
            Empresa empresa = new Empresa();
            empresa = bbdd.obtenerEmpresa(id);
            tfEmpresa.setText(empresa.getNombre());
            tfEmpresa.setForeground(Color.BLACK);
            empresaSeleccionada = empresa;
        }
    }//GEN-LAST:event_tablaEmpresasMouseClicked

    private void tfAlumnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAlumnoFocusGained
        if (tfAlumno.getText().equals("Busque en cualquier campo")) {
            tfAlumno.setText("");
            tfAlumno.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_tfAlumnoFocusGained

    private void tfAlumnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAlumnoFocusLost
        if (tfAlumno.getText().isEmpty()) {
            tfAlumno.setText("Busque en cualquier campo");
            tfAlumno.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_tfAlumnoFocusLost

    private void tfEmpresaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmpresaFocusGained
        if (tfEmpresa.getText().equals("Busque en cualquier campo")) {
            tfEmpresa.setText("");
            tfEmpresa.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_tfEmpresaFocusGained

    private void tfEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmpresaFocusLost
        if (tfEmpresa.getText().isEmpty()) {
            tfEmpresa.setText("Busque en cualquier campo");
            tfEmpresa.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_tfEmpresaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTable tablaEmpresas;
    private javax.swing.JTextField tfAlumno;
    private javax.swing.JTextField tfBusqueda;
    private javax.swing.JTextField tfBusqueda1;
    private javax.swing.JTextField tfEmpresa;
    // End of variables declaration//GEN-END:variables
}
