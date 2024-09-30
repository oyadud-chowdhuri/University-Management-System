
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class StudentFeeForm extends JFrame implements ActionListener{
    JButton btnBack,btnPay, btnUpdate;
    JLabel lblTotal;
    
    Choice cRollNo;
    JComboBox cbCourse, cbBranch,cbSemester;

    public StudentFeeForm() {
        setSize(550,600);
        setLocation(650,250);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblHeading = new JLabel("Pay Fee Form");
        lblHeading.setBounds(175,20,200,30);
        lblHeading.setFont(new Font("serif",Font.BOLD,30));
        add(lblHeading);
        
        JLabel lblRollNo = new JLabel("Select Roll No:");
        lblRollNo.setBounds(50,80,150,30);
        lblRollNo.setFont(new Font("serif",Font.BOLD,20));
        add(lblRollNo);
        
        cRollNo = new Choice();
        cRollNo.setBounds(220,80,150,30);
        add(cRollNo);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            
            while(rs.next()){
                cRollNo.add(rs.getString("rollno"));
            }
            
        } catch (Exception e) {
        }
        
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50,120,150,30);
        lblName.setFont(new Font("serif",Font.BOLD,20));
        add(lblName);
        
        JLabel lblNameVal = new JLabel();
        lblNameVal.setBounds(220,120,250,30);
        lblNameVal.setFont(new Font("serif",Font.BOLD,20));
        add(lblNameVal);
        
    
        JLabel lblFName = new JLabel("Father's Name:");
        lblFName.setBounds(50,160,150,30);
        lblFName.setFont(new Font("serif",Font.BOLD,20));
        add(lblFName);
        
        JLabel lblFNameVal = new JLabel();
        lblFNameVal.setBounds(220,160,250,30);
        lblFNameVal.setFont(new Font("serif",Font.BOLD,20));
        add(lblFNameVal);
        
        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(50,200,150,30);
        lblCourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblCourse);
        
        String course[]= {"Bsc","Msc","BBA","MBA","EMBA"};
        cbCourse = new JComboBox(course);
        cbCourse.setBounds(220,200,150,20);
        add(cbCourse);
        
        JLabel lblBranch = new JLabel("Branch:");
        lblBranch.setBounds(50,240,150,30);
        lblBranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblBranch);
        
        String branch []={"CSE","CSSE","SE","CS","CIS","IPE","BBA","MBA",
        "EEE","Architecture","English"}; 
        cbBranch = new JComboBox(branch);
        cbBranch.setBounds(220,240,150,20);
        add(cbBranch);
        
        JLabel lblSemester = new JLabel("Semester:");
        lblSemester.setBounds(50,280,150,30);
        lblSemester.setFont(new Font("serif",Font.BOLD,20));
        add(lblSemester);
        
        String semester []={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"}; 
        cbSemester = new JComboBox(semester);
        cbSemester.setBounds(220,280,150,20);
        add(cbSemester);
        
        JLabel lblTPay = new JLabel("Total Pay:");
        lblTPay.setBounds(50,320,150,30);
        lblTPay.setFont(new Font("serif",Font.BOLD,20));
        add(lblTPay);
        
        lblTotal = new JLabel();
        lblTotal.setBounds(220,320,150,30);
        lblTotal.setFont(new Font("serif",Font.BOLD,20));
        add(lblTotal);
        
        
        cRollNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    
                    Conn c = new Conn();
                    String query = "select * from student where rollno = '"+cRollNo.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblNameVal.setText(rs.getString("name"));
                        lblFNameVal.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
            
                        e.printStackTrace();
                    }
                
            }
        });
        
       
        
        
        
        
        
        
        
        //update Button
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(60,440,100,30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.addActionListener(this);
        btnUpdate.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnUpdate);
        
        //PAy Button
        btnPay = new JButton("Pay");
        btnPay.setBounds(190,440,100,30);
        btnPay.setBackground(Color.BLACK);
        btnPay.setForeground(Color.WHITE);
        btnPay.addActionListener(this);
        btnPay.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnPay);
        
        
        //Back bUtton
        btnBack = new JButton("Back");
        btnBack.setBounds(320,440,100,30);
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);
        btnBack.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnBack);
        
        setVisible(true);
       
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnUpdate){
            String course = (String)cbBranch.getSelectedItem();
            String semester = (String)cbSemester.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                
                while(rs.next()){
                    lblTotal.setText(rs.getString(semester));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == btnPay){
            
            String rollNo = cRollNo.getSelectedItem();
            String course = (String)cbCourse.getSelectedItem();
            String branch = (String)cbBranch.getSelectedItem();
            String semester = (String)cbSemester.getSelectedItem();
            String total  = lblTotal.getText();
            
            try {
                Conn c = new Conn();
                String query = "insert into collegefee values('"+rollNo+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Payment Successful" );
                setVisible(false);
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
       
    }
    
    
    
    public static void main (String [] args){
        new StudentFeeForm();
    }

   
    
}
