
package university.management.system;


import java.sql.*;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class StudentLeaveDetails extends JFrame implements ActionListener{
    
    Choice cRollNo;
    JTable table;
    JButton btnSearch, btnPrint,btnAdd,btnUpdate,btnCancel;
    
    

    StudentLeaveDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1200,700);
        setLocation(450,200);
        
         JLabel headName = new JLabel("Student Leave Details");
        headName.setBounds(450,20,300,30);
        headName.setFont(new Font("Serif",Font.BOLD,30));
        add(headName);
        
        JLabel heading = new JLabel("Search by Roll Number:");
        heading.setBounds(20,80,200,30);
        heading.setFont(new Font("Serif",Font.PLAIN,20));
        add(heading);
        
        cRollNo = new Choice();
        cRollNo.setBounds(250,80,150,30);
        add(cRollNo);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            
            while(rs.next()){
                cRollNo.add(rs.getString("rollno"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
         try {
             
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
    
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        
        JScrollPane  jsp= new JScrollPane(table);
        jsp.setBounds(0,210,1200,550);
        add(jsp);
        
        // search button
        btnSearch = new JButton("Search");
        btnSearch.setBounds(20,130,80,30);
        btnSearch.addActionListener(this);
        add(btnSearch);
        
        // Print  button
        btnPrint = new JButton("Print");
        btnPrint.setBounds(120,130,80,30);
        btnPrint.addActionListener(this);
        add(btnPrint);
        
        // ADD button
        btnAdd = new JButton("Add");
        btnAdd.setBounds(220,130,80,30);
        btnAdd.addActionListener(this);
        add(btnAdd);
        
        // Update button
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(320,130,80,30);
        btnUpdate.addActionListener(this);
        add(btnUpdate);
        
        //  Cancel button
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(420,130,80,30);
        btnCancel.setBackground(Color.RED);
        btnCancel.addActionListener(this);
        add(btnCancel);
         
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== btnSearch){
            
            String query = "select * from studentleave where rollno = '"+cRollNo.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                 table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
            }
        }else if(ae.getSource() == btnPrint ){
            
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == btnAdd){
            
            setVisible(false);
            new StudentLeave();
        }else if(ae.getSource() == btnUpdate){
            setVisible(false);
            // new UpdateStudentLeave();
            
        }else {
            setVisible(false);
        }
            
        
    }
    
    
    
    public static void main(String [] args){
        
        new StudentLeaveDetails();
    }

    
    
}
