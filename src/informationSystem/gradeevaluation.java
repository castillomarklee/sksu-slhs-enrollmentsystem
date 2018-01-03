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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author castillo
 */
public class gradeevaluation extends javax.swing.JInternalFrame {
        DBconnetion mycon = new DBconnetion();
        Connection conn;
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;
        String enrollid;
        int gradecount;
    public gradeevaluation() {
        initComponents();
        mycon.doConnect();
        subject();
    }
    
    void subject(){
           
        try {
            Statement graderecord;
        ResultSet graderecordresult;
          conn = mycon.con;
          stmt = conn.createStatement();
          rs = stmt.executeQuery("select * from enrollstudentgradedummy");
          
          if(rs.next()){
              enrollid = rs.getString(1);
          }
          enrollstudent();
          
          graderecord = conn.createStatement();
          graderecordresult = graderecord.executeQuery("SELECT \n" +
"  subject.subjectid, \n" +
"  subject.subjecttitle, \n" +
"  subject.subjectunit, \n" +
"  grade.subjectgrade\n" +
"FROM \n" +
"  public.subject, \n" +
"  public.grade\n" +
"WHERE \n" +
"  subject.subjectid = grade.subjectid and grade.enrollstudentid='" + enrollid + "'");
          DefaultTableModel model = ((DefaultTableModel)tblsubject.getModel());
          model.getDataVector().removeAllElements();
          
          while(graderecordresult.next()){
              model.addRow(new Object[] {graderecordresult.getString(1), graderecordresult.getString(2), graderecordresult.getString(3), graderecordresult.getString(4)});
          }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }
    
    void enrollstudent(){
        try {
            conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT \n" +
"  enrollstudentgradedummy.enrollstudentid, \n" +
"  student.studfirst, \n" +
"  student.studmiddle, \n" +
"  student.studlast\n" +
"FROM \n" +
"  public.enrolladdsubject, \n" +
"  public.enrollstudentgradedummy, \n" +
"  public.student\n" +
"WHERE \n" +
"  enrolladdsubject.accountnumber = student.accountnumber AND\n" +
"  enrollstudentgradedummy.enrollstudentid = enrolladdsubject.enrollstudentid and enrollstudentgradedummy.enrollstudentid='" + enrollid + "'");
            
            if(rs.next()){
                lblenrollid.setText(rs.getString(1));
                lblfirstname.setText(rs.getString(2));
                lblmiddlename.setText(rs.getString(3));
                lbllastname.setText(rs.getString(4));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsubject = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        lbllastname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblenrollid = new javax.swing.JLabel();
        lblfirstname = new javax.swing.JLabel();
        lblmiddlename = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jPanel1.setLayout(null);

        tblsubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Subject ID", "Subject title", "Subject unit", "Subject grade"
            }
        ));
        tblsubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsubjectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsubject);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 280, 500, 270);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 500, 70);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/evaluate icon.png"))); // NOI18N
        jButton1.setText("Evaluate");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(0, 70, 360, 60);

        lbllastname.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lbllastname);
        lbllastname.setBounds(170, 240, 220, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("Enroll ID");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 150, 90, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Firstname");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 180, 90, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Middlename");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 210, 120, 30);

        lblenrollid.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblenrollid);
        lblenrollid.setBounds(170, 150, 220, 30);

        lblfirstname.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblfirstname);
        lblfirstname.setBounds(170, 180, 220, 30);

        lblmiddlename.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblmiddlename);
        lblmiddlename.setBounds(170, 210, 220, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel6.setText("Lastname");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 240, 90, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/Delete-icon (2).png"))); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(370, 70, 130, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          try {
          conn = mycon.con;
          String query = "delete from enrollstudentgradedummy";
          pstmt = conn.prepareStatement(query);
          pstmt.execute();
          this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblsubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsubjectMouseClicked

    }//GEN-LAST:event_tblsubjectMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Statement gradestatement;
            ResultSet subjectgrade;
            
            conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT \n" +
"  grade.subjectgrade\n" +
"FROM \n" +
"  public.grade where enrollstudentid='" + enrollid + "'");
            
            ArrayList<Integer> gradearray = new ArrayList<>();
            int i = 1;
            while(rs.next()){
                gradearray.add(Integer.parseInt(rs.getString(1)));
            }
            int graderesult=0;
            for(int result=0;result<gradearray.size();result++){
                graderesult += gradearray.get(i);
            }
            
            gradestatement = conn.createStatement();
            subjectgrade = gradestatement.executeQuery("select count(*) from grade where enrollstudentid='" + enrollid + "'");
            
            if(subjectgrade.next()){
                gradecount = Integer.parseInt(subjectgrade.getString(1));
            }
            int gradetotal = graderesult/gradecount;
            
            int gradeevaluation = 79;
            
            if(gradeevaluation < gradetotal){
                JOptionPane.showMessageDialog(this, "General average: " + gradetotal + " Student Passed");
            }else{
                JOptionPane.showMessageDialog(this, "Student Failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Please input all grades");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblenrollid;
    private javax.swing.JLabel lblfirstname;
    private javax.swing.JLabel lbllastname;
    private javax.swing.JLabel lblmiddlename;
    private javax.swing.JTable tblsubject;
    // End of variables declaration//GEN-END:variables
}