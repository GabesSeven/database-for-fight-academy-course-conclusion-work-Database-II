package trabalhobancodedados;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaDadosLuta extends javax.swing.JFrame {
    Database database;
    Luta luta;
    Lutador desafiante, desafiado;
    DefaultTableModel modelo;
    int optionOperacao;
    
    public TelaDadosLuta(int opcao) throws SQLException {
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
            for (Luta lut : database.getTodasLutas()) {
                //System.out.print(tec.cpf+tec.nome+tec.nacionalidade+tec.arteMarcial);
                modelo.addRow(new Object[]{
                    lut.getDesafiante().getCpf(),
                    lut.getDesafiado().getCpf(),
                    lut.getData()
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botaoRealizarOperacao = new javax.swing.JButton();
        botaoBuscar = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("LUTADOR DESAFIANTE");

        jLabel3.setText("LUTADOR DESAFIADO");

        jLabel5.setText("DATA");

        botaoRealizarOperacao.setText("Realizar Operação");
        botaoRealizarOperacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoRealizarOperacaoMouseClicked(evt);
            }
        });

        botaoBuscar.setText("Buscar por Todos Atributos");
        botaoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoBuscarMouseClicked(evt);
            }
        });

        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESAFIANTE", "DESAFIADO", "DATA"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(botaoRealizarOperacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel5))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(botaoRealizarOperacao)
                        .addGap(7, 7, 7)
                        .addComponent(botaoBuscar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void botaoBuscarMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        try { 
            database = new Database("GVFerreira", "171026985");
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String cpfDesafiante, cpfDesafiado;
        
        cpfDesafiante = jFormattedTextField1.getText();
        try {
            desafiante = database.getLutador(cpfDesafiante);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosLuta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(desafiante == null){
            JOptionPane.showMessageDialog(null,"Lutador não existente" , "Lutador não existente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        cpfDesafiado = jFormattedTextField2.getText();
        try {
            desafiado = database.getLutador(cpfDesafiado);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosLuta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(desafiado == null){
            JOptionPane.showMessageDialog(null, "Lutador não existente", "Lutador não existente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {    
            Luta lut = database.getLuta(desafiante, desafiado, jFormattedTextField3.getText());
            //System.out.print(tec.cpf+tec.nome+tec.nacionalidade+tec.arteMarcial);
                modelo.addRow(new Object[]{
                    lut.getDesafiante().getCpf(),
                    lut.getDesafiado().getCpf(),
                    lut.getData()
                });
        } catch (SQLException ex) {
            System.out.print("oiii111");
            Logger.getLogger(TelaDadosTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("oiii222");
    }                                        

    private void botaoRealizarOperacaoMouseClicked(java.awt.event.MouseEvent evt) {                                                   
        // TODO add your handling code here:
        String cpfDesafiante, cpfDesafiado;
        
        cpfDesafiante = jFormattedTextField1.getText();
        try {
            desafiante = database.getLutador(cpfDesafiante);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosLuta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(desafiante == null){
            JOptionPane.showMessageDialog(null,"Lutador não existente" , "Lutador não existente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        cpfDesafiado = jFormattedTextField2.getText();
        try {
            desafiado = database.getLutador(cpfDesafiado);
        } catch (SQLException ex) {
            Logger.getLogger(TelaDadosLuta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(desafiado == null){
            JOptionPane.showMessageDialog(null, "Lutador não existente", "Lutador não existente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        luta = new Luta(desafiante, desafiado, jFormattedTextField3.getText());
        
        try {
            switch (optionOperacao){
                case 2:
                    database.deletaLuta(luta);
                    break;
                case 3: 
                    database.insereLuta(luta);
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

    private void jFormattedTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    


    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoRealizarOperacao;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   


}

