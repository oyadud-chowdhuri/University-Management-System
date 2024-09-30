
package university.management.system;


import java.sql.*;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JTable table;
    JButton btnSearch, btnPrint,btnAdd,btnUpdate,btnCancel;
    
    

    TeacherDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1200,700);
        setLocation(450,200);
        
        JLabel heading = new JLabel("Search by Employe Id:");
        heading.setBounds(20,20,200,30);
        heading.setFont(new Font("Serif",Font.PLAIN,20));
        add(heading);
        
        cEmpId = new Choice();
        cEmpId.setBounds(250,20,150,30);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
            while(rs.next()){
                cEmpId.add(rs.getString("empid"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
         try {
             
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
    
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        
        JScrollPane  jsp= new JScrollPane(table);
        jsp.setBounds(0,150,1200,550);
        add(jsp);
        
        // search button
        btnSearch = new JButton("Search");
        btnSearch.setBounds(20,70,80,30);
        btnSearch.addActionListener(this);
        add(btnSearch);
        
        // Print  button
        btnPrint = new JButton("Print");
        btnPrint.setBounds(120,70,80,30);
        btnPrint.addActionListener(this);
        add(btnPrint);
        
        // ADD button
        btnAdd = new JButton("Add");
        btnAdd.setBounds(220,70,80,30);
        btnAdd.addActionListener(this);
        add(btnAdd);
        
        // Update button
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(320,70,80,30);
        btnUpdate.addActionListener(this);
        add(btnUpdate);
        
        //  Cancel button
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(420,70,80,30);
        btnCancel.setBackground(Color.RED);
        btnCancel.addActionListener(this);
        add(btnCancel);
         
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== btnSearch){
            
            String query = "select * from teacher where empid = '"+cEmpId.getSelectedItem()+"'";
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
            new AddTeacher();
        }else if(ae.getSource() == btnUpdate){
            setVisible(false);
            // new UpdateTeacher();
            
        }else {
            setVisible(false);
        }
               
    }
    

    public static void main(String [] args){
        
        new TeacherDetails();
    }

    
    
}

