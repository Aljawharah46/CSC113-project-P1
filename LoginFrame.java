import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginFrame extends JFrame implements ActionListener {

    private JTextField nameField;
    private JPasswordField passField;
    private JButton loginButton;

    public LoginFrame(){

        setTitle("Party Planner");
        setSize(420,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container c = getContentPane();
        c.setBackground(new Color(245,230,250));
        c.setLayout(null);

        JLabel title = new JLabel("Party Planner");
        title.setBounds(120,20,200,40);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(new Color(120,50,150));
        c.add(title);

        JLabel subtitle = new JLabel("Login to continue");
        subtitle.setBounds(145,55,150,20);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        c.add(subtitle);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(60,100,100,25);
        c.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(160,100,180,30);
        c.add(nameField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(60,145,100,25);
        c.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(160,145,180,30);
        c.add(passField);

        loginButton = new JButton("Login");
        loginButton.setBounds(145,210,120,35);
        loginButton.setBackground(new Color(180,140,220));
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        c.add(loginButton);

        loginButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){

        try{

            String name = nameField.getText();
            String pass = new String(passField.getPassword());

            File f = new File("System.dat");

            Client client = theMain.fetchClient(name,pass,f);

            if(client == null){

                String phone = "";
                boolean validPhone = false;

                while(!validPhone){

                    try{

                        phone = JOptionPane.showInputDialog(
                        this,
                        "Enter your phone number:");

                        if(phone.length()!=10)
                            throw new InvalidPhoneNumberException(
                            "Phone number must be 10 digits.");

                        for(int i=0;i<phone.length();i++){

                            if(!Character.isDigit(phone.charAt(i)))
                                throw new InvalidPhoneNumberException(
                                "Phone number must contain digits only.");
                        }

                        validPhone = true;

                    }
                    catch(InvalidPhoneNumberException ex){

                        JOptionPane.showMessageDialog(this,
                        ex.getMessage());
                    }
                }

                client = new Client(name,phone,pass);
                theMain.saveClient(client,f);

                JOptionPane.showMessageDialog(this,
                "Welcome " + client.getName() +
                "\nYour account has been created successfully!");
            }

            else{

                JOptionPane.showMessageDialog(this,
                "Welcome back, " + client.getName() + "!");
            }

            PartyGUI gui = new PartyGUI(client);
            gui.setVisible(true);
            dispose();

        }
        catch(Exception ex){

            JOptionPane.showMessageDialog(this,
            "Login failed.");
        }
    }

    public static void main(String[] args){

        LoginFrame f = new LoginFrame();
        f.setVisible(true);
    }
}