import javax.swing.*; import java.awt.*; import java.awt.event.*; import java.io.* ;  import java.util.* ;  
 public class AdminFram extends JFrame implements ActionListener { 
 
JButton jButtonDeletRoom; 
JButton jButtonBack; 
JButton jButtonExit; 
JButton jButtonView; 
 
JLabel jLabelTitle; 
JLabel jLabel2;  
JPanel jPanel1; 
 
JTextArea TextArea1; 
JTextField jTextField1; 
Container contentPane ; 
 
// constructor public AdminFram(){ contentPane = getContentPane( ); contentPane.setLayout(null); 
 
setTitle("Hotel Reservation system"); 
setLocation  (200, 150); 
setResizable (false); 
setSize(700, 500); 
this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // jLabelTitle; jLabelTitle = new JLabel("Admin menu : ");  jLabelTitle.setFont(new java.awt.Font("Segoe UI", 2, 26)); // 2= italic               jLabelTitle. setBounds(50 , 20 , 500 , 50 ) ;  contentPane.add(jLabelTitle ); 
 
// jLabel2; jLabel2 = new JLabel("Enter room number: "); jLabel2. setBounds(50 , 90 , 150 , 20 ) ;  contentPane.add(jLabel2 ); 
 
// jTextField1; jTextField1 = new JTextField(); jTextField1.setColumns(10); jTextField1. setBounds(50 , 130 , 120 , 20 ) ;  contentPane.add(jTextField1 ); 
 
 
// jButtonDeletRoom; jButtonDeletRoom = new JButton("Delet room");  jButtonDeletRoom. setBounds(50 , 170 , 120 , 30 ) ;  contentPane.add(jButtonDeletRoom ); jButtonDeletRoom.addActionListener(this); 
 
//JButton jButtonBack; jButtonBack = new JButton("Back");  jButtonBack. setBounds(50 , 400 , 70 , 30 ) ;  contentPane.add(jButtonBack ); jButtonBack.addActionListener(this); 
 
//JButton jButtonExit; jButtonExit = new JButton("Exit");  jButtonExit. setBounds(130 , 400 , 70 , 30 ) ;  contentPane.add(jButtonExit ); jButtonExit.addActionListener(this); 
 
//JPanel jPanel1; jPanel1 = new JPanel(); jPanel1.setBorder(BorderFactory.createTitledBorder("View Reservation")); jPanel1.setBounds(250 , 20 , 350 , 420 ) ; jPanel1.setLayout(null); 
 
// jTextArea1; 
TextArea1 = new JTextArea(20,30); 
TextArea1.setBorder(BorderFactory.createLineBorder(Color.GREEN));  
//TextArea1.setLineWrap(true); //TextArea1.setWrapStyleWord(true); //  
 
JScrollPane scrollPane = new JScrollPane(TextArea1); // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
); scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS _NEEDED); 
scrollPane.setBounds(25, 25, 300, 330); //  
 jPanel1.add(scrollPane); //  
 
// jButtonView; jButtonView = new JButton("view all reservation");  jButtonView. setBounds(100 , 365 , 150 , 30 ) ;  jPanel1.add(jButtonView); 
jButtonView.addActionListener(this); 
 contentPane.add(jPanel1 ); 
 
} 
  public void actionPerformed(ActionEvent event) { 
if( event.getSource().equals((JButton)  jButtonDeletRoom)){  String strNo = jTextField1.getText() ;       int no ;       try{       no = Integer.parseInt(strNo) ;  
     }catch(NumberFormatException ex ){ 
         JOptionPane.showMessageDialog(this , "invalid room number" );           return ;  
     }      
    if( TestHotel.hotel.deleteRoom(no)){ 
        JOptionPane.showMessageDialog(this ,  "delete is done"); 
    }     else 
        JOptionPane.showMessageDialog(this , "Can't Delete"); 
               jTextField1.setText("0");  
} 
else//========================================================= if( event.getSource().equals((JButton)  jButtonBack)){  this.setVisible(false); 
} else 
if( event.getSource().equals((JButton)  jButtonExit)){ 
 TestHotel.hotel.savaAllInfo();  
        JOptionPane.showMessageDialog(this, "save all data is done. \n good by."); 
    
        System.exit(0); 
} else   //====================================== if( event.getSource().equals((JButton)  jButtonView)){ 
 TextArea1.setText("");  
        Reservation[] list = TestHotel.hotel.reservations ;          int count = 0;          for( int i = 0 ; i < list.length ; i++)             if( list[i] != null ){                 TextArea1.append(list[i].toString() + "\n");                 TextArea1.append("==========\n");                 count++; 
            }    if( count == 0 ){ 
   TextArea1.append("============ no reservation found =============\n"); 
 
} 
} 
 
 
}// end actionPerformed 
} 
