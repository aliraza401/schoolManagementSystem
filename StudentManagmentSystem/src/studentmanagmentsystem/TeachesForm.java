
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


public class TeachesForm extends javax.swing.JFrame {
    Connection con;
    DefaultTableModel model;
    Teacher t1 ;
    Courses c1;
    
    public TeachesForm() {
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
        ArrayList<Teaches> aList = new ArrayList();
        
        try
        {
           Statement s = con.createStatement();
           String sql = " SELECT * FROM `teacher_teaches_course`  ORDER BY `teacher_teacher_id` DESC";
           s.executeQuery(sql);
           
           ResultSet rs = s.executeQuery(sql);
        
           while(rs.next())
           {
                  int t_id =rs.getInt("teacher_teacher_id");
            
              
               int  c_id =rs.getInt("course_course_id");
               
   t1= new Teacher(t_id);
   c1=new Courses(c_id);
         
               Teaches ds = new Teaches(t1,c1  );
               
               aList.add(ds);
           }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        for(int i = 0 ; i < aList.size() ; i++ )
        {
                t1 = aList.get(i).getT();
                 c1=aList.get(i).getC();
                  
            Object[] o = new Object[2];
            o[0] =t1.getTeacher_id() ;
            o[1] = c1.getCourse_id();
     
            
           
            
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        serRec = new javax.swing.JButton();
        remRec = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        resetSerch = new javax.swing.JButton();
        jText2 = new javax.swing.JTextField();
        jText5 = new javax.swing.JTextField();
        addRec = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jText1 = new javax.swing.JTextField();

        jSeparator1.setBackground(new java.awt.Color(255, 102, 102));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Course_id");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                "Teacher_id", "Course_id"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Teacher_id");

        resetSerch.setBackground(new java.awt.Color(204, 255, 204));
        resetSerch.setText("RESET SEARCH");
        resetSerch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSerchActionPerformed(evt);
            }
        });

        jText2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jText2.setForeground(new java.awt.Color(0, 0, 255));
        jText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText2ActionPerformed(evt);
            }
        });

        jText5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jText5.setForeground(new java.awt.Color(0, 0, 255));
        jText5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText5ActionPerformed(evt);
            }
        });
        jText5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jText5KeyPressed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(addRec, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jText5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resetSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(serRec, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(remRec, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jText1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(652, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(314, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(remRec, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jText5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serRec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
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
      int  t_id = Integer.parseInt(jText1.getText());
                int c_id = Integer.parseInt(jText2.getText());
                
               
         if( jText1.toString().equals("") || jText2.toString().equals("")   )
        {
            JOptionPane.showMessageDialog(null, "ENTER RECORD AGAIN (BLANK ENTERY)");
        }
        else
      {
            
                 try
                 {

                     Statement s = con.createStatement();
                     String sql = " UPDATE `teacher_teaches_courses` SET `teacher_teacher_id` = '"+t_id+"', `course_course_id` = '"+c_id+"' WHERE `teacher_teaches_course`.`teacher_teachera_id` = '"+t_id+"' ; ";
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
                       
                
               
                 
            
            }
        
         
     }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void serRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serRecActionPerformed
     String data = jText5.getText();
     ArrayList<Teaches> aList = new ArrayList();
     
     if(data.equals(""))
     {
         JOptionPane.showMessageDialog(null, "Emptey Entery");
     }
     else
     {
        try
        {
            Statement s = con.createStatement();
            String sql = " SELECT * FROM `teacher_teaches_id` WHERE `course_course_id` LIKE '%"+data+"%'";
            s.executeQuery(sql);

            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                      int  t_id =rs.getInt("teacher_teaches_id");
              int  c_id =rs.getInt("course_course_id");
               
         t1= new Teacher(t_id);
         c1= new Courses(c_id);
               Teaches ds = new Teaches(t1,c1  );
               
                  aList.add(ds);
            }

        }catch(SQLException e)
        {
            System.out.println(e);
        }

        clearRecord();
        for( int i = 0 ; i < aList.size() ; i++ )
        {
            Object[] o = new Object[2]; 

            o[0] = aList.get(i).getT();
            o[1] = aList.get(i).getC();
           
       
            
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
            int t_id= Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
            try
            {
                Statement s = con.createStatement();
                String sql = " DELETE FROM `teacher_teaches_course` WHERE `teacher_teaches_course`.`teacher_teacher_id` = '"+t_id+"' ";
                s.executeLargeUpdate(sql);
                
                clearRecord();
                displayRecord();
                JOptionPane.showMessageDialog(null,"Record Removed successfully");
                 jText1.setText(""); 
                jText2.setText("");
                 
                
          
            }
            catch(SQLException e )
            {
                System.out.println(e);
            }
          
        } 
      }
        
    }//GEN-LAST:event_remRecActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

       int t_id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
  
        
        int  c_id= Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
      
   jText1.setText(t_id+"");
        jText2.setText(c_id+"");
        
       
 
    }//GEN-LAST:event_jTable1MouseClicked

    private void resetSerchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSerchActionPerformed
        clearRecord();
        displayRecord();
    }//GEN-LAST:event_resetSerchActionPerformed

    private void jText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText2ActionPerformed

    private void jText5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText5ActionPerformed

    private void jText5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText5KeyPressed
     if( evt.getKeyCode() == KeyEvent.VK_ENTER )
     {
          String data = jText5.getText();
          ArrayList<Teaches> aList = new ArrayList();
     if(data.equals(""))
     {
         JOptionPane.showMessageDialog(null, "Emptey Entery");
     }
     else
     {    
     try
     {
         Statement s = con.createStatement();
         String sql = " SELECT * FROM `teacher_teaches_course` WHERE  `teacher_teacher_id` LIKE '%"+data+"%'  ORDER BY `teacher_teacher_id` DESC";
         s.executeQuery(sql);
         
         ResultSet rs = s.executeQuery(sql);
         
         while(rs.next())
         {
                int t_id =rs.getInt("teacher_teacher_id");
            
              
               int  c_id =rs.getInt("course_course_id");
               
   t1= new Teacher(t_id);
   c1=new Courses(c_id);
         
               Teaches ds = new Teaches(t1,c1  );
               
               aList.add(ds);
         }
         
     }catch(SQLException e)
     {
         System.out.println(e);
     }

     clearRecord();
     for( int i = 0 ; i < aList.size() ; i++ ){
         t1 = aList.get(i).getT();
                 c1=aList.get(i).getC();
                  
            Object[] o = new Object[2];
            o[0] =t1.getTeacher_id() ;
            o[1] = c1.getCourse_id();
            
            
            model.addRow(o);
     }
     
    
     }
     }
    }//GEN-LAST:event_jText5KeyPressed

    private void addRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecActionPerformed
            
               int  t_id= Integer.parseInt(jText1.getText());
              
                int c_id  = Integer.parseInt(jText2.getText());
                
               
                
        
         if( jText1.toString().equals("") || jText2.toString().equals("")   )
        {
            JOptionPane.showMessageDialog(null, "ENTER RECORD AGAIN (BLANK ENTERY)");
        }
        else
        {
            
                 try
                 {

                     Statement s = con.createStatement();
                     String sql = "INSERT INTO `teacher_teaches_course` (`teacher_teacher_id`, `course_course_id`) VALUES ('"+t_id+"', '"+c_id+"');";
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
                 
                
                
            }
        
    }//GEN-LAST:event_addRecActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
MainMenu m = new MainMenu();
        m.setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText1ActionPerformed

    private void jText1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText1KeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
                 jText2.setText("");
               
                 jText1.setText("");
            
                    
                  clearRecord();
                  displayRecord();
        
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(TeachesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeachesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeachesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeachesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TeachesForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRec;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jText1;
    private javax.swing.JTextField jText2;
    private javax.swing.JTextField jText5;
    private javax.swing.JButton remRec;
    private javax.swing.JButton resetSerch;
    private javax.swing.JButton serRec;
    // End of variables declaration//GEN-END:variables
}
