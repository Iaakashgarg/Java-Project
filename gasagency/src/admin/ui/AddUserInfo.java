/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTO;
import operational.Checks;

/**
 *
 * @author Grapess
 */
public class AddUserInfo extends javax.swing.JInternalFrame {

    LoginInfoTO updateData;

    public AddUserInfo() {
        initComponents();
        setSize(850, 600);
    }

    public AddUserInfo(LoginInfoTO data) {
        this();
        this.updateData = data;
        if (data != null) {
            btnAdd.setText("Update This Record");
            jtfUserName.setText(data.getUserName());
            jtfUserName.setEnabled(false);
            jtfPassword.setText(data.getPassword());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();
        jtfUserName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add User Info");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Enter User Password :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 150, 270, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Enter User Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 70, 250, 29);
        getContentPane().add(jtfPassword);
        jtfPassword.setBounds(360, 150, 300, 40);
        getContentPane().add(jtfUserName);
        jtfUserName.setBounds(360, 70, 300, 40);

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnAdd.setText("Add User Info");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(120, 270, 470, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String message = "";
        try {
            String username = jtfUserName.getText().trim();
            String password = jtfPassword.getText().trim();
            if (Checks.isEmpty(username) || Checks.isEmpty(password)) {
                message = "Please Fill Any value in textboxes";
            } else {
                LoginInfoTO data = new LoginInfoTO();
                LoginInfoDAO action = new LoginInfoDAO();
                data.setUserName(username);
                data.setPassword(password);
                if (btnAdd.getText().contains("Add")) {
                    if (action.insertRecord(data)) {
                        message = " User is Added into System";
                    } else {
                        message = action.getErrorMessage();
                    }
                } else if (btnAdd.getText().contains("Update")) {
                    if (action.updateRecord(data)) {
                        message = " User Info is Update into System";
                        ViewUserInfo obj = new ViewUserInfo();
                        obj.setVisible(true);
                        JDesktopPane jdp = getDesktopPane();
                        jdp.add(obj);
                        try {
                            obj.setSelected(true);
                        } catch (PropertyVetoException ex) {
                        }
                        dispose();
                    } else {
                        message = action.getErrorMessage();
                    }
                }
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnAddActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfUserName;
    // End of variables declaration//GEN-END:variables
}
