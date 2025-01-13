package com.mycompany.donezodraft;

import java.awt.Font;
import java.io.InputStream;
import javax.swing.JFrame;

public class LandingPage extends javax.swing.JFrame {
    public LandingPage() {
        initComponents();
    setBounds(450, 100, 1082, 747);

        try {
        InputStream outfitFontStream = getClass().getResourceAsStream("/fontStyles/Outfit-ExtraBold.ttf");
        Font outfitFont = Font.createFont(Font.TRUETYPE_FONT, outfitFontStream).deriveFont(55f);
        lblTasks.setFont(outfitFont);
        lblDoneZo.setFont(outfitFont);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTasks = new javax.swing.JLabel();
        lblDoneZo = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(231, 231, 231));
        setPreferredSize(new java.awt.Dimension(1083, 710));
        setResizable(false);
        getContentPane().setLayout(null);

        lblTasks.setBackground(new java.awt.Color(0, 0, 102));
        lblTasks.setForeground(new java.awt.Color(0, 0, 102));
        lblTasks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTasks.setText("Tasks?");
        getContentPane().add(lblTasks);
        lblTasks.setBounds(190, 200, 680, 90);

        lblDoneZo.setForeground(new java.awt.Color(0, 0, 102));
        lblDoneZo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoneZo.setText("Already DoneZo.");
        getContentPane().add(lblDoneZo);
        lblDoneZo.setBounds(160, 290, 760, 80);

        lblMessage.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.");
        getContentPane().add(lblMessage);
        lblMessage.setBounds(190, 360, 660, 60);

        btnLogin.setBackground(new java.awt.Color(231, 231, 231));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 102));
        btnLogin.setText("Log In");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(550, 460, 150, 30);

        btnSignIn.setBackground(new java.awt.Color(0, 0, 102));
        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignIn.setForeground(new java.awt.Color(255, 255, 255));
        btnSignIn.setText("Sign In");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignIn);
        btnSignIn.setBounds(370, 460, 160, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImages/LandingPage.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        LoginForm login = new LoginForm();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        SignUp sign = new SignUp();
        sign.setVisible(true);
        sign.pack();
        sign.setLocationRelativeTo(null);
        sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnSignInActionPerformed

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
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LandingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDoneZo;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTasks;
    // End of variables declaration//GEN-END:variables
}
