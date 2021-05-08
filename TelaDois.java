package trabalhobancodedados;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaDois extends javax.swing.JFrame {
    int optionOperacao;
    TelaDadosTecnico telaDadosTecnico;
    TelaDadosLutador telaDadosLutador;
    TelaDadosLuta telaDadosLuta;
    TelaDadosAcademia telaDadosAcademia;
    
    public TelaDois(int opcao) {
        optionOperacao = opcao;
        initComponents();
        if(optionOperacao == 1)
            botaoLuta.setVisible(false);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        botaoLutador = new javax.swing.JButton();
        botaoLuta = new javax.swing.JButton();
        botaoAcademia = new javax.swing.JButton();
        imagemInserir = new javax.swing.JLabel();
        botaoTecnico = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoLutador.setText("Lutador");
        botaoLutador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoLutadorMouseClicked(evt);
            }
        });

        botaoLuta.setText("Luta");
        botaoLuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoLutaMouseClicked(evt);
            }
        });
        botaoLuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLutaActionPerformed(evt);
            }
        });

        botaoAcademia.setText("Acadêmia ");
        botaoAcademia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoAcademiaMouseClicked(evt);
            }
        });

        imagemInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobancodedados/telainserir.jpg"))); // NOI18N

        botaoTecnico.setText("Técnico");
        botaoTecnico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoTecnicoMouseClicked(evt);
            }
        });
        botaoTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTecnicoActionPerformed(evt);
            }
        });

        jLabel1.setText("SELECIONE QUEM VOCÊ DESEJA OPERAR:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botaoLutador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoLuta, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(botaoAcademia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(imagemInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(botaoLutador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(botaoLuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(botaoAcademia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagemInserir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void botaoTecnicoMouseClicked(java.awt.event.MouseEvent evt) {                                          
        try {
            // TODO add your handling code here:
            telaDadosTecnico = new TelaDadosTecnico(optionOperacao);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDois.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }                                         

    private void botaoLutadorMouseClicked(java.awt.event.MouseEvent evt) {                                          
        try {
            // TODO add your handling code here:
            telaDadosLutador = new TelaDadosLutador(optionOperacao);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDois.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }                                         

    private void botaoLutaMouseClicked(java.awt.event.MouseEvent evt) {                                       
        try {
            // TODO add your handling code here:
            telaDadosLuta = new TelaDadosLuta(optionOperacao);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDois.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }                                      

    private void botaoAcademiaMouseClicked(java.awt.event.MouseEvent evt) {                                           
        try {
            // TODO add your handling code here:
            telaDadosAcademia = new TelaDadosAcademia(optionOperacao);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDois.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }                                          

    private void botaoLutaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void botaoTecnicoActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoAcademia;
    private javax.swing.JButton botaoLuta;
    private javax.swing.JButton botaoLutador;
    private javax.swing.JButton botaoTecnico;
    private javax.swing.JLabel imagemInserir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

