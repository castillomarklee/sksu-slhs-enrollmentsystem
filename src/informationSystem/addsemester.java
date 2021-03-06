/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationSystem;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
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
public class addsemester extends javax.swing.JFrame {
        DBconnetion mycon = new DBconnetion();
        Connection conn;
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;
        String semesterid;
    public addsemester() {
        initComponents();
        mycon.doConnect();
        semester();
        center();
    }
    
    void semester(){
        try {
            conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from semester");
            DefaultTableModel model = ((DefaultTableModel)tblsemester.getModel());
            model.getDataVector().removeAllElements();
            
            while(rs.next()){
                model.addRow(new Object[] {rs.getString(2)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }
            public void close(){
    WindowEvent winclose = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
}
            
                   void center(){
     
         Dimension screen = Toolkit.getDefaultToolkit().getScreenSize() ;
Dimension jscreen = this.getSize();

this.setLocation((screen.width - jscreen.width)/2, ((screen.height-jscreen.height)/2)-90);

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
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsemester = new javax.swing.JTable();
        txtsemester = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 460, 100);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setText("Save");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("Edit");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText("Delete");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setText("Clear");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setText("Back");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(0, 100, 460, 60);

        tblsemester.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Semester"
            }
        ));
        tblsemester.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsemesterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsemester);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 310, 452, 120);
        jPanel1.add(txtsemester);
        txtsemester.setBounds(40, 190, 370, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int asksave = JOptionPane.showConfirmDialog(this, "Save data?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(asksave == JOptionPane.YES_OPTION){
            if(txtsemester.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input the data first");
            }else{
                try {
                    conn = mycon.con;
                String querysave = "insert into semester(semestername) values(?)";
                pstmt = conn.prepareStatement(querysave);
                pstmt.setString(1, txtsemester.getText().toUpperCase());
                pstmt.execute();
                
                JOptionPane.showMessageDialog(this, "Data has been saved");
                
                txtsemester.setText(null);
                semester();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int askupdate = JOptionPane.showConfirmDialog(this, "Do you want to update this data?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(askupdate == JOptionPane.YES_OPTION){
            if(txtsemester.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please select the data first");
            }else{
                try {
                    conn = mycon.con;
                    String queryupdate = "update semester set semestername=? where semester=?";
                    pstmt = conn.prepareStatement(queryupdate);
                    pstmt.setString(1, txtsemester.getText().toUpperCase());
                    pstmt.setString(2, semesterid);
                    pstmt.execute();
                    
                    JOptionPane.showMessageDialog(this, "Data has been updated");
                    txtsemester.setText(null);
                    semester();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int askdelete = JOptionPane.showConfirmDialog(this, "Do you want to delete this data", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(askdelete == JOptionPane.YES_NO_OPTION){
            if(txtsemester.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please input the data first");
            }else{
                try {
                    conn = mycon.con;
                    String querydelete = "delete from semester where semesterid=?";
                    pstmt = conn.prepareStatement(querydelete);
                    pstmt.setString(1, semesterid);
                    pstmt.execute();
                    
                    JOptionPane.showMessageDialog(this, "Data has been deleted");
                    txtsemester.setText(null);
                    semester();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtsemester.setText(null);
        semester();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblsemesterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsemesterMouseClicked
        try {
            int semesterrow = tblsemester.getSelectedRow();
            
            String semesterrow1 = (tblsemester.getModel().getValueAt(semesterrow, 0).toString());
            
            conn = mycon.con;
            String query = "select * from semester where semestername='" + semesterrow1 + "'";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                semesterid = rs.getString(1);
                txtsemester.setText(rs.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_tblsemesterMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        settings informationsystemsettings = new settings();
        informationsystemsettings.setVisible(true);
        close();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(addsemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addsemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addsemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addsemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addsemester().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblsemester;
    private javax.swing.JTextField txtsemester;
    // End of variables declaration//GEN-END:variables
}
