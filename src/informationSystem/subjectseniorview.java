/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author castillo
 */
public class subjectseniorview extends javax.swing.JInternalFrame {
        DBconnetion mycon = new DBconnetion();
    Connection conn;
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    public subjectseniorview() {
        initComponents();
        mycon.doConnect();
        loadyearlevel();
        tablesenior();
    }
    void loadyearlevel(){
        try {
            conn = mycon.con;
            stmt = conn.createStatement();
            String senioryearlevel = "SENIOR";
            rs = stmt.executeQuery("select studentyearlevel from yearlevel where studentcategory like'" + senioryearlevel.toUpperCase() + "%'");
            
            
            while(rs.next()){
                cbyearlevel.addItem(rs.getString(1));
            }
        } catch (Exception e) {
        }
    }
    
    void tablesenior(){
        try {
            conn = mycon.con;
            stmt = conn.createStatement();
            String seniorquery = "SENIOR";
            rs = stmt.executeQuery("SELECT \n" +
"  subject.\"sub_ID\", \n" +
"  subject.sub_title, \n" +
"  subject.sub_unit, \n" +
"  subject.sub_yearlevel, \n" +
"  teachertable.teacher_first, \n" +
"  subject.sub_category\n" +
"FROM \n" +
"  teachertable, \n" +
"  subject\n" +
"WHERE \n" +
"  teachertable.teacher_id = subject.teacher_id and sub_category like'" + seniorquery.toUpperCase() + "%'");
            DefaultTableModel model = ((DefaultTableModel)tblsubjectview.getModel());
            model.getDataVector().removeAllElements();
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbyearlevel = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsubjectview = new javax.swing.JTable();
        btnviewall = new javax.swing.JButton();

        setClosable(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        cbyearlevel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblsubjectview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Subject ID", "Subject Name", "Subject Unit", "Subject Yearlevel", "Teacher", "Category"
            }
        ));
        jScrollPane1.setViewportView(tblsubjectview);

        btnviewall.setText("View All");
        btnviewall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbyearlevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnviewall, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbyearlevel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnviewall, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT \n" +
"  subject.\"sub_ID\", \n" +
"  subject.sub_title, \n" +
"  subject.sub_unit, \n" +
"  subject.sub_yearlevel, \n" +
"  teachertable.teacher_first, \n" +
"  subject.sub_category\n" +
"FROM \n" +
"  teachertable, \n" +
"  subject\n" +
"WHERE \n" +
"  teachertable.teacher_id = subject.teacher_id and sub_yearlevel like'" + cbyearlevel.getSelectedItem().toString().toUpperCase() + "%'");
                        DefaultTableModel model = ((DefaultTableModel)tblsubjectview.getModel());
            model.getDataVector().removeAllElements();
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnviewallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewallActionPerformed
        tablesenior();
    }//GEN-LAST:event_btnviewallActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnviewall;
    private javax.swing.JComboBox<String> cbyearlevel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblsubjectview;
    // End of variables declaration//GEN-END:variables
}
