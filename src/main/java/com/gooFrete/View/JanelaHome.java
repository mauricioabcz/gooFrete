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
public class JanelaHome extends javax.swing.JPanel {

    public JanelaHome() {
        initComponents();
        this.traduzir();
        setColor(btn_1); 
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaCadastros,btn_JanelaRotas}, new JPanel[]{ind_2,ind_3, ind_4});
    }

    public void traduzir(){
        this.lb_SoftwareName.setText(Janela.traducao.getString("lb_SoftwareName"));
        this.lb_Home.setText(Janela.traducao.getString("lb_Home"));
        this.lb_Cadastros.setText(Janela.traducao.getString("lb_Cadastros"));
        this.lb_Rotas.setText(Janela.traducao.getString("lb_Rotas"));
        this.lb_Relatorios.setText(Janela.traducao.getString("lb_Relatorios"));
        this.lb_Settings.setText(Janela.traducao.getString("lb_Settings"));
        this.lb_Logout.setText(Janela.traducao.getString("lb_Logout"));
        this.lb_PT.setText(Janela.traducao.getString("lb_Portugues"));
        this.lb_US.setText(Janela.traducao.getString("lb_English"));
        this.lb_LT.setText(Janela.traducao.getString("lb_Latin"));
        this.lb_ES.setText(Janela.traducao.getString("lb_Spanish"));
        this.lb_FR.setText(Janela.traducao.getString("lb_French"));
        this.lb_GE.setText(Janela.traducao.getString("lb_Germany"));
        this.lb_JP.setText(Janela.traducao.getString("lb_Japan"));
        this.lb_IT.setText(Janela.traducao.getString("lb_Italian"));
    }
    
    public void trocaLingua(String targetLanguage, String targetCountry){
        Janela.loadLanguage(targetLanguage, targetCountry);
        traduzir();
    }
    
    public void gotoJanelaCadastros(){
        Janela.p2 = new JanelaCadastros();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p1);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p2, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaRotas(){
        Janela.p5 = new JanelaRotas();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p1);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p5, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaRelatorios(){
        Janela.p6 = new JanelaRelatorios();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p1);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p6, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_pane = new javax.swing.JPanel();
        btn_1 = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        lb_Home = new javax.swing.JLabel();
        btn_JanelaRelatorios = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        lb_Relatorios = new javax.swing.JLabel();
        btn_JanelaCadastros = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        lb_Cadastros = new javax.swing.JLabel();
        btn_JanelaRotas = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        lb_Rotas = new javax.swing.JLabel();
        btn_5 = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        lb_Settings = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lb_PT = new javax.swing.JLabel();
        lb_US = new javax.swing.JLabel();
        lb_ES = new javax.swing.JLabel();
        lb_JP = new javax.swing.JLabel();
        lb_LT = new javax.swing.JLabel();
        lb_IT = new javax.swing.JLabel();
        lb_FR = new javax.swing.JLabel();
        lb_GE = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lb_Logout = new javax.swing.JLabel();
        lb_SoftwareName = new javax.swing.JLabel();

        side_pane.setBackground(new java.awt.Color(23, 35, 51));
        side_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setBackground(new java.awt.Color(23, 35, 51));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_1MousePressed(evt);
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

        lb_Home.setForeground(new java.awt.Color(255, 255, 255));
        lb_Home.setText("Home");

        javax.swing.GroupLayout btn_1Layout = new javax.swing.GroupLayout(btn_1);
        btn_1.setLayout(btn_1Layout);
        btn_1Layout.setHorizontalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Home)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_1Layout.setVerticalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, -1));

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

        lb_Relatorios.setForeground(new java.awt.Color(255, 255, 255));
        lb_Relatorios.setText("Relatórios");

        javax.swing.GroupLayout btn_JanelaRelatoriosLayout = new javax.swing.GroupLayout(btn_JanelaRelatorios);
        btn_JanelaRelatorios.setLayout(btn_JanelaRelatoriosLayout);
        btn_JanelaRelatoriosLayout.setHorizontalGroup(
            btn_JanelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Relatorios)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        btn_JanelaRelatoriosLayout.setVerticalGroup(
            btn_JanelaRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaRelatoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Relatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lb_Cadastros.setForeground(new java.awt.Color(255, 255, 255));
        lb_Cadastros.setText("Cadastros");

        javax.swing.GroupLayout btn_JanelaCadastrosLayout = new javax.swing.GroupLayout(btn_JanelaCadastros);
        btn_JanelaCadastros.setLayout(btn_JanelaCadastrosLayout);
        btn_JanelaCadastrosLayout.setHorizontalGroup(
            btn_JanelaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaCadastrosLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Cadastros)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_JanelaCadastrosLayout.setVerticalGroup(
            btn_JanelaCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaCadastrosLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaCadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Cadastros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lb_Rotas.setForeground(new java.awt.Color(255, 255, 255));
        lb_Rotas.setText("Rotas");

        javax.swing.GroupLayout btn_JanelaRotasLayout = new javax.swing.GroupLayout(btn_JanelaRotas);
        btn_JanelaRotas.setLayout(btn_JanelaRotasLayout);
        btn_JanelaRotasLayout.setHorizontalGroup(
            btn_JanelaRotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRotasLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Rotas)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        btn_JanelaRotasLayout.setVerticalGroup(
            btn_JanelaRotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaRotasLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaRotasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Rotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaRotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, -1));

        btn_5.setBackground(new java.awt.Color(23, 35, 51));
        btn_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_5MouseReleased(evt);
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

        lb_Settings.setForeground(new java.awt.Color(255, 255, 255));
        lb_Settings.setText("Settings");

        javax.swing.GroupLayout btn_5Layout = new javax.swing.GroupLayout(btn_5);
        btn_5.setLayout(btn_5Layout);
        btn_5Layout.setHorizontalGroup(
            btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_5Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Settings)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        btn_5Layout.setVerticalGroup(
            btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_5Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 120, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lb_PT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_PT.setIcon(new javax.swing.ImageIcon(".\\images\\brasil.png"));
        lb_PT.setText("Português");
        lb_PT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_PT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_PTMousePressed(evt);
            }
        });

        lb_US.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_US.setIcon(new javax.swing.ImageIcon(".\\images\\eua.png"));
        lb_US.setText("Inglês");
        lb_US.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_US.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_USMousePressed(evt);
            }
        });

        lb_ES.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_ES.setIcon(new javax.swing.ImageIcon(".\\images\\espanha.png"));
        lb_ES.setText("Espanhol");
        lb_ES.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_ES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_ESMousePressed(evt);
            }
        });

        lb_JP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_JP.setIcon(new javax.swing.ImageIcon(".\\images\\japao.png"));
        lb_JP.setText("Japonês");
        lb_JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_JP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_JPMousePressed(evt);
            }
        });

        lb_LT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_LT.setIcon(new javax.swing.ImageIcon(".\\images\\vaticano.png"));
        lb_LT.setText("Latim");
        lb_LT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_LT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_LTMousePressed(evt);
            }
        });

        lb_IT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_IT.setIcon(new javax.swing.ImageIcon(".\\images\\italia.png"));
        lb_IT.setText("Italiano");
        lb_IT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_IT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_ITMousePressed(evt);
            }
        });

        lb_FR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_FR.setIcon(new javax.swing.ImageIcon(".\\images\\franca.png"));
        lb_FR.setText("Francês");
        lb_FR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_FR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_FRMousePressed(evt);
            }
        });

        lb_GE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_GE.setIcon(new javax.swing.ImageIcon(".\\images\\alemanha.png"));
        lb_GE.setText("Alemão");
        lb_GE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_GE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_GEMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_PT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_US, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_ES, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_JP, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_LT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_IT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_FR, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_GE, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_PT)
                    .addComponent(lb_US)
                    .addComponent(lb_ES)
                    .addComponent(lb_JP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_LT)
                    .addComponent(lb_IT)
                    .addComponent(lb_FR)
                    .addComponent(lb_GE))
                .addGap(320, 320, 320))
        );

        jPanel2.setBackground(new java.awt.Color(71, 120, 197));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        lb_Logout.setForeground(new java.awt.Color(255, 255, 255));
        lb_Logout.setIcon(new javax.swing.ImageIcon(".\\images\\iconExit.png"));
        lb_Logout.setText("Logout");
        lb_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_LogoutMousePressed(evt);
            }
        });

        lb_SoftwareName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_SoftwareName.setForeground(new java.awt.Color(255, 255, 255));
        lb_SoftwareName.setText("gooFrete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_SoftwareName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_Logout)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_SoftwareName)
                            .addComponent(lb_Logout))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(0, 0, 0)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed
        // TODO add your handling code here:
        setColor(btn_1);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaCadastros,btn_JanelaRotas, btn_5}, new JPanel[]{ind_2,ind_3, ind_4, ind_5});
    }//GEN-LAST:event_btn_1MousePressed

    private void btn_JanelaRelatoriosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaRelatoriosMouseReleased
        // TODO add your handling code here:
        setColor(btn_JanelaRelatorios);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_1,btn_JanelaCadastros,btn_JanelaRotas, btn_5}, new JPanel[]{ind_1,ind_3, ind_4, ind_5});
        gotoJanelaRelatorios();
    }//GEN-LAST:event_btn_JanelaRelatoriosMouseReleased

    private void btn_JanelaCadastrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaCadastrosMousePressed
        // TODO add your handling code here:
        setColor(btn_JanelaCadastros);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_1,btn_JanelaRotas, btn_5}, new JPanel[]{ind_2,ind_1, ind_4, ind_5});
        gotoJanelaCadastros();
    }//GEN-LAST:event_btn_JanelaCadastrosMousePressed

    private void btn_JanelaRotasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaRotasMousePressed
        // TODO add your handling code here:
        setColor(btn_JanelaRotas);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaCadastros,btn_1, btn_5}, new JPanel[]{ind_2,ind_3, ind_1, ind_5});
        gotoJanelaRotas();
    }//GEN-LAST:event_btn_JanelaRotasMousePressed

    private void btn_5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseReleased
        // TODO add your handling code here:
        setColor(btn_5);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{btn_1,btn_JanelaCadastros,btn_JanelaRotas, btn_JanelaRelatorios}, new JPanel[]{ind_1,ind_3, ind_4, ind_2});
        ReturnMessagePane.informationPainel(Janela.traducao.getString("alert_EmObras"));
    }//GEN-LAST:event_btn_5MouseReleased

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:

        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        Janela.j.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    int xx, xy;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void lb_LogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_LogoutMousePressed
        System.exit(0);
    }//GEN-LAST:event_lb_LogoutMousePressed

    private void lb_PTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PTMousePressed
        trocaLingua("pt", "BR");
    }//GEN-LAST:event_lb_PTMousePressed

    private void lb_USMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_USMousePressed
        trocaLingua("en", "US");
    }//GEN-LAST:event_lb_USMousePressed

    private void lb_ESMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ESMousePressed
        trocaLingua("es", "ES");
    }//GEN-LAST:event_lb_ESMousePressed

    private void lb_JPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_JPMousePressed
        trocaLingua("ja", "JP");
    }//GEN-LAST:event_lb_JPMousePressed

    private void lb_LTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_LTMousePressed
        trocaLingua("la", "VA");
    }//GEN-LAST:event_lb_LTMousePressed

    private void lb_ITMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ITMousePressed
        trocaLingua("it", "IT");
    }//GEN-LAST:event_lb_ITMousePressed

    private void lb_FRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_FRMousePressed
        trocaLingua("fr", "FR");
    }//GEN-LAST:event_lb_FRMousePressed

    private void lb_GEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_GEMousePressed
        trocaLingua("de", "DE");
    }//GEN-LAST:event_lb_GEMousePressed

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
    private javax.swing.JPanel btn_1;
    private javax.swing.JPanel btn_5;
    private javax.swing.JPanel btn_JanelaCadastros;
    private javax.swing.JPanel btn_JanelaRelatorios;
    private javax.swing.JPanel btn_JanelaRotas;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lb_Cadastros;
    private javax.swing.JLabel lb_ES;
    private javax.swing.JLabel lb_FR;
    private javax.swing.JLabel lb_GE;
    private javax.swing.JLabel lb_Home;
    private javax.swing.JLabel lb_IT;
    private javax.swing.JLabel lb_JP;
    private javax.swing.JLabel lb_LT;
    private javax.swing.JLabel lb_Logout;
    private javax.swing.JLabel lb_PT;
    private javax.swing.JLabel lb_Relatorios;
    private javax.swing.JLabel lb_Rotas;
    private javax.swing.JLabel lb_Settings;
    private javax.swing.JLabel lb_SoftwareName;
    private javax.swing.JLabel lb_US;
    private javax.swing.JPanel side_pane;
    // End of variables declaration//GEN-END:variables
}
