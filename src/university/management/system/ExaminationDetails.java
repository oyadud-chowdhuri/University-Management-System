
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField tfSerach;
    JButton btnSubmit, btnCancel;
    JTable table;

    public ExaminationDetails() {
        setSize(1000,475);
        setLocation(450,300);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,20,300,20);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);
        
        tfSerach = new JTextField();
        tfSerach.setBounds(80,60,180,30);
        add(tfSerach);
        
         //Submit Button
        
        btnSubmit = new JButton("Search");
        btnSubmit.setBounds(330,60,130,30);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.addActionListener(this);
        btnSubmit.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnSubmit);
        
        //Cancel button
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(500,60,130,30);
        btnCancel.setBackground(Color.RED);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(this);
        btnCancel.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnCancel);
        
        table = new JTable();
        table.setFont(new Font("Serif",Font.PLAIN,16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(1,130,999,300);
        add(jsp);
        
        try {
            
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
               tfSerach.setText(table.getModel().getValueAt(row, 2).toString());
            
            }
            
        });
        
        
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== btnSubmit){
            new Marks(tfSerach.getText());
            setVisible(false);
            
            
        }else{
            setVisible(false);
        
        }
        
       
    }
    
    
    
    public static void main(String [] args ){
        
        new ExaminationDetails();
    }

    
    
}
