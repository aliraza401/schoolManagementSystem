
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


public class CourseForm extends javax.swing.JFrame {
    Connection con;
    DefaultTableModel model;
    
    public CourseForm() {
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
        ArrayList<Courses> aList = new ArrayList();
        
        try
        {
           Statement s = con.createStatement();
           String sql = " SELECT * FROM `course`  ORDER BY `course_id` DESC";
           s.executeQuery(sql);
           
           ResultSet rs = s.executeQuery(sql);
        
           while(rs.next())
           {
                  int  id =rs.getInt("course_id");
               String name = rs.getString("course_name");
              
               int  credits =rs.getInt("credit_hours");
                 int  code =rs.getInt("course_code");
               Courses ds = new Courses( id , name,code,credits );
               
               aList.add(ds);
           }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        for(int i = 0 ; i < aList.size() ; i++ )
        {
                int id = aList.get(i).getCourse_id();
                  String name = aList.get(i).getCourse_Name();
                 int credits = aList.get(i).getCredits_hour();
                  int code=aList.get(i).getCourse_code();
            Object[] o = new Object[4];
            o[0] = id;
            o[1] = name;
             o[2]=code;
            o[3]=credits;
            
           
            
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
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jText3 = new javax.swing.JTextField();
        serRec = new javax.swing.JButton();
        remRec = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        resetSerch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jText2 = new javax.swing.JTextField();
        jText5 = new javax.swing.JTextField();
        addRec = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jText1 = new javax.swing.JTextField();
        jText4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jSeparator1.setBackground(new java.awt.Color(255, 102, 102));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Search by name or id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("NAME");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jText3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jText3.setForeground(new java.awt.Color(0, 0, 255));
        jText3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText3ActionPerformed(evt);
            }
        });
        jText3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jText3KeyPressed(evt);
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
                "course_id", "course_name", "course_code", "credits"
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("CODE");

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

        jText4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jText4.setForeground(new java.awt.Color(51, 51, 255));
        jText4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("CREDITS");

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
                        .addComponent(jText5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(serRec, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(remRec, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(addRec, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jText3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jText2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(jText1)))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jText4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(654, 654, 654))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jText1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jText2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jText4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remRec, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
      int  id = Integer.parseInt(jText1.getText());
                String name = jText2.getText();
                
                int  credits = Integer.parseInt(jText4.getText());
               
                int code  = Integer.parseInt(jText3.getText());
         if( jText1.toString().equals("") || jText2.toString().equals("") ||jText4.toString().equals("")||jText3.toString().equals("")  )
        {
            JOptionPane.showMessageDialog(null, "ENTER RECORD AGAIN (BLANK ENTERY)");
        }
        else
        {
            
                 try
                 {

                     Statement s = con.createStatement();
                     String sql = " UPDATE `course` SET `course_id` = '"+id+"', `course_name` = '"+name+"',`credit_hours` = '"+credits+"',`course_code` = '"+code+"' WHERE `course`.`course_id` = '"+id+"' ; ";
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
                 jText4.setText("");
                
               
                 
            
            }
        
         
     }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jText3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText3ActionPerformed

    private void jText3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jText3KeyPressed

    }//GEN-LAST:event_jText3KeyPressed

    private void serRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serRecActionPerformed
     String data = jText5.getText();
     ArrayList<Courses> aList = new ArrayList();
     
