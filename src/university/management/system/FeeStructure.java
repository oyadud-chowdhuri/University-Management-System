
package university.management.system;

import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;


public class FeeStructure extends JFrame{

    public FeeStructure() {
        
        setSize(1000,700);
        setLocation(450,150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblHead = new JLabel("Fee Structure");
        lblHead.setBounds(350,30,300,30);
        lblHead.setFont(new Font("serif",Font.BOLD,40));
        add(lblHead);
        
        JTable tbl = new JTable();
        
        JScrollPane jsp = new JScrollPane(tbl);
        jsp.setBounds(5,100,975,700);
        add(jsp);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            tbl.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        setVisible(true);
    }
    
    
    
    public static void main (String [] args){
        
        new FeeStructure();
    }
    
}
