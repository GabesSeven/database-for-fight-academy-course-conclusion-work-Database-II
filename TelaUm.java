package trabalhobancodedados;

import java.sql.SQLException;

public class TelaUm extends javax.swing.JFrame {
    TelaDois telaDois;
    
    public TelaUm() {
        initComponents();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        botaoAtualizar = new javax.swing.JButton();
        botaoInserir = new javax.swing.JButton();
        botaoDeletar = new javax.swing.JButton();
        imagemInicial = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoAtualizarMouseClicked(evt);
            }
        });
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        botaoInserir.setText("Inserir");
        botaoInserir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoInserirMouseClicked(evt);
            }
        });

        botaoDeletar.setText("Deletar");
        botaoDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoDeletarMouseClicked(evt);
            }
        });

        imagemInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobancodedados/telainicial.jpg"))); // NOI18N

        jLabel1.setText("SELECIONE UMA DAS OPEAÇÕES ABAIXO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(imagemInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(botaoAtualizar)
                .addGap(18, 18, 18)
                .addComponent(botaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(imagemInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAtualizar)
                    .addComponent(botaoInserir)
                    .addComponent(botaoDeletar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void botaoAtualizarMouseClicked(java.awt.event.MouseEvent evt) {                                            
        // TODO add your handling code here:
        //this.setVisible(false);
        telaDois = new TelaDois(1);
    }                                           

    private void botaoDeletarMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        //this.setVisible(false);
        telaDois = new TelaDois(2);
    }                                         

    private void botaoInserirMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        //this.setVisible(false);
        telaDois = new TelaDois(3);
    }                                         

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(TelaUm::new);
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoDeletar;
    private javax.swing.JButton botaoInserir;
    private javax.swing.JLabel imagemInicial;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

