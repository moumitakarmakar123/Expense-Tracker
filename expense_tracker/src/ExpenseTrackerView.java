

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 

/**
 * Swing-based view for the Expense Tracker application. Responsible for
 * rendering inputs and the transactions table. Holds an internal list of
 * transactions but exposes it immutably to callers.
 */
public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private List<Transaction> transactions = new ArrayList<>();

  

  /**
   * @return the JTable component showing the transactions
   */
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  /**
   * @return raw string entered in the amount field
   */
  public String getAmountText() {
    return amountField.getText();
  }

  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  /**
   * @return raw string entered in the category field
   */
  public String getCategoryText() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }
  /**
   * @return the table model backing the transactions table
   */
  public DefaultTableModel getTableModel() {
    return model;
  }

  /**
   * Constructs the view with a provided table model.
   * @param model table model to use for the transactions table
   */
  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  public void refreshTable(List<Transaction> transactions) {
      // model.setRowCount(0);
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost=0;
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});

      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      transactionsTable.updateUI();
  
    }  

  public void refresh() {

    List<Transaction> transactions = getTransactions();
  
    refreshTable(transactions);
  
  }

  public List<Transaction> getTransactions() {
    return Collections.unmodifiableList(new ArrayList<>(transactions));
  }
  
  public void addTransaction(Transaction t) {
    transactions.add(t);
    refresh();
  }
  

}
