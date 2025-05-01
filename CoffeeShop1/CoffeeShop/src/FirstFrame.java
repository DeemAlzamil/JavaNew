import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.* ;
import java.util.* ;

public class FirstFrame extends JFrame implements ActionListener {
 JButton jButtonCustomer;
 JButton jButtonAdmin;
 JButton jButtonExit;
 JLabel jLabeltitle;
 JLabel jLabelImage;
Container contentPane ;

// constructor
public FirstFrame(){
contentPane = getContentPane( );
contentPane.setLayout(null);

setTitle ("Hotel Reservation system");
setLocation (200, 150);
setResizable (false);//hi
setSize(700, 400);

this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

jLabelImage = new JLabel(new ImageIcon ("hotelImage.JPEG" ) ) ; 

//image
jLabelImage.setBounds(300 , 100 , 300 , 168 ) ;
contentPane.add(jLabelImage );

jLabeltitle = new JLabel("welcom in our system : ");
jLabeltitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); 
jLabeltitle. setBounds(50 , 20 , 500 , 50 ) ;
contentPane.add(jLabeltitle );

jButtonCustomer = new JButton("Customer");
jButtonCustomer. setBounds(30 , 100 , 120 , 30 ) ;
contentPane.add(jButtonCustomer );
jButtonCustomer.addActionListener(this);

jButtonAdmin = new JButton("Admin");
jButtonAdmin. setBounds(30 , 150 , 120 , 30 ) ;
contentPane.add(jButtonAdmin );
jButtonAdmin.addActionListener(this);

jButtonExit = new JButton("Exit");
jButtonExit. setBounds(30 , 200 , 120 , 30 ) ;
contentPane.add(jButtonExit );
jButtonExit.addActionListener(this);

}// constructor
public void actionPerformed(ActionEvent event) {
if( event.getSource().equals(jButtonCustomer)){
CustomerFrame cFram = new CustomerFrame() ;
 cFram.setVisible(true);
}
else
if( event.getSource().equals(jButtonAdmin)){
String pass = "1234" ;
 String str = JOptionPane.showInputDialog("Enter passWord");
 if( str.equals(pass))
 {

 AdminFram aFram = new AdminFram() ;
 aFram.setVisible(true);}
 else
 JOptionPane.showMessageDialog(this, "invalid passWord");
}
else
if( event.getSource().equals(jButtonExit)){
TestHotel.hotel.savaAllInfo();
JOptionPane.showMessageDialog(this, "save all data is done. \n good by.");

 System.exit(0);
}
}// end actionPerformed
}