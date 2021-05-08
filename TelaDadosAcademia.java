package trabalhobancodedados;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaDadosAcademia extends javax.swing.JFrame {
    Database database;
    Tecnico tecnico;
    DefaultTableModel modelo;
    int optionOperacao;
    private Academia academia;
    
    public TelaDadosAcademia(int opcao) throws SQLException {
        optionOperacao = opcao;
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        
        modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        viewTable();
    }
    
    private void viewTable() throws SQLException{
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        database = new Database("GVFerreira", "171026985");      
        
        try {    
            for (Academia aca : database.getTodasAcademias()) {
                //System.out.print(tec.cpf+tec.nome+tec.nacionalidade+tec.arteMarcial);
                modelo.addRow(new Object[]{
                    aca.getCnpj(),
                    aca.getNome(),
                    aca.getEndereco(),
                    aca.getTecnico2()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botaoRealizaOperacao = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        botaoBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("CNPJ");

        jLabel4.setText("ENDEREÇO");

        jLabel3.setText("NOME");

        jLabel5.setText("TÉCNICO RESPONSÁVEL");

        botaoRealizaOperacao.setText("Realizar Operação");
        botaoRealizaOperacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoRealizaOperacaoMouseClicked(evt);
            }
        });

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNPJ", "NOME", "ENDEREÇO", "TÉCNICO RESPONSÁVEL"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        jFormattedTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField4ActionPerformed(evt);
            }
        });

        botaoBuscar.setText("Buscar po CNPJ");
        botaoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoBuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botaoBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFormattedTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoRealizaOperacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(botaoRealizaOperacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoBuscar))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void botaoRealizaOperacaoMouseClicked(java.awt.event.MouseEvent evt) {                                                  
        // TODO add your handling code here:
        String tecnico;
        //String acad = jFormattedTextField3.getText();
        tecnico = jFormattedTextField4.getText();
        
        try {
            this.tecnico = database.getTecnico(tecnico);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosLuta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*if(this.tecnico == null){
            JOptionPane.showMessageDialog(null,"Tecnico não existente" , "Tecnico não existente", JOptionPane.ERROR_MESSAGE);
            return;
        }*/
        
        academia = new Academia(jFormattedTextField1.getText(), jFormattedTextField2.getText(), 
               jFormattedTextField3.getText(), this.tecnico);    
        try {
            switch (optionOperacao){
                case 1:
                    database.atualizaAcademia(academia);
                    break;
                case 2:
                    database.deletaAcademia(academia);
                    break;
                case 3: 
                    database.insereAcademia(academia);
                    break;
                case 4:
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosTecnico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao inserir técnico", JOptionPane.ERROR_MESSAGE);
        }
        try {
            viewTable();
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                                 

    private void botaoBuscarMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        try { 
            database = new Database("GVFerreira", "171026985");
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {    
            Academia aca = database.getAcademia(jFormattedTextField1.getText());
            //System.out.print(tec.cpf+tec.nome+tec.nacionalidade+tec.arteMarcial);
            modelo.addRow(new Object[]{
                aca.getCnpj(),
                aca.getNome(),
                aca.getEndereco(),
                aca.getTecnico2()
            });
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jFormattedTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    


    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoRealizaOperacao;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}

