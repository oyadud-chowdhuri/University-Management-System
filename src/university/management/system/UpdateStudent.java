
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;



public class UpdateStudent extends JFrame implements ActionListener{
    
    JTextField tfName,tfFName,tfAddress,tfPhone,tfEmail,tfX,
            tfXII, tfNID, tfCourse;
    JLabel lableRollNo,lblBranchValue,lblCourseValue;
    JDateChooser dcDOB;
    //JComboBox cbCourse, cbBranch;
    JButton btnSubmit,btnCancel;
    Choice cRoll;
    
    //Random ran = new Random();
    //Long first4 = Math.abs((ran.nextLong()%9000L + 1000L));
    
    UpdateStudent(){
        setSize(900,700);
        setLocation(450,200);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student");
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
        
        lableRollNo = new JLabel();
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
        
        
        lblCourseValue = new JLabel();
        lblCourseValue.setBounds(200,400,150,30);
        add(lblCourseValue);
        
        //Add Branch 
        JLabel lblBanch = new JLabel("Branch:");
        lblBanch.setBounds(400,400,200,30);
        lblBanch.setFont(new Font("serif",Font.BOLD,20));
        add(lblBanch);
        
        
        lblBranchValue = new JLabel();
        lblBranchValue.setBounds(600,400,150,30);
        add(lblBranchValue);
        
        
        
        cRoll.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno = '"+cRoll.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        tfName.setText(rs.getString("name"));
                        tfFName.setText(rs.getString("fname"));
                        lableRollNo.setText(rs.getString("rollno"));
                        ((JTextField)dcDOB.getDateEditor().getUiComponent()).setText(rs.getString("dob"));
                        tfAddress.setText(rs.getString("address"));
                        tfPhone.setText(rs.getString("phone"));
                        tfEmail.setText(rs.getString("email"));
                        tfX.setText(rs.getString("class_x"));
                        tfXII.setText(rs.getString("class_xii"));
                        tfNID.setText(rs.getString("nid"));
                        lblCourseValue.setText(rs.getString("course"));
                        lblBranchValue.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    }
            }
        });
        
         //Submit Button
        
        btnSubmit = new JButton("Update");
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
            String course = lblCourseValue.getText();
            String branch = lblBranchValue.getText();
            
            try {
                //String query = "insert into student values "
                        //+ "('"+name+"','"+fName+"','"+rollNo+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+xMark+"','"+XiiMark+"','"+NID+"','"+course+"','"+branch+"')"; 
                String query1 = "update student set name='"+name+"',dob='"+dob+"',fname='"+fName+"',address='"+address+"', phone='"+phone+"',email='"+email+"',class_x='"+xMark+"',class_xii='"+XiiMark+"',nid='"+NID+"',course='"+course+"', branch='"+branch+"' where rollno ='"+cRoll.getSelectedItem()+"'";
                
                Conn con = new Conn();
                con.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null, "Student Details Update Successfully!");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
       
    }
    
    public static void main(String [] Args){
        
        new UpdateStudent();
    }

    
    
}
