/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ufu.poo2.si.telas.menu;

import edu.ufu.poo2.si.telas.cliente.CadastroCliente;
import edu.ufu.poo2.si.telas.cliente.VisualizarCliente;
import edu.ufu.poo2.si.telas.estoque.CadastroProduto;
import edu.ufu.poo2.si.telas.estoque.VisualizarProduto;
import edu.ufu.poo2.si.telas.pedido.CadastroPedido;
import edu.ufu.poo2.si.telas.pedido.VisualizarPedido;
import edu.ufu.poo2.si.telas.vendedor.CadastroVendedor;
import edu.ufu.poo2.si.telas.vendedor.VisualizarVendedor;
import edu.ufu.poo2.si.util.exceptions.ErroException;

import javax.swing.*;

/**
 * @author gmahlow
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSistema = new javax.swing.JLabel();
        btnCadastroCliente = new javax.swing.JButton();
        btnVisualizarClientes = new javax.swing.JButton();
        labelSistema1 = new javax.swing.JLabel();
        btnCadastrarProduto = new javax.swing.JButton();
        btnVisualizarEstoque = new javax.swing.JButton();
        btnCadastrarPedido = new javax.swing.JButton();
        btnVisualizarPedido = new javax.swing.JButton();
        btnCadastrarVendedor = new javax.swing.JButton();
        btnVisualizarVendedor = new javax.swing.JButton();

        labelSistema.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        labelSistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSistema.setText("Sistema de Vendas");
        labelSistema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnCadastroCliente.setText("Cadastrar Cliente");
        btnCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroClienteActionPerformed(evt);
            }
        });

        btnVisualizarClientes.setText("Visualizar Clientes");
        btnVisualizarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnVisualizarClientesActionPerformed(evt);
                } catch (ErroException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });

        labelSistema1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        labelSistema1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSistema1.setText("Sistema de Vendas");
        labelSistema1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnCadastrarProduto.setText("Cadastrar Produto");
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });

        btnVisualizarEstoque.setText("Visualizar Estoque");
        btnVisualizarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarEstoqueActionPerformed(evt);
            }
        });

        btnCadastrarPedido.setText("Cadastrar Pedido");
        btnCadastrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPedidoActionPerformed(evt);
            }
        });

        btnVisualizarPedido.setText("Visualizar Pedidos");
        btnVisualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarPedidoActionPerformed(evt);
            }
        });

        btnCadastrarVendedor.setText("Cadastrar Vendedor");
        btnCadastrarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVendedorActionPerformed(evt);
            }
        });

        btnVisualizarVendedor.setText("Visualizar Vendedor");
        btnVisualizarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnVisualizarVendedorActionPerformed(evt);
                } catch (ErroException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSistema1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVisualizarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastrarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCadastrarVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVisualizarEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(btnVisualizarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVisualizarVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSistema1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisualizarClientes)
                    .addComponent(btnCadastroCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarProduto)
                    .addComponent(btnVisualizarEstoque, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarPedido)
                    .addComponent(btnVisualizarPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarVendedor)
                    .addComponent(btnVisualizarVendedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCadastroCliente.getAccessibleContext().setAccessibleName("btnCadastroCliente");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarClientesActionPerformed(java.awt.event.ActionEvent evt) throws ErroException {//GEN-FIRST:event_btnVisualizarClientesActionPerformed
        // TODO add your handling code here:
        new VisualizarCliente().setVisible(true);
    }//GEN-LAST:event_btnVisualizarClientesActionPerformed

    private void btnCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroClienteActionPerformed
        // TODO add your handling code here:
        new CadastroCliente().setVisible(true);
    }//GEN-LAST:event_btnCadastroClienteActionPerformed

    private void btnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutoActionPerformed
        // TODO add your handling code here:
        new CadastroProduto().setVisible(true);
    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnCadastrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPedidoActionPerformed
        // TODO add your handling code here:
        new CadastroPedido().setVisible(true);
    }//GEN-LAST:event_btnCadastrarPedidoActionPerformed

    private void btnVisualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarPedidoActionPerformed
        // TODO add your handling code here:
        new VisualizarPedido().setVisible(true);
    }//GEN-LAST:event_btnVisualizarPedidoActionPerformed

    private void btnVisualizarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarEstoqueActionPerformed
        // TODO add your handling code here:
        new VisualizarProduto().setVisible(true);
    }//GEN-LAST:event_btnVisualizarEstoqueActionPerformed

    private void btnCadastrarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVendedorActionPerformed
        // TODO add your handling code here:
        new CadastroVendedor().setVisible(true);
    }//GEN-LAST:event_btnCadastrarVendedorActionPerformed

    private void btnVisualizarVendedorActionPerformed(java.awt.event.ActionEvent evt) throws ErroException {//GEN-FIRST:event_btnVisualizarVendedorActionPerformed
        // TODO add your handling code here:
        new VisualizarVendedor().setVisible(true);
    }//GEN-LAST:event_btnVisualizarVendedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarPedido;
    private javax.swing.JButton btnCadastrarProduto;
    private javax.swing.JButton btnCadastrarVendedor;
    private javax.swing.JButton btnCadastroCliente;
    private javax.swing.JButton btnVisualizarClientes;
    private javax.swing.JButton btnVisualizarEstoque;
    private javax.swing.JButton btnVisualizarPedido;
    private javax.swing.JButton btnVisualizarVendedor;
    private javax.swing.JLabel labelSistema;
    private javax.swing.JLabel labelSistema1;
    // End of variables declaration//GEN-END:variables
}