     if(data.equals(""))
     {
         JOptionPane.showMessageDialog(null, "Emptey Entery");
     }
     else
     {
        try
        {
            Statement s = con.createStatement();
            String sql = " SELECT * FROM `course` WHERE `course_name` LIKE '%"+data+"%'";
            s.executeQuery(sql);

            ResultSet rs = s.executeQuery(sql);

            while(rs.next())
            {
                      int  id =rs.getInt("course_id");
               String name = rs.getString("course_name");
               
               int  credits =rs.getInt("credit_hours");
                 int  code =rs.getInt("course_code");
               Courses ds = new Courses( id , name,code ,credits );
               
                  aList.add(ds);
            }

        }catch(SQLException e)
        {
            System.out.println(e);
        }

        clearRecord();
        for( int i = 0 ; i < aList.size() ; i++ )
        {
            Object[] o = new Object[4]; 

            o[0] = aList.get(i).getCourse_id();
            o[1] = aList.get(i).getCourse_Name();
            o[2] = aList.get(i).getCourse_code();
            o[3] = aList.get(i).getCredits_hour();
       
            
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
            String name= (jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
            try
            {
                Statement s = con.createStatement();
                String sql = " DELETE FROM `course` WHERE `course`.`course_name` = '"+name+"' ";
                s.executeLargeUpdate(sql);
                
                clearRecord();
                displayRecord();
                JOptionPane.showMessageDialog(null,"Record Removed successfully");
                 jText1.setText(""); 
                jText2.setText("");
                 jText4.setText("");
                
                  
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

        int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        String name = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        
        int  code= Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        int credits = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
   jText1.setText(id+"");
        jText2.setText(name);
         jText4.setText(credits+"");
            jText3.setText(code+"");
       
 
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
          ArrayList<Courses> aList = new ArrayList();
     if(data.equals(""))
     {
         JOptionPane.showMessageDialog(null, "Emptey Entery");
     }
     else
     {    
     try
     {
         Statement s = con.createStatement();
         String sql = " SELECT * FROM `course` WHERE  `course_id` LIKE '%"+data+"%'  ORDER BY `course_id` DESC";
         s.executeQuery(sql);
         
         ResultSet rs = s.executeQuery(sql);
         
         while(rs.next())
         {
                int  id =rs.getInt("course_id");
               String name = rs.getString("course_name");
             
               int  credits =rs.getInt("credit_hours");
                 int  code =rs.getInt("course_code");
               Courses ds = new Courses( id , name,code,credits );
               
               aList.add(ds);
         }
         
     }catch(SQLException e)
     {
         System.out.println(e);
     }

     clearRecord();
     for( int i = 0 ; i < aList.size() ; i++ ){
         int id = aList.get(i).getCourse_id();
            String name = aList.get(i).getCourse_Name();
           
            
            int credits = aList.get(i).getCredits_hour();
            int code=aList.get(i).getCourse_code();
            
           Object[] o = new Object[4];
            o[0] = id;
            o[1] = name;
            
            o[2]=credits;
            
            o[3]=code;
            model.addRow(o);
     }
     
    
     }
     }
    }//GEN-LAST:event_jText5KeyPressed

    private void addRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecActionPerformed
            
                int  id = Integer.parseInt(jText1.getText());
                String name = jText2.getText();
                int code  = Integer.parseInt(jText3.getText());
                int  credits = Integer.parseInt(jText4.getText());
               
                
        
         if( jText1.toString().equals("") || jText2.toString().equals("") || jText3.toString().equals("") ||jText4.toString().equals("")  )
        {
            JOptionPane.showMessageDialog(null, "ENTER RECORD AGAIN (BLANK ENTERY)");
        }
        else
        {
            
                 try
                 {

                     Statement s = con.createStatement();
                     String sql = "INSERT INTO `course` (`course_id`, `course_name`,  `credit_hours`,  `course_code`) VALUES ('"+id+"', '"+name+"','"+credits+"','"+code+"');";
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
                 jText4.setText("");
               
                
                
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
                 jText4.setText("");
                 jText3.setText("");
                 jText1.setText("");
            
                    
                  clearRecord();
                  displayRecord();
        
    }//GEN-LAST:event_formMouseClicked

    private void jText4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jText4ActionPerformed

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
            java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseForm().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jText1;
    private javax.swing.JTextField jText2;
    private javax.swing.JTextField jText3;
    private javax.swing.JTextField jText4;
    private javax.swing.JTextField jText5;
    private javax.swing.JButton remRec;
    private javax.swing.JButton resetSerch;
    private javax.swing.JButton serRec;
    // End of variables declaration//GEN-END:variables
}
