# Online Shop System (Java / BlueJ Project)

A gui application that simulates a simple online shop. Built in Java using the BlueJ environment, this project lets users manage products, sellers, and sales records with a user-friendly GUI.

---

## **Project Overview**

- **Type:** Desktop Application (Java, Swing, BlueJ)
- **Features:**
  - Add, update, and manage products (items for sale)
  - Add and manage seller information
  - Process sales (sell items, record transactions)
  - Generate sales and inventory reports
  - All data stored in-memory (no external database required)
  - Designed for educational/demo purposes

---

## **Getting Started**

### **Requirements**
- [Java JDK](https://adoptopenjdk.net/) (version 8+)
- [BlueJ](https://www.bluej.org/) IDE  
  _You can also run the project in any IDE that supports standard Java Swing projects._

### **How to Run**
1. **Open the project in BlueJ:**
    - Launch BlueJ.
    - Open the folder as a project.
2. **Compile all classes:**  
   BlueJ: Click "Compile" or right-click and select "Compile".
3. **Run the Application:**
    - Right-click on `OnlineShopFrame` and select `void main(String[] args)`.
    - The main window (GUI) should launch.

---

## **Project Structure**

  - OnlineShopFrame.java: "Main app window, contains panels for all features"
  - model/:
      - Item.java: "Product class (single item details)"
      - Items.java: "Product management (list/collection of items)"
      - Seller.java: "Single seller details"
      - Sellers.java: "Seller management (list/collection)"
      - SaleItem.java: "Represents items in a sale transaction"
      - Record.java: "Single sales record"
      - Records.java: "Sales records management"
      - State.java: "Application state tracking"
      - Updater.java: "Handles updates/refreshes in the model"
      - MyObserver.java: "Implements observer pattern for real-time UI updates"
      - ...: "Other helper/model classes as needed"
  - "*.class, *.ctxt": "Compiled Java bytecode and BlueJ context files (should be git-ignored)"
  - package.bluej: "BlueJ project config (can be ignored in version control)"
  - README.TXT: "Project readme/documentation"


---

## **Main Functionalities**

- **Add Products:**  
  Enter details for new products/items for sale, including name, description, price, and quantity.
- **Add Sellers:**  
  Register sellers with their information for tracking who is responsible for each sale.
- **Process Sales:**  
  Sell items to customers, reduce stock, and create sales records.
- **Reports:**  
  Generate and display sales/inventory reports for business tracking.
- **Real-time Updates:**  
  Observer pattern ensures UI panels reflect latest changes instantly.

---

## **Usage Notes & Limitations**

- All data is stored in-memory. Closing the application will reset all entries.
- This project does not persist data to disk or connect to a database.
- GUI may use Java Swing (standard library, so no extra dependencies).
- Designed and structured for learning and demonstration.

