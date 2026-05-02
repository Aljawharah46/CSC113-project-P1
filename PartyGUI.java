import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class PartyGUI extends JFrame implements ActionListener {

    private JTextField clientNameField;
    private JTextField phoneField;
    private JTextField partyNameField;
    private JTextField guestNumField;
    private JTextField serviceNumField;

    private JSpinner dateSpinner;
    private JComboBox locationBox;

    private JButton createPartyButton;
    private JButton addServiceButton;
    private JButton showSummaryButton;
    private JButton totalCostButton;

    private Client client;
    private Party clientParty;
    private boolean partyCreated = false;

    private ResultFrame resultFrame;

    public PartyGUI() {
        setTitle("Party Management System");
        setSize(500, 450);
        setLocation(150, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        resultFrame = new ResultFrame();

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.setBackground(new Color(245, 230, 250));

        JLabel titleLabel = new JLabel("Party Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(100, 40, 120));
        contentPane.add(titleLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2, 8, 8));
        inputPanel.setBackground(new Color(250, 240, 255));

        inputPanel.add(new JLabel("Client Name:"));
        clientNameField = new JTextField(20);
        inputPanel.add(clientNameField);

        inputPanel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField(20);
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Party Name:"));
        partyNameField = new JTextField(20);
        inputPanel.add(partyNameField);

        inputPanel.add(new JLabel("Date:"));
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(editor);
        inputPanel.add(dateSpinner);

        inputPanel.add(new JLabel("Location:"));
        locationBox = new JComboBox();
        locationBox.addItem("Riyadh");
        locationBox.addItem("Jeddah");
        locationBox.addItem("Dammam");
        locationBox.addItem("Lebanon");
        locationBox.addItem("Other");
        inputPanel.add(locationBox);

        inputPanel.add(new JLabel("Number of Guests:"));
        guestNumField = new JTextField(20);
        inputPanel.add(guestNumField);

        inputPanel.add(new JLabel("Number of Services:"));
        serviceNumField = new JTextField(20);
        inputPanel.add(serviceNumField);

        contentPane.add(inputPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 8, 8));
        buttonPanel.setBackground(new Color(245, 230, 250));

        createPartyButton = new JButton("Create Party");
        addServiceButton = new JButton("Add Service");
        showSummaryButton = new JButton("Show Summary");
        totalCostButton = new JButton("Total Cost");

        createPartyButton.setBackground(new Color(220, 190, 240));
        addServiceButton.setBackground(new Color(220, 190, 240));
        showSummaryButton.setBackground(new Color(220, 190, 240));
        totalCostButton.setBackground(new Color(220, 190, 240));

        buttonPanel.add(createPartyButton);
        buttonPanel.add(addServiceButton);
        buttonPanel.add(showSummaryButton);
        buttonPanel.add(totalCostButton);

        contentPane.add(buttonPanel);

        createPartyButton.addActionListener(this);
        addServiceButton.addActionListener(this);
        showSummaryButton.addActionListener(this);
        totalCostButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == createPartyButton) {
            createParty();
        }

        else if (event.getSource() == addServiceButton) {
            addService();
        }

        else if (event.getSource() == showSummaryButton) {
            showSummary();
        }

        else if (event.getSource() == totalCostButton) {
            showTotalCost();
        }
    }

    private void createParty() {
        try {
            String clientName = clientNameField.getText();
            String phone = phoneField.getText();
            String partyName = partyNameField.getText();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String date = format.format(dateSpinner.getValue());

            String location = locationBox.getSelectedItem().toString();

            int guestNum = Integer.parseInt(guestNumField.getText());
            int serviceNum = Integer.parseInt(serviceNumField.getText());

            client = new Client(clientName, phone);
            client.createParty(partyName, date, location, serviceNum, guestNum);

            clientParty = client.getParty();
            partyCreated = true;

            JOptionPane.showMessageDialog(this, "Party created successfully!");
        }

        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Guest number and service number must be numbers.");
        }
    }

    private void addService() {
        if (!partyCreated) {
            JOptionPane.showMessageDialog(this, "Create a party first!");
            return;
        }

        try {
            String type = JOptionPane.showInputDialog(this,
                    "Enter service type:\n1. Entertainment\n2. Venue\n3. Catering");

            int serviceType = Integer.parseInt(type);

            String serviceName = JOptionPane.showInputDialog(this, "Enter service name:");
            String priceText = JOptionPane.showInputDialog(this, "Enter base price:");
            double basePrice = Double.parseDouble(priceText);

            if (serviceType == 1) {
                String hoursText = JOptionPane.showInputDialog(this, "Enter number of hours:");
                int hours = Integer.parseInt(hoursText);

                EntertainmentService s = new EntertainmentService(serviceName, basePrice, hours);
                clientParty.addService(s);

                JOptionPane.showMessageDialog(this, "Entertainment service added successfully!");
            }

            else if (serviceType == 2) {
                String capacityText = JOptionPane.showInputDialog(this, "Enter capacity:");
                int capacity = Integer.parseInt(capacityText);

                VenueService s = new VenueService(serviceName, basePrice, capacity);
                clientParty.addService(s);

                JOptionPane.showMessageDialog(this, "Venue service added successfully!");
            }

            else if (serviceType == 3) {
                int numberOfGuests = clientParty.countGuestsRecursive(0);

                CateringService s = new CateringService(serviceName, basePrice, numberOfGuests);
                clientParty.addService(s);

                JOptionPane.showMessageDialog(this, "Catering service added successfully!");
            }

            else {
                JOptionPane.showMessageDialog(this, "Invalid service type.");
            }
        }

        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    private void showSummary() {
        if (partyCreated) {
            resultFrame.showResult(clientParty.getPartyDetails());
        } else {
            JOptionPane.showMessageDialog(this, "Create a party first!");
        }
    }

    private void showTotalCost() {
        if (partyCreated) {
            double total = client.calculateCost();
            resultFrame.showResult("The total cost of the party is " + total);
        } else {
            JOptionPane.showMessageDialog(this, "Create a party first!");
        }
    }

    public static void main(String[] args) {
        PartyGUI frame = new PartyGUI();
        frame.setVisible(true);
    }
}
