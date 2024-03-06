/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.MenuMetodos;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import modelo.TIPOUSUARIO;

/**
 *
 * @author LinkA
 */
public class PanelMenu extends javax.swing.JPanel {
    Color botonSeleccionado = new Color(230, 161, 2);
    Color botonNoSeleccionado = new Color(254, 177, 3);
    Color tagSeleccionado = new Color(0, 0, 0);
    Color tagNoSeleccionado = new Color(104, 104, 104);
    MenuMetodos menuMetodos = new MenuMetodos();

    /**
     * Creates new form PanelMenu
     */
    public PanelMenu() {
        initComponents();
        if (PanelLogin.usuarioIniciado.getTipousuario()== TIPOUSUARIO.TUTOR) {
            PanelBotonMenuIzqUsuarios.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMenuIzquierda = new javax.swing.JPanel();
        PanelTituloMenuIzquierda = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        PanelBotonmenuIzqMenu = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelBotonmenuIzqAlumnos1 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        PanelBotonMenuIzqEmpresas = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelBotonMenuIzqBolsaEmpleo = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PanelBotonMenuIzqNecesidades = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PanelBotonMenuIzqUsuarios = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SeparadorInferiorMenuIzq = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        PanelBotonMenuIzqAnexo = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        PanelCentralMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        PanelMenuIzquierda.setBackground(new java.awt.Color(254, 177, 3));
        PanelMenuIzquierda.setMaximumSize(new java.awt.Dimension(100, 196602));
        PanelMenuIzquierda.setMinimumSize(new java.awt.Dimension(200, 0));
        PanelMenuIzquierda.setLayout(new javax.swing.BoxLayout(PanelMenuIzquierda, javax.swing.BoxLayout.Y_AXIS));

        PanelTituloMenuIzquierda.setBackground(new java.awt.Color(254, 177, 3));
        PanelTituloMenuIzquierda.setPreferredSize(new java.awt.Dimension(200, 100));
        PanelTituloMenuIzquierda.setLayout(new javax.swing.BoxLayout(PanelTituloMenuIzquierda, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel6.setText("Menú principal");
        PanelTituloMenuIzquierda.add(jLabel6);

        PanelMenuIzquierda.add(PanelTituloMenuIzquierda);

        PanelBotonmenuIzqMenu.setBackground(new java.awt.Color(254, 177, 3));
        PanelBotonmenuIzqMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelBotonmenuIzqMenu.setMaximumSize(new java.awt.Dimension(250, 50));
        PanelBotonmenuIzqMenu.setMinimumSize(new java.awt.Dimension(0, 50));
        PanelBotonmenuIzqMenu.setPreferredSize(new java.awt.Dimension(162, 70));
        PanelBotonmenuIzqMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelBotonmenuIzqMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBotonmenuIzqMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBotonmenuIzqMenuMouseExited(evt);
            }
        });
        PanelBotonmenuIzqMenu.setLayout(new javax.swing.BoxLayout(PanelBotonmenuIzqMenu, javax.swing.BoxLayout.LINE_AXIS));

        jPanel10.setBackground(new java.awt.Color(104, 104, 104));
        jPanel10.setMaximumSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelBotonmenuIzqMenu.add(jPanel10);

        jLabel13.setText("   ");
        PanelBotonmenuIzqMenu.add(jLabel13);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/casa (Personalizado).png"))); // NOI18N
        PanelBotonmenuIzqMenu.add(jLabel3);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("  Menú");
        PanelBotonmenuIzqMenu.add(jLabel1);

        PanelMenuIzquierda.add(PanelBotonmenuIzqMenu);

        PanelBotonmenuIzqAlumnos1.setBackground(new java.awt.Color(254, 177, 3));
        PanelBotonmenuIzqAlumnos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelBotonmenuIzqAlumnos1.setMaximumSize(new java.awt.Dimension(250, 50));
        PanelBotonmenuIzqAlumnos1.setMinimumSize(new java.awt.Dimension(0, 50));
        PanelBotonmenuIzqAlumnos1.setPreferredSize(new java.awt.Dimension(162, 70));
        PanelBotonmenuIzqAlumnos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelBotonmenuIzqAlumnos1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBotonmenuIzqAlumnos1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBotonmenuIzqAlumnos1MouseExited(evt);
            }
        });
        PanelBotonmenuIzqAlumnos1.setLayout(new javax.swing.BoxLayout(PanelBotonmenuIzqAlumnos1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel16.setBackground(new java.awt.Color(104, 104, 104));
        jPanel16.setMaximumSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelBotonmenuIzqAlumnos1.add(jPanel16);

        jLabel20.setText("   ");
        PanelBotonmenuIzqAlumnos1.add(jLabel20);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfil (Personalizado).png"))); // NOI18N
        PanelBotonmenuIzqAlumnos1.add(jLabel21);

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel22.setText("  Alumnos");
        PanelBotonmenuIzqAlumnos1.add(jLabel22);

        PanelMenuIzquierda.add(PanelBotonmenuIzqAlumnos1);

        PanelBotonMenuIzqEmpresas.setBackground(new java.awt.Color(254, 177, 3));
        PanelBotonMenuIzqEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelBotonMenuIzqEmpresas.setMaximumSize(new java.awt.Dimension(250, 50));
        PanelBotonMenuIzqEmpresas.setMinimumSize(new java.awt.Dimension(0, 50));
        PanelBotonMenuIzqEmpresas.setPreferredSize(new java.awt.Dimension(162, 70));
        PanelBotonMenuIzqEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqEmpresasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqEmpresasMouseExited(evt);
            }
        });
        PanelBotonMenuIzqEmpresas.setLayout(new javax.swing.BoxLayout(PanelBotonMenuIzqEmpresas, javax.swing.BoxLayout.LINE_AXIS));

        jPanel11.setBackground(new java.awt.Color(104, 104, 104));
        jPanel11.setMaximumSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelBotonMenuIzqEmpresas.add(jPanel11);

        jLabel14.setText("   ");
        PanelBotonMenuIzqEmpresas.add(jLabel14);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/oficina (Personalizado).png"))); // NOI18N
        PanelBotonMenuIzqEmpresas.add(jLabel4);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("  Empresas");
        PanelBotonMenuIzqEmpresas.add(jLabel7);
        PanelBotonMenuIzqEmpresas.add(jLabel2);

        PanelMenuIzquierda.add(PanelBotonMenuIzqEmpresas);

        PanelBotonMenuIzqBolsaEmpleo.setBackground(new java.awt.Color(254, 177, 3));
        PanelBotonMenuIzqBolsaEmpleo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelBotonMenuIzqBolsaEmpleo.setMaximumSize(new java.awt.Dimension(250, 50));
        PanelBotonMenuIzqBolsaEmpleo.setMinimumSize(new java.awt.Dimension(0, 50));
        PanelBotonMenuIzqBolsaEmpleo.setPreferredSize(new java.awt.Dimension(162, 70));
        PanelBotonMenuIzqBolsaEmpleo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqBolsaEmpleoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqBolsaEmpleoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqBolsaEmpleoMouseExited(evt);
            }
        });
        PanelBotonMenuIzqBolsaEmpleo.setLayout(new javax.swing.BoxLayout(PanelBotonMenuIzqBolsaEmpleo, javax.swing.BoxLayout.LINE_AXIS));

        jPanel12.setBackground(new java.awt.Color(104, 104, 104));
        jPanel12.setMaximumSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelBotonMenuIzqBolsaEmpleo.add(jPanel12);

        jLabel15.setText("   ");
        PanelBotonMenuIzqBolsaEmpleo.add(jLabel15);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/maletin (Personalizado).png"))); // NOI18N
        PanelBotonMenuIzqBolsaEmpleo.add(jLabel5);

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("  Bolsa de empleo");
        PanelBotonMenuIzqBolsaEmpleo.add(jLabel8);

        PanelMenuIzquierda.add(PanelBotonMenuIzqBolsaEmpleo);

        PanelBotonMenuIzqNecesidades.setBackground(new java.awt.Color(254, 177, 3));
        PanelBotonMenuIzqNecesidades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelBotonMenuIzqNecesidades.setMaximumSize(new java.awt.Dimension(250, 50));
        PanelBotonMenuIzqNecesidades.setMinimumSize(new java.awt.Dimension(0, 50));
        PanelBotonMenuIzqNecesidades.setPreferredSize(new java.awt.Dimension(162, 70));
        PanelBotonMenuIzqNecesidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqNecesidadesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqNecesidadesMouseExited(evt);
            }
        });
        PanelBotonMenuIzqNecesidades.setLayout(new javax.swing.BoxLayout(PanelBotonMenuIzqNecesidades, javax.swing.BoxLayout.LINE_AXIS));

        jPanel13.setBackground(new java.awt.Color(104, 104, 104));
        jPanel13.setMaximumSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelBotonMenuIzqNecesidades.add(jPanel13);

        jLabel16.setText("   ");
        PanelBotonMenuIzqNecesidades.add(jLabel16);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu (Personalizado).png"))); // NOI18N
        PanelBotonMenuIzqNecesidades.add(jLabel11);

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setText("  Necesidades");
        PanelBotonMenuIzqNecesidades.add(jLabel9);

        PanelMenuIzquierda.add(PanelBotonMenuIzqNecesidades);

        PanelBotonMenuIzqUsuarios.setBackground(new java.awt.Color(254, 177, 3));
        PanelBotonMenuIzqUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelBotonMenuIzqUsuarios.setMaximumSize(new java.awt.Dimension(250, 50));
        PanelBotonMenuIzqUsuarios.setMinimumSize(new java.awt.Dimension(0, 50));
        PanelBotonMenuIzqUsuarios.setPreferredSize(new java.awt.Dimension(162, 70));
        PanelBotonMenuIzqUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqUsuariosMouseExited(evt);
            }
        });
        PanelBotonMenuIzqUsuarios.setLayout(new javax.swing.BoxLayout(PanelBotonMenuIzqUsuarios, javax.swing.BoxLayout.LINE_AXIS));

        jPanel14.setBackground(new java.awt.Color(104, 104, 104));
        jPanel14.setMaximumSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelBotonMenuIzqUsuarios.add(jPanel14);

        jLabel17.setText("   ");
        PanelBotonMenuIzqUsuarios.add(jLabel17);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cuenta (Personalizado).png"))); // NOI18N
        PanelBotonMenuIzqUsuarios.add(jLabel12);

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setText("  Usuarios");
        PanelBotonMenuIzqUsuarios.add(jLabel10);

        PanelMenuIzquierda.add(PanelBotonMenuIzqUsuarios);

        SeparadorInferiorMenuIzq.setBackground(new java.awt.Color(254, 177, 3));
        SeparadorInferiorMenuIzq.setMaximumSize(new java.awt.Dimension(250, 10023232));

        jPanel15.setBackground(new java.awt.Color(254, 177, 3));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
        });
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion (Personalizado).png"))); // NOI18N
        jLabel18.setText("Cerrar sesión");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.setMaximumSize(null);
        jLabel18.setMinimumSize(null);
        jLabel18.setPreferredSize(null);
        jPanel15.add(jLabel18, java.awt.BorderLayout.CENTER);

        PanelBotonMenuIzqAnexo.setBackground(new java.awt.Color(254, 177, 3));
        PanelBotonMenuIzqAnexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelBotonMenuIzqAnexo.setMaximumSize(new java.awt.Dimension(250, 50));
        PanelBotonMenuIzqAnexo.setMinimumSize(new java.awt.Dimension(0, 50));
        PanelBotonMenuIzqAnexo.setPreferredSize(new java.awt.Dimension(162, 70));
        PanelBotonMenuIzqAnexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqAnexoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqAnexoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelBotonMenuIzqAnexoMouseExited(evt);
            }
        });
        PanelBotonMenuIzqAnexo.setLayout(new javax.swing.BoxLayout(PanelBotonMenuIzqAnexo, javax.swing.BoxLayout.LINE_AXIS));

        jPanel17.setBackground(new java.awt.Color(104, 104, 104));
        jPanel17.setMaximumSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PanelBotonMenuIzqAnexo.add(jPanel17);

        jLabel19.setText("     ");
        PanelBotonMenuIzqAnexo.add(jLabel19);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconAnexo22.png"))); // NOI18N
        jLabel23.setText("   ");
        PanelBotonMenuIzqAnexo.add(jLabel23);

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel24.setText("Anexo2.2");
        PanelBotonMenuIzqAnexo.add(jLabel24);

        javax.swing.GroupLayout SeparadorInferiorMenuIzqLayout = new javax.swing.GroupLayout(SeparadorInferiorMenuIzq);
        SeparadorInferiorMenuIzq.setLayout(SeparadorInferiorMenuIzqLayout);
        SeparadorInferiorMenuIzqLayout.setHorizontalGroup(
            SeparadorInferiorMenuIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SeparadorInferiorMenuIzqLayout.createSequentialGroup()
                .addComponent(PanelBotonMenuIzqAnexo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        SeparadorInferiorMenuIzqLayout.setVerticalGroup(
            SeparadorInferiorMenuIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeparadorInferiorMenuIzqLayout.createSequentialGroup()
                .addComponent(PanelBotonMenuIzqAnexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelMenuIzquierda.add(SeparadorInferiorMenuIzq);

        add(PanelMenuIzquierda, java.awt.BorderLayout.LINE_START);

        PanelCentralMenu.setBackground(new java.awt.Color(255, 255, 255));
        PanelCentralMenu.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1065, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );

        PanelCentralMenu.add(jPanel1, "card2");

        add(PanelCentralMenu, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void PanelBotonmenuIzqMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonmenuIzqMenuMouseEntered
        PanelBotonmenuIzqMenu.setBackground(botonSeleccionado);
        jPanel10.setBackground(tagSeleccionado);
    }//GEN-LAST:event_PanelBotonmenuIzqMenuMouseEntered

    private void PanelBotonmenuIzqMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonmenuIzqMenuMouseExited
        PanelBotonmenuIzqMenu.setBackground(botonNoSeleccionado);
        jPanel10.setBackground(tagNoSeleccionado);
    }//GEN-LAST:event_PanelBotonmenuIzqMenuMouseExited

    private void PanelBotonmenuIzqAlumnos1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonmenuIzqAlumnos1MouseEntered
        PanelBotonmenuIzqAlumnos1.setBackground(botonSeleccionado);
        jPanel16.setBackground(tagSeleccionado);
    }//GEN-LAST:event_PanelBotonmenuIzqAlumnos1MouseEntered

    private void PanelBotonmenuIzqAlumnos1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonmenuIzqAlumnos1MouseExited
        PanelBotonmenuIzqAlumnos1.setBackground(botonNoSeleccionado);
        jPanel16.setBackground(tagNoSeleccionado);
    }//GEN-LAST:event_PanelBotonmenuIzqAlumnos1MouseExited

    private void PanelBotonmenuIzqAlumnos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonmenuIzqAlumnos1MouseClicked
        PanelCentralMenu = menuMetodos.cambioPanel(new PanelAlumnos(), PanelCentralMenu);
    }//GEN-LAST:event_PanelBotonmenuIzqAlumnos1MouseClicked

    private void PanelBotonMenuIzqUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonMenuIzqUsuariosMouseClicked
        PanelCentralMenu = menuMetodos.cambioPanel(new PanelUsuarios(), PanelCentralMenu);
    }//GEN-LAST:event_PanelBotonMenuIzqUsuariosMouseClicked

    private void PanelBotonMenuIzqBolsaEmpleoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonMenuIzqBolsaEmpleoMouseClicked
        PanelCentralMenu = menuMetodos.cambioPanel(new PanelBolsaEmpleoBueno(), PanelCentralMenu);
    }//GEN-LAST:event_PanelBotonMenuIzqBolsaEmpleoMouseClicked

    private void PanelBotonmenuIzqMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonmenuIzqMenuMouseClicked
       
    }//GEN-LAST:event_PanelBotonmenuIzqMenuMouseClicked

    private void PanelBotonMenuIzqAnexoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonMenuIzqAnexoMouseClicked
        PanelCentralMenu = menuMetodos.cambioPanel(new PanelAnexo22(), PanelCentralMenu);
    }//GEN-LAST:event_PanelBotonMenuIzqAnexoMouseClicked

    private void PanelBotonMenuIzqAnexoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonMenuIzqAnexoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelBotonMenuIzqAnexoMouseEntered

    private void PanelBotonMenuIzqAnexoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBotonMenuIzqAnexoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelBotonMenuIzqAnexoMouseExited

    private void PanelBotonMenuIzqEmpresasMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBotonMenuIzqEmpresasMouseEntered
        PanelBotonMenuIzqEmpresas.setBackground(botonSeleccionado);
        jPanel11.setBackground(tagSeleccionado);
    }// GEN-LAST:event_PanelBotonMenuIzqEmpresasMouseEntered

    private void PanelBotonMenuIzqEmpresasMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBotonMenuIzqEmpresasMouseExited
        PanelBotonMenuIzqEmpresas.setBackground(botonNoSeleccionado);
        jPanel11.setBackground(tagNoSeleccionado);
    }// GEN-LAST:event_PanelBotonMenuIzqEmpresasMouseExited

    private void PanelBotonMenuIzqBolsaEmpleoMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBotonMenuIzqBolsaEmpleoMouseEntered
        PanelBotonMenuIzqBolsaEmpleo.setBackground(botonSeleccionado);
        jPanel12.setBackground(tagSeleccionado);
    }// GEN-LAST:event_PanelBotonMenuIzqBolsaEmpleoMouseEntered

    private void PanelBotonMenuIzqBolsaEmpleoMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBotonMenuIzqBolsaEmpleoMouseExited
        PanelBotonMenuIzqBolsaEmpleo.setBackground(botonNoSeleccionado);
        jPanel12.setBackground(tagNoSeleccionado);
    }// GEN-LAST:event_PanelBotonMenuIzqBolsaEmpleoMouseExited

    private void PanelBotonMenuIzqNecesidadesMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBotonMenuIzqNecesidadesMouseEntered
        PanelBotonMenuIzqNecesidades.setBackground(botonSeleccionado);
        jPanel13.setBackground(tagSeleccionado);
    }// GEN-LAST:event_PanelBotonMenuIzqNecesidadesMouseEntered

    private void PanelBotonMenuIzqNecesidadesMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBotonMenuIzqNecesidadesMouseExited
        PanelBotonMenuIzqNecesidades.setBackground(botonNoSeleccionado);
        jPanel13.setBackground(tagNoSeleccionado);
    }// GEN-LAST:event_PanelBotonMenuIzqNecesidadesMouseExited

    private void PanelBotonMenuIzqUsuariosMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBotonMenuIzqUsuariosMouseEntered
        PanelBotonMenuIzqUsuarios.setBackground(botonSeleccionado);
        jPanel14.setBackground(tagSeleccionado);
    }// GEN-LAST:event_PanelBotonMenuIzqUsuariosMouseEntered

    private void PanelBotonMenuIzqUsuariosMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelBotonMenuIzqUsuariosMouseExited
        PanelBotonMenuIzqUsuarios.setBackground(botonNoSeleccionado);
        jPanel14.setBackground(tagNoSeleccionado);
    }// GEN-LAST:event_PanelBotonMenuIzqUsuariosMouseExited

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel15MouseEntered
        jPanel15.setBackground(botonSeleccionado);
    }// GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel15MouseExited
        jPanel15.setBackground(botonNoSeleccionado);
    }// GEN-LAST:event_jPanel15MouseExited

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel15MouseClicked
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.dispose();
        PanelLogin panelLogin = new PanelLogin();
        panelLogin.setVisible(true);
    }// GEN-LAST:event_jPanel15MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotonMenuIzqAnexo;
    private javax.swing.JPanel PanelBotonMenuIzqBolsaEmpleo;
    private javax.swing.JPanel PanelBotonMenuIzqEmpresas;
    private javax.swing.JPanel PanelBotonMenuIzqNecesidades;
    private javax.swing.JPanel PanelBotonMenuIzqUsuarios;
    private javax.swing.JPanel PanelBotonmenuIzqAlumnos1;
    private javax.swing.JPanel PanelBotonmenuIzqMenu;
    private javax.swing.JPanel PanelCentralMenu;
    private javax.swing.JPanel PanelMenuIzquierda;
    private javax.swing.JPanel PanelTituloMenuIzquierda;
    private javax.swing.JPanel SeparadorInferiorMenuIzq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    // End of variables declaration//GEN-END:variables
}
