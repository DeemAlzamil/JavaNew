//CustomerFrame 
 import javax.swing.*; import java.awt.*; import java.awt.event.*; import java.io.* ;  import java.util.* ;  
 public class CustomerFrame extends JFrame implements ActionListener {  
ButtonGroup buttonGroup = new ButtonGroup() ; 
JButton addButton , cancelButton , checkOutButton ,searchButton , backButton ,  
                        exitButton  ;  
JComboBox comboBox; 
JLabel jLabelTitle , jLabel2 , jLabel3 , jLabel4 , jLabel5 , jLabel6 ; 
JPanel panel1 , panel2; 
JRadioButton radio1 , radio2 , radio3 , radio4 ; 
JTextArea textArea ;  
JTextField text1 , text2 , text3 , text4 ; 
 Container contentPane ; 
   
// constructor public CustomerFrame(){ contentPane = getContentPane( ); contentPane.setLayout(null); 
 setTitle     ("customer menu system"); setLocation  (200, 100); setResizable (false); setSize(800, 550); this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
// jLabelTitle; jLabelTitle = new JLabel("Customer menu : ");  jLabelTitle.setFont(new java.awt.Font("Segoe UI", 2, 26)); // 2= italic               jLabelTitle. setBounds(50 , 20 , 500 , 50 ) ;  contentPane.add(jLabelTitle ); 
 
// panel reservation panel1 = new JPanel(); panel1.setBorder(BorderFactory.createTitledBorder("Reservation")); panel1.setBounds(20 , 80 , 350 , 370 ) ; panel1.setLayout(null); contentPane.add(panel1 ); 
 
// panel2 view rooms panel2 = new JPanel(); panel2.setBorder(BorderFactory.createTitledBorder("view rooms")); panel2.setBounds(400 , 80 , 350 , 420 ) ; panel2.setLayout(null); contentPane.add(panel2 ); 
 
//  tools of panel1  jLabel2 = new JLabel("Room No. : "); jLabel2. setBounds(20 , 20 , 150 , 20 ) ;  panel1.add( jLabel2 );  
 jLabel3 = new JLabel("User id: : "); jLabel3. setBounds(20 , 50 , 150 , 20 ) ;  panel1.add( jLabel3 );  
 jLabel4 = new JLabel("full Name : "); jLabel4. setBounds(20 , 80 , 150 , 20 ) ;  panel1.add( jLabel4 );  
 jLabel5 = new JLabel("Mobile No. : "); jLabel5. setBounds(20 , 110 , 150 , 20 ) ;  panel1.add( jLabel5 );  
 jLabel6 = new JLabel("Days : "); jLabel6. setBounds(20 , 140 , 150 , 20 ) ;  panel1.add( jLabel6 );  
 
text1 = new JTextField(); text1.setColumns(10); text1. setBounds(180 , 20 , 120 , 20 ) ; panel1.add( text1 ) ;  
 
text2 = new JTextField(); text2.setColumns(10); text2. setBounds(180 , 50 , 120 , 20 ) ; panel1.add( text2 ) ; 
 text3 = new JTextField(); text3.setColumns(10); 
text3. setBounds(180 , 80 , 120 , 20 ) ; panel1.add( text3 ) ; 
 text4 = new JTextField(); text4.setColumns(10); text4. setBounds(180 , 110 , 120 , 20 ) ; panel1.add( text4 ) ; 
 
String[] list = {"1" , "2" , "3" , "4"} ;  comboBox = new JComboBox(list) ; comboBox.setBounds(180 , 140 , 100 , 20 ) ;  panel1.add(comboBox);  
 addButton = new JButton("add reservation : ");  addButton. setBounds(20 , 170 , 150 , 30 ) ;  panel1.add(addButton ); 
addButton.addActionListener(this); 
 cancelButton = new JButton("cancel reservation : ");  cancelButton. setBounds(20 , 210 , 150 , 30 ) ;  panel1.add(cancelButton ); 
cancelButton.addActionListener(this); 
 checkOutButton = new JButton("checkOut reservation : ");  checkOutButton. setBounds(20 , 250 , 150 , 30 ) ;  panel1.add(checkOutButton ); 
checkOutButton.addActionListener(this); 
 searchButton = new JButton("search reservation : ");  searchButton. setBounds(20 , 290 , 150 , 30 ) ;  panel1.add(searchButton ); 
searchButton.addActionListener(this); 
 
//backButton , exitButton backButton = new JButton("Back");  backButton. setBounds(20 , 460 , 100 , 30 ) ;  contentPane.add(backButton ); backButton.addActionListener(this); 
 
exitButton = new JButton("Exit");  exitButton. setBounds(130 , 460 , 100 , 30 ) ;  contentPane.add(exitButton ); exitButton.addActionListener(this); 
 
//  tools of panel2 textArea = new JTextArea(20,30); 
textArea.setBorder(BorderFactory.createLineBorder(Color.GREEN));  
//textArea.setLineWrap(true); //textArea.setWrapStyleWord(true); //  
 
JScrollPane scrollPane = new JScrollPane(textArea); // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
); 
scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS
_NEEDED); scrollPane.setBounds(25, 25, 300, 300); //  panel2.add(scrollPane); //  
 
