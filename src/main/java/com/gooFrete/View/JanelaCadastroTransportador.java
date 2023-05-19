package com.gooFrete.View;

import com.gooFrete.Controller.CarrierController;
import com.gooFrete.Controller.EquipmentController;
import com.gooFrete.Model.Carrier;
import com.gooFrete.Model.Equipment;
import com.gooFrete.Model.ReturnMessagePane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauricio.rodrigues
 */
public class JanelaCadastroTransportador extends javax.swing.JPanel {

    private List<Carrier> listaTransportadores;
    private List<Equipment> listaVeiculosVinculados;
    private CarrierController carrierController;
    private EquipmentController equipmentController;
    
    public JanelaCadastroTransportador() {
        initComponents();
        traduzir();
        
        setColor(btn_JanelaCadastros); 
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_Home,btn_JanelaRotas, btn_JanelaSettings}, new JPanel[]{ind_2,ind_1, ind_4, ind_5});
        
        carrierController = new CarrierController();
        atualizaTabela();
    }
    
    public void traduzir(){
        this.lb_TelaTransportadorTitle.setText(Janela.traducao.getString("lb_TelaTransportadorTitle"));
        this.lb_Home.setText(Janela.traducao.getString("lb_Home"));
        this.lb_Cadastros.setText(Janela.traducao.getString("lb_Cadastros"));
        this.lb_Rotas.setText(Janela.traducao.getString("lb_Rotas"));
        this.lb_Relatorios.setText(Janela.traducao.getString("lb_Relatorios"));
        this.lb_Settings.setText(Janela.traducao.getString("lb_Settings"));
        this.lb_Logout.setText(Janela.traducao.getString("lb_Logout"));
        this.lb_NovoTransportador.setText(Janela.traducao.getString("lb_NovoTransportador"));
        this.lb_RazaoSocial.setText(Janela.traducao.getString("lb_RazaoSocial"));
        this.lb_CNPJCPF.setText(Janela.traducao.getString("lb_CNPJCPF"));
        this.lb_Endereco.setText(Janela.traducao.getString("lb_Endereco"));
        this.lb_Bairro.setText(Janela.traducao.getString("lb_Bairro"));
        this.lb_Cidade.setText(Janela.traducao.getString("lb_Cidade"));
        this.lb_Estado.setText(Janela.traducao.getString("lb_Estado"));
        this.lb_CEP.setText(Janela.traducao.getString("lb_CEP"));
        this.lb_Pais.setText(Janela.traducao.getString("lb_Pais"));
        this.lb_Tipo.setText(Janela.traducao.getString("lb_Tipo"));
        this.lb_Telefone.setText(Janela.traducao.getString("lb_Telefone"));
        this.bt_AtualizarDados.setText(Janela.traducao.getString("bt_AtualizarCadastro"));
        this.bt_Salvar.setText(Janela.traducao.getString("bt_Novo"));
        this.bt_Limpar.setText(Janela.traducao.getString("bt_Limpar"));
        this.bt_Att.setText(Janela.traducao.getString("bt_Atualizar"));
        this.bt_Remover.setText(Janela.traducao.getString("bt_Remover"));
        this.bt_Details.setText(Janela.traducao.getString("bt_Detalhes"));
        this.tabelaTransportadores.getColumnModel().getColumn(0).setHeaderValue(Janela.traducao.getString("tb_Transportador"));
        this.tabelaTransportadores.getColumnModel().getColumn(1).setHeaderValue(Janela.traducao.getString("tb_CNPJCPF"));
        this.tabelaTransportadores.getColumnModel().getColumn(2).setHeaderValue(Janela.traducao.getString("tb_Tipo"));
        this.tabelaVeiculos.getColumnModel().getColumn(0).setHeaderValue(Janela.traducao.getString("tb_Tipo"));
        this.tabelaVeiculos.getColumnModel().getColumn(1).setHeaderValue(Janela.traducao.getString("tb_Modelo"));
        this.tabelaVeiculos.getColumnModel().getColumn(2).setHeaderValue(Janela.traducao.getString("tb_Marca"));
        this.tabelaVeiculos.getColumnModel().getColumn(3).setHeaderValue(Janela.traducao.getString("tb_Placa"));
        this.tabelaVeiculos.getColumnModel().getColumn(4).setHeaderValue(Janela.traducao.getString("tb_Eixos"));
    }
    
    public void gotoJanelaHome(){
        Janela.p1 = new JanelaHome();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p3);
        janela.getContentPane().remove(Janela.p3);
        janela.add(Janela.p1, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaRotas(){
        Janela.p5 = new JanelaRotas();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p3);
        janela.getContentPane().remove(Janela.p3);
        janela.add(Janela.p5, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaCadastros(){
        Janela.p2 = new JanelaCadastros();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p3);
        janela.getContentPane().remove(Janela.p3);
        janela.add(Janela.p2, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanelaRelatorios(){
        Janela.p6 = new JanelaRelatorios();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(Janela.p3);
        janela.getContentPane().remove(Janela.p3);
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
        btn_JanelaRotas = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        lb_Rotas = new javax.swing.JLabel();
        btn_JanelaSettings = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        lb_Settings = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaTransportadores = new javax.swing.JTable();
        bt_Att = new javax.swing.JButton();
        bt_Remover = new javax.swing.JButton();
        lb_NovoTransportador = new javax.swing.JLabel();
        lb_RazaoSocial = new javax.swing.JLabel();
        lb_CNPJCPF = new javax.swing.JLabel();
        lb_Endereco = new javax.swing.JLabel();
        lb_Bairro = new javax.swing.JLabel();
        lb_Cidade = new javax.swing.JLabel();
        lb_Estado = new javax.swing.JLabel();
        lb_CEP = new javax.swing.JLabel();
        lb_Tipo = new javax.swing.JLabel();
        bt_Details = new javax.swing.JButton();
        tf_Nome = new javax.swing.JTextField();
        tf_CNPJCPF = new javax.swing.JTextField();
        cb_Tipo = new javax.swing.JComboBox<>();
        tf_Endereco = new javax.swing.JTextField();
        tf_Bairro = new javax.swing.JTextField();
        tf_Cidade = new javax.swing.JTextField();
        tf_CEP = new javax.swing.JTextField();
        cb_Estado = new javax.swing.JComboBox<>();
        bt_Limpar = new javax.swing.JButton();
        bt_Salvar = new javax.swing.JButton();
        lb_VeiculosVinculados = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVeiculos = new javax.swing.JTable();
        lb_Telefone = new javax.swing.JLabel();
        tf_Telefone = new javax.swing.JTextField();
        lb_Pais = new javax.swing.JLabel();
        cb_Pais = new javax.swing.JComboBox<>();
        bt_AtualizarDados = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lb_Logout = new javax.swing.JLabel();
        lb_TelaTransportadorTitle = new javax.swing.JLabel();

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
        jPanel6.setPreferredSize(new java.awt.Dimension(1054, 540));

        tabelaTransportadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transportador", "CNPJ/CPF", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabelaTransportadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTransportadoresMouseClicked(evt);
            }
        });
        tabelaTransportadores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaTransportadoresKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaTransportadores);

        bt_Att.setBackground(new java.awt.Color(255, 255, 255));
        bt_Att.setText("Atualizar");
        bt_Att.setFocusPainted(false);
        bt_Att.setFocusable(false);
        bt_Att.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AttActionPerformed(evt);
            }
        });

        bt_Remover.setBackground(new java.awt.Color(255, 255, 255));
        bt_Remover.setText("Remover");
        bt_Remover.setFocusPainted(false);
        bt_Remover.setFocusable(false);
        bt_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RemoverActionPerformed(evt);
            }
        });

        lb_NovoTransportador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_NovoTransportador.setText("Novo Transportador");

        lb_RazaoSocial.setText("Razão Social:");

        lb_CNPJCPF.setText("CNPJ/CPF:");

        lb_Endereco.setText("Endereço:");

        lb_Bairro.setText("Bairro:");

        lb_Cidade.setText("Cidade:");

        lb_Estado.setText("Estado:");

        lb_CEP.setText("CEP:");

        lb_Tipo.setText("Tipo:");

        bt_Details.setBackground(new java.awt.Color(255, 255, 255));
        bt_Details.setText("Detalhes");
        bt_Details.setFocusPainted(false);
        bt_Details.setFocusable(false);
        bt_Details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_DetailsMouseClicked(evt);
            }
        });

        cb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Empresa Transportadora de Cargas - ETC", "Transportador Autonômo de Cargas - TAC" }));

        cb_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        bt_Limpar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Limpar.setText("Limpar");
        bt_Limpar.setFocusPainted(false);
        bt_Limpar.setFocusable(false);
        bt_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LimparActionPerformed(evt);
            }
        });

        bt_Salvar.setBackground(new java.awt.Color(255, 255, 255));
        bt_Salvar.setText("Novo");
        bt_Salvar.setFocusPainted(false);
        bt_Salvar.setFocusable(false);
        bt_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SalvarActionPerformed(evt);
            }
        });

        lb_VeiculosVinculados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_VeiculosVinculados.setText("Veículos Vinculados");

        tabelaVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Modelo", "Marca", "Placa", "Eixos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaVeiculos);

        lb_Telefone.setText("Telefone:");

        lb_Pais.setText("País:");

        cb_Pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Brasil" }));

        bt_AtualizarDados.setBackground(new java.awt.Color(255, 255, 255));
        bt_AtualizarDados.setText("Atualizar Cadastro");
        bt_AtualizarDados.setFocusPainted(false);
        bt_AtualizarDados.setFocusable(false);
        bt_AtualizarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AtualizarDadosActionPerformed(evt);
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
                        .addComponent(bt_Remover))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(bt_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_AtualizarDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Salvar))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_CNPJCPF)
                                    .addComponent(lb_Endereco)
                                    .addComponent(lb_Bairro)
                                    .addComponent(lb_Cidade)
                                    .addComponent(lb_Estado)
                                    .addComponent(lb_CEP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_CNPJCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_Endereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_Bairro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_Cidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_CEP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_Estado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lb_RazaoSocial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_NovoTransportador)
                            .addComponent(lb_VeiculosVinculados)
                            .addComponent(jScrollPane2))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(lb_Telefone)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lb_Pais, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lb_Tipo, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_Telefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_Pais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb_NovoTransportador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_RazaoSocial)
                            .addComponent(tf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_CNPJCPF)
                            .addComponent(tf_CNPJCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Endereco)
                            .addComponent(tf_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Bairro)
                            .addComponent(tf_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Cidade)
                            .addComponent(tf_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_Estado)
                            .addComponent(cb_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_CEP)
                            .addComponent(tf_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_Limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_VeiculosVinculados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_Pais))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_Tipo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_Telefone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bt_Salvar)
                                    .addComponent(bt_AtualizarDados))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Att)
                    .addComponent(bt_Remover)
                    .addComponent(bt_Details))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(71, 120, 197));
        jPanel2.setName(""); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(298, 40));
        jPanel2.setRequestFocusEnabled(false);
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

        lb_Logout.setBackground(new java.awt.Color(255, 255, 255));
        lb_Logout.setForeground(new java.awt.Color(255, 255, 255));
        lb_Logout.setIcon(new javax.swing.ImageIcon(".\\images\\iconExit.png"));
        lb_Logout.setText("Logout");
        lb_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_LogoutMousePressed(evt);
            }
        });

        lb_TelaTransportadorTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb_TelaTransportadorTitle.setForeground(new java.awt.Color(255, 255, 255));
        lb_TelaTransportadorTitle.setText("Cadastros > Transportador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_TelaTransportadorTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(65, 65, 65)
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
                            .addComponent(lb_Logout)
                            .addComponent(lb_TelaTransportadorTitle))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(side_pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HomeMousePressed
        // TODO add your handling code here:
        setColor(btn_Home);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btn_JanelaRelatorios,btn_JanelaCadastros,btn_JanelaRotas, btn_JanelaSettings}, new JPanel[]{ind_2,ind_3, ind_4, ind_5});
        gotoJanelaHome();
    }//GEN-LAST:event_btn_HomeMousePressed

    private void atualizaTabela(){
        listaTransportadores = carrierController.carrierQueryAll();
        String tipoTransportador, carrierCNPJCPF;
        
        //Atualiza tabela
        ((DefaultTableModel) tabelaTransportadores.getModel()).setRowCount(0);
        for (int i = 0; i < listaTransportadores.size(); i++) {
            
            tipoTransportador = (listaTransportadores.get(i).getCarrierType() == 0) ? "TAC" : "ETC";
            carrierCNPJCPF =  listaTransportadores.get(i).getCarrierCNPJCPF();
            if (carrierCNPJCPF.length() == 11) {
                carrierCNPJCPF = formatarCPF(carrierCNPJCPF);
            } else {
                carrierCNPJCPF = formatarCNPJ(carrierCNPJCPF);
            }
            
            ((DefaultTableModel) tabelaTransportadores.getModel()).addRow(new Object[]{
                listaTransportadores.get(i).getCarrierName(),
                carrierCNPJCPF,
                tipoTransportador
            });
        }
    }
    
    private void salvarNovoTransportador(){
        String carrierName, carrierCNPJCPF, address,district, city, state, country, zipcode, carrierTypeText, telefone;
        int carrierType;
        Carrier novoTransportador;
        
        carrierName = tf_Nome.getText();
        carrierCNPJCPF = removerFormatacao(tf_CNPJCPF.getText());
        address = tf_Endereco.getText();
        district = tf_Bairro.getText();
        city = tf_Cidade.getText();
        state = cb_Estado.getSelectedItem().toString();
        country = cb_Pais.getSelectedItem().toString();
        zipcode = removerFormatacao(tf_CEP.getText());
        carrierTypeText = cb_Tipo.getSelectedItem().toString();
        telefone = removerFormatacao(tf_Telefone.getText());
        if (carrierTypeText.equals("Transportador Autonômo de Cargas - TAC")) {
                carrierType = 0;
            } else {
                carrierType = 1;
            }
        novoTransportador = new Carrier(carrierName, carrierCNPJCPF, address, district, city, state, country, zipcode, telefone, carrierType);
        boolean status = carrierController.carrierPersistence(novoTransportador);
        if (status) System.out.println("Transportador cadastrado com sucesso.");;
    }
    
    private void removerTransportador(){
        //Pega CNPJ da tabela
        String carrierCNPJCPF;
        carrierCNPJCPF = removerFormatacao((String) tabelaTransportadores.getModel().getValueAt(tabelaTransportadores.getSelectedRow() ,1));
        //Faz remoção
        boolean status = carrierController.carrierDelete(carrierCNPJCPF);
        if (status) System.out.println("Transportador removido com sucesso.");;
    }
    
    private void selecionarTransportador(){
        //Pega CNPJ da tabela
        String carrierCNPJCPF;
        carrierCNPJCPF = removerFormatacao((String) tabelaTransportadores.getModel().getValueAt(tabelaTransportadores.getSelectedRow() ,1));
        //Faz a pesquisa
        Carrier transportador = carrierController.carrierQueryOneCarrier(carrierCNPJCPF);
        System.out.println(transportador.toString());
        //Preenche campos
        tf_Nome.setText(transportador.getCarrierName());
        tf_Endereco.setText(transportador.getAddress());
        tf_Bairro.setText(transportador.getDistrict());
        tf_Cidade.setText(transportador.getCity());
        cb_Estado.setSelectedItem(transportador.getState());
        cb_Pais.setSelectedItem(transportador.getCountry());
        tf_CEP.setText(formatCEP(transportador.getZipcode()));
        if (transportador.getCarrierType() == 0) { //Transportador Autonômo de Cargas - TAC
                tf_CNPJCPF.setText(formatarCPF(transportador.getCarrierCNPJCPF()));
                cb_Tipo.setSelectedIndex(2);
            } else {
                tf_CNPJCPF.setText(formatarCNPJ(transportador.getCarrierCNPJCPF()));
                cb_Tipo.setSelectedIndex(1);
            }
        tf_Telefone.setText(formatPhoneNumber(transportador.getTelefone()));
    }
    
    private void atualizarTransportador(){
        String carrierName, carrierCNPJCPF, address,district, city, state, country, zipcode, carrierTypeText, telefone;
        int carrierType;
        Carrier novoTransportador;
        
        carrierName = tf_Nome.getText();
        carrierCNPJCPF = removerFormatacao(tf_CNPJCPF.getText());
        address = tf_Endereco.getText();
        district = tf_Bairro.getText();
        city = tf_Cidade.getText();
        state = cb_Estado.getSelectedItem().toString();
        country = cb_Pais.getSelectedItem().toString();
        zipcode = removerFormatacao(tf_CEP.getText());
        carrierTypeText = cb_Tipo.getSelectedItem().toString();
        telefone = removerFormatacao(tf_Telefone.getText());
        if (carrierTypeText.equals("Transportador Autonômo de Cargas - TAC")) {
                carrierType = 0;
            } else {
                carrierType = 1;
            }
        novoTransportador = new Carrier(carrierName, carrierCNPJCPF, address, district, city, state, country, zipcode, telefone, carrierType);
        boolean status = carrierController.carrierAtualization(novoTransportador, removerFormatacao((String) tabelaTransportadores.getModel().getValueAt(tabelaTransportadores.getSelectedRow() ,1)));
        if (status) System.out.println("Transportador atualizado com sucesso.");;
    }
    
    private void atualizaVinculosComVeiculos(){
        //Pega CNPJ da tabela
        String carrierCNPJCPF;
        carrierCNPJCPF = removerFormatacao((String) tabelaTransportadores.getModel().getValueAt(tabelaTransportadores.getSelectedRow() ,1));
        //Faz a pesquisa
        listaVeiculosVinculados = carrierController.equipmentVinculados(carrierCNPJCPF);
        String tipoVeiculo, modelo, marca, placa;
        int eixos;
        
        //Atualiza tabela
        ((DefaultTableModel) tabelaVeiculos.getModel()).setRowCount(0);
        for (int i = 0; i < listaVeiculosVinculados.size(); i++) {
            
            tipoVeiculo = (listaVeiculosVinculados.get(i).getEquipmentType());
            modelo =  listaVeiculosVinculados.get(i).getModelo();
            marca = listaVeiculosVinculados.get(i).getMarca();
            placa = listaVeiculosVinculados.get(i).getLicensePlate();
            eixos = listaVeiculosVinculados.get(i).getEixos();
            
            ((DefaultTableModel) tabelaVeiculos.getModel()).addRow(new Object[]{
                tipoVeiculo,
                modelo,
                marca,
                placa,
                eixos
            });
        }
    }
    
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
        gotoJanelaCadastros();
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
        ReturnMessagePane.informationPainel(Janela.traducao.getString("alert_EmObras"));
    }//GEN-LAST:event_btn_JanelaSettingsMouseReleased

    private void bt_AttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AttActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_bt_AttActionPerformed

    private void bt_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RemoverActionPerformed
        removerTransportador();
        limparCampos();
        atualizaTabela();
    }//GEN-LAST:event_bt_RemoverActionPerformed

    private void bt_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_LimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_bt_LimparActionPerformed

    private void bt_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SalvarActionPerformed
        salvarNovoTransportador();
        limparCampos();
        atualizaTabela();
    }//GEN-LAST:event_bt_SalvarActionPerformed

    private void tabelaTransportadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTransportadoresMouseClicked
        selecionarTransportador();
        atualizaVinculosComVeiculos();
    }//GEN-LAST:event_tabelaTransportadoresMouseClicked

    private void bt_AtualizarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AtualizarDadosActionPerformed
        atualizarTransportador();
        limparCampos();
        atualizaTabela();
    }//GEN-LAST:event_bt_AtualizarDadosActionPerformed

    private void tabelaTransportadoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaTransportadoresKeyReleased
        selecionarTransportador();
        atualizaVinculosComVeiculos();
    }//GEN-LAST:event_tabelaTransportadoresKeyReleased

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

    private void lb_LogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_LogoutMousePressed
        System.exit(0);
    }//GEN-LAST:event_lb_LogoutMousePressed

    private void bt_DetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_DetailsMouseClicked
        ReturnMessagePane.informationPainel("Função em desenvolvimento.");
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
    
    private String formatPhoneNumber(String number) {
        if (number.length() == 11) {  // celular
            return String.format("(%s) %s %s-%s", number.substring(0, 2), number.substring(2, 3),
                    number.substring(3, 7), number.substring(7));
        } else if (number.length() == 10) {  // telefone fixo
            return String.format("(%s) %s-%s", number.substring(0, 2), number.substring(2, 6),
                    number.substring(6));
        } else {
            return "Número inválido";
        }
    }
    
    private String formatCEP(String cep) {
        return cep.substring(0, 5) + "-" + cep.substring(5);
    }
    
    private String removerFormatacao(String s) {
        return s.replaceAll("[^0-9]+", "");
    }
    
    private void limparCampos(){
        tf_Nome.setText("");
        tf_CNPJCPF.setText("");
        tf_Endereco.setText("");
        tf_Bairro.setText("");
        tf_Cidade.setText("");
        cb_Estado.setSelectedIndex(0);
        cb_Pais.setSelectedIndex(0);
        tf_CEP.setText("");
        cb_Tipo.setSelectedIndex(0);
        tf_Telefone.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Att;
    private javax.swing.JButton bt_AtualizarDados;
    private javax.swing.JButton bt_Details;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_Remover;
    private javax.swing.JButton bt_Salvar;
    private javax.swing.JPanel btn_Home;
    private javax.swing.JPanel btn_JanelaCadastros;
    private javax.swing.JPanel btn_JanelaRelatorios;
    private javax.swing.JPanel btn_JanelaRotas;
    private javax.swing.JPanel btn_JanelaSettings;
    private javax.swing.JComboBox<String> cb_Estado;
    private javax.swing.JComboBox<String> cb_Pais;
    private javax.swing.JComboBox<String> cb_Tipo;
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
    private javax.swing.JLabel lb_Bairro;
    private javax.swing.JLabel lb_CEP;
    private javax.swing.JLabel lb_CNPJCPF;
    private javax.swing.JLabel lb_Cadastros;
    private javax.swing.JLabel lb_Cidade;
    private javax.swing.JLabel lb_Endereco;
    private javax.swing.JLabel lb_Estado;
    private javax.swing.JLabel lb_Home;
    private javax.swing.JLabel lb_Logout;
    private javax.swing.JLabel lb_NovoTransportador;
    private javax.swing.JLabel lb_Pais;
    private javax.swing.JLabel lb_RazaoSocial;
    private javax.swing.JLabel lb_Relatorios;
    private javax.swing.JLabel lb_Rotas;
    private javax.swing.JLabel lb_Settings;
    private javax.swing.JLabel lb_TelaTransportadorTitle;
    private javax.swing.JLabel lb_Telefone;
    private javax.swing.JLabel lb_Tipo;
    private javax.swing.JLabel lb_VeiculosVinculados;
    private javax.swing.JPanel side_pane;
    private javax.swing.JTable tabelaTransportadores;
    private javax.swing.JTable tabelaVeiculos;
    private javax.swing.JTextField tf_Bairro;
    private javax.swing.JTextField tf_CEP;
    private javax.swing.JTextField tf_CNPJCPF;
    private javax.swing.JTextField tf_Cidade;
    private javax.swing.JTextField tf_Endereco;
    private javax.swing.JTextField tf_Nome;
    private javax.swing.JTextField tf_Telefone;
    // End of variables declaration//GEN-END:variables
}
