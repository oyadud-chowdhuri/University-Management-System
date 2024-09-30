
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Project extends JFrame implements ActionListener{
    
    public Project(){
        
        setSize(1920,1080);
        
        ///ADD IMAGE
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920,1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        ////ADD MENU BAR
        // Add New Information
        
        JMenuBar mb = new JMenuBar();
        
        JMenu newInformation = new JMenu("New Information Add");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
         // Add New Faculty Member
        
        JMenuItem facultyInfo = new JMenuItem("Add New Faculty");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        // Add New Student
        
        JMenuItem studentsInfo = new JMenuItem("Add New Student");
        studentsInfo.setBackground(Color.WHITE);
        studentsInfo.addActionListener(this);
        newInformation.add(studentsInfo);
        
        // Add SHOW DETAILS
        
        JMenu viewDetails = new JMenu("View Details");
        viewDetails.setForeground(Color.BLUE);
        mb.add(viewDetails);
        
         // Show Faculty information
        
        JMenuItem viewFacultyInfo = new JMenuItem("View Faculty Info");
        viewFacultyInfo.setBackground(Color.WHITE);
        viewFacultyInfo.addActionListener(this);
        viewDetails.add(viewFacultyInfo);
        
        // Show Student Details
        
        JMenuItem viewsStudentsInfo = new JMenuItem("View Student info");
        viewsStudentsInfo.setBackground(Color.WHITE);
        viewsStudentsInfo.addActionListener(this);
        viewDetails.add(viewsStudentsInfo);
        
        //Add Leave Apply
        
         JMenu leave = new JMenu("Apply Leave");
         leave.setForeground(Color.BLUE);
         mb.add(leave);
         
         //Leave Apply for Faculty Members
         
         JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
         facultyLeave.setBackground(Color.WHITE);
         facultyLeave.addActionListener(this);
         leave.add(facultyLeave);
         
         //Leave Apply for Students
         JMenuItem studentLeave = new JMenuItem("Student Leave");
         studentLeave.setBackground(Color.WHITE);
         studentLeave.addActionListener(this);
         leave.add(studentLeave);
         
         //Add Leave Detailes
         
         JMenu leaveDetailes = new JMenu("Leave Details");
         leaveDetailes.setForeground(Color.BLUE);
         mb.add(leaveDetailes);
         
          // Faculty Members leave details
         
         JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
         facultyLeaveDetails.setBackground(Color.WHITE);
         facultyLeaveDetails.addActionListener(this);
         leaveDetailes.add(facultyLeaveDetails);
         
          //Students Leave Details
         JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
         studentLeaveDetails.setBackground(Color.WHITE);
         studentLeaveDetails.addActionListener(this);
         leaveDetailes.add(studentLeaveDetails);
         
         //Add Examination
         
         JMenu exam = new JMenu("Examination");
         exam.setForeground(Color.BLUE);
         mb.add(exam);
         
         //Upload Marks
         
         JMenuItem entermarks = new JMenuItem("Upload Marks");
         entermarks.setBackground(Color.WHITE);
         entermarks.addActionListener(this);
         exam.add(entermarks);
         
         // vIEW Result
          
         JMenuItem examDetails = new JMenuItem("Examination Result");
         examDetails.setBackground(Color.WHITE);
         examDetails.addActionListener(this);
         exam.add(examDetails);
         
         //Add update information
         
         JMenu updateInfo = new JMenu("Update Information");
         updateInfo.setForeground(Color.BLUE);
         mb.add(updateInfo);
         
         //update faculty Information
         
         JMenuItem updatefacultyInfo = new JMenuItem("Update Faculty Info");
         updatefacultyInfo.setBackground(Color.WHITE);
         updatefacultyInfo.addActionListener(this);
         updateInfo.add(updatefacultyInfo);
         
         //Update Students Information
         
         JMenuItem updateStudentsInfo = new JMenuItem("Update student Info");
         updateStudentsInfo.setBackground(Color.WHITE);
         updateStudentsInfo.addActionListener(this);
         updateInfo.add(updateStudentsInfo);
         
         
         //Fees information
         
         JMenu fee = new JMenu("Fee Details");
         fee.setForeground(Color.BLUE);
         mb.add(fee);
         
         //Fee Structure
         JMenuItem feeStructure = new JMenuItem("Fees Structure");
         feeStructure.setBackground(Color.WHITE);
         feeStructure.addActionListener(this);
         fee.add(feeStructure);
         
         //Update Students Information
         
         JMenuItem feeForm = new JMenuItem("Student Fee Form");
         feeForm.setBackground(Color.WHITE);
         feeForm.addActionListener(this);
         fee.add(feeForm);
         
         //Utility
         
         JMenu utility = new JMenu("Utility");
         utility.setForeground(Color.BLUE);
         mb.add(utility);
         
         //NotePad
         JMenuItem notePad = new JMenuItem("Notepad");
         notePad.setBackground(Color.WHITE);
         notePad.addActionListener(this);
         utility.add(notePad);
         
         //Calculator
         
         JMenuItem cal = new JMenuItem("Calculator");
         cal.setBackground(Color.WHITE);
         cal.addActionListener(this);
         utility.add(cal);
         
         //about
         
         JMenu about = new JMenu("About");
         about.setForeground(Color.BLUE);
         mb.add(about);
         
         //Perform about
         JMenuItem abt = new JMenuItem("About");
         abt.setBackground(Color.WHITE);
         abt.addActionListener(this);
         about.add(abt);
         
         
          //Exit
         
         JMenu exit = new JMenu("Exit");
         exit.setForeground(Color.BLUE);
         mb.add(exit);
         
         //Perform Exit
         JMenuItem ex = new JMenuItem("Exit");
         ex.setBackground(Color.WHITE);
         ex.addActionListener(this);
         exit.add(ex);
         
                 
        
        setJMenuBar(mb);
        
        
        setVisible(true);
    }
    
    

    @Override
       public void actionPerformed(ActionEvent ae) {
       String msg = ae.getActionCommand();
       
       if(msg.equals("Exit")){
            setVisible(false);
       }else if(msg.equals("Calculator")){
           try {
                 Runtime.getRuntime().exec("calc.exe");
           } catch (Exception e) {
           }
         
       }else if(msg.equals("Notepad")){
           try {
                 Runtime.getRuntime().exec("notepad.exe");
           } catch (Exception e) {
           }
         
       }else if(msg.equals("Add New Student")){
           
           new AddStudent();
           
       }else if(msg.equals("Add New Faculty")){
           
           new AddTeacher();
       }else if(msg.equals("View Faculty Info")){
           
           new TeacherDetails();
       }else if(msg.equals("View Student info")){
           
           new StudentDetails();
       }else if(msg.equals("Faculty Leave")){
           
           new TeacherLeave();
       }else if(msg.equals("Student Leave")){
           
           new StudentLeave();
       }else if(msg.equals("Faculty Leave Details")){
           new TeacherLeaveDetail();
       }else if(msg.equals("Student Leave Details")){
           
           new StudentLeaveDetails();
       }else if(msg.equals("Update Faculty Info")){
           new UpdateTeacher();
       }else if(msg.equals("Update student Info")){
           new UpdateStudent();
       }else if(msg.equals("Upload Marks")){
           new EnterMarks();
       }else if(msg.equals("Examination Result")){
           new ExaminationDetails();
       }else if (msg.equals("Fees Structure")){
           new FeeStructure();
       }else if(msg.equals("Student Fee Form")){
           new StudentFeeForm();
       }
          
    }
       
    public static void main(String [] args){
        new Project();
    }
    
    
}
