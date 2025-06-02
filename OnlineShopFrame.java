import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import model.*;
import model.Seller;

/**
 * This is the main frame for the Online Shop application.
 */
public class OnlineShopFrame extends JFrame {

    // Main tabbed pane to hold different functionality panels
    private JTabbedPane tabbedPane;

    // Individual panels for different operations
    private AddSellerPanel addSellerPanel;
    private AddItemPanel addItemPanel;
    private SellItemsPanel sellItemsPanel;
    private JPanel reportPanel;

    // Other necessary attributes for the application
    private Updater updater;
    private Sellers sellers = new Sellers();
    private Items items = new Items();
    private int sellerId = 1;
    private int itemId = 1;
    private OnlineShop onlineShop = new OnlineShop();

    /**
     * Constructor initializes the GUI components and layout.
     * @param updater - Updater object used for observer pattern.
     */
    public OnlineShopFrame(Updater updater) {
        this.updater = updater;

        // Basic frame settings
        setTitle("Online Shop");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        // Instantiating the panels and adding them to the tabbedPane
        addSellerPanel = new AddSellerPanel();
        addItemPanel = new AddItemPanel();
        sellItemsPanel = new SellItemsPanel();
        tabbedPane.addTab("Add Seller", addSellerPanel);
        tabbedPane.addTab("Add Item", addItemPanel);
        tabbedPane.addTab("Sell Items", sellItemsPanel);

        reportPanel = new createReportPanel();
        tabbedPane.addTab("Monthly Report", reportPanel);

        add(tabbedPane);
    }

    /**
     * Panel for adding sellers.
     */
    private class AddSellerPanel extends JPanel implements MyObserver {
        JButton addSellerButton = new JButton("Add Seller");
        JTextField sellerNameField = new JTextField(20);
        JLabel message = new JLabel();

        // Observer pattern's update method
        public void update() {
            message.setText("Seller added successfully!");
        }

        public AddSellerPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // Action listener for adding a seller
            addSellerButton.addActionListener(new AddSellerAction());

            // Designing the input panel for adding sellers
            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("Seller Name:"));
            inputPanel.add(sellerNameField);
            inputPanel.add(addSellerButton);
            inputPanel.setAlignmentX(CENTER_ALIGNMENT);

            // Adding components to this panel
            add(Box.createVerticalStrut(20));
            add(inputPanel);
            add(Box.createVerticalStrut(10));
            add(message);
            add(Box.createVerticalGlue());

            sellers.attach(this);
        }

        private class AddSellerAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Seller newSeller = new Seller(sellerId++, sellerNameField.getText());
                onlineShop.addSeller(newSeller);
                update();
            }
        }
    }

    private class AddItemPanel extends JPanel implements MyObserver {
        JButton addItemButton = new JButton("Add Item");
        JLabel addPrice = new JLabel("Price: ");
        JLabel addName = new JLabel("Name: ");
        JLabel addTotalItem = new JLabel("Total Item: ");
        JTextField price = new JTextField(10);
        JTextField name = new JTextField(10);
        JTextField totalItem = new JTextField(10);

        JLabel message = new JLabel();
        public void update() {
            message.setText("add Item successfully");
        }

        public AddItemPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            addItemButton.addActionListener(new AddItemAction());

            JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
            inputPanel.add(addPrice);
            inputPanel.add(price);
            inputPanel.add(addName);
            inputPanel.add(name);
            inputPanel.add(addTotalItem);
            inputPanel.add(totalItem);
            inputPanel.setAlignmentX(CENTER_ALIGNMENT);

            add(Box.createVerticalStrut(20));
            add(inputPanel);
            add(Box.createVerticalStrut(10));
            add(addItemButton);
            add(Box.createVerticalStrut(10));
            add(message);
            add(Box.createVerticalGlue());

            items.attach(this);
        }private class AddItemAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                double thePrice = Double.parseDouble(price.getText());
                int theTotalItem = Integer.parseInt(totalItem.getText());
                Item newItem = new SaleItem(itemId++, thePrice, name.getText(), theTotalItem );
                onlineShop.addItem(newItem);
                update();

            }
        }
    }

    private class SellItemsPanel extends JPanel implements MyObserver {
        JButton sellItemButton = new JButton("Sell Item");
        JLabel addId = new JLabel("Enter the item id: ");
        JTextField id = new JTextField(10);
        JLabel message = new JLabel();
        public void update() {
            message.setText("Sell Item Successfully!!!");
        }

        public SellItemsPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            sellItemButton.addActionListener(new SellItemAction());

            JPanel inputPanel = new JPanel();
            inputPanel.add(addId);
            inputPanel.add(id);
            inputPanel.add(sellItemButton);
            inputPanel.setAlignmentX(CENTER_ALIGNMENT);

            add(Box.createVerticalStrut(20));
            add(inputPanel);
            add(Box.createVerticalStrut(10));
            add(message);
            add(Box.createVerticalGlue());
        }

        private class SellItemAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                int theId = Integer.parseInt(id.getText());
                onlineShop.sellItems(theId);
                update();
            }
        }
    }

    private class createReportPanel extends JPanel implements MyObserver {
        private JTextArea reportArea;
        private JButton generateReportButton;
        public void update() {

        }

        public createReportPanel() {
            setLayout(new BorderLayout());

            reportArea = new JTextArea(20, 50);
            reportArea.setEditable(false); // Ensure users can't modify the report

            // Set up JScrollPane and add it to the panel
            JScrollPane scrollPane = new JScrollPane(reportArea);
            add(scrollPane, BorderLayout.CENTER);
            generateReportButton = new JButton("Generate Monthly Report");
            generateReportButton.addActionListener(new ReportAction());
            add(generateReportButton, BorderLayout.SOUTH);
        }
        private class ReportAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportArea.setText(onlineShop.report());
            }
        }
    }
    public static void main() {
        Updater updater = new Updater();
        OnlineShopFrame frame = new OnlineShopFrame(updater);
        frame.setVisible(true);
    }
}