// radio  radio1 = new JRadioButton("Regular Room"); radio1. setBounds(25 , 330 , 120 , 30 ) ;  panel2.add(radio1 ); 
radio1.addActionListener(this); 
 radio2 = new JRadioButton("Suite Room"); radio2. setBounds(155 , 330 , 120 , 30 ) ;  panel2.add(radio2 ); 
radio2.addActionListener(this); 
 radio3 = new JRadioButton("Royal Suite"); radio3. setBounds(25 , 370 , 120 , 30 ) ;  panel2.add(radio3 ); 
radio3.addActionListener(this); 
 radio4 = new JRadioButton("Available Room"); radio4. setBounds(155 , 370 , 120 , 30 ) ;  panel2.add(radio4 ); 
radio4.addActionListener(this); 
  buttonGroup.add(radio1);  buttonGroup.add(radio2);  buttonGroup.add(radio3);  buttonGroup.add(radio4);   
}// end constructor 
 public void actionPerformed(ActionEvent event) { if( event.getSource().equals((JButton)  addButton)){ 
       // add reservation         int RoomNo ;          try{ 
         RoomNo = Integer.parseInt(text1.getText() ) ;  
        } catch(NumberFormatException ex){ 
        JOptionPane.showMessageDialog(null , "room number must be only digit , try again");         return ;  
    } 
         
     Room roomObj = TestHotel.hotel.searchRoom(RoomNo) ;  if( roomObj == null || roomObj.isAvailable() == false){ System.out.println("this room is not available, try again"); return ;  }    
         
        String id = text2.getText() ;  
        String name = text3.getText() ; 
         
         
        String mob ;  
             try{  mob = text4.getText() ;   if( mob.length() != 10 || !mob.startsWith("05"))      throw new invalidMopileNo("mobile number must starts with 05 and only 10 digit");    long num = Long.parseLong(mob) ;  
  
      } 
    catch(NumberFormatException ex){ 
        JOptionPane.showMessageDialog(this , "mobile must be only digit , try again");         return ;  
    } 
    catch(invalidMopileNo ex){ 
        JOptionPane.showMessageDialog(this ,ex.getMessage());         return ;  
    }        int days = comboBox.getSelectedIndex()  + 1 ; // becaus index start from 0 
         
 Reservation res = new Reservation(name , mob , id ) ;  
        
res.CheckIn(roomObj, days); 
TestHotel.hotel.addReservation(res) ;  
JOptionPane.showMessageDialog(this ,"reservation is added sucssfully , be happy with our hotel"); 
JOptionPane.showMessageDialog(this ,res.toString() ); 
 text1.setText(""); text2.setText(""); text3.setText(""); text4.setText(""); 
 
   
} 
//============================================= if( event.getSource().equals((JButton)  cancelButton)){ 
// cancel  int RoomNo ;   try{ 
 RoomNo = Integer.parseInt(text1.getText() ) ;  
 } catch(NumberFormatException ex){ 
 JOptionPane.showMessageDialog(this , "room number must be only digit , try again");  return ;  
} 
 String id = text2.getText() ; 
             
