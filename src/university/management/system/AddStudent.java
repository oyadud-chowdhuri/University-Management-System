
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class AddStudent extends JFrame implements ActionListener{
    
    JTextField tfName,tfFName,tfAddress,tfPhone,tfEmail,tfX,
            tfXII, tfNID, tfCourse;
    JLabel lableRollNo;
    JDateChooser dcDOB;
    JComboBox cbCourse, cbBranch;
    JButton btnSubmit,btnCancel;
    
    Random ran = new Random();
    Long first4 = Math.abs((ran.nextLong()%9000L + 1000L));
    
    AddStudent(){
        setSize(900,700);
        setLocation(450,200);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Add New Student");
        heading.setBounds(310,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        //Add Name
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50,150,100,30);
        lblName.setFont(new Font("serif",Font.BOLD,20));
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(200,150,150,30);
        add(tfName);
        
        //Add father name
        JLabel lblFName = new JLabel("Father's Name:");
        lblFName.setBounds(400,150,200,30);
        lblFName.setFont(new Font("serif",Font.BOLD,20));
        add(lblFName);
        
        tfFName = new JTextField();
        tfFName.setBounds(600,150,150,30);
        add(tfFName);
        
        //Add Roll Number
        JLabel lblRoll = new JLabel("Roll No:");
        lblRoll.setBounds(50,200,100,30);
        lblRoll.setFont(new Font("serif",Font.BOLD,20));
        add(lblRoll);
        
        lableRollNo = new JLabel("2409"+first4);
        lableRollNo.setBounds(200,200,100,30);
        lableRollNo.setFont(new Font("serif",Font.BOLD,20));
        add(lableRollNo);
       
       //Add Date of Birth
        JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
        lblDateOfBirth.setBounds(400,200,200,30);
        lblDateOfBirth.setFont(new Font("serif",Font.BOLD,20));
        add(lblDateOfBirth);
        
        dcDOB = new JDateChooser();
        dcDOB.setBounds(600,200,150,30);
        add(dcDOB);
        
        //Add Address
        JLabel lblAddress = new JLabel("Adress:");
        lblAddress.setBounds(50,250,100,30);
        lblAddress.setFont(new Font("serif",Font.BOLD,20));
        add(lblAddress);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(200,250,150,30);
        add(tfAddress);
        
         //Add Phone Number 
        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(400,250,200,30);
        lblPhone.setFont(new Font("serif",Font.BOLD,20));
        add(lblPhone);
        
        tfPhone = new JTextField();
        tfPhone.setBounds(600,250,150,30);
        add(tfPhone);
        
        //Add Email
        JLabel lblEmail = new JLabel("Email Id:");
        lblEmail.setBounds(50,300,100,30);
        lblEmail.setFont(new Font("serif",Font.BOLD,20));
        add(lblEmail);
        
        tfEmail = new JTextField();
        tfEmail.setBounds(200,300,150,30);
        add(tfEmail);
        
         //Add Class X marks 
        JLabel lblX = new JLabel("Class X(%):");
        lblX.setBounds(400,300,200,30);
        lblX.setFont(new Font("serif",Font.BOLD,20));
        add(lblX);
        
        tfX = new JTextField();
        tfX.setBounds(600,300,150,30);
        add(tfX);
        
        //Add Class XII marks
        JLabel lblXII = new JLabel("Class XII(%):");
        lblXII.setBounds(50,350,120,30);
        lblXII.setFont(new Font("serif",Font.BOLD,20));
        add(lblXII);
        
        tfXII = new JTextField();
        tfXII.setBounds(200,350,150,30);
        add(tfXII);
        
        //Add NID 
        JLabel lblNID = new JLabel("NID:");
        lblNID.setBounds(400,350,200,30);
        lblNID.setFont(new Font("serif",Font.BOLD,20));
        add(lblNID);
        
        tfNID = new JTextField();
        tfNID.setBounds(600,350,150,30);
        add(tfNID);
        
        //Add Courses
        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(50,400,120,30);
        lblCourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblCourse);
        
        String course[]= {"Bsc","Msc","BBA","MBA","EMBA"};
        cbCourse = new JComboBox(course);
        cbCourse.setBounds(200,400,150,30);
        add(cbCourse);
        
        //Add Branch 
        JLabel lblBanch = new JLabel("Branch:");
        lblBanch.setBounds(400,400,200,30);
        lblBanch.setFont(new Font("serif",Font.BOLD,20));
        add(lblBanch);
        
        String branch []={"CSE","CSSE","SE","CS","CIS","IPE","Finance","Accounting",
        "EEE","Architecture"}; 
        cbBranch = new JComboBox(branch);
        cbBranch.setBounds(600,400,150,30);
        add(cbBranch);
        
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
        if(ae.getSource()== btnSubmit){
            
            String name = tfName.getText();
            String fName = tfFName.getText();
            String rollNo = lableRollNo.getText();
            String dob = ((JTextField)dcDOB.getDateEditor().getUiComponent()).getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String xMark = tfX.getText();
            String XiiMark = tfXII.getText();
            String NID = tfNID.getText();
            String course = (String)cbCourse.getSelectedItem();
            String branch = (String) cbBranch.getSelectedItem();
            
            try {
                String query = "insert into student values "
                        + "('"+name+"','"+fName+"','"+rollNo+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+xMark+"','"+XiiMark+"','"+NID+"','"+course+"','"+branch+"')"; 
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details insert Successfully!");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
       
    }
    
    public static void main(String [] Args){
        
        new AddStudent();
    }

    
    
}
