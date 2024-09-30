package university.management.system;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Marks extends JFrame implements ActionListener {
    
    String rollNo;
    JButton btnCancel;
    
    public Marks(String rollNo) {
        
        this.rollNo = rollNo;
        
        setSize(500, 600);
        setLocation(500, 100);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Result Of Examination");
        heading.setBounds(125, 10, 500, 30);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);
        
        JLabel lblRollNo = new JLabel("Roll No: " + rollNo);
        lblRollNo.setBounds(50, 60, 200, 20);
        lblRollNo.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblRollNo);
        
        JLabel lblSemester = new JLabel();
        lblSemester.setBounds(50, 90, 300, 20);
        lblSemester.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblSemester);
        
        JLabel lblSub1 = new JLabel();
        lblSub1.setBounds(100,200,500,20);
        lblSemester.setFont(new Font("Serif", Font.BOLD, 30));
        add(lblSub1);
        
        JLabel lblSub2 = new JLabel();
        lblSub2.setBounds(100,230,500,20);
        lblSemester.setFont(new Font("Serif", Font.BOLD, 30));
        add(lblSub2);
        
        JLabel lblSub3 = new JLabel();
        lblSub3.setBounds(100,260,500,20);
        lblSemester.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblSub3);
        
        JLabel lblSub4 = new JLabel();
        lblSub4.setBounds(100,290,500,20);
        lblSemester.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblSub4);
        
        JLabel lblSub5 = new JLabel();
        lblSub5.setBounds(100,320,500,20);
        lblSemester.setFont(new Font("Serif", Font.BOLD, 20));
        add(lblSub5);
        
        try {
            
            Conn c = new Conn();
            
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollNo+"'");
            while(rs1.next()){
                lblSub1.setText(rs1.getString("subject1"));
                lblSub2.setText(rs1.getString("subject2"));
                lblSub3.setText(rs1.getString("subject3"));
                lblSub4.setText(rs1.getString("subject4"));
                lblSub5.setText(rs1.getString("subject5"));
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollNo+"'");
            while(rs2.next()){
                lblSub1.setText(lblSub1.getText()+"--"+rs2.getString("marks1"));
                lblSub2.setText(lblSub2.getText()+"--"+rs2.getString("marks2"));
                lblSub3.setText(lblSub3.getText()+"--"+rs2.getString("marks3"));
                lblSub4.setText(lblSub4.getText()+"--"+rs2.getString("marks4"));
                lblSub5.setText(lblSub5.getText()+"--"+rs2.getString("marks5"));
                lblSemester.setText("Semester :" +rs2.getString("semester"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        btnCancel = new JButton("Back");
        btnCancel.setBounds(180,420,130,30);
        btnCancel.setBackground(Color.RED);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(this);
        btnCancel.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnCancel);
        
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
         setVisible(false);
    }
    
    public static void main(String[] args) {
        new Marks("");
    }

   
    
}
