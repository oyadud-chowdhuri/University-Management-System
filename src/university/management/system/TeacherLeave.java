
package university.management.system;

import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import javax.swing.*;


public class TeacherLeave extends JFrame implements ActionListener{
    Choice cEmpid, leaveTime;
    JButton btnSubmit,btnCancel;
    JDateChooser dcDate;

    TeacherLeave() {
        
        setSize(550,500);
        setLocation(700,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblHeading = new JLabel("Apply Leave (Teacher)");
        lblHeading.setBounds(150,20,300,25);
        lblHeading.setFont(new Font("serif",Font.BOLD,25));
        add(lblHeading);
        
        JLabel lblEmp = new JLabel("Search By Employe Id:");
        lblEmp.setBounds(50,80,150,30);
        lblEmp.setFont(new Font("serif",Font.PLAIN,20));
        add(lblEmp);
        
        
        cEmpid = new Choice();
        cEmpid.setBounds(200,80,150,30);
        add(cEmpid);
        
       try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
            while(rs.next()){
                cEmpid.add(rs.getString("empid"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       JLabel lblDate = new JLabel("Date:");
       lblDate.setBounds(50,120,150,30);
       lblDate.setFont(new Font("serif",Font.PLAIN,20));
       add(lblDate);
       
       dcDate = new JDateChooser();
       dcDate.setBounds(200,120,150,30);
       add(dcDate);
       
       JLabel lblTime = new JLabel("Time Duration: ");
       lblTime.setBounds(50,160,150,30);
       lblTime.setFont(new Font("serif",Font.PLAIN,20));
       add(lblTime);
       
       leaveTime = new Choice();
       leaveTime.setBounds(200,160,150,30);
       leaveTime.add("Half Day");
       leaveTime.add("Full Day");
       add(leaveTime);
       
        //Submit Button
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(90,250,150,30);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.addActionListener(this);
        btnSubmit.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnSubmit);
        
        //Cancel button
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(300,250,150,30);
        btnCancel.setBackground(Color.RED);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(this);
        btnCancel.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnCancel);
       
       
       
        setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == btnSubmit) {
             
             String empIdNo = cEmpid.getSelectedItem();
             String date = ((JTextField)dcDate.getDateEditor().getUiComponent()).getText();
             String duration = leaveTime.getSelectedItem();
             try {
                 
                 String query = "insert into teacherleave values ('"+empIdNo+"','"+date+"','"+duration+"')";
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Application Submit successfully!!");
                 setVisible(false);
                 
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
             
         }else{
             setVisible(false);
         }
        
    }
    
  
    public static void main(String [] args){
        new TeacherLeave();
    }

}

