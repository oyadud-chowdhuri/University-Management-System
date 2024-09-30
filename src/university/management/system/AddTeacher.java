
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tfName,tfFName,tfAddress,tfPhone,tfEmail,tfBsc,
            tfMsc , tfNID;
    JLabel lableEMPId;
    JDateChooser dcDOB;
    JComboBox cbDept;
    JButton btnSubmit,btnCancel;
    
    Random ran = new Random();
    Long first4 = Math.abs((ran.nextLong()%9000L + 1000L));
    
    AddTeacher(){
        setSize(900,700);
        setLocation(450,200);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Add New Teacher");
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
        
        //Add EMP Number
        JLabel lblEmpID = new JLabel("Employe Id:");
        lblEmpID.setBounds(50,200,110,30);
        lblEmpID.setFont(new Font("serif",Font.BOLD,20));
        add(lblEmpID);
        
        lableEMPId = new JLabel("1000"+first4);
        lableEMPId.setBounds(200,200,100,30);
        lableEMPId.setFont(new Font("serif",Font.BOLD,20));
        add(lableEMPId);
       
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
        
         //Add B.Sc CGPA 
        JLabel lblBsc = new JLabel("CGPA(B.Sc/BBA):");
        lblBsc.setBounds(400,300,200,30);
        lblBsc.setFont(new Font("serif",Font.BOLD,20));
        add(lblBsc);
        
        tfBsc = new JTextField();
        tfBsc.setBounds(600,300,150,30);
        add(tfBsc);
        
        //Add NID
        JLabel lblNID = new JLabel("NID:");
        lblNID.setBounds(50,350,150,30);
        lblNID.setFont(new Font("serif",Font.BOLD,20));
        add(lblNID);
        
        tfNID = new JTextField();
        tfNID .setBounds(200,350,150,30);
        add(tfNID);
        
        //Add M.Sc CGPA
        JLabel lblMsc = new JLabel("CGPA(M.Sc/MBA)");
        lblMsc.setBounds(400,350,200,30);
        lblMsc.setFont(new Font("serif",Font.BOLD,20));
        add(lblMsc);
        
        tfMsc = new JTextField();
        tfMsc.setBounds(600,350,150,30);
        add(tfMsc);
        
        //Add Courses
        JLabel lblDept = new JLabel("Department:");
        lblDept.setBounds(50,400,120,30);
        lblDept.setFont(new Font("serif",Font.BOLD,20));
        add(lblDept);
        
        String dept[]= {"FST","FBA","English","FA"};
        cbDept = new JComboBox(dept);
        cbDept.setBounds(200,400,150,30);
        add(cbDept);
        
        
        
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
            String empId = lableEMPId.getText();
            String dob = ((JTextField)dcDOB.getDateEditor().getUiComponent()).getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String BScCgpa = tfBsc.getText();
            String MScCgpa = tfMsc.getText();
            String NID = tfNID.getText();
            String dept = (String)cbDept.getSelectedItem();
            
            
            try {
                String query = "insert into teacher values "
                        + "('"+name+"','"+fName+"','"+empId+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+BScCgpa+"','"+MScCgpa+"','"+NID+"','"+dept+"')"; 
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details insert Successfully!");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
       
    }
    
    public static void main(String [] Args){
        
        new AddTeacher();
    }

    
    
}
