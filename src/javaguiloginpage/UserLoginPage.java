package javaguiloginpage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserLoginPage {
    public static void main(String args[]){
        //creating a frame and setting the frame properties
        JFrame frame=new JFrame("User Login Page");
        frame.setLayout(null);
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating a label and text field
        JLabel username=new JLabel("User Name: ");
        frame.add(username);
        username.setBounds(150,120,150,60);
        JTextField tf=new JTextField();
        frame.add(tf);
        tf.setBounds(230,140,180,20);

        //creating a label and text field
        JLabel mobileno=new JLabel("Mobile No: ");
        frame.add(mobileno);
       mobileno.setBounds(150,180,150,60);
        JTextField tf1=new JTextField();
        frame.add(tf1);
        tf1.setBounds(230,200,180,20);

        //creating a label and button
        JLabel gender=new JLabel("Gender: ");
        frame.add(gender);
        gender.setBounds(150,245,150,60);
        JRadioButton male=new JRadioButton("Male");
        JRadioButton female=new JRadioButton("Female");
        male.setBounds(230,260,80,30);
        female.setBounds(320,260,80,30);
        frame.add(male);
        frame.add(female);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        //creating a label and list
        JLabel dob=new JLabel("DOB: ");
        dob.setBounds(150,320,150,60);
        frame.add(dob);

        JComboBox<String> dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i)); // Add days directly as Strings
        }
        frame.add(dayComboBox);
        dayComboBox.setBounds(220, 330, 50, 30);
        // Month ComboBox (1 to 12)
        JComboBox<String> monthComboBox = new JComboBox<>();
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (String month : monthNames) {
            monthComboBox.addItem(month);  // Add month names directly
        }
        frame.add(monthComboBox);
        monthComboBox.setBounds(280, 330, 80, 30);

        // Year ComboBox (2003 to 2008)
        JComboBox<String> yearComboBox = new JComboBox<>();
        for (int i = 2003; i <= 2008; i++) {
            yearComboBox.addItem(String.valueOf(i));  // Add years directly
        }
        frame.add(yearComboBox);
        yearComboBox.setBounds(370, 330, 70, 30);

        JLabel address=new JLabel("Address: ");
        address.setBounds(150,380,150,60);
        frame.add(address);
        JTextField tef=new JTextField();
        tef.setBounds(250,380,180,80);
        frame.add(tef);


        JCheckBox cb=new JCheckBox();
        frame.add(cb);
        cb.setBounds(220,512,20,20);
        JLabel tm=new JLabel("Accept Terms and Conditions");
        frame.add(tm);
        tm.setBounds(245,500,180,40);

        //submit and reset
        JButton submit=new JButton("Submit");
        submit.setBounds(250,600,80,30);
        frame.add(submit);

        JButton reset=new JButton("Reset");
       reset.setBounds(350,600,80,30);
        frame.add(reset);

        //adding actionlistener for submit and reset option
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(
                        tf.getText().length()!=0 &&
                tf1.getText().length()!=0 &&
                                (male.isSelected() || female.isSelected()) &&
                tef.getText().length()!=0 &&
                cb.isSelected()){
                    JFrame display=new JFrame("Confirmation Page");
                    display.setSize(400,400);
                    display.setLayout(null);
                    display.getContentPane().setBackground(Color.MAGENTA);
                    JTextArea details=new JTextArea();
                    details.setBounds(50,50,250,250);

                    String userDetails="User Name: "+tf.getText()+"\n\n" +
                            "Mobile No: "+tf1.getText()+"\n\n"+
                            "Gender: "+(male.isSelected() ? "Male" : "Female")+"\n\n"+
                            "DOB: "+dayComboBox.getSelectedItem()+"-"+monthComboBox.getSelectedItem()+"-"+yearComboBox.getSelectedItem()+"\n\n"+
                            "Address: "+tef.getText();
                    details.setText(userDetails);
                    details.setEditable(false);
                    display.add(details);
                    display.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Please fill all the fields");
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               tf.setText("");
               tf1.setText("");
               tef.setText("");
                JRadioButton dummy = new JRadioButton();
                genderGroup.add(dummy);
                dummy.setSelected(true);
                genderGroup.remove(dummy);
              dayComboBox.setSelectedIndex(0);
              monthComboBox.setSelectedIndex(0);
              yearComboBox.setSelectedIndex(0);
              cb.setSelected(false);
            }
        });
        frame.revalidate();
        frame.repaint();
    }
}
