import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class PartyGUI extends JFrame implements ActionListener {

    private Client client;
    private Party clientParty;
    private boolean partyCreated = false;

    private JTextField partyNameField;
    private JTextField guestNumField;
    private JTextField serviceNumField;

    private JSpinner dateSpinner;
    private JComboBox<String> locationBox;

    private JButton createPartyButton;
    private JButton addGuestButton;
    private JButton removeGuestButton;
    private JButton addServiceButton;
    private JButton removeServiceButton;
    private JButton showSummaryButton;
    private JButton totalCostButton;

    private ResultFrame resultFrame;

  public PartyGUI(Client client) {

    this.client = client;

    setTitle("Welcome " + client.getName());
    setSize(650,550);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    resultFrame = new ResultFrame();

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout(15,15));
    contentPane.setBackground(new Color(245,230,250));

    JLabel title = new JLabel(
    "Party Management System",
    JLabel.CENTER);

    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setForeground(new Color(120,50,150));
    contentPane.add(title, BorderLayout.NORTH);

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(5,2,15,15));
    centerPanel.setBackground(new Color(250,240,255));
    centerPanel.setBorder(
    BorderFactory.createEmptyBorder(20,30,20,30));

    centerPanel.add(new JLabel("Party Name:"));
    partyNameField = new JTextField();
    centerPanel.add(partyNameField);

    centerPanel.add(new JLabel("Date:"));
    dateSpinner = new JSpinner(new SpinnerDateModel());
    JSpinner.DateEditor editor =
    new JSpinner.DateEditor(dateSpinner,"dd/MM/yyyy");
    dateSpinner.setEditor(editor);
    centerPanel.add(dateSpinner);

    centerPanel.add(new JLabel("Location:"));
    locationBox = new JComboBox<String>();

    locationBox.addItem("Riyadh");
    locationBox.addItem("Jeddah");
    locationBox.addItem("Dammam");
    locationBox.addItem("Abha");
    locationBox.addItem("Alula");
    locationBox.addItem("Zahle");
    locationBox.addItem("Beirut");
    locationBox.addItem("Tripoli");
     locationBox.addItem("Khartum");


    centerPanel.add(locationBox);

    // centerPanel.add(new JLabel("Number of Guests:"));
    // guestNumField = new JTextField();
    // centerPanel.add(guestNumField);

    // centerPanel.add(new JLabel("Number of Services:"));
    // serviceNumField = new JTextField();
    // centerPanel.add(serviceNumField);

    contentPane.add(centerPanel, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4,2,12,12));
    buttonPanel.setBackground(new Color(245,230,250));
    buttonPanel.setBorder(
    BorderFactory.createEmptyBorder(15,30,25,30));

    createPartyButton = new JButton("Create Party");
    addGuestButton = new JButton("Add Guest");
    removeGuestButton = new JButton("Remove Guest");
    addServiceButton = new JButton("Add Service");
    removeServiceButton = new JButton("Remove Service");
    showSummaryButton = new JButton("Show Summary");
    totalCostButton = new JButton("Total Cost");

    JButton[] buttons = {
        createPartyButton,
        addGuestButton,
        removeGuestButton,
        addServiceButton,
        removeServiceButton,
        showSummaryButton,
        totalCostButton
    };

    for(JButton b : buttons){
        b.setBackground(new Color(180,140,220));
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 13));
        buttonPanel.add(b);
        b.addActionListener(this);
    }

    contentPane.add(buttonPanel, BorderLayout.SOUTH);
    System.out.println(client.getParty());
}
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==createPartyButton)
            createParty();

        else if(e.getSource()==addGuestButton)
            addGuest();

        else if(e.getSource()==removeGuestButton)
            removeGuest();

        else if(e.getSource()==addServiceButton)
            addService();

        else if(e.getSource()==removeServiceButton)
            removeService();

        else if(e.getSource()==showSummaryButton)
            showSummary();

        else if(e.getSource()==totalCostButton)
            showTotalCost();
    }

    private void createParty(){

        try{
            String name = partyNameField.getText();

            SimpleDateFormat f =
            new SimpleDateFormat("dd/MM/yyyy");

            String date = f.format(dateSpinner.getValue());

            String location =
            locationBox.getSelectedItem().toString();

            // int guests =
            // Integer.parseInt(guestNumField.getText());

            // int services =
            // Integer.parseInt(serviceNumField.getText());

            client.createParty(name,date,location);

            clientParty = client.getParty();

            partyCreated = true;

            JOptionPane.showMessageDialog(this,
            "Party created successfully!");

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,
            "Enter valid data.");
        }
    }

    private void addGuest(){

        if(!partyCreated){
            JOptionPane.showMessageDialog(this,
            "Create party first!");
            return;
        }

        try{
            String name =
            JOptionPane.showInputDialog("Guest Name:");

            String phone =
            JOptionPane.showInputDialog("Guest Phone:");

            if(phone.length()!=10)
                throw new InvalidPhoneNumberException(
                "Phone number must be 10 digits.");

            String id =
            JOptionPane.showInputDialog("Invitation ID:");

            Guest g = new Guest(name,phone,id);

            if(clientParty.addGuest(g))
                JOptionPane.showMessageDialog(this,
                "Guest added successfully.");
            else
                JOptionPane.showMessageDialog(this,
                "Cannot add guest.\nGuest limit reached.");

        }catch(InvalidPhoneNumberException ex){
            JOptionPane.showMessageDialog(this,
            ex.getMessage());
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this,
            "Invalid input.");
        }
    }

    private void removeGuest(){

        if(!partyCreated){
            JOptionPane.showMessageDialog(this,
            "Create party first!");
            return;
        }

        String name =
        JOptionPane.showInputDialog("Enter guest name:");

        if(clientParty.removeGuest(name))
            JOptionPane.showMessageDialog(this,
            "Guest removed successfully.");
        else
            JOptionPane.showMessageDialog(this,
            "Guest not found.");
    }

    private void addService(){

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

            boolean added = false;

            if(choice==1){

                int hours =
                Integer.parseInt(
                JOptionPane.showInputDialog("Hours:"));

                added = clientParty.addService(
                new EntertainmentService(name,price,hours));
            }

            else if(choice==2){

                int cap =
                Integer.parseInt(
                JOptionPane.showInputDialog("Capacity:"));

                added = clientParty.addService(
                new VenueService(name,price,cap));
            }

            else if(choice==3){

                int num =
                clientParty.countGuests();

                added = clientParty.addService(
                new CateringService(name,price,num));
            }

            if(added)
                JOptionPane.showMessageDialog(this,
                "Service added successfully.");
            else
                JOptionPane.showMessageDialog(this,
                "Cannot add service.\nService limit reached.");

        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,
            "Wrong input.");
        }
    }

    private void removeService(){

        if(!partyCreated){
            JOptionPane.showMessageDialog(this,
            "Create party first!");
            return;
        }

        String name =
        JOptionPane.showInputDialog("Enter service name:");

        if(clientParty.removeService(name))
            JOptionPane.showMessageDialog(this,
            "Service removed successfully.");
        else
            JOptionPane.showMessageDialog(this,
            "Service not found.");
    }

    private void showSummary(){

        if(partyCreated)
            resultFrame.showResult(clientParty.getPartyDetails());

        else
            JOptionPane.showMessageDialog(this,"Create party first!");
    }

    private void showTotalCost(){

        if(partyCreated)
            resultFrame.showResult(
            "Total Cost = "
            + client.calculateCost());

        else
            JOptionPane.showMessageDialog(this,
            "Create party first!");
    }
}