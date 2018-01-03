/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author castillo
 */
public class enrollstudent extends javax.swing.JInternalFrame {
        DBconnetion mycon = new DBconnetion();
        Connection conn;
        PreparedStatement pstmt;
        Statement stmt;
        ResultSet rs;
        String sectionid;
        String yearelvelset;
        boolean sectionstudent = false;
        String ernollstudent;
        String enrollstudentrecord;
        String enrolladdsubject;
        
   public enrollstudent() {
        initComponents();
        mycon.doConnect();
        student();
        timer();
        yearlevelstudent();
        cbsection.setEnabled(false);
        cbyearlevel.setEnabled(true);
        btnenter.setEnabled(true);
        logindummy();
        employeeid();
        
  
       

        
    }
   
    void timer(){
     Timer t = new Timer(1000,new Listener());
     t.start();
    
}
class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Date date = Calendar.getInstance().getTime();
            SimpleDateFormat frmtime = new SimpleDateFormat("hh:mm:ss a");
            String timenow = frmtime.format(date);
            lbltime.setText(timenow.toString());

            Format frmt = new SimpleDateFormat("MMMMM dd, yyyy");
            String dshow = frmt.format(date); 
            lbldate.setText(dshow.toString());
        }
}
   
   void student(){
       try {
           conn = mycon.con;
           stmt = conn.createStatement();
           rs = stmt.executeQuery("select * from registertable");
           DefaultTableModel model = ((DefaultTableModel)tblstudent.getModel());
           model.getDataVector().removeAllElements();
           
           while(rs.next()){
               model.addRow(new Object[]{rs.getString(35), rs.getString(1), rs.getString(2), rs.getString(3)});
           }
       } catch (Exception e) {
       }
   }
   
   void junior(){
       try {
           conn = mycon.con;
           stmt = conn.createStatement();
           String juniorenroll = "JUNIOR";
           rs = stmt.executeQuery("SELECT \n" +
"  section.sectionname\n" +
"FROM \n" +
"  public.section, \n" +
"  public.yearlevel, \n" +
"  public.category\n" +
"WHERE \n" +
"  section.yearlevelid = yearlevel.yearlevelid AND\n" +
"  yearlevel.categoryid = category.categoryid and category.categoryname='" + juniorenroll + "'");
           
           while(rs.next()){
               cbsection.addItem(rs.getString(1));
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
       }
   }
   
   void senior(){
       try {
           conn = mycon.con;
           stmt = conn.createStatement();
           String seniorenroll = "SENIOR";
           rs = stmt.executeQuery("select * from section");
       } catch (Exception e) {
       }
       
   }
   
   void section(){
       try {
           
           stmt = conn.createStatement();
           rs = stmt.executeQuery("select * from section where yearlevelid='" + yearelvelset + "'");
           
           while(rs.next()){
               cbsection.addItem(rs.getString(2));
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
       }
   }
   
   void yearlevelstudent(){
       try {
           conn = mycon.con;
           stmt = conn.createStatement();
           rs = stmt.executeQuery("select * from yearlevel");
           
           while(rs.next()){
               cbyearlevel.addItem(rs.getString(2));
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
       }
   }
   
       void logindummy(){
    Connection con = mycon.con;
    ResultSet rsdummmy;
    Statement stmtdummy;
    
        try {
            stmtdummy = con.createStatement();
            rsdummmy = stmtdummy.executeQuery("select username from logindummy");
            String user;
            
            if(rsdummmy.next()){
                
                user = rsdummmy.getString(1).toString();
                lbluser.setText(user);
                
            }
        } catch (Exception e) {
        }
}
    void employeeid(){
        try {
            Connection con = mycon.con;
            ResultSet rsemployeeid;
            Statement stmtemployeeid;
            
            try {
                stmtemployeeid = con.createStatement();
                rsemployeeid = stmtemployeeid.executeQuery("select * from admin where username like'" + lbluser.getText() + "%'");
                String employeeID;
                if(rsemployeeid.next()){
                    employeeID = rsemployeeid.getString(1).toString();
                    lblemployeeid.setText(employeeID);
                }
            } catch (Exception e) {
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
        jLabel3 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblemployeeid = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtstudentsearch = new javax.swing.JTextField();
        lblstudlast = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblstudid = new javax.swing.JLabel();
        lblstudfirst = new javax.swing.JLabel();
        lblstudmiddle = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblstudent = new javax.swing.JTable();
        btnshowdata = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbsection = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbyearlevel = new javax.swing.JComboBox<>();
        btnenter = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Date:");

        lbldate.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel11.setText("Time:");

        lbltime.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel10.setText("User:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel12.setText("Employer ID:");

        lblemployeeid.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        lbluser.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbluser, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblemployeeid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbldate, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(lbltime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblemployeeid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 580, 80);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/Student-id-icon.png"))); // NOI18N
        jButton1.setText("Enroll");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttonicons/Button-Close-icon.png"))); // NOI18N
        jButton3.setText("Cancel enroll");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(0, 80, 580, 80);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel1.setText("Yearlevel:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 410, 110, 30);

        txtstudentsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtstudentsearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtstudentsearch);
        txtstudentsearch.setBounds(110, 220, 280, 30);

        lblstudlast.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblstudlast);
        lblstudlast.setBounds(200, 350, 290, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Firstname:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 290, 110, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setText("Middlename:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 320, 120, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel6.setText("Search:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 540, 140, 30);

        lblstudid.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblstudid);
        lblstudid.setBounds(200, 260, 290, 30);

        lblstudfirst.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblstudfirst);
        lblstudfirst.setBounds(200, 290, 280, 30);

        lblstudmiddle.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jPanel1.add(lblstudmiddle);
        lblstudmiddle.setBounds(200, 320, 290, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel7.setText("Student ID:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 260, 110, 30);

        tblstudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "Firstname", "Middlename", "Lastname"
            }
        ));
        tblstudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblstudentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblstudent);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 590, 580, 100);

        btnshowdata.setText("Show Data");
        btnshowdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowdataActionPerformed(evt);
            }
        });
        jPanel1.add(btnshowdata);
        btnshowdata.setBounds(480, 220, 90, 30);

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(400, 220, 70, 30);

        jPanel1.add(cbsection);
        cbsection.setBounds(150, 500, 300, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("Lastname:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 350, 110, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel8.setText("Section:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 500, 110, 30);

        jPanel1.add(cbyearlevel);
        cbyearlevel.setBounds(160, 410, 360, 30);

        btnenter.setText("Enter");
        btnenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenterActionPerformed(evt);
            }
        });
        jPanel1.add(btnenter);
        btnenter.setBounds(270, 450, 140, 30);

        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(470, 500, 90, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel9.setText("Enroll ID");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 220, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtstudentsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstudentsearchKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtstudentsearch.getText().isEmpty()){
            
        }else{
            try {
           conn = mycon.con;
           stmt = conn.createStatement();
           rs = stmt.executeQuery("select * from registertable where studfirst like'" + txtstudentsearch.getText().toUpperCase() + "%' or studmiddle like'" + txtstudentsearch.getText().toUpperCase() + "%' or studlast like'" + txtstudentsearch.getText().toUpperCase() + "%' or accountnumber like'" + txtstudentsearch.getText().toUpperCase() + "%'");
           
           DefaultTableModel model = ((DefaultTableModel)tblstudent.getModel());
           model.getDataVector().removeAllElements();
           
           while(rs.next()){
               model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
               lblstudid.setText(rs.getString(1));
               lblstudfirst.setText(rs.getString(2));
               lblstudmiddle.setText(rs.getString(3));
               lblstudlast.setText(rs.getString(4));
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
       }
        }
        }
        
    }//GEN-LAST:event_txtstudentsearchKeyReleased

    private void btnshowdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowdataActionPerformed
        student();
    }//GEN-LAST:event_btnshowdataActionPerformed

    private void tblstudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblstudentMouseClicked
        try {
            int studentrow = tblstudent.getSelectedRow();
            String selectrow1 = (tblstudent.getModel().getValueAt(studentrow, 0).toString());
            String selectrow2 = (tblstudent.getModel().getValueAt(studentrow, 1).toString());
            String selectrow3 = (tblstudent.getModel().getValueAt(studentrow, 2).toString());
            String selectrow4 = (tblstudent.getModel().getValueAt(studentrow, 3).toString());
            
            String tablequery = "select * from registertable where studfirst='" + selectrow2 + "' or studmiddle='" + selectrow3 + "' or studlast='" + selectrow4 + "'";
            pstmt = conn.prepareStatement(tablequery);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                lblstudid.setText(rs.getString(35));
                lblstudfirst.setText(rs.getString(1));
                lblstudmiddle.setText(rs.getString(2));
                lblstudlast.setText(rs.getString(3));
                ernollstudent = rs.getString(35);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_tblstudentMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(lblstudid.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill in the Enroll ID");
        }else{
             int ask = JOptionPane.showConfirmDialog(this, "Enroll Student?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(ask == JOptionPane.YES_OPTION){
            if(cbsection.getSelectedItem() == null){
                JOptionPane.showMessageDialog(this, "Please set the yearlevel and select the section first");
            }else{
                PreparedStatement recordstudent;
            PreparedStatement deleterecord;
            PreparedStatement enrollstudentrecord;
            PreparedStatement enrolladdsubject;
            try {
              
                   String recordstudentinformation = "insert into student select * from registertable where accountnumber='" + lblstudid.getText().toUpperCase() + "'";
                recordstudent = conn.prepareStatement(recordstudentinformation);
                recordstudent.execute();
            String querysave = "insert into ernollstudent values(?,?,?,?)";
            String queryaddsubjectenroll = "insert into enrolladdsubject values(?,?,?,?)";
            String querysaveenrollstudentrecord = "insert into enrollstudentrecord values(?,?,?)";
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from section where sectionname='" + cbsection.getSelectedItem().toString() + "'");
            if(rs.next()){
                sectionid = rs.getString(1);
            }
            pstmt = conn.prepareStatement(querysave);
            pstmt.setString(1, ernollstudent);
            pstmt.setString(2, lblstudid.getText().toUpperCase());
            pstmt.setString(3, sectionid);
            pstmt.setString(4, lbldate.getText());
 
            pstmt.execute();
            
            enrollstudentrecord = conn.prepareStatement(querysaveenrollstudentrecord);
            enrollstudentrecord.setString(1, ernollstudent);
            enrollstudentrecord.setString(2, lblstudid.getText().toUpperCase());
            enrollstudentrecord.setString(3, sectionid);
            enrollstudentrecord.execute();
            
            enrolladdsubject = conn.prepareStatement(queryaddsubjectenroll);
            enrolladdsubject.setString(1, ernollstudent);
            enrolladdsubject.setString(2, lblstudid.getText());
            enrolladdsubject.setString(3, sectionid);
            enrolladdsubject.setString(4, lbldate.getText());
            enrolladdsubject.execute();
            
            
            String deletestudentinformation = "delete from registertable where accountnumber=?";
            deleterecord = conn.prepareStatement(deletestudentinformation);
            deleterecord.setInt(1, Integer.parseInt(lblstudid.getText()));
            deleterecord.execute();
            
            JOptionPane.showMessageDialog(this, "Student has been enrolled");
           
            lblstudid.setText(null);
            lblstudfirst.setText(null);
            lblstudmiddle.setText(null);
            lblstudlast.setText(null);
            student();
            
            subject subjectform = new subject();
            subjectform.setVisible(true);
            studentform studentrecord = new studentform();
             this.dispose();
             studentrecord.setVisible(false);
            studentrecord.close(); 
                
                
           
            
            
            
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            }
            }
            
        }
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenterActionPerformed

        try {
            cbsection.setEnabled(true);
            sectionstudent = true;
            Statement sectionstatement;
            ResultSet sectionresult;
            conn = mycon.con;
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from yearlevel where yearlevelname='" + cbyearlevel.getSelectedItem().toString() + "'");
            
            if(rs.next()){
                yearelvelset = rs.getString(1);
            }
                            cbsection.removeAllItems();
            sectionstatement = conn.createStatement();
            sectionresult = sectionstatement.executeQuery("select * from section where yearlevelid='" + yearelvelset + "'");
            
            while(sectionresult.next()){
                cbsection.addItem(sectionresult.getString(2));
            }
            
            cbyearlevel.setEnabled(false);
            btnenter.setEnabled(false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }//GEN-LAST:event_btnenterActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cbsection.removeAllItems();
        cbyearlevel.setEnabled(true);
        btnenter.setEnabled(true);
        cbsection.setEnabled(false);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int askcancel = JOptionPane.showConfirmDialog(this, "Do you want to cancel enroll?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(askcancel == JOptionPane.YES_OPTION){
            if(lblstudid.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please select the student first");
            }else{
                PreparedStatement deleterecord;
                try {
                    conn = mycon.con;
                   String querycancel = "insert into student select * from registertable where accountnumber=?";
                   pstmt = conn.prepareStatement(querycancel);
                   pstmt.setString(1, lblstudid.getText());
                   pstmt.execute();
                   
                   String deletequery = "delete from registertable where accountnumber=?";
                   deleterecord = conn.prepareStatement(deletequery);
                   deleterecord.setString(1, lblstudid.getText());
                   deleterecord.execute();
                   
                   JOptionPane.showMessageDialog(this, "Enroll canceled");
                  
            lblstudid.setText(null);
            lblstudfirst.setText(null);
            lblstudmiddle.setText(null);
            lblstudlast.setText(null);
            student();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnenter;
    private javax.swing.JButton btnshowdata;
    private javax.swing.JComboBox<String> cbsection;
    private javax.swing.JComboBox<String> cbyearlevel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblemployeeid;
    private javax.swing.JLabel lblstudfirst;
    private javax.swing.JLabel lblstudid;
    private javax.swing.JLabel lblstudlast;
    private javax.swing.JLabel lblstudmiddle;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lbluser;
    private javax.swing.JTable tblstudent;
    private javax.swing.JTextField txtstudentsearch;
    // End of variables declaration//GEN-END:variables
}
