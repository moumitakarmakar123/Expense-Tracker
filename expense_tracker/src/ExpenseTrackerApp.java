import javax.swing.table.DefaultTableModel;

/**
 * Application entry point. Wires the view to basic controller behavior
 * (input validation and transaction creation) and shows the UI.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      try {
        // Get raw input from view
        String amountText = view.getAmountText();
        String categoryText = view.getCategoryText();

        // Validate
        double amount = InputValidation.parseAndValidateAmount(amountText);
        String category = InputValidation.validateCategory(categoryText);

        // Create transaction object
        Transaction t = new Transaction(amount, category);

        // Add to model via view
        view.addTransaction(t);
      } catch (IllegalArgumentException ex) {
        javax.swing.JOptionPane.showMessageDialog(
          null,
          ex.getMessage(),
          "Invalid Input",
          javax.swing.JOptionPane.ERROR_MESSAGE
        );
      }
    });

  }

}
