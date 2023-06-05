import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SportsClubManagementSystemGUI extends JFrame implements ActionListener {

    // GUI components
    private JButton saveBtn;
    private JLabel sportsLbl, nameLbl, ageLbl, genderLbl,contactLbl,emailLbl,addressLbl,bloodGroupLbl;
    private JTextField nameTf, ageTf, contactTf,emailTf, bloodGroupTf,addressTf;
    private JRadioButton maleRb, femaleRb, othersRb;
    private ButtonGroup genderBg;
    private JCheckBox footballCb, basketballCb, tennisCb, cricketCb,badmintonCb;
    

    // Constructor
    public SportsClubManagementSystemGUI() {
        setTitle("Sports Club Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setForeground(Color.BLUE);
        setLocation(400,10);
        setSize(600, 800);
        setVisible(true);

      

        // Set up components

        Font font = new Font("Arial", Font.PLAIN, 24);
        
        
        sportsLbl = new JLabel("Sports:");
        sportsLbl.setFont(font);
        footballCb = new JCheckBox("Football");
        basketballCb = new JCheckBox("Basketball");
        tennisCb = new JCheckBox("Tennis");
        cricketCb=new JCheckBox("Cricket");
        badmintonCb=new JCheckBox("Badminton");
    
    

        nameLbl = new JLabel("Name:               ");
        nameLbl.setFont(font);
        nameTf = new JTextField(35);

        bloodGroupLbl = new JLabel("Blood Group:   ");
        bloodGroupLbl.setFont(font);
        bloodGroupTf = new JTextField(3);

        ageLbl = new JLabel("Age:                  ");
        ageLbl.setFont(font);
        ageTf = new JTextField(3);

        contactLbl = new JLabel("Contact No.:     ");
        contactLbl.setFont(font);
        contactTf = new JTextField(12);

        emailLbl = new JLabel("Email ID:          ");
        emailLbl.setFont(font);
        emailTf = new JTextField(25);


        addressLbl = new JLabel("Address:          ");
        addressLbl.setFont(font);
        addressTf = new JTextField(35);

        genderLbl = new JLabel("Gender:");
        genderLbl.setFont(font);
        maleRb = new JRadioButton("Male");
        femaleRb = new JRadioButton("Female");
        othersRb = new JRadioButton("Rather not say");
        genderBg = new ButtonGroup();
        genderBg.add(maleRb);
        genderBg.add(femaleRb);
        genderBg.add(othersRb);

        saveBtn = new JButton("Save");
        saveBtn.addActionListener(this);

        // Set up layout

        
        JPanel sportsPanel = new JPanel();
        sportsPanel.setLayout(new GridLayout(1, 4));
        sportsPanel.add(sportsLbl);
        sportsPanel.add(footballCb);
        sportsPanel.add(basketballCb);
        sportsPanel.add(tennisCb);
        sportsPanel.add(cricketCb);
        sportsPanel.add(badmintonCb);

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        //namePanel.setLayout(new GridLayout(1, 1));
        namePanel.add(nameLbl);
        namePanel.add(nameTf);
        

        JPanel agePanel = new JPanel();
        agePanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        agePanel.add(ageLbl);
        agePanel.add(ageTf);

        JPanel bloodGroupPanel = new JPanel();
        bloodGroupPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
       
        bloodGroupPanel.add(bloodGroupLbl);
        bloodGroupPanel.add(bloodGroupTf);

        JPanel contactPanel = new JPanel();
      
        contactPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        contactPanel.add(contactLbl);
        contactPanel.add(contactTf);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        emailPanel.add(emailLbl);
        emailPanel.add(emailTf);

        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        addressPanel.add(addressLbl);
        addressPanel.add(addressTf);



        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new GridLayout(1, 4));
        genderPanel.add(genderLbl);
        genderPanel.add(maleRb);
        genderPanel.add(femaleRb);
        genderPanel.add(othersRb);

    

        JPanel savePanel = new JPanel();
        savePanel.setLayout(new FlowLayout());
        savePanel.add(saveBtn);

        

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        mainPanel.setLayout(new GridLayout(9, 1));
        mainPanel.add(sportsPanel);
        mainPanel.add(namePanel);
        mainPanel.add(agePanel);
        mainPanel.add(bloodGroupPanel);
        mainPanel.add(contactPanel);
        mainPanel.add(emailPanel);
        mainPanel.add(addressPanel);
        mainPanel.add(genderPanel);
        mainPanel.add(savePanel);
        

        setContentPane(mainPanel);
        setVisible(true);
    }

    // ActionListener for save button
    public void actionPerformed(ActionEvent e) {
        String name = nameTf.getText();
        String age = ageTf.getText();
        String contact = contactTf.getText();
        String email =emailTf.getText();
        String address=addressTf.getText();
        String bloodGroup = bloodGroupTf.getText();
        String gender = "";
        if (maleRb.isSelected()) {
            gender = "Male";
        } else if (femaleRb.isSelected()) {
            gender = "Female";
        } else if(othersRb.isSelected()){
            gender= "Others";
        }

        String sports = "";
        if (footballCb.isSelected()) {
            sports += "Football,";
        }
        if (basketballCb.isSelected()) {
            sports += "Basketball,";
        }
        if (tennisCb.isSelected()) {
            sports += "Tennis,";
            }
        if (cricketCb.isSelected()) {
            sports += "Cricket,";
            }
            if (badmintonCb.isSelected()) {
                sports += "Badminton,";
                }
            // remove the last comma
            sports = sports.substring(0, sports.length()-1);

            // save data to a file
    try {
        File file = new File("D:\\EDUC\\2ndYEAR\\Programming\\JAVA MiniProject\\sportscLub.txt");
        FileWriter writer = new FileWriter(file, true);
        writer.write(name+ "_" +age+ "_" +contact+"_"+bloodGroup+ "_" +email+ "_" +address+ "_" +gender+ "_" +sports+ "\n");
        writer.close();
        JOptionPane.showMessageDialog(this, "Data saved successfully.");
        // clear input fields
        nameTf.setText("");
        ageTf.setText("");
        contactTf.setText("");
        emailTf.setText("");
        addressTf.setText("");
        bloodGroupTf.setText("");
        genderBg.clearSelection();
        footballCb.setSelected(false);
        basketballCb.setSelected(false);
        tennisCb.setSelected(false);
        badmintonCb.setSelected(false);

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

// main method to run the program
public static void main(String[] args) {
    new SportsClubManagementSystemGUI();
}
}      