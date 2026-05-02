import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class PartyGUI extends JFrame implements ActionListener {

    private Client client;   //logged in client
    private Party clientParty;     //current party object
    private boolean partyCreated = false;   //check if party was created 
    //text fields for party info
    private JTextField partyNameField;
    private JTextField guestNumField;
    private JTextField serviceNumField;
    
        private JSpinner dateSpinner; //spinner for choosing date

    private JComboBox <String> locationBox;  //drop down list for locations(used before)
    //buttons for actions 
    private JButton createPartyButton;
    private JButton addGuestButton;
    private JButton addServiceButton;
    private JButton showSummaryButton;
    private JButton totalCostButton;
    //second frame to show result (class resultFrame)
    private ResultFrame resultFrame;

    public PartyGUI(Client client) {     //constructor

        this.client = client;

        setTitle("Welcome " + client.getName());
        setSize(500, 430);
        setLocation(200, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        resultFrame = new ResultFrame();

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.setBackground(new Color(245,230,250));

        JLabel title = new JLabel("Party Management System");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(120,50,150));
        contentPane.add(title);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,2,8,8));
        panel.setBackground(new Color(250,240,255));

        panel.add(new JLabel("Party Name:"));
        partyNameField = new JTextField();
        panel.add(partyNameField);

        panel.add(new JLabel("Date:"));
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner,"dd/MM/yyyy");
        dateSpinner.setEditor(editor);
        panel.add(dateSpinner);

        panel.add(new JLabel("Location:"));
        locationBox = new JComboBox <String>();
        locationBox.addItem("Select Location");
        locationBox.addItem("Riyadh");
        locationBox.addItem("Jeddah");
        locationBox.addItem("Dammam");
        locationBox.addItem("Abha");
        locationBox.addItem("Alula");
        locationBox.addItem("Zahle");
        locationBox.addItem("Beruit");
        locationBox.addItem("Tripoli");

        panel.add(locationBox);

        panel.add(new JLabel("Number of Guests:"));
        guestNumField = new JTextField();
        panel.add(guestNumField);

        panel.add(new JLabel("Number of Services:"));
        serviceNumField = new JTextField();
        panel.add(serviceNumField);

        contentPane.add(panel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,2,8,8));
        buttonPanel.setBackground(new Color(245,230,250));

        createPartyButton = new JButton("Create Party");
        addGuestButton = new JButton("Add Guest");
        addServiceButton = new JButton("Add Service");
        showSummaryButton = new JButton("Show Summary");
        totalCostButton = new JButton("Total Cost");

        buttonPanel.add(createPartyButton);
        buttonPanel.add(addGuestButton);
        buttonPanel.add(addServiceButton);
        buttonPanel.add(showSummaryButton);
        buttonPanel.add(totalCostButton);

        contentPane.add(buttonPanel);

        createPartyButton.addActionListener(this);
        addGuestButton.addActionListener(this);
        addServiceButton.addActionListener(this);
        showSummaryButton.addActionListener(this);
        totalCostButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {  //handles clicks 

        if(e.getSource()==createPartyButton)
            createParty();

        else if(e.getSource()==addGuestButton)
            addGuest();

        else if(e.getSource()==addServiceButton)
            addService();

        else if(e.getSource()==showSummaryButton)
            showSummary();

        else if(e.getSource()==totalCostButton)
            showTotalCost();
    }

    private void createParty() {   //creates party

        try{
            String name = partyNameField.getText();

            SimpleDateFormat f =
            new SimpleDateFormat("dd/MM/yyyy");

            String date = f.format(dateSpinner.getValue());

            String location =
            locationBox.getSelectedItem().toString();

            int guests =
            Integer.parseInt(guestNumField.getText());

            int services =
            Integer.parseInt(serviceNumField.getText());

            client.createParty(name,date,location,services,guests);

            clientParty = client.getParty();

            partyCreated = true;

            JOptionPane.showMessageDialog(this,
            "Party created successfully!");

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,
            "Enter valid data.");
        }
    }

    private void addGuest(){   //add guests to current party

        if(!partyCreated){
            JOptionPane.showMessageDialog(this,
            "Create party first!");
            return;
        }

        String name =
        JOptionPane.showInputDialog("Guest Name:");

        String phone =
        JOptionPane.showInputDialog("Guest Phone:");

        String id =
        JOptionPane.showInputDialog("Invitation ID:");

        Guest g = new Guest(name,phone,id);

        clientParty.addGuest(g);
    }

    private void addService(){  //add services 

        if(!partyCreated){
            JOptionPane.showMessageDialog(this,
            "Create party first!");
            return;
        }

        try{

            String type =
            JOptionPane.showInputDialog(
            "1. Entertainment\n2. Venue\n3. Catering");

            int choice = Integer.parseInt(type);

            String name =
            JOptionPane.showInputDialog("Service Name:");

            double price =
            Double.parseDouble(
            JOptionPane.showInputDialog("Base Price:"));

            if(choice==1){

                int hours =
                Integer.parseInt(
                JOptionPane.showInputDialog("Hours:"));

                clientParty.addService(
                new EntertainmentService(name,price,hours));
            }

            else if(choice==2){

                int cap =
                Integer.parseInt(
                JOptionPane.showInputDialog("Capacity:"));

                clientParty.addService(
                new VenueService(name,price,cap));
            }

            else{

                int num =
                clientParty.countGuestsRecursive(0);

                clientParty.addService(
                new CateringService(name,price,num));
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,
            "Wrong input.");
        }
    }

    private void showSummary(){   // display party details in result frame 

        if(partyCreated)
            resultFrame.showResult(
            clientParty.getPartyDetails());

        else
            JOptionPane.showMessageDialog(this,
            "Create party first!");
    }

    private void showTotalCost(){  // display total cost 

        if(partyCreated)
            resultFrame.showResult(
            "Total Cost = "
            + client.calculateCost());

        else
            JOptionPane.showMessageDialog(this,
            "Create party first!");
    }
}
