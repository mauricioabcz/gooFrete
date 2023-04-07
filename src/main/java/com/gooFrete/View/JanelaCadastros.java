package com.gooFrete.View;

import com.gooFrete.Model.ReturnMessagePane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mauricio.rodrigues
 */
public class JanelaCadastros extends javax.swing.JPanel {

    public JanelaCadastros() {
        initComponents();
        setColor(btn_JanelaCadastros); 
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_Home,btn_JanelaRotas, btn_JanelaSettings}, new JPanel[]{ind_2,ind_1, ind_4, ind_5});
    }
    public void gotoJanelaHome(){
        Janela.p1 = new JanelaHome();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p2);
        janela.getContentPane().remove(Janela.p2);
        janela.add(Janela.p1, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaCadastroTransportadores(){
        Janela.p3 = new JanelaCadastroTransportador();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p2);
        janela.getContentPane().remove(Janela.p2);
        janela.add(Janela.p3, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaCadastroVeiculos(){
        Janela.p4 = new JanelaCadastroVeiculo();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p2);
        janela.getContentPane().remove(Janela.p2);
        janela.add(Janela.p4, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaRotas(){
        Janela.p5 = new JanelaRotas();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p2);
        janela.getContentPane().remove(Janela.p2);
        janela.add(Janela.p5, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaRelatorios(){
        Janela.p6 = new JanelaRelatorios();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p2);
        janela.getContentPane().remove(Janela.p2);
        janela.add(Janela.p6, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_pane = new javax.swing.JPanel();
        btn_Home = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_JanelaRelatorios = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_JanelaCadastros = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_JanelaRotas = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_JanelaSettings = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_JanelaCadastroTransportador = new javax.swing.JLabel();
        btn_JanelaCadastroVeiculos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        side_pane.setBackground(new java.awt.Color(23, 35, 51));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Home.setBackground(new java.awt.Color(23, 35, 51));
        btn_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HomeMousePressed(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Home");

        javax.swing.GroupLayout btn_HomeLayout = new javax.swing.GroupLayout(btn_Home);
        btn_Home.setLayout(btn_HomeLayout);
        btn_HomeLayout.setHorizontalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_HomeLayout.setVerticalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, -1));

        btn_JanelaRelatorios.setBackground(new java.awt.Color(23, 35, 51));
        btn_JanelaRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_JanelaRelatoriosMouseReleased(evt);
            }
        });

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Relatórios");

        javax.swing.GroupLayout btn_JanelaRelatoriosLayout = new javax.swing.GroupLayout(btn_JanelaRelatorios);
        btn_JanelaRelatorios.setLayout(btn_JanelaRelatoriosLayout);
        btn_JanelaRelatoriosLayout.setHorizontalGroup(
            btn_JanelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        btn_JanelaRelatoriosLayout.setVerticalGroup(
            btn_JanelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaRelatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 120, -1));

        btn_JanelaCadastros.setBackground(new java.awt.Color(23, 35, 51));
        btn_JanelaCadastros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_JanelaCadastrosMousePressed(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cadastros");

        javax.swing.GroupLayout btn_JanelaCadastrosLayout = new javax.swing.GroupLayout(btn_JanelaCadastros);
        btn_JanelaCadastros.setLayout(btn_JanelaCadastrosLayout);
        btn_JanelaCadastrosLayout.setHorizontalGroup(
            btn_JanelaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaCadastrosLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_JanelaCadastrosLayout.setVerticalGroup(
            btn_JanelaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaCadastrosLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaCadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaCadastros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 120, -1));

        btn_JanelaRotas.setBackground(new java.awt.Color(23, 35, 51));
        btn_JanelaRotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_JanelaRotasMousePressed(evt);
            }
        });

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Rotas");

        javax.swing.GroupLayout btn_JanelaRotasLayout = new javax.swing.GroupLayout(btn_JanelaRotas);
        btn_JanelaRotas.setLayout(btn_JanelaRotasLayout);
        btn_JanelaRotasLayout.setHorizontalGroup(
            btn_JanelaRotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRotasLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        btn_JanelaRotasLayout.setVerticalGroup(
            btn_JanelaRotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRotasLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaRotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaRotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, -1));

        btn_JanelaSettings.setBackground(new java.awt.Color(23, 35, 51));
        btn_JanelaSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_JanelaSettingsMouseReleased(evt);
            }
        });

        ind_5.setOpaque(false);
        ind_5.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Settings");

        javax.swing.GroupLayout btn_JanelaSettingsLayout = new javax.swing.GroupLayout(btn_JanelaSettings);
        btn_JanelaSettings.setLayout(btn_JanelaSettingsLayout);
        btn_JanelaSettingsLayout.setHorizontalGroup(
            btn_JanelaSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel12)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        btn_JanelaSettingsLayout.setVerticalGroup(
            btn_JanelaSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 120, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btn_JanelaCadastroTransportador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_JanelaCadastroTransportador.setIcon(new javax.swing.ImageIcon(".\\images\\carrierBtn.png"));
        btn_JanelaCadastroTransportador.setText("Transportador");
        btn_JanelaCadastroTransportador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_JanelaCadastroTransportador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_JanelaCadastroTransportadorMousePressed(evt);
            }
        });

        btn_JanelaCadastroVeiculos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_JanelaCadastroVeiculos.setIcon(new javax.swing.ImageIcon(".\\images\\equipmentBtn.png"));
        btn_JanelaCadastroVeiculos.setText("     Veículos");
        btn_JanelaCadastroVeiculos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_JanelaCadastroVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_JanelaCadastroVeiculosMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_JanelaCadastroTransportador, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_JanelaCadastroVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(496, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_JanelaCadastroTransportador)
                    .addComponent(btn_JanelaCadastroVeiculos))
                .addContainerGap(436, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(71, 120, 197));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(".\\images\\iconExit.png"));
        jLabel2.setText("Logout");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cadastros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:
        setColor(btn_Home);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaCadastros,btn_JanelaRotas, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_4, ind_5});
        gotoJanelaHome();
    }//GEN-LAST:event_btn_HomeMousePressed

    private void btn_JanelaRelatoriosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaRelatoriosMouseReleased
        // TODO add your handling code here:
        setColor(btn_JanelaRelatorios);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_Home,btn_JanelaCadastros,btn_JanelaRotas, btn_JanelaSettings}, new JPanel[]{ind_1,ind_3, ind_4, ind_5});
        gotoJanelaRelatorios();
    }//GEN-LAST:event_btn_JanelaRelatoriosMouseReleased

    private void btn_JanelaCadastrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaCadastrosMousePressed
        // TODO add your handling code here:
        setColor(btn_JanelaCadastros);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_Home,btn_JanelaRotas, btn_JanelaSettings}, new JPanel[]{ind_2,ind_1, ind_4, ind_5});
        gotoJanelaRelatorios();
    }//GEN-LAST:event_btn_JanelaCadastrosMousePressed

    private void btn_JanelaRotasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaRotasMousePressed
        // TODO add your handling code here:
        setColor(btn_JanelaRotas);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaCadastros,btn_Home, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_1, ind_5});
        gotoJanelaRotas();
    }//GEN-LAST:event_btn_JanelaRotasMousePressed

    private void btn_JanelaSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaSettingsMouseReleased
        // TODO add your handling code here:
        setColor(btn_JanelaSettings);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{btn_Home,btn_JanelaCadastros,btn_JanelaRotas, btn_JanelaRelatorios}, new JPanel[]{ind_1,ind_3, ind_4, ind_2});
        ReturnMessagePane.informationPainel("Função em desenvolvimento.");
    }//GEN-LAST:event_btn_JanelaSettingsMouseReleased

    private void btn_JanelaCadastroTransportadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaCadastroTransportadorMousePressed
        gotoJanelaCadastroTransportadores();
    }//GEN-LAST:event_btn_JanelaCadastroTransportadorMousePressed

    private void btn_JanelaCadastroVeiculosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaCadastroVeiculosMousePressed
        gotoJanelaCadastroVeiculos();
    }//GEN-LAST:event_btn_JanelaCadastroVeiculosMousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:

        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        Janela.j.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel1MousePressed

    int xx, xy;
        private void setColor(JPanel pane)
    {
        pane.setBackground(new Color(41,57,80));
    }
    
    private void resetColor(JPanel [] pane, JPanel [] indicators)
    {
        for(int i=0;i<pane.length;i++){
           pane[i].setBackground(new Color(23,35,51));
           
        } for(int i=0;i<indicators.length;i++){
           indicators[i].setOpaque(false);           
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_Home;
    private javax.swing.JLabel btn_JanelaCadastroTransportador;
    private javax.swing.JLabel btn_JanelaCadastroVeiculos;
    private javax.swing.JPanel btn_JanelaCadastros;
    private javax.swing.JPanel btn_JanelaRelatorios;
    private javax.swing.JPanel btn_JanelaRotas;
    private javax.swing.JPanel btn_JanelaSettings;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel side_pane;
    // End of variables declaration//GEN-END:variables
}
