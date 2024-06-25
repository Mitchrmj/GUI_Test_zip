import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {
    private JLabel labelOutput;
    private JTextField textUsername;
    private JButton buttonOK;
    private JButton buttonMenu;
    private JButton buttonStart;
    private JLabel displayUsername;
    private JButton buttonResults;
    private JButton buttonTopics;
    private JTable dataTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;




    public GUI() {
        setTitle("Window title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // quit the app when we close the window
        setSize(800, 500);
        setLayout(null);



        labelOutput = new JLabel("Computer Science Quiz");
        labelOutput.setFont(new Font("Courier", Font.BOLD,30));
        labelOutput.setBounds(213,100, 375,30);


        textUsername = new JTextField();
        textUsername.setBounds(198, 200, 250, 30);
        textUsername.addActionListener(this);

        displayUsername = new JLabel("Username: ");
        displayUsername.setFont(new Font("Courier", Font.PLAIN,12));
        displayUsername.setBounds(198, 170, 150, 30);

        buttonOK = new JButton("OK");
        buttonOK.setBounds(478, 200, 95, 30);
        buttonOK.addActionListener(this);

        buttonMenu = new JButton("MENU");
        buttonMenu.setBounds(260, 250, 120, 35);
        buttonMenu.addActionListener(this);

        buttonStart = new JButton("START");
        buttonStart.setBounds(420, 250, 120, 35);
        buttonStart.addActionListener(this);

        buttonResults = new JButton("RESULTS");
        buttonResults.setBounds(0, 0, 200, 230);
        buttonResults.addActionListener(this);

        buttonTopics = new JButton("TOPICS");
        buttonTopics.setBounds(0, 230, 200, 230);
        buttonTopics.addActionListener(this);


        add(labelOutput);
        add(textUsername);
        add(buttonOK);
        add(buttonMenu);
        add(buttonStart);
        add(displayUsername);
        add(buttonResults);
        add(buttonTopics);

        // Initialize the table
        tableModel = new DefaultTableModel(0, 1);



        dataTable = new JTable(tableModel);
        dataTable.setDefaultEditor(Object.class, null);
        dataTable.setFont(new Font("Courier", Font.PLAIN, 18)); // Set a larger font size
        dataTable.setRowHeight(30);
        dataTable.setTableHeader(null);
        dataTable.setPreferredScrollableViewportSize(new Dimension(300, 150));
        dataTable.setFillsViewportHeight(true);

        // Scroll pane settings
        scrollPane = new JScrollPane(dataTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(220, 20, 550, 425);

        add(scrollPane);

        setVisible(true);
        buttonResults.setVisible(false);
        buttonTopics.setVisible(false);
        scrollPane.setVisible(false);
        System.out.println("SEQUENCE: GUI_test created");
    }

    String username = null;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonOK) {
            System.out.println();
            username = textUsername.getText();
            displayUsername.setText("Username: " + username);
        }
        if(e.getSource() == buttonMenu) {
            buttonResults.setVisible(true);
            buttonTopics.setVisible(true);

            textUsername.setVisible(false);
            buttonOK.setVisible(false);
            buttonMenu.setVisible(false);
            buttonStart.setVisible(false);
            displayUsername.setVisible(false);
            labelOutput.setVisible(false);
        }

        if(e.getSource() == buttonResults) {
            scrollPane.setVisible(true);
            String[] rowData = {"Sajan Scored 0/10"}; // Example initial value
            tableModel.addRow(rowData);
        }
        if(e.getSource() == buttonTopics) {
            scrollPane.setVisible(false);
        }

    }
}