/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.dao.CylinderTypeDAO;
import model.to.CylinderTypeTO;

/**
 *
 * @author Grapess
 */
public class ViewCylinderType extends javax.swing.JInternalFrame {

    ArrayList<CylinderTypeTO> allTypes;
    JPopupMenu myMenu;
    int row;

    public ViewCylinderType() {
        initComponents();
        setSize(750, 550);
        refreshTable();
        myMenu = new JPopupMenu();
        JMenuItem jmiUpdate = new JMenuItem("Update This Record");
        myMenu.add(jmiUpdate);
        JMenuItem jmiDelete = new JMenuItem("Delete This Record");
        myMenu.add(jmiDelete);
        row = -1;
        jmiUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });
        jmiDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });
    }

    private void updateRecord() {
        try {
            if (row != -1) {
                CylinderTypeTO data = allTypes.get(row);
                if (data != null) {
                    AddCylinderType obj = new AddCylinderType(data);
                    obj.setVisible(true);
                    obj.setTitle("Update Cylinder Type");
                    JDesktopPane jdp = getDesktopPane();
                    jdp.add(obj);
                    try {
                        obj.setSelected(true);
                    } catch (PropertyVetoException ex) {
                    }
                    dispose();
                }
            }
        } catch (Exception ex) {
        }
    }

    private void deleteRecord() {
        try {
            if (row != -1) {
                CylinderTypeTO data = allTypes.get(row);
                if (data != null) {
                    int option = JOptionPane.showConfirmDialog(this, " Are You Sure To Delete This Record?");
                    if (option == JOptionPane.OK_OPTION) {
                        CylinderTypeDAO action = new CylinderTypeDAO();
                        if (action.deleteRecord(data.getTypeID())) {
                            JOptionPane.showMessageDialog(this, "Deletion Happen");
                            refreshTable();
                        } else {
                            JOptionPane.showMessageDialog(this, action.getErrorMessage());
                        }
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    private void refreshTable() {
        String[] headerNames = {"User Name", "User Password"};
        allTypes = new CylinderTypeDAO().getAllRecord();
        if (allTypes != null) {
            int size = allTypes.size();
            Object[][] datas = new Object[size][2];
            int index = 0;
            for (CylinderTypeTO cit : allTypes) {
                datas[index] = new Object[2];
                datas[index][0] = cit.getTypeID();
                datas[index][1] = cit.getTypeName();
                index++;
            }
            jtCylinderInfo.setModel(new DefaultTableModel(datas, headerNames));
        } else {
            Object[][] datas = new Object[1][2];
            datas[0] = new Object[2];
            datas[0][0] = "NO DATA";
            datas[0][1] = "NO DATA";
            jtCylinderInfo.setModel(new DefaultTableModel(datas, headerNames));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtCylinderInfo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Cylinder Info");

        jtCylinderInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtCylinderInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtCylinderInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCylinderInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCylinderInfo);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtCylinderInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCylinderInfoMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            int idx = jtCylinderInfo.rowAtPoint(evt.getPoint());
            jtCylinderInfo.getSelectionModel().setSelectionInterval(idx, idx);
            row = jtCylinderInfo.getSelectedRow();
            myMenu.show(jtCylinderInfo, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jtCylinderInfoMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtCylinderInfo;
    // End of variables declaration//GEN-END:variables
}