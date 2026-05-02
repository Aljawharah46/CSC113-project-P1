import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginFrame extends JFrame
implements ActionListener {

    private JTextField nameField;  // fields for name and pass
    private JPasswordField passField;
    private JButton loginButton;  // login button

    public LoginFrame(){    //builds login components 

        setTitle("Login");
        setSize(350,220);
        setLocation(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new GridLayout(4,2,8,8));
        c.setBackground(new Color(245,230,250));

        c.add(new JLabel("Name:"));
        nameField = new JTextField();
        c.add(nameField);

        c.add(new JLabel("Password:"));
        passField = new JPasswordField();
        c.add(passField);

        loginButton = new JButton("Login");
        c.add(new JLabel(""));
        c.add(loginButton);

        loginButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){   // excutes when login buttom is clicked 

        try{

            String name = nameField.getText();
            String pass =
            new String(passField.getPassword());

            File f = new File("System.dat");

            Client client =
            theMain.fetchClient(name,pass,f);

            if(client==null){

                String phone =
                JOptionPane.showInputDialog(
                this,"New User! Enter Phone:");

                client =
                new Client(name,phone,pass);

                theMain.saveClient(client,f);

                JOptionPane.showMessageDialog(this,
                "Account Created!");
            }

            PartyGUI gui =
            new PartyGUI(client);

            gui.setVisible(true);

            dispose();

        }catch(Exception ex){

            JOptionPane.showMessageDialog(this,
            "Error.");
        }
    }

    public static void main(String[] args){   // starts window login

        LoginFrame f =
        new LoginFrame();

        f.setVisible(true);
    }
}
