
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;



public class EnterMarks extends  JFrame implements ActionListener{
    
    Choice cRoll;
    JComboBox cbSemester;
    JTextField tfSub1,tfSub2,tfSub3,tfSub4,tfSub5,tfMarks1,tfMarks2,tfMarks3,tfMarks4,tfMarks5;
    JButton btnSubmit,btnCancel;

    public EnterMarks() {
  
        setSize(900,700);
        setLocation(450,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Enter Student's Marks");
        heading.setBounds(310,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        
        JLabel rollHeading = new JLabel("Select Roll Number:");
        rollHeading.setBounds(50,80,200,30);
        rollHeading.setFont(new Font("Serif",Font.BOLD,20));
        add(rollHeading);
        
        cRoll = new Choice();
        cRoll.setBounds(250,80,200,20);
        add(cRoll);
        
        try {
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select rollno from student");
            while(rs.next()){
                
                 cRoll.add(rs.getString("rollno"));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblSemester = new JLabel("Semester:");
        lblSemester.setBounds(50,120,200,30);
        lblSemester.setFont(new Font("Serif",Font.BOLD,20));
        add(lblSemester);
        
        
        String semester []={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"}; 
        cbSemester = new JComboBox(semester);
        cbSemester.setBounds(250,120,200,20);
        add(cbSemester);
        
        JLabel lblEntSub = new JLabel("Enter Subject");
        lblEntSub.setBounds(100,180,200,30);
        lblEntSub.setFont(new Font("Serif",Font.BOLD,20));
        add(lblEntSub);
        
        JLabel lblEntMarks = new JLabel("Enter Marks");
        lblEntMarks.setBounds(320,180,200,30);
        lblEntMarks.setFont(new Font("Serif",Font.BOLD,20));
        add(lblEntMarks);
        
        tfSub1 = new JTextField();
        tfSub1.setBounds(60,220,200,25);
        add(tfSub1);
        
        tfSub2 = new JTextField();
        tfSub2.setBounds(60,250,200,25);
        add(tfSub2);
        
        tfSub3 = new JTextField();
        tfSub3.setBounds(60,280,200,25);
        add(tfSub3);
        
        tfSub4 = new JTextField();
        tfSub4.setBounds(60,310,200,25);
        add(tfSub4);
        
        tfSub5 = new JTextField();
        tfSub5.setBounds(60,340,200,25);
        add(tfSub5);
        
        //Markssss
        
        tfMarks1 = new JTextField();
        tfMarks1.setBounds(280,220,200,25);
        add(tfMarks1);
        
        tfMarks2 = new JTextField();
        tfMarks2.setBounds(280,250,200,25);
        add(tfMarks2);
        
        tfMarks3 = new JTextField();
        tfMarks3.setBounds(280,280,200,25);
        add(tfMarks3);
        
        tfMarks4 = new JTextField();
        tfMarks4.setBounds(280,310,200,25);
        add(tfMarks4);
        
        tfMarks5 = new JTextField();
        tfMarks5.setBounds(280,340,200,25);
        add(tfMarks5);
        
         //Submit Button
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(250,500,150,30);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.addActionListener(this);
        btnSubmit.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnSubmit);
        
        //Cancel button
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(450,500,150,30);
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
            try {
                Conn c = new Conn();
            
                String query1 = "insert into subject values('"+cRoll.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"', '"+tfSub1.getText()+"', '"+tfSub2.getText()+"', '"+tfSub3.getText()+"', '"+tfSub4.getText()+"', '"+tfSub5.getText()+"')";
                String query2 = "insert into marks values ('"+cRoll.getSelectedItem()+"','"+cbSemester.getSelectedItem()+"','"+tfMarks1.getText()+"','"+tfMarks2.getText()+"','"+tfMarks3.getText()+"','"+tfMarks4.getText()+"','"+tfMarks5.getText()+"')";
            
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Marks Upload Successfully");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    
    public static void main (String []args ){
        
        new EnterMarks();
    }

    
}
