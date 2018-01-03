/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationSystem;

import java.awt.event.KeyEvent;
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
public class subjectenroll extends javax.swing.JInternalFrame {
        DBconnetion mycon = new DBconnetion();
        Connection conn;
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;
        String yearlevelid;
        String result;
        String junior;
        String senior;
    public subjectenroll() {
        initComponents();
        mycon.doConnect();
        cbsemester.setEnabled(false);
        btnsemester.setEnabled(false);
        tblstudent.setEnabled(false);
    }
    
    void student(){
        try {
           String juniorcheck = "setjuniorenroll";
           String seniorcheck = "setseniorenroll";
           String setjunior = "JUNIOR";
           String setsenior = "SENIOR";
           
           if(junior == juniorcheck){
                conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT \n" +
"  enrollstudentrecord.enrollstudentid, \n" +
"  student.studfirst, \n" +
"  student.studmiddle, \n" +
"  student.studlast, \n" +
"  section.sectionname\n" +
"FROM \n" +
"  public.student, \n" +
"  public.section, \n" +
"  public.yearlevel, \n" +
"  public.category, \n" +
"  public.enrollstudentrecord\n" +
"WHERE \n" +
"  student.accountnumber = enrollstudentrecord.accountnumber AND\n" +
"  section.yearlevelid = yearlevel.yearlevelid AND\n" +
"  category.categoryid = yearlevel.categoryid AND\n" +
"  enrollstudentrecord.sectionid = section.sectionid and category.categoryname='" + setjunior + "'");
            
            DefaultTableModel model = ((DefaultTableModel) tblstudent.getModel());
            model.getDataVector().removeAllElements();
            
            while(rs.next()){
                model.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }
           } if(senior == seniorcheck){
                 conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT \n" +
"  enrollstudentrecord.enrollstudentid, \n" +
"  student.studfirst, \n" +
"  student.studmiddle, \n" +
"  student.studlast, \n" +
"  section.sectionname\n" +
"FROM \n" +
"  public.student, \n" +
"  public.section, \n" +
"  public.yearlevel, \n" +
"  public.category, \n" +
"  public.enrollstudentrecord\n" +
"WHERE \n" +
"  student.accountnumber = enrollstudentrecord.accountnumber AND\n" +
"  section.yearlevelid = yearlevel.yearlevelid AND\n" +
"  category.categoryid = yearlevel.categoryid AND\n" +
"  enrollstudentrecord.sectionid = section.sectionid and category.categoryname='" + setsenior + "'");
            
            DefaultTableModel model = ((DefaultTableModel) tblstudent.getModel());
            model.getDataVector().removeAllElements();
            
            while(rs.next()){
                model.addRow(new Object[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }
    
    void yearlevelcombobox(){
        try {
            String checkjunior = "setjuniorenroll";
            String checksenior = "setseniorenroll";
            
            if(junior == checkjunior){
                cbyearlevel.removeAllItems();
                conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT \n" +
"  yearlevel.yearlevelname\n" +
"FROM \n" +
"  public.yearlevel, \n" +
"  public.category\n" +
"WHERE \n" +
"  category.categoryid = yearlevel.categoryid and category.categoryname='JUNIOR'");
            
            while(rs.next()){
                cbyearlevel.addItem(rs.getString(1));
            }
            }if(senior == checksenior){
                cbyearlevel.removeAllItems();
                conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT \n" +
"  yearlevel.yearlevelname\n" +
"FROM \n" +
"  public.yearlevel, \n" +
"  public.category\n" +
"WHERE \n" +
"  category.categoryid = yearlevel.categoryid and category.categoryname='SENIOR'");
            
            while(rs.next()){
                cbyearlevel.addItem(rs.getString(1));
            }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }
    
    void semester(){
            try {
                String checkjunior = "setjuniorenroll";
                String checksenior = "setseniorenroll";
                
                if(junior == checkjunior){
                    cbsemester.setEnabled(false);
                } if(senior == checksenior){
                    cbsemester.removeAllItems();
                    conn = mycon.con;
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("select * from semester");
                    
                    while(rs.next()){
                        cbsemester.addItem(rs.getString(2));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
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
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnjunior = new javax.swing.JButton();
        btnsenior = new javax.swing.JButton();
        lblenrollname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblenrollid = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstudent = new javax.swing.JTable();
        cbyearlevel = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbsemester = new javax.swing.JComboBox<>();
        btnsemester = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setLayout(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 550, 80);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/Categories-applications-education-school-icon.png"))); // NOI18N
        jButton2.setText("Enroll Subject");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/clear icon.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/view icon.png"))); // NOI18N
        jButton4.setText("View");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        btnjunior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/junior icon.png"))); // NOI18N
        btnjunior.setText("Junior");
        btnjunior.setFocusable(false);
        btnjunior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnjunior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnjunior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnjuniorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnjunior);

        btnsenior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/senioricon.png"))); // NOI18N
        btnsenior.setText("Senior");
        btnsenior.setFocusable(false);
        btnsenior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsenior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsenior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseniorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnsenior);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(0, 80, 550, 80);

        lblenrollname.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblenrollname);
        lblenrollname.setBounds(170, 260, 330, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("Semester");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 170, 90, 30);

        lblenrollid.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblenrollid);
        lblenrollid.setBounds(170, 230, 330, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Search");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 300, 130, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setText("Student Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 260, 130, 30);

        tblstudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Enroll ID", "Firstname", "Middlename", "Lastname", "Section"
            }
        ));
        tblstudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblstudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblstudent);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 340, 550, 260);

        jPanel1.add(cbyearlevel);
        cbyearlevel.setBounds(150, 300, 250, 30);

        jButton1.setText("Enter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(420, 300, 90, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Enroll ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 230, 90, 30);

        cbsemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JUNIOR SEMESTER" }));
        jPanel1.add(cbsemester);
        cbsemester.setBounds(150, 170, 250, 30);

        btnsemester.setText("Enter");
        btnsemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsemesterActionPerformed(evt);
            }
        });
        jPanel1.add(btnsemester);
        btnsemester.setBounds(410, 170, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblstudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblstudentMouseClicked
        try {
            int enrollrow = tblstudent.getSelectedRow();
            
            String enrollrow1 = (tblstudent.getModel().getValueAt(enrollrow, 0).toString());
            String enrollrow2 = (tblstudent.getModel().getValueAt(enrollrow, 1).toString());
            String enrollrow3 = (tblstudent.getModel().getValueAt(enrollrow, 2).toString());
            String enrollrow4 = (tblstudent.getModel().getValueAt(enrollrow, 3).toString());
            String enrollrow5 = (tblstudent.getModel().getValueAt(enrollrow, 4).toString());
            conn = mycon.con;
            String enrollquery = "SELECT \n" +
"  enrollstudentrecord.enrollstudentid, \n" +
"  student.studfirst, \n" +
"  yearlevel.yearlevelid\n" +
"FROM \n" +
"  public.student, \n" +
"  public.enrollstudentrecord, \n" +
"  public.section, \n" +
"  public.yearlevel\n" +
"WHERE \n" +
"  student.accountnumber = enrollstudentrecord.accountnumber AND\n" +
"  enrollstudentrecord.sectionid = section.sectionid AND\n" +
"  yearlevel.yearlevelid = section.yearlevelid and enrollstudentrecord.enrollstudentid='" + enrollrow1 + "'";
            
            pstmt = conn.prepareStatement(enrollquery);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                String enrollidstudent = rs.getString(1);
                lblenrollid.setText(enrollidstudent);
                String enrollnamestudent = rs.getString(2);
                lblenrollname.setText(enrollnamestudent);
                yearlevelid = rs.getString(3);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_tblstudentMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int askenroll = JOptionPane.showConfirmDialog(this, "Enroll student?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(askenroll == JOptionPane.YES_OPTION){
            if(lblenrollid.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please select first student to be enrolled");
            }else{
                PreparedStatement recordgrade;
            PreparedStatement deleteenrollrecord;
            PreparedStatement cooltable;
            try {
                String checkjunior = "setjuniorenroll";
                String checksenior = "setseniorenroll";
                
                if(junior == checkjunior){
                    conn = mycon.con;
             String query = "insert into grade(subjectid,enrollstudentid) SELECT \n" +
"  subject.subjectid, \n" +
"  ernollstudent.enrollstudentid\n" +
"FROM \n" +
"  public.yearlevel, \n" +
"  public.subject, \n" +
"  public.section, \n" +
"  public.ernollstudent\n" +
"WHERE \n" +
"  yearlevel.yearlevelid = section.yearlevelid AND\n" +
"  subject.yearlevelid = yearlevel.yearlevelid AND\n" +
"  section.sectionid = ernollstudent.sectionid and ernollstudent.enrollstudentid='" + lblenrollid.getText() + "' and subject.yearlevelid='" + yearlevelid + "';";
             pstmt = conn.prepareStatement(query);
             pstmt.execute();
             
             String recordgradequery = "insert into recordgrade(subjectid,enrollstudentid) SELECT \n" +
"  subject.subjectid, \n" +
"  ernollstudent.enrollstudentid\n" +
"FROM \n" +
"  public.yearlevel, \n" +
"  public.subject, \n" +
"  public.section, \n" +
"  public.ernollstudent\n" +
"WHERE \n" +
"  yearlevel.yearlevelid = section.yearlevelid AND\n" +
"  subject.yearlevelid = yearlevel.yearlevelid AND\n" +
"  section.sectionid = ernollstudent.sectionid and ernollstudent.enrollstudentid='" + lblenrollid.getText() + "' and subject.yearlevelid='"+ yearlevelid + "';";
             recordgrade = conn.prepareStatement(recordgradequery);
             recordgrade.execute();
             
             String delete = "delete from enrollstudentrecord where enrollstudentid=?";
             deleteenrollrecord = conn.prepareStatement(delete);
             deleteenrollrecord.setString(1, lblenrollid.getText());
             deleteenrollrecord.execute();
             
             
             
             JOptionPane.showMessageDialog(this, "Subjects enrolled");
             lblenrollid.setText(null);
             lblenrollname.setText(null);
             cbyearlevel.setSelectedIndex(0);
             student();
                } if(senior == checksenior){
                    conn = mycon.con;
             String query = "insert into grade(subjectid,enrollstudentid) SELECT \n" +
"  subject.subjectid, \n" +
"  ernollstudent.enrollstudentid\n" +
"FROM \n" +
"  public.yearlevel, \n" +
"  public.subject, \n" +
"  public.section, \n" +
"  public.ernollstudent\n" +
"WHERE \n" +
"  yearlevel.yearlevelid = section.yearlevelid AND\n" +
"  subject.yearlevelid = yearlevel.yearlevelid AND\n" +
"  section.sectionid = ernollstudent.sectionid and ernollstudent.enrollstudentid='" + lblenrollid.getText() + "' and subject.yearlevelid='" + yearlevelid + "' and subject.semester='" + cbsemester.getSelectedItem().toString() + "'";
             pstmt = conn.prepareStatement(query);
             pstmt.execute();
             
             String recordgradequery = "insert into recordgrade(subjectid,enrollstudentid) SELECT \n" +
"  subject.subjectid, \n" +
"  ernollstudent.enrollstudentid\n" +
"FROM \n" +
"  public.yearlevel, \n" +
"  public.subject, \n" +
"  public.section, \n" +
"  public.ernollstudent\n" +
"WHERE \n" +
"  yearlevel.yearlevelid = section.yearlevelid AND\n" +
"  subject.yearlevelid = yearlevel.yearlevelid AND\n" +
"  section.sectionid = ernollstudent.sectionid and ernollstudent.enrollstudentid='" + lblenrollid.getText() + "' and subject.yearlevelid='"+ yearlevelid + "' and subject.semester='" + cbsemester.getSelectedItem().toString() + "'";
             recordgrade = conn.prepareStatement(recordgradequery);
             recordgrade.execute();
             
             String delete = "delete from enrollstudentrecord where enrollstudentid=?";
             deleteenrollrecord = conn.prepareStatement(delete);
             deleteenrollrecord.setString(1, lblenrollid.getText());
             deleteenrollrecord.execute();
             
             
             
             JOptionPane.showMessageDialog(this, "Subjects enrolled");
             lblenrollid.setText(null);
             lblenrollname.setText(null);
             cbyearlevel.setSelectedIndex(0);
             student();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            }
            }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        lblenrollid.setText(null);
        lblenrollname.setText(null);
        cbyearlevel.setSelectedIndex(0);
        tblstudent.setEnabled(false);
        cbsemester.setSelectedIndex(0);
        cbsemester.setEnabled(false);
        btnsemester.setEnabled(false);
        student();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        student();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            conn = mycon.con;
            String querysearch = "SELECT \n" +
"  enrollstudentrecord.enrollstudentid, \n" +
"  student.studfirst, \n" +
"  yearlevel.yearlevelid\n" +
"FROM \n" +
"  public.student, \n" +
"  public.enrollstudentrecord, \n" +
"  public.section, \n" +
"  public.yearlevel\n" +
"WHERE \n" +
"  student.accountnumber = enrollstudentrecord.accountnumber AND\n" +
"  enrollstudentrecord.sectionid = section.sectionid AND\n" +
"  yearlevel.yearlevelid = section.yearlevelid where yearlevel like'" + cbyearlevel.getSelectedItem().toString() + "%'";
            
            while(rs.next()){
                lblenrollid.setText(rs.getString(1));
                lblenrollname.setText(rs.getString(2));
                yearlevelid = rs.getString(3);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnjuniorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjuniorActionPerformed
        junior = "setjuniorenroll";
        senior = null;
        tblstudent.setEnabled(true);
        cbsemester.setEnabled(false);
        btnsemester.setEnabled(false);
        student();
        yearlevelcombobox();
    }//GEN-LAST:event_btnjuniorActionPerformed

    private void btnseniorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseniorActionPerformed
        senior = "setseniorenroll";
        junior = null;
        tblstudent.setEnabled(true);
        cbsemester.setEnabled(true);
        btnsemester.setEnabled(true);
        student();
        semester();
        yearlevelcombobox();
    }//GEN-LAST:event_btnseniorActionPerformed

    private void btnsemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsemesterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnjunior;
    private javax.swing.JButton btnsemester;
    private javax.swing.JButton btnsenior;
    private javax.swing.JComboBox<String> cbsemester;
    private javax.swing.JComboBox<String> cbyearlevel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblenrollid;
    private javax.swing.JLabel lblenrollname;
    private javax.swing.JTable tblstudent;
    // End of variables declaration//GEN-END:variables
}