if( TestHotel.hotel.cancelReservation(id, RoomNo))   JOptionPane.showMessageDialog(this ,"cancel done.");   else 
 JOptionPane.showMessageDialog(this ,"sorry , can't cancel.");              text1.setText(""); text2.setText(""); text3.setText(""); text4.setText(""); 
} 
//============================================= if( event.getSource().equals((JButton)  checkOutButton)){ 
  // check out  int RoomNo ;  try{ 
RoomNo = Integer.parseInt(text1.getText() ) ;  
} catch(NumberFormatException ex){ 
JOptionPane.showMessageDialog(this , "room number must be only digit , try again"); return ;  
} 
String id = text2.getText() ; 
 
Reservation res = TestHotel.hotel.searchReservation(id, RoomNo) ;  if(res == null ) 
JOptionPane.showMessageDialog(this ,"can't found this reservation"); else 
 res.CheckOut(); 
   text1.setText(""); text2.setText(""); text3.setText(""); text4.setText(""); 
} 
//============================================= if( event.getSource().equals((JButton)  searchButton)){ 
// searchReservation 
 int RoomNo ;  try{ 
RoomNo = Integer.parseInt(text1.getText() ) ;  
} catch(NumberFormatException ex){ 
JOptionPane.showMessageDialog(this , "room number must be only digit , try again"); return ;  
} 
String id = text2.getText() ; 
 
 
Reservation res = TestHotel.hotel.searchReservation(id, RoomNo) ;  if(res == null ) 
 JOptionPane.showMessageDialog(this ,"can't found this reservation"); else 
JOptionPane.showMessageDialog(this , res.toString()); 
 text1.setText(""); text2.setText(""); text3.setText(""); text4.setText(""); 
 
} 
//============================================= if( event.getSource().equals((JButton)  backButton)){  this.setVisible(false); 
} 
//============================================= if( event.getSource().equals((JButton)  exitButton)){ 
// exit 
TestHotel.hotel.savaAllInfo();  
JOptionPane.showMessageDialog(this, "save all data is done. \n good by."); 
System.exit(0); 
} 
//============================================= if( event.getSource().equals((JRadioButton)  radio1) && radio1.isSelected()){// regular textArea.setText("");  
RegularRoom[] list =  TestHotel.hotel.getRegular();  for( int i = 0 ;i < list.length ; i++ ) if( list[i] !=  null ) textArea.append(list[i].toString()+ "\n"); 
 
} 
//============================================= if( event.getSource().equals((JRadioButton)  radio2) && radio2.isSelected()){ //suite textArea.setText("");  
 
Suite[] list2 = TestHotel.hotel.getAllSuite();  for( int i = 0 ;i < list2.length ; i++ ) if( list2[i] !=  null && ! (list2[i] instanceof RoyalSuite )) textArea.append(list2[i].toString()+ "\n");   
 
} 
//============================================= if( event.getSource().equals((JRadioButton)  radio3)  && radio3.isSelected()){ // royal textArea.setText("");  int num ;      try{ 
   num = Integer.parseInt(JOptionPane.showInputDialog(this , "Enter number of extra rooms that you want : ") );  
    }catch(NumberFormatException ex ){ 
    JOptionPane.showMessageDialog(this, ex.toString() );     return ;  
} 
Suite[] list3 = TestHotel.hotel.getAllSuite(num); 
 for( int i = 0 ;i < list3.length ; i++ ) if( list3[i] !=  null ) textArea.append(list3[i].toString()+ "\n");   } 
//============================================= if( event.getSource().equals((JRadioButton) radio4)  && radio4.isSelected() 
){ // available textArea.setText("");  
 Room[] list4 = TestHotel.hotel.getAllAvailable();  for( int i = 0 ;i < list4.length ; i++ ) if( list4[i] !=  null  ){     textArea.append(list4[i].getClass().getSimpleName());   textArea.append(list4[i].toString() + "\n"); 
} 
} 
//============================================= 
 
 
 
 
 
 
 
 
 
 
 
}// end actionPerformed 
 
}// end class  
