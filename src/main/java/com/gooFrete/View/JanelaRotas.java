package com.gooFrete.View;

import com.gooFrete.Controller.CarrierController;
import com.gooFrete.Controller.EquipmentController;
import com.gooFrete.Controller.ViagemController;
import com.gooFrete.Model.Carrier;
import com.gooFrete.Model.Equipment;
import com.gooFrete.Model.ReturnMessagePane;
import com.gooFrete.Model.Travel;
import com.gooFrete.Model.Viagem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 *
 * @author mauricio.rodrigues
 */
public class JanelaRotas extends javax.swing.JPanel {

    private List<Equipment> listaVeiculos;
    private List<Carrier> listaTransportadores;
    private List<Carrier> listaTransportadoresVinculados;
    private List<Travel> listaViagens;
    private CarrierController carrierController;
    private EquipmentController equipmentController;
    private ViagemController viagemController;
    
    public JanelaRotas() {
        initComponents();
        traduzir();
        if (Janela.selectLanguage.equals("ja_JP")) {
            ajustaFonteJapones();
        } else {
            ajustaFonteOutros();
        }
        setColor(btn_4); 
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_Home,btn_JanelaCadastros, btn_JanelaSettings}, new JPanel[]{ind_2,ind_1, ind_3, ind_5});
        
        equipmentController = new EquipmentController();
        carrierController = new CarrierController();
        viagemController = new ViagemController();
        cb_Veiculos.setEnabled(false);
        atualizaTabela();
        
    }
    
    public void traduzir(){
        this.lb_TelaRotasTitle.setText(Janela.traducao.getString("lb_TelaRotasTitle"));
        this.lb_Home.setText(Janela.traducao.getString("lb_Home"));
        this.lb_Cadastros.setText(Janela.traducao.getString("lb_Cadastros"));
        this.lb_Rotas.setText(Janela.traducao.getString("lb_Rotas"));
        this.lb_Relatorios.setText(Janela.traducao.getString("lb_Relatorios"));
        this.lb_Settings.setText(Janela.traducao.getString("lb_Settings"));
        this.lb_Logout.setText(Janela.traducao.getString("lb_Logout"));
        this.lb_TipoPedagio.setText(Janela.traducao.getString("lb_TipoPedagio"));
        this.lb_Transportador.setText(Janela.traducao.getString("lb_Transportador"));
        this.lb_Veiculo.setText(Janela.traducao.getString("lb_Veiculo"));
        this.lb_AdicionarDestino.setText(Janela.traducao.getString("lb_AdicionarDestino"));
        this.bt_Limpar.setText(Janela.traducao.getString("bt_Limpar"));
        this.bt_Att.setText(Janela.traducao.getString("bt_Atualizar"));
        this.bt_RemoverViagem.setText(Janela.traducao.getString("bt_Remover"));
        this.bt_RemoverDestino.setText(Janela.traducao.getString("bt_Remover"));
        this.bt_Calcular.setText(Janela.traducao.getString("bt_Calcular"));
        this.bt_Sobe.setText(Janela.traducao.getString("bt_Sobe"));
        this.bt_Desce.setText(Janela.traducao.getString("bt_Desce"));
        this.bt_AtdicionarDestino.setText(Janela.traducao.getString("bt_AdicionarDestino"));
        this.bt_Details.setText(Janela.traducao.getString("bt_Detalhes"));
        this.lb_NovoVeiculo.setText(Janela.traducao.getString("lb_NovoVeiculo"));
        this.lb_DestinosSelecionados.setText(Janela.traducao.getString("bt_DestinosSelecionados"));
        this.tabelaViagens.getColumnModel().getColumn(0).setHeaderValue(Janela.traducao.getString("tb_Tipo"));
        this.tabelaViagens.getColumnModel().getColumn(1).setHeaderValue(Janela.traducao.getString("tb_Viagem"));
        this.tabelaViagens.getColumnModel().getColumn(2).setHeaderValue(Janela.traducao.getString("tb_CNPJCPF"));
        this.tabelaViagens.getColumnModel().getColumn(3).setHeaderValue(Janela.traducao.getString("tb_Transportador"));
        this.tabelaViagens.getColumnModel().getColumn(4).setHeaderValue(Janela.traducao.getString("tb_Distancia"));
        this.tabelaViagens.getColumnModel().getColumn(5).setHeaderValue(Janela.traducao.getString("tb_Duracao"));
        this.tabelaDestinos.getColumnModel().getColumn(0).setHeaderValue(Janela.traducao.getString("tb_Ordem"));
        this.tabelaDestinos.getColumnModel().getColumn(1).setHeaderValue(Janela.traducao.getString("tb_CidadeETC"));
        
    }
    
    public void ajustaFonteJapones(){
        // Define a fonte desejada
        Font fonte4 = new Font("MS Gothic", Font.PLAIN, 14);
        Font fonte2 = new Font("MS Gothic", Font.PLAIN, 12);
        Font fonte3 = new Font("MS Gothic", Font.PLAIN, 18);
        // Aplica a fonte às labels
        this.lb_TelaRotasTitle.setFont(fonte3);
        this.lb_NovoVeiculo.setFont(fonte4);
        this.lb_DestinosSelecionados.setFont(fonte4);
        this.lb_Home.setFont(fonte2);
        this.lb_Cadastros.setFont(fonte2);
        this.lb_Rotas.setFont(fonte2);
        this.lb_Relatorios.setFont(fonte2);
        this.lb_Settings.setFont(fonte2);
        this.lb_Logout.setFont(fonte2);
    }
    
    public void ajustaFonteOutros(){
        // Define a fonte desejada
        Font fonte4 = new Font("Segoe UI", Font.PLAIN, 14);
        Font fonte2 = new Font("Segoe UI", Font.PLAIN, 12);
        Font fonte3 = new Font("Segoe UI", Font.PLAIN, 18);
        // Aplica a fonte às labels
        this.lb_TelaRotasTitle.setFont(fonte3);
        this.lb_NovoVeiculo.setFont(fonte4);
        this.lb_DestinosSelecionados.setFont(fonte4);
        this.lb_Home.setFont(fonte2);
        this.lb_Cadastros.setFont(fonte2);
        this.lb_Rotas.setFont(fonte2);
        this.lb_Relatorios.setFont(fonte2);
        this.lb_Settings.setFont(fonte2);
        this.lb_Logout.setFont(fonte2);
    }
    
    public void gotoJanelaHome(){
        Janela.p1 = new JanelaHome();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p5);
        janela.getContentPane().remove(Janela.p5);
        janela.add(Janela.p1, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaCadastros(){
        Janela.p2 = new JanelaCadastros();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p5);
        janela.getContentPane().remove(Janela.p5);
        janela.add(Janela.p2, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaRelatorios(){
        Janela.p6 = new JanelaRelatorios();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p5);
        janela.getContentPane().remove(Janela.p5);
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
        lb_Home = new javax.swing.JLabel();
        btn_JanelaRelatorios = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        lb_Relatorios = new javax.swing.JLabel();
        btn_JanelaCadastros = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        lb_Cadastros = new javax.swing.JLabel();
        btn_4 = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        lb_Rotas = new javax.swing.JLabel();
        btn_JanelaSettings = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        lb_Settings = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaViagens = new javax.swing.JTable();
        bt_Att = new javax.swing.JButton();
        bt_RemoverViagem = new javax.swing.JButton();
        lb_NovoVeiculo = new javax.swing.JLabel();
        lb_TipoPedagio = new javax.swing.JLabel();
        lb_Transportador = new javax.swing.JLabel();
        bt_Details = new javax.swing.JButton();
        cb_Transportadores = new javax.swing.JComboBox<>();
        bt_Limpar = new javax.swing.JButton();
        bt_Calcular = new javax.swing.JButton();
        lb_DestinosSelecionados = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDestinos = new javax.swing.JTable();
        bt_AtdicionarDestino = new javax.swing.JButton();
        cb_TipoPedagio = new javax.swing.JComboBox<>();
        lb_Veiculo = new javax.swing.JLabel();
        cb_Veiculos = new javax.swing.JComboBox<>();
        lb_AdicionarDestino = new javax.swing.JLabel();
        tf_Destino = new javax.swing.JTextField();
        bt_RemoverDestino = new javax.swing.JButton();
        bt_Desce = new javax.swing.JButton();
        bt_Sobe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lb_Logout = new javax.swing.JLabel();
        lb_TelaRotasTitle = new javax.swing.JLabel();

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

        lb_Home.setForeground(new java.awt.Color(255, 255, 255));
        lb_Home.setText("Home");

        javax.swing.GroupLayout btn_HomeLayout = new javax.swing.GroupLayout(btn_Home);
        btn_Home.setLayout(btn_HomeLayout);
        btn_HomeLayout.setHorizontalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Home)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btn_HomeLayout.setVerticalGroup(
            btn_HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btn_4.setBackground(new java.awt.Color(23, 35, 51));
        btn_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_4MousePressed(evt);
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

        javax.swing.GroupLayout btn_4Layout = new javax.swing.GroupLayout(btn_4);
        btn_4.setLayout(btn_4Layout);
        btn_4Layout.setHorizontalGroup(
            btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Rotas)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        btn_4Layout.setVerticalGroup(
            btn_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_4Layout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Rotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, -1));

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

        lb_Settings.setForeground(new java.awt.Color(255, 255, 255));
        lb_Settings.setText("Settings");

        javax.swing.GroupLayout btn_JanelaSettingsLayout = new javax.swing.GroupLayout(btn_JanelaSettings);
        btn_JanelaSettings.setLayout(btn_JanelaSettingsLayout);
        btn_JanelaSettingsLayout.setHorizontalGroup(
            btn_JanelaSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lb_Settings)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        btn_JanelaSettingsLayout.setVerticalGroup(
            btn_JanelaSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_JanelaSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        side_pane.add(btn_JanelaSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 120, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tabelaViagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Viagem", "CNPJ/CPF", "Transportador", "Distância", "Duração", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaViagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaViagensMouseClicked(evt);
            }
        });
        tabelaViagens.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaViagensKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaViagens);

        bt_Att.setBackground(new java.awt.Color(255, 255, 255));
        bt_Att.setText("Atualizar");
        bt_Att.setFocusPainted(false);
        bt_Att.setFocusable(false);
        bt_Att.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AttActionPerformed(evt);
            }
        });

        bt_RemoverViagem.setBackground(new java.awt.Color(255, 255, 255));
        bt_RemoverViagem.setText("Remover");
        bt_RemoverViagem.setFocusPainted(false);
        bt_RemoverViagem.setFocusable(false);
        bt_RemoverViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RemoverViagemActionPerformed(evt);
            }
        });

        lb_NovoVeiculo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_NovoVeiculo.setText("Novo Veículo");

        lb_TipoPedagio.setText("Tipo Pedágio:");

        lb_Transportador.setText("Transportador:");

        bt_Details.setBackground(new java.awt.Color(255, 255, 255));
        bt_Details.setText("Detalhes");
        bt_Details.setFocusPainted(false);
        bt_Details.setFocusable(false);
        bt_Details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_DetailsMouseClicked(evt);
            }
        });

        cb_Transportadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cb_Transportadores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_TransportadoresItemStateChanged(evt);
            }
        });

        bt_Limpar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Limpar.setText("Limpar");
        bt_Limpar.setFocusPainted(false);
        bt_Limpar.setFocusable(false);
        bt_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LimparActionPerformed(evt);
            }
        });

        bt_Calcular.setBackground(new java.awt.Color(255, 255, 255));
        bt_Calcular.setText("Calcular");
        bt_Calcular.setFocusPainted(false);
        bt_Calcular.setFocusable(false);
        bt_Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CalcularActionPerformed(evt);
            }
        });

        lb_DestinosSelecionados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_DestinosSelecionados.setText("Destinos Selecionados");

        tabelaDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Cidade/CEP/Código IBGE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(tabelaDestinos);

        bt_AtdicionarDestino.setBackground(new java.awt.Color(255, 255, 255));
        bt_AtdicionarDestino.setText("Adicionar Destino");
        bt_AtdicionarDestino.setFocusPainted(false);
        bt_AtdicionarDestino.setFocusable(false);
        bt_AtdicionarDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AtdicionarDestinoActionPerformed(evt);
            }
        });

        cb_TipoPedagio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Cartão", "Tag" }));

        lb_Veiculo.setText("Veículo:");

        cb_Veiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        lb_AdicionarDestino.setText("Adicionar destino:");

        bt_RemoverDestino.setBackground(new java.awt.Color(255, 255, 255));
        bt_RemoverDestino.setText("Remover");
        bt_RemoverDestino.setFocusPainted(false);
        bt_RemoverDestino.setFocusable(false);
        bt_RemoverDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RemoverDestinoActionPerformed(evt);
            }
        });

        bt_Desce.setBackground(new java.awt.Color(255, 255, 255));
        bt_Desce.setText("Desce");
        bt_Desce.setFocusPainted(false);
        bt_Desce.setFocusable(false);
        bt_Desce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DesceActionPerformed(evt);
            }
        });

        bt_Sobe.setBackground(new java.awt.Color(255, 255, 255));
        bt_Sobe.setText("Sobe");
        bt_Sobe.setFocusPainted(false);
        bt_Sobe.setFocusable(false);
        bt_Sobe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SobeActionPerformed(evt);
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
                        .addComponent(bt_Att)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Details)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_RemoverViagem))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(bt_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_AtdicionarDestino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Calcular))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(bt_RemoverDestino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_Sobe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_Desce))
                            .addComponent(lb_NovoVeiculo)
                            .addComponent(lb_DestinosSelecionados)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_Transportador)
                                    .addComponent(lb_TipoPedagio))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_Transportadores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_TipoPedagio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_Veiculo)
                                    .addComponent(lb_AdicionarDestino))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_Veiculos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tf_Destino))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_NovoVeiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_TipoPedagio)
                            .addComponent(cb_TipoPedagio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Transportador)
                            .addComponent(cb_Transportadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Veiculo)
                            .addComponent(cb_Veiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_AdicionarDestino)
                            .addComponent(tf_Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Calcular)
                            .addComponent(bt_AtdicionarDestino)
                            .addComponent(bt_Limpar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_DestinosSelecionados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Att)
                    .addComponent(bt_RemoverViagem)
                    .addComponent(bt_Details)
                    .addComponent(bt_RemoverDestino)
                    .addComponent(bt_Desce)
                    .addComponent(bt_Sobe))
                .addContainerGap())
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

        lb_TelaRotasTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TelaRotasTitle.setForeground(new java.awt.Color(255, 255, 255));
        lb_TelaRotasTitle.setText("Rotas > Gerenciar Viagens");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_TelaRotasTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_Logout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
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
                            .addComponent(lb_TelaRotasTitle)
                            .addComponent(lb_Logout))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:
        setColor(btn_Home);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaCadastros,btn_4, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_4, ind_5});
        gotoJanelaHome();
    }//GEN-LAST:event_btn_HomeMousePressed

    private void atualizaTabela(){
        listaVeiculos = equipmentController.equipmentQueryAll();
        listaTransportadores = carrierController.carrierQueryAll();
        String carrierName, carrierCNPJCPF, carrierComboBox;
        
        //Atualiza lista
        cb_Transportadores.removeAllItems();
        cb_Transportadores.addItem("Selecione");
        for (int i = 0; i < listaTransportadores.size(); i++) {
            
            carrierName = listaTransportadores.get(i).getCarrierName();
            if (listaTransportadores.get(i).getCarrierType() == 0) {
                carrierCNPJCPF = formatarCPF(listaTransportadores.get(i).getCarrierCNPJCPF());
            } else {
                carrierCNPJCPF = formatarCNPJ(listaTransportadores.get(i).getCarrierCNPJCPF());
            }
            carrierComboBox = carrierName + " - " + carrierCNPJCPF;
            cb_Transportadores.addItem(carrierComboBox);
        }
        
        //Atualiza tabela
        listaViagens = viagemController.travelQueryAll();
        String tipoPagamento, carrierCNPJCPFTable;
        
        ((DefaultTableModel) tabelaViagens.getModel()).setRowCount(0);
        for (int i = 0; i < listaViagens.size(); i++) {
            
            tipoPagamento = (listaViagens.get(i).getTipoPagamento() == 0) ? "Cartão" : "Tag";
            carrierCNPJCPFTable =  listaViagens.get(i).getCarrierCNPJCPF();
            if (carrierCNPJCPFTable.length() == 11) {
                carrierCNPJCPFTable = formatarCPF(carrierCNPJCPFTable);
            } else {
                carrierCNPJCPFTable = formatarCNPJ(carrierCNPJCPFTable);
            }
            
            ((DefaultTableModel) tabelaViagens.getModel()).addRow(new Object[]{
                tipoPagamento,
                listaViagens.get(i).getIdentification(),
                carrierCNPJCPFTable,
                listaViagens.get(i).getCarrierName(),
                listaViagens.get(i).getDistancia(),
                listaViagens.get(i).getDuracao(),
                listaViagens.get(i).getValor()
            });
        }
        
    }
    
    public void removeDestino(){
        int selectedRowIndex = tabelaDestinos.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tabelaDestinos.getModel();
        model.removeRow(selectedRowIndex);

        // Atualizar o número da coluna índice após a remoção
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i+1, i, 0); 
        }
        
        tabelaDestinos.repaint();
    }
    
    public void sobeDestino(){
        int selectedRowIndex = tabelaDestinos.getSelectedRow();
        // Verificar se a linha selecionada não é a primeira linha
        if (selectedRowIndex > 0) {
            DefaultTableModel model = (DefaultTableModel) tabelaDestinos.getModel();

            // Obter os dados da linha selecionada
            Object[] rowData = new Object[tabelaDestinos.getColumnCount()];
            for (int i = 0; i < tabelaDestinos.getColumnCount(); i++) {
                rowData[i] = tabelaDestinos.getValueAt(selectedRowIndex, i);
            }

            // Remover a linha selecionada
            model.removeRow(selectedRowIndex);

            // Inserir a linha armazenada na posição anterior à linha selecionada
            model.insertRow(selectedRowIndex - 1, rowData);

            // Atualizar as posições das linhas restantes
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(i + 1, i, 0);
            }
        }
    }
    
    public void desdeDestino(){
        int selectedRowIndex = tabelaDestinos.getSelectedRow();
        // Verificar se a linha selecionada não é a última linha
        if (selectedRowIndex < tabelaDestinos.getRowCount() - 1) {
            DefaultTableModel model = (DefaultTableModel) tabelaDestinos.getModel();
            // Obter os dados da linha selecionada
            Object[] rowData = new Object[tabelaDestinos.getColumnCount()];
            for (int i = 0; i < tabelaDestinos.getColumnCount(); i++) {
                rowData[i] = tabelaDestinos.getValueAt(selectedRowIndex, i);
            }

            // Remover a linha selecionada
            model.removeRow(selectedRowIndex);

            // Inserir a linha armazenada na posição posterior à linha selecionada
            model.insertRow(selectedRowIndex + 1, rowData);

            // Atualizar as posições das linhas restantes
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(i + 1, i, 0);
            }
        }
    }
    
    private void atualizaVinculosComVeiculos(){
        //Pega nome selecionado
        String carrierCNPJCPF;
        carrierCNPJCPF = cb_Transportadores.getSelectedItem().toString();
        carrierCNPJCPF = encontraCNPJCPF(carrierCNPJCPF);
        carrierCNPJCPF = removerFormatacao(carrierCNPJCPF);
        System.out.println(carrierCNPJCPF);
        
        //Faz a pesquisa
        listaVeiculos = carrierController.equipmentVinculados(carrierCNPJCPF);
        String tipoVeiculo, placa, equipmentComboBox;
        int eixos;
        
        //Atualiza tabela
        //Atualiza lista
        cb_Veiculos.removeAllItems();
        cb_Veiculos.addItem("Selecione");
        for (int i = 0; i < listaVeiculos.size(); i++) {
            eixos = listaVeiculos.get(i).getEixos();
            placa = listaVeiculos.get(i).getLicensePlate();
            tipoVeiculo = listaVeiculos.get(i).getEquipmentType();

            equipmentComboBox = tipoVeiculo + " - Placa: " + placa + " - Número de Eixos: " + eixos;
            cb_Veiculos.addItem(equipmentComboBox);
        }
        cb_Veiculos.setEnabled(true);
    }
    
    private void adicionarDestino(){
        String destino;
        int numeroLinhas;
        
        destino = tf_Destino.getText();
        numeroLinhas = tabelaDestinos.getRowCount();
        
        ((DefaultTableModel) tabelaDestinos.getModel()).addRow(new Object[]{
                numeroLinhas + 1,
                destino
            });
    }
    
    public void processaViagem() throws IOException{
        String nomeTransportador, transportadorCNPJCPF, tipoVeiculo, tipoPedagio, placa; 
        int numEixos, tipoPagamento = -1; 
        String paradas = "";

        //Extrai tipoVeiculo
        // Separar a string em um array de strings
        String[] parts = cb_Veiculos.getSelectedItem().toString().split(" - ");
        // Obter os elementos do array, que corresponde ao tipo de veículo e placa
        tipoVeiculo = removerAcentos(parts[0]);
        placa = extrairPlaca(parts[1]);
        
        //Extrai numEixos
        numEixos =  Integer.parseInt(removerFormatacao(parts[2]));
         
        for (int i = 0; i < tabelaDestinos.getRowCount(); i++) {
            Object cellValue = tabelaDestinos.getValueAt(i, 1);
                if (i == 0) {
                    paradas = removerAcentos(cellValue.toString());
                } else {
                    paradas = paradas + ";" + removerAcentos(cellValue.toString());
                }
        }
        
        //Extrai tipoPagamento
        tipoPedagio = cb_TipoPedagio.getSelectedItem().toString();
        if (tipoPedagio.equals("Cartão")) {
            tipoPagamento = 0;
        }
        if (tipoPedagio.equals("Tag")) {
            tipoPagamento = 1;
        }
        
        //Extrai tipoVeiculo
        // Separar a string em um array de strings
        parts = cb_Transportadores.getSelectedItem().toString().split(" - ");
        // Obter os elementos do array, que corresponde ao nome e CNPJ do transportador
        transportadorCNPJCPF = removerFormatacao(parts[1]);
        nomeTransportador = parts[0];
        
        //Solicita cálculo
        Viagem viagem = new Viagem(nomeTransportador, transportadorCNPJCPF, tipoVeiculo, placa, numEixos, tipoPagamento,paradas);
        System.out.println(viagem.toString());
        boolean status = viagemController.processaViagem(viagem);
        if (status) System.out.println("Viagem processada com sucesso.");
    }
    
    public void removerViagem(){
        String viagemIdentification = (String) tabelaViagens.getModel().getValueAt(tabelaViagens.getSelectedRow() ,2);
        boolean status = viagemController.removerViagem(viagemIdentification);
        if (status) System.out.println("Viagem removida com sucesso.");;
    }
    
    private void btn_JanelaRelatoriosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaRelatoriosMouseReleased
        // TODO add your handling code here:
        setColor(btn_JanelaRelatorios);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btn_Home,btn_JanelaCadastros,btn_4, btn_JanelaSettings}, new JPanel[]{ind_1,ind_3, ind_4, ind_5});
        gotoJanelaRelatorios();
    }//GEN-LAST:event_btn_JanelaRelatoriosMouseReleased

    private void btn_JanelaCadastrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaCadastrosMousePressed
        // TODO add your handling code here:
        setColor(btn_JanelaCadastros);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_Home,btn_4, btn_JanelaSettings}, new JPanel[]{ind_2,ind_1, ind_4, ind_5});
        gotoJanelaCadastros();
    }//GEN-LAST:event_btn_JanelaCadastrosMousePressed

    private void btn_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MousePressed
        // TODO add your handling code here:
        setColor(btn_4);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaCadastros,btn_Home, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_1, ind_5});
    }//GEN-LAST:event_btn_4MousePressed

    private void btn_JanelaSettingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_JanelaSettingsMouseReleased
        // TODO add your handling code here:
        setColor(btn_JanelaSettings);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{btn_Home,btn_JanelaCadastros,btn_4, btn_JanelaRelatorios}, new JPanel[]{ind_1,ind_3, ind_4, ind_2});
        ReturnMessagePane.informationPainel(Janela.traducao.getString("alert_EmObras"));
    }//GEN-LAST:event_btn_JanelaSettingsMouseReleased

    private void lb_LogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_LogoutMousePressed
        System.exit(0);
    }//GEN-LAST:event_lb_LogoutMousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:

        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        Janela.j.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void bt_SobeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SobeActionPerformed
        sobeDestino();
    }//GEN-LAST:event_bt_SobeActionPerformed

    private void bt_DesceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DesceActionPerformed
        desdeDestino();
    }//GEN-LAST:event_bt_DesceActionPerformed

    private void bt_RemoverDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RemoverDestinoActionPerformed
        removeDestino();
    }//GEN-LAST:event_bt_RemoverDestinoActionPerformed

    private void bt_AtdicionarDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AtdicionarDestinoActionPerformed
        adicionarDestino();
        limparDestino();
    }//GEN-LAST:event_bt_AtdicionarDestinoActionPerformed

    private void bt_CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CalcularActionPerformed
        try {
            processaViagem();
            limparCampos();
            atualizaTabela();
        } catch (IOException ex) {
            Logger.getLogger(JanelaRotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_CalcularActionPerformed

    private void bt_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_LimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_bt_LimparActionPerformed

    private void cb_TransportadoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_TransportadoresItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cb_Transportadores.getSelectedItem().toString().equals("Selecione")) {
                cb_Veiculos.setEnabled(false);
                System.out.println("Transportador não selecionado.");
            } else {
                atualizaVinculosComVeiculos();
            }
        }
    }//GEN-LAST:event_cb_TransportadoresItemStateChanged

    private void bt_RemoverViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RemoverViagemActionPerformed
        removerViagem();
        atualizaTabela();
    }//GEN-LAST:event_bt_RemoverViagemActionPerformed

    private void bt_AttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AttActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_bt_AttActionPerformed

    private void tabelaViagensKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaViagensKeyReleased
        //        selecionarVeiculo();
        //        atualizaVinculoComTransportadores();
    }//GEN-LAST:event_tabelaViagensKeyReleased

    private void tabelaViagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaViagensMouseClicked
        //        selecionarVeiculo();
        //        atualizaVinculoComTransportadores();
    }//GEN-LAST:event_tabelaViagensMouseClicked

    private void bt_DetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_DetailsMouseClicked
        ReturnMessagePane.informationPainel(Janela.traducao.getString("alert_EmObras"));
    }//GEN-LAST:event_bt_DetailsMouseClicked

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

    private String formatarCNPJ(String cnpj) {
        try {
            NumberFormat formatter = NumberFormat.getInstance();
            formatter.setMinimumIntegerDigits(14);
            formatter.setGroupingUsed(false);
            String cnpjFormatado = formatter.format(Long.parseLong(cnpj));
            return cnpjFormatado.substring(0, 2) + "." + cnpjFormatado.substring(2, 5) + "." + cnpjFormatado.substring(5, 8) + "/" + cnpjFormatado.substring(8, 12) + "-" + cnpjFormatado.substring(12, 14);
        } catch (Exception e) {
            return cnpj;
        }
    }
    
    private String formatarCPF(String cpf) {
        try {
            NumberFormat formatter = NumberFormat.getInstance();
            formatter.setMinimumIntegerDigits(11);
            formatter.setGroupingUsed(false);
            String cpfFormatado = formatter.format(Long.parseLong(cpf));
            return cpfFormatado.substring(0, 3) + "." + cpfFormatado.substring(3, 6) + "." + cpfFormatado.substring(6, 9) + "-" + cpfFormatado.substring(9, 11);
        } catch (Exception e) {
            return cpf;
        }
    }
    
    public static String extrairPlaca(String texto) {
        String placa = texto.replace("Placa: ", "");
        return placa;
    }

    private String formatCEP(String cep) {
        return cep.substring(0, 5) + "-" + cep.substring(5);
    }
    
    private String removerFormatacao(String s) {
        return s.replaceAll("[^0-9]+", "");
    }
    
    private String encontraCNPJCPF(String texto){

    Pattern padrao = Pattern.compile("\\b(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})\\b");
    Matcher matcher = padrao.matcher(texto);

    ArrayList<String> numeros = new ArrayList();

    while (matcher.find()) {
      numeros.add(matcher.group());
    }
    return numeros.get(0);
    }
    
    private void limparDestino(){
        tf_Destino.setText("");
    }
    
    public String removerAcentos(String texto) {
        String textoSemAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(textoSemAcentos).replaceAll("")
                .replaceAll("[ÂÀÁÄÃ]", "A")
                .replaceAll("[âãàáä]", "a")
                .replaceAll("[ÊÈÉË]", "E")
                .replaceAll("[êèéë]", "e")
                .replaceAll("[ÎÍÌÏ]", "I")
                .replaceAll("[îíìï]", "i")
                .replaceAll("[ÔÕÒÓÖ]", "O")
                .replaceAll("[ôõòóö]", "o")
                .replaceAll("[ÛÙÚÜ]", "U")
                .replaceAll("[ûúùü]", "u")
                .replaceAll("Ç", "C")
                .replaceAll("ç", "c")
                .replaceAll("[ýÿ]", "y")
                .replaceAll("Ý", "Y")
                .replaceAll("ñ", "n")
                .replaceAll("Ñ", "N");
    }
    
    private void limparCampos(){
        cb_TipoPedagio.setSelectedIndex(0);
        cb_Transportadores.setSelectedIndex(0);
        cb_Veiculos.setSelectedIndex(0);
        tf_Destino.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_AtdicionarDestino;
    private javax.swing.JButton bt_Att;
    private javax.swing.JButton bt_Calcular;
    private javax.swing.JButton bt_Desce;
    private javax.swing.JButton bt_Details;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_RemoverDestino;
    private javax.swing.JButton bt_RemoverViagem;
    private javax.swing.JButton bt_Sobe;
    private javax.swing.JPanel btn_4;
    private javax.swing.JPanel btn_Home;
    private javax.swing.JPanel btn_JanelaCadastros;
    private javax.swing.JPanel btn_JanelaRelatorios;
    private javax.swing.JPanel btn_JanelaSettings;
    private javax.swing.JComboBox<String> cb_TipoPedagio;
    private javax.swing.JComboBox<String> cb_Transportadores;
    private javax.swing.JComboBox<String> cb_Veiculos;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_AdicionarDestino;
    private javax.swing.JLabel lb_Cadastros;
    private javax.swing.JLabel lb_DestinosSelecionados;
    private javax.swing.JLabel lb_Home;
    private javax.swing.JLabel lb_Logout;
    private javax.swing.JLabel lb_NovoVeiculo;
    private javax.swing.JLabel lb_Relatorios;
    private javax.swing.JLabel lb_Rotas;
    private javax.swing.JLabel lb_Settings;
    private javax.swing.JLabel lb_TelaRotasTitle;
    private javax.swing.JLabel lb_TipoPedagio;
    private javax.swing.JLabel lb_Transportador;
    private javax.swing.JLabel lb_Veiculo;
    private javax.swing.JPanel side_pane;
    private javax.swing.JTable tabelaDestinos;
    private javax.swing.JTable tabelaViagens;
    private javax.swing.JTextField tf_Destino;
    // End of variables declaration//GEN-END:variables
}
