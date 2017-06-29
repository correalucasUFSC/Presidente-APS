/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.View;

import Presidente.Constantes;
import br.ufsc.inf.Model.Carta;
import java.net.URL;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class TelaMesa extends javax.swing.JFrame {

    protected AtorJogador atorJogador;
    protected static String EXTENSAO_CARTA = ".png";
    
    /**
     * Creates new form TElaMesa
     */
    public TelaMesa(AtorJogador atorJogador) {
        initComponents();
        this.atorJogador = atorJogador;
        
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelMesa = new javax.swing.JPanel();
        cartaAdversario0 = new javax.swing.JLabel();
        cartaAdversario1 = new javax.swing.JLabel();
        cartaAdversario2 = new javax.swing.JLabel();
        cartaAdversario3 = new javax.swing.JLabel();
        cartaAdversario4 = new javax.swing.JLabel();
        cartaAdversario5 = new javax.swing.JLabel();
        cartaAdversario6 = new javax.swing.JLabel();
        cartaAdversario7 = new javax.swing.JLabel();
        cartaAdversario8 = new javax.swing.JLabel();
        cartaAdversario9 = new javax.swing.JLabel();
        cartaJogador0 = new javax.swing.JLabel();
        cartaJogador1 = new javax.swing.JLabel();
        cartaJogador2 = new javax.swing.JLabel();
        cartaJogador3 = new javax.swing.JLabel();
        cartaJogador4 = new javax.swing.JLabel();
        cartaJogador5 = new javax.swing.JLabel();
        cartaJogador6 = new javax.swing.JLabel();
        cartaJogador7 = new javax.swing.JLabel();
        cartaJogador8 = new javax.swing.JLabel();
        cartaJogador9 = new javax.swing.JLabel();
        cartaMesa0 = new javax.swing.JLabel();
        cartaMesa1 = new javax.swing.JLabel();
        cartaMesa3 = new javax.swing.JLabel();
        cartaMesa2 = new javax.swing.JLabel();
        nomeAdversario = new javax.swing.JLabel();
        tipoAdversario = new javax.swing.JLabel();
        nomeJogador = new javax.swing.JLabel();
        tipoJogador = new javax.swing.JLabel();
        fazerJogada = new javax.swing.JButton();
        vitoriaAdversario = new javax.swing.JLabel();
        vitoriaJogador = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuConectar = new javax.swing.JMenu();
        jMenuIniciarPartida = new javax.swing.JMenu();
        jMenuDesconectar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelMesa.setBackground(new java.awt.Color(0, 153, 51));
        painelMesa.setBorder(new javax.swing.border.MatteBorder(null));

        cartaAdversario0.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario0.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario0.setToolTipText("0");
        cartaAdversario0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario1.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario1.setToolTipText("1");
        cartaAdversario1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario2.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario2.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario2.setToolTipText("2");
        cartaAdversario2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario3.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario3.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario3.setToolTipText("3");
        cartaAdversario3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario4.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario4.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario4.setToolTipText("4");
        cartaAdversario4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario5.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario5.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario5.setToolTipText("5");
        cartaAdversario5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario6.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario6.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario6.setToolTipText("6");
        cartaAdversario6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario7.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario7.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario7.setToolTipText("7");
        cartaAdversario7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario8.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario8.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario8.setToolTipText("8");
        cartaAdversario8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaAdversario9.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaAdversario9.setForeground(new java.awt.Color(255, 0, 0));
        cartaAdversario9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaAdversario9.setToolTipText("9");
        cartaAdversario9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador0.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador0.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador0.setToolTipText("0");
        cartaJogador0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador1.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador1.setToolTipText("1");
        cartaJogador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador2.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador2.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador2.setToolTipText("2");
        cartaJogador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador3.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador3.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador3.setToolTipText("3");
        cartaJogador3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador4.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador4.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador4.setToolTipText("4");
        cartaJogador4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador5.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador5.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador5.setToolTipText("5");
        cartaJogador5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador6.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador6.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador6.setToolTipText("6");
        cartaJogador6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador7.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador7.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador7.setToolTipText("7");
        cartaJogador7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador8.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador8.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador8.setToolTipText("8");
        cartaJogador8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaJogador9.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        cartaJogador9.setForeground(new java.awt.Color(255, 0, 0));
        cartaJogador9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N
        cartaJogador9.setToolTipText("9");
        cartaJogador9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cartaMesa0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N

        cartaMesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N

        cartaMesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N

        cartaMesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-branca.png"))); // NOI18N

        nomeAdversario.setForeground(new java.awt.Color(255, 255, 255));
        nomeAdversario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nomeAdversario.setText("Jogador2");

        tipoAdversario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tipoAdversario.setForeground(new java.awt.Color(255, 255, 51));
        tipoAdversario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tipoAdversario.setText("PRESIDENTE");

        nomeJogador.setForeground(new java.awt.Color(255, 255, 255));
        nomeJogador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nomeJogador.setText("Jogador1");

        tipoJogador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tipoJogador.setForeground(new java.awt.Color(255, 255, 51));
        tipoJogador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tipoJogador.setText("PRESIDENTE");

        fazerJogada.setText("Fazer jogada");

        vitoriaAdversario.setForeground(new java.awt.Color(0, 204, 0));
        vitoriaAdversario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vitoriaAdversario.setText("0 vitórias");

        vitoriaJogador.setForeground(new java.awt.Color(0, 204, 0));
        vitoriaJogador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vitoriaJogador.setText("0 vitórias");

        javax.swing.GroupLayout painelMesaLayout = new javax.swing.GroupLayout(painelMesa);
        painelMesa.setLayout(painelMesaLayout);
        painelMesaLayout.setHorizontalGroup(
            painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMesaLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomeAdversario)
                    .addComponent(nomeJogador)
                    .addComponent(tipoJogador)
                    .addComponent(tipoAdversario)
                    .addComponent(vitoriaAdversario)
                    .addComponent(vitoriaJogador))
                .addGap(18, 18, 18)
                .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMesaLayout.createSequentialGroup()
                        .addComponent(cartaJogador0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaJogador9))
                    .addGroup(painelMesaLayout.createSequentialGroup()
                        .addComponent(cartaAdversario0)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaAdversario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartaAdversario2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMesaLayout.createSequentialGroup()
                                .addComponent(cartaAdversario3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaAdversario4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaAdversario5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaAdversario6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaAdversario7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaAdversario8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaAdversario9))
                            .addGroup(painelMesaLayout.createSequentialGroup()
                                .addComponent(cartaMesa0)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaMesa1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaMesa2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cartaMesa3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                                .addComponent(fazerJogada)))))
                .addGap(122, 122, 122))
        );
        painelMesaLayout.setVerticalGroup(
            painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMesaLayout.createSequentialGroup()
                .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMesaLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cartaAdversario8)
                            .addComponent(cartaAdversario9)
                            .addComponent(cartaAdversario7)
                            .addComponent(cartaAdversario6)
                            .addComponent(cartaAdversario5)
                            .addComponent(cartaAdversario3)
                            .addComponent(cartaAdversario4)
                            .addComponent(cartaAdversario2)
                            .addComponent(cartaAdversario0)
                            .addComponent(cartaAdversario1))
                        .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelMesaLayout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cartaMesa3)
                                    .addComponent(cartaMesa2)
                                    .addComponent(cartaMesa0)
                                    .addComponent(cartaMesa1)))
                            .addGroup(painelMesaLayout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(fazerJogada))))
                    .addGroup(painelMesaLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(tipoAdversario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeAdversario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vitoriaAdversario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMesaLayout.createSequentialGroup()
                        .addGroup(painelMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cartaJogador8)
                            .addComponent(cartaJogador9)
                            .addComponent(cartaJogador7)
                            .addComponent(cartaJogador6)
                            .addComponent(cartaJogador5)
                            .addComponent(cartaJogador3)
                            .addComponent(cartaJogador4)
                            .addComponent(cartaJogador2)
                            .addComponent(cartaJogador0)
                            .addComponent(cartaJogador1))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMesaLayout.createSequentialGroup()
                        .addComponent(tipoJogador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeJogador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vitoriaJogador)
                        .addGap(57, 57, 57))))
        );

        jMenuConectar.setText("Conectar");
        jMenuConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuConectarMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuConectar);

        jMenuIniciarPartida.setText("Iniciar Partida");
        jMenuIniciarPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuIniciarPartidaMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuIniciarPartida);

        jMenuDesconectar.setText("Desconectar");
        jMenuDesconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuDesconectarMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuDesconectar);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuConectarMouseClicked
        // TODO add your handling code here:
        //Informar que Conectar foi clicado
        this.atorJogador.conectar();
    }//GEN-LAST:event_jMenuConectarMouseClicked

    private void jMenuIniciarPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuIniciarPartidaMouseClicked
        // TODO add your handling code here:
        //Informar que Iniciar partida foi clicado
        this.atorJogador.iniciarPartida();
    }//GEN-LAST:event_jMenuIniciarPartidaMouseClicked

    private void jMenuDesconectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuDesconectarMouseClicked
        // TODO add your handling code here:
        this.atorJogador.desconectar();
    }//GEN-LAST:event_jMenuDesconectarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartaAdversario0;
    private javax.swing.JLabel cartaAdversario1;
    private javax.swing.JLabel cartaAdversario2;
    private javax.swing.JLabel cartaAdversario3;
    private javax.swing.JLabel cartaAdversario4;
    private javax.swing.JLabel cartaAdversario5;
    private javax.swing.JLabel cartaAdversario6;
    private javax.swing.JLabel cartaAdversario7;
    private javax.swing.JLabel cartaAdversario8;
    private javax.swing.JLabel cartaAdversario9;
    private javax.swing.JLabel cartaJogador0;
    private javax.swing.JLabel cartaJogador1;
    private javax.swing.JLabel cartaJogador2;
    private javax.swing.JLabel cartaJogador3;
    private javax.swing.JLabel cartaJogador4;
    private javax.swing.JLabel cartaJogador5;
    private javax.swing.JLabel cartaJogador6;
    private javax.swing.JLabel cartaJogador7;
    private javax.swing.JLabel cartaJogador8;
    private javax.swing.JLabel cartaJogador9;
    private javax.swing.JLabel cartaMesa0;
    private javax.swing.JLabel cartaMesa1;
    private javax.swing.JLabel cartaMesa2;
    private javax.swing.JLabel cartaMesa3;
    private javax.swing.JButton fazerJogada;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuConectar;
    private javax.swing.JMenu jMenuDesconectar;
    private javax.swing.JMenu jMenuIniciarPartida;
    private javax.swing.JLabel nomeAdversario;
    private javax.swing.JLabel nomeJogador;
    private javax.swing.JPanel painelMesa;
    private javax.swing.JLabel tipoAdversario;
    private javax.swing.JLabel tipoJogador;
    private javax.swing.JLabel vitoriaAdversario;
    private javax.swing.JLabel vitoriaJogador;
    // End of variables declaration//GEN-END:variables

    public void informarResultado(int resultado) {
        switch(resultado){
            case Constantes.CONEXAO_EXITO:
                JOptionPane.showMessageDialog(this, Constantes.CONEXAO_EXITO_STRING);
                break;
            case Constantes.CONEXAO_FALHOU:
                JOptionPane.showMessageDialog(this, Constantes.CONEXAO_FALHOU_STRING);
                break;
            case Constantes.JA_CONECTADO:
                JOptionPane.showMessageDialog(this, Constantes.JA_CONECTADO_STRING);
                break;
            case Constantes.DESCONEXAO_EXITO:
                JOptionPane.showMessageDialog(this, Constantes.DESCONEXAO_EXITO_STRING);
                break;
            case Constantes.DESCONEXAO_FALHOU:
                JOptionPane.showMessageDialog(this, Constantes.DESCONEXAO_FALHOU_STRING);
                break; 
            case Constantes.JA_DESCONECTADO:
                JOptionPane.showMessageDialog(this, Constantes.JA_DESCONECTADO_STRING);
                break;    
            case Constantes.FALTA_CONEXAO:
                JOptionPane.showMessageDialog(this, Constantes.FALTA_CONEXAO_STRING);
                break; 
            case Constantes.JOGO_EM_ANDAMENTO:
                JOptionPane.showMessageDialog(this, Constantes.JOGO_EM_ANDAMENTO_STRING);
                break;   
            case Constantes.INICIAR_PARTIDA_FALHOU:
                JOptionPane.showMessageDialog(this, Constantes.INICIAR_PARTIDA_FALHOU_STRING);
                break; 
            case Constantes.SOLICITADO_INICIO_PARTIDA:
                JOptionPane.showMessageDialog(this, Constantes.SOLICITADO_INICIO_PARTIDA_STRING);
                break;     
        }
    }

    public String obterNomeServidor() {
        String enderecoServidor = Constantes.ENDERECO_SERVIDOR;
        enderecoServidor = JOptionPane.showInputDialog(this, 
                Constantes.INSIRA_ENDERECO_SERVIDOR, enderecoServidor);
        return enderecoServidor;
    }

    public String obterNomeJogador() {
        return JOptionPane.showInputDialog(Constantes.INSIRA_NOME_JOGADOR);
    }

    public void atualizarNomeAdversario(String nome) {
        //TODO ATUALIZAR NOME ADVERSARIO
    }
    
    private String getImagemCarta(String caminho) {
	return Constantes.IMAGE_PATH + caminho + EXTENSAO_CARTA;
    }

    public void atualizaTelaJogador(List<Carta> cartasJogador, int cartasAdversario, List<Carta> cartasMesa) {
        escondeCartas("adversario", cartasAdversario);
        colocaCartasDaMesa(cartasMesa);
        colocaCartasDaMao("jogador", cartasJogador);
    }

    public void atualizaTelaAdversario(int cartasJogador, List<Carta> cartasAdversario, List<Carta> cartasMesa) {
        escondeCartas("jogador", cartasJogador);
        colocaCartasDaMesa(cartasMesa);
        colocaCartasDaMao("adversario", cartasAdversario);        
    }
    
    private void escondeCartas(String jogador, int tamanho){
        if(jogador.toLowerCase().equals("adversario")){
            if(tamanho == 1) cartaAdversario0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 2) cartaAdversario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 3) cartaAdversario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 4) cartaAdversario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 5) cartaAdversario4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 6) cartaAdversario5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 7) cartaAdversario6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 8) cartaAdversario7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 9) cartaAdversario8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 10) cartaAdversario9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
        } else if(jogador.toLowerCase().equals("jogador")){
            if(tamanho == 1) cartaJogador0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 2) cartaJogador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 3) cartaJogador2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 4) cartaJogador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 5) cartaJogador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 6) cartaJogador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 7) cartaJogador6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 8) cartaJogador7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 9) cartaJogador8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));
            if(tamanho == 10) cartaJogador9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufsc/inf/View/imgs/carta-oculta.png")));            
        }
    }
    
    private void colocaCartasDaMesa(List<Carta> cartasMesa){
        int tamanho = cartasMesa.size();
        if(tamanho == 1) cartaMesa0.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMesa.get(0).getCaminho()))));
        if(tamanho == 2) cartaMesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMesa.get(1).getCaminho()))));
        if(tamanho == 3) cartaMesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMesa.get(2).getCaminho()))));
        if(tamanho == 4) cartaMesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMesa.get(3).getCaminho()))));
    }
    
    private void colocaCartasDaMao(String jogador, List<Carta> cartasMao){
        int tamanho = cartasMao.size();
        if(jogador.toLowerCase().equals("adversario")){
            if(tamanho == 1) cartaAdversario0.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(0).getCaminho()))));
            if(tamanho == 2) cartaAdversario1.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(1).getCaminho()))));
            if(tamanho == 3) cartaAdversario2.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(2).getCaminho()))));
            if(tamanho == 4) cartaAdversario3.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(3).getCaminho()))));
            if(tamanho == 5) cartaAdversario4.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(4).getCaminho()))));
            if(tamanho == 6) cartaAdversario5.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(5).getCaminho()))));
            if(tamanho == 7) cartaAdversario6.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(6).getCaminho()))));
            if(tamanho == 8) cartaAdversario7.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(7).getCaminho()))));
            if(tamanho == 9) cartaAdversario8.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(8).getCaminho()))));
            if(tamanho == 10) cartaAdversario9.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(9).getCaminho()))));
        } else if(jogador.toLowerCase().equals("jogador")){
            if(tamanho == 1) cartaJogador0.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(0).getCaminho()))));
            if(tamanho == 2) cartaJogador1.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(1).getCaminho()))));
            if(tamanho == 3) cartaJogador2.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(2).getCaminho()))));
            if(tamanho == 4) cartaJogador3.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(3).getCaminho()))));
            if(tamanho == 5) cartaJogador4.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(4).getCaminho()))));
            if(tamanho == 6) cartaJogador5.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(5).getCaminho()))));
            if(tamanho == 7) cartaJogador6.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(6).getCaminho()))));
            if(tamanho == 8) cartaJogador7.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(7).getCaminho()))));
            if(tamanho == 9) cartaJogador8.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(8).getCaminho()))));
            if(tamanho == 10) cartaJogador9.setIcon(new javax.swing.ImageIcon(getClass().getResource(getImagemCarta(cartasMao.get(9).getCaminho()))));        
        }
    }
    
    private void cartaClicada(javax.swing.JLabel carta){
        String posicao = carta.getToolTipText();
        if(carta.getText().equals("X")){
            //tiraSeleção
            carta.setText("");            
        } else {
            //envia posição selecionada   
            carta.setText("X");         
        }
    }
    
    public void trocaNomeJogador(String nome) {
        this.nomeJogador.setText(nome);
    }
    
    public void trocaNomeAdversario(String nome) {
        this.nomeAdversario.setText(nome);
    }
    
    public void trocaPresidente(String jogador) {
        if(jogador.equals("jogador")) {
            this.tipoJogador.setText("PRESIDENTE");
            this.tipoAdversario.setText("CU"); 
        } else {
            this.tipoJogador.setText("CU");
            this.tipoAdversario.setText("PRESIDENTE");
        }
    }
    
    public void aumentaVitoria(String jogador, int quantidade) {  
        String texto = quantidade == 1 ? " vitória" : " vitórias";      
        if(jogador.equals("jogador")) {
            this.vitoriaJogador.setText(quantidade + texto);
        } else {
            this.vitoriaAdversario.setText(quantidade + texto);
        }
    }
}
