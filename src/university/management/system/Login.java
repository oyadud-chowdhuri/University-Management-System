
package university.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;


public class Login extends JFrame implements ActionListener{
    
    JButton btnLogin,btnCancel;
    JTextField tfUserName, pfPassword;
     

    public Login()   {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Lable UserName
        JLabel lblUserName = new JLabel("User Name");
        lblUserName.setBounds(60,60,100,20);
        add(lblUserName);
        
        // Text Field for input User Name
        
        tfUserName = new JTextField();
        tfUserName.setBounds(175,60,150,20);
        add(tfUserName);
        
         // Lable Password
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60,100,100,20);
        add(lblPassword);
        
        // Text Field for input Password
        
        pfPassword = new JPasswordField();
        pfPassword.setBounds(175,100,150,20);
        add(pfPassword);
        
        //Login Button
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(60,150,110,30);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(this);
        btnLogin.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnLogin);
        
        //Cancel button
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(215,150,110,30);
        btnCancel.setBackground(Color.RED);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(this);
        btnCancel.setFont(new Font("Serif", Font.BOLD, 15));
        add(btnCancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(210,210, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,210,210);
        add(image);
        
        
        setLocation(700,400);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()== btnLogin){
           
           String userName = tfUserName.getText();
           String password = pfPassword.getText();
           
           String query ="SELECT * FROM login where username='"+userName+"' and password='"+ password+"'";
           
           try {
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Project();
               }else{
                   JOptionPane.showMessageDialog(null, "Invalid username or password");
               }
               c.s.close();
               
           } catch (Exception e) {
               e.printStackTrace();
           }
       }else if(ae.getSource()==btnCancel){
           setVisible(false);
       }
    }
    
    
    
    
    public static void main(String [] args){
        new Login();
    }
    
}

