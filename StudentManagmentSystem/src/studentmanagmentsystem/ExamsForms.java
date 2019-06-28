
package studentmanagmentsystem;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ExamsForms extends javax.swing.JFrame {
    Connection con;
    DefaultTableModel model;
    Students s1;
    public ExamsForms() {
        initComponents();
        makeConnection();
        displayRecord();
    }
    
    
    public void makeConnection()
    {
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost/studen_managment_system", "root", "");
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
     
    public void displayRecord()
    {
        model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Exams> aList = new ArrayList();
        
        try
        {
           Statement s = con.createStatement();
           String sql = " SELECT * FROM `exams`  ORDER BY `marks` DESC";
           s.executeQuery(sql);
           
           ResultSet rs = s.executeQuery(sql);
        
           while(rs.next())
           {
          int s_id =rs.getInt("student_student_id");
        
              
               int  marks =rs.getInt("marks");
                 float percentage =rs.getFloat("percentage");
                 s1=new Students(s_id);
               Exams ds = new Exams(marks,percentage,s1 );
               
               aList.add(ds);
           }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        for(int i = 0 ; i < aList.size() ; i++ )
        {
                s1 = aList.get(i).getS();
                
                 int marks = aList.get(i).getMarks();
                  float  percentage=aList.get(i).getPercentage();
            Object[] o = new Object[3];
            o[0] = marks;
            o[1] = percentage;
             o[2]=s1.getStudent_id();
            
            
           
            
            model.addRow(o);
        }
        
     
    }
     
    public void clearRecord()
    {
        for( int i = 0 ; i < model.getRowCount() ; i++ )
        {
            for( int j = 0 ; j < model.getColumnCount() ; j++ )
            {
                model.setValueAt("", i, j);
            }
        }
        model.setRowCount(0);
    }
     

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jText2 = new javax.swing.JTextField();
        serRec = new javax.swing.JButton();
        remRec = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        resetSerch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jText4 = new javax.swing.JTextField();
        addRec = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jText1 = new javax.swing.JTextField();
        jText3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jSeparator1.setBackground(new java.awt.Color(255, 102, 102));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Search by name or id");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jText2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jText2.setForeground(new java.awt.Color(0, 0, 255));
        jText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText2ActionPerformed(evt);
            }
        });
        jText2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jText2KeyPressed(evt);
            }
        });

        serRec.setBackground(new java.awt.Color(204, 255, 204));
        serRec.setText("SEARCH ");
        serRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serRecActionPerformed(evt);
            }
        });

        remRec.setBackground(new java.awt.Color(204, 255, 204));
        remRec.setText("REMOVE  RECORD");
        remRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remRecActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "marks", "percentage", "Student_id"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(" ID");

        resetSerch.setBackground(new java.awt.Color(204, 255, 204));
        resetSerch.setText("RESET SEARCH");
        resetSerch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSerchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Marks");

        jText4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jText4.setForeground(new java.awt.Color(0, 0, 255));
        jText4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText4ActionPerformed(evt);
            }
        });
        jText4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jText4KeyPressed(evt);
            }
        });

        addRec.setBackground(new java.awt.Color(204, 255, 204));
        addRec.setText("ADD RECORD");
        addRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jText1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jText1.setForeground(new java.awt.Color(0, 0, 255));
        jText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText1ActionPerformed(evt);
            }
        });
        jText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jText1KeyPressed(evt);
            }
        });

        jText3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jText3.setForeground(new java.awt.Color(51, 51, 255));
        jText3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Percentage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jText4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(serRec, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(remRec, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(addRec, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jText1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jText3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addGap(654, 654, 654))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(335, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jText3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remRec, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jText4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serRec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     int selected = jTable1.getSelectedRow();
     if(selected < 0){
         JOptionPane.showMessageDialog(null,"NO ROW SELECTED\nselect row again");
     }
     else{
     int s_id = Integer.parseInt(jText1.getText());
                
                
                int  marks = Integer.parseInt(jText2.getText());
               
                float percentage = Float.parseFloat(jText3.getText());
         if( jText1.toString().equals("")  ||jText3.toString().equals("")||jText2.toString().equals("")  )
        {
            JOptionPane.showMessageDialog(null, "ENTER RECORD AGAIN (BLANK ENTERY)");
        }
        else
        {
            
                 try
                 {

                     Statement s = con.createStatement();
                     String sql = " UPDATE `exams` SET `marks`='"+marks+"',`percentage`='"+percentage+"',`student_student_id`='"+s_id+"' WHERE 1 ; ";
                     s.executeLargeUpdate(sql);
                     
                     clearRecord();
                     displayRecord();
                     JOptionPane.showMessageDialog(null, "Record updated successfully");
                 }catch(SQLException e)
                 {
                     System.out.println(e);
                 }
                     jText1.setText("");
                jText2.setText("");
                       
                 jText3.setText("");
                
               
                 
            
            }
        
         
     }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText2ActionPerformed
        // TODO add your handling percentage here:
    }//GEN-LAST:event_jText2ActionPerformed

    private void jText2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText2KeyPressed

    }//GEN-LAST:event_jText2KeyPressed

    private void serRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serRecActionPerformed
     String data = jText4.getText();
     ArrayList<Exams> aList = new ArrayList();
     
     if(data.equals(""))
     {
         JOptionPane.showMessageDialog(null, "Emptey Entery");
     }
     else
     {
        try
        {
            Statement s = con.createStatement();
            String sql = " SELECT * FROM `exams` WHERE `student_student_id` LIKE '%"+data+"%'";
            s.executeQuery(sql);

            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
              int s_id =rs.getInt("student_student_id");
        
              
               int  marks =rs.getInt("marks");
                 int  percentage =rs.getInt("percentage");
                        s1=new Students(s_id);
               Exams ds = new Exams(marks,percentage,s1 );
               
               aList.add(ds);
           }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        for(int i = 0 ; i < aList.size() ; i++ )
        {
                s1 = aList.get(i).getS();
                
                 int marks = aList.get(i).getMarks();
                  float percentage=aList.get(i).getPercentage();
            Object[] o = new Object[3];
            o[0] = marks;
            o[1] = percentage;
             o[2]=s1.getStudent_id();
       
            
            model.addRow(o);
       }
       
     }
    }//GEN-LAST:event_serRecActionPerformed

    private void remRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remRecActionPerformed
      int selected = jTable1.getSelectedRow();
      if( selected < 0 )
      {
          JOptionPane.showMessageDialog(null,"NO ROW SELECTED\nselect row again");
      }
      else
      {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record");
        if(option == 0 )
        {
            int marks= Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
            try
            {
                Statement s = con.createStatement();
                String sql = " DELETE FROM `exams` WHERE `exams`.`marks` = '"+marks+"' ";
                s.executeLargeUpdate(sql);
                
                clearRecord();
                displayRecord();
                JOptionPane.showMessageDialog(null,"Record Removed successfully");
                 jText1.setText(""); 
                jText2.setText("");
                 jText3.setText("");
     
            }
            catch(SQLException e )
            {
                System.out.println(e);
            }
          
        } 
      }
        
    }//GEN-LAST:event_remRecActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int s_id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
     
        
        float  percentage= Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        int marks = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
   jText1.setText(s_id+"");
       
         jText2.setText(marks+"");
            jText3.setText(percentage+"");
       
 
    }//GEN-LAST:event_jTable1MouseClicked

    private void resetSerchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSerchActionPerformed
        clearRecord();
        displayRecord();
    }//GEN-LAST:event_resetSerchActionPerformed

    private void jText4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText4ActionPerformed
        // TODO add your handling percentage here:
    }//GEN-LAST:event_jText4ActionPerformed

    private void jText4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText4KeyPressed
     if( evt.getKeyCode() == KeyEvent.VK_ENTER )
     {
          String data = jText4.getText();
          ArrayList<Exams> aList = new ArrayList();
     if(data.equals(""))
     {
         JOptionPane.showMessageDialog(null, "Emptey Entery");
     }
     else
     {    
     try
     {
         Statement s = con.createStatement();
         String sql = " SELECT * FROM `exams` WHERE  `marks` LIKE '%"+data+"%'  ORDER BY `marks` DESC";
         s.executeQuery(sql);
         
         ResultSet rs = s.executeQuery(sql);
         
         while(rs.next())
         {
      int s_id =rs.getInt("student_student_id");
        
              
               int  marks =rs.getInt("marks");
                 float  percentage =rs.getFloat("percentage");
                        s1=new Students(s_id);
               Exams ds = new Exams(marks,percentage,s1 );
               
               aList.add(ds);
         }
         
     }catch(SQLException e)
     {
         System.out.println(e);
     }

     clearRecord();
     for( int i = 0 ; i < aList.size() ; i++ ){
          s1 = aList.get(i).getS();
                
                 int marks = aList.get(i).getMarks();
                  float  percentage=aList.get(i).getPercentage();
            Object[] o = new Object[3];
            o[0] = marks;
            o[1] = percentage;
             o[2]=s1.getStudent_id();
            model.addRow(o);
     }
     
    
     }
     }
    }//GEN-LAST:event_jText4KeyPressed

    private void addRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecActionPerformed
            
               int s_id = Integer.parseInt(jText1.getText());
                
               float percentage = Float.parseFloat(jText3.getText());
                int  marks = Integer.parseInt(jText2.getText());
               
                
        
         if( jText1.toString().equals("")  || jText2.toString().equals("") ||jText3.toString().equals("")  )
        {
            JOptionPane.showMessageDialog(null, "ENTER RECORD AGAIN (BLANK ENTERY)");
        }
        else
        {
            
                 try
                 {

                     Statement s = con.createStatement();
                     String sql = "INSERT INTO `exams` ( `marks`,  `percentage`,  `student_student_id`) VALUES ('"+marks+"','"+percentage+"','"+s_id+"');";
                     s.executeLargeUpdate(sql);
                     
                     clearRecord();
                     displayRecord();
                     JOptionPane.showMessageDialog(null, "Record added successfully");

                 }catch(SQLException e)
                 {
                     System.out.println(e);
                     JOptionPane.showMessageDialog(null, "Record od this id already exist");
                 }
                  jText1.setText("");
                 jText2.setText("");
                
                 jText3.setText("");
               
                
                
            }
        
    }//GEN-LAST:event_addRecActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
MainMenu m = new MainMenu();
        m.setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText1ActionPerformed
        // TODO add your handling percentage here:
    }//GEN-LAST:event_jText1ActionPerformed

    private void jText1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText1KeyPressed
        // TODO add your handling percentage here:
    }//GEN-LAST:event_jText1KeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
                 jText2.setText("");
                 jText3.setText("");
             
                 jText1.setText("");
            
                    
                  clearRecord();
                  displayRecord();
        
    }//GEN-LAST:event_formMouseClicked

    private void jText3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText3ActionPerformed
        // TODO add your handling percentage here:
    }//GEN-LAST:event_jText3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting percentage (optional) ">
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
            java.util.logging.Logger.getLogger(ExamsForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamsForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamsForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamsForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamsForms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRec;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jText1;
    private javax.swing.JTextField jText2;
    private javax.swing.JTextField jText3;
    private javax.swing.JTextField jText4;
    private javax.swing.JButton remRec;
    private javax.swing.JButton resetSerch;
    private javax.swing.JButton serRec;
    // End of variables declaration//GEN-END:variables
}
