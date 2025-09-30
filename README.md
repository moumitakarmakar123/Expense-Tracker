# Expense Tracker - HW1 Baseline

This project is a simple Expense Tracker that lets users add daily transactions with amount, category, and date.

## Supported features
- Add a transaction with amount, category, and auto-generated timestamp
- Input validation before adding a transaction
  - amount: number > 0 and < 1000
  - category: one of "food", "travel", "bills", "entertainment", "other"
- UI displays transactions in a table and appends a Total row

## How to build and run (without Ant)
From project root:

```bash
# Compile sources and tests
javac -cp ".;expense_tracker\\lib\\junit-4.11.jar" -d expense_tracker\\out expense_tracker\\src\\*.java expense_tracker\\test\\*.java

# Run tests
java -cp ".;expense_tracker\\lib\\junit-4.11.jar;expense_tracker\\out" org.junit.runner.JUnitCore ExpenseTrackerTest

# Run the app
java -cp ".;expense_tracker\\lib\\junit-4.11.jar;expense_tracker\\out" ExpenseTrackerApp
```

## How to build and test (with Ant)
If you have Apache Ant installed, from the `expense_tracker` folder:
- `ant document` to generate the `jdoc` folder
- `ant compile` to compile classes into `bin`
- `ant test` to compile and run unit tests
- `ant clean` to remove generated files

## Generating API documentation (Javadoc)
From project root (no Ant):
```bash
javadoc -d expense_tracker\\jdoc expense_tracker\\src\\*.java
```
Then open `expense_tracker/jdoc/index.html` in a browser.

With Ant: run `ant document` from the `expense_tracker` folder and open `jdoc/index.html`.

## API overview (examples)
- `Transaction`
  - `Transaction(double amount, String category)`
  - `double getAmount()`
  - `String getCategory()`
  - `String getTimestamp()`
- `ExpenseTrackerView`
  - `String getAmountText()` / `String getCategoryText()`
  - `void addTransaction(Transaction t)`
  - `List<Transaction> getTransactions()` (immutable snapshot)
- `InputValidation`
  - `static double parseAndValidateAmount(String raw)`
  - `static String validateCategory(String raw)`

## Notes on design
- MVC responsibilities are separated: `ExpenseTrackerView` (View), action listener in `ExpenseTrackerApp` (Controller), `Transaction` (Model). The list is encapsulated in the view and exposed immutably.

## Original README (reference)
The original instructions are preserved below for reference:

```text
# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## How to build and test (from Terminal):
1. Make sure that you have Apache Ant installed. Run ```ant``` in the root directory, which contains the build.xml build file.

2. Run ```ant document``` to generate the jdoc folder. In that folder, open the index.html file.

3. Run ```ant compile``` to generate the class files. Compiled classes will be in the bin directory.

4. Run ```ant test``` to compile all unit tests and run them.

## How to run (from Terminal):
After building the project (i.e., running ant), run: ```java -cp bin ExpenseTrackerApp```

## How to clean up (from Terminal):
Run ```ant clean``` to clean the project (i.e., delete all generated files).

## Code Modification

Create a file named ```InputValidation.java```  to validate the ```amount``` and ```category``` field of this app. Some hints are as follows:
1. The ```amount``` should be greater than 0 and less than 1000. 
2. It should be a valid number. 
3. The ```category``` should be a valid string input from the following list: "food", "travel", "bills", "entertainment", "other" .
4. You should display error messages on the GUI and not accept the invalid input. . You should throw an appropriate exception. 
5. Update the ExpenseTrackerApp.java with the input validation steps for adding transaction.

## Manual Review
Here are some examples of satisfying ```non-functional``` requirements:
1. Understandability
• External documentation (such as a README file) improves program understanding. This app’s
README file helps users and developers by providing the build instructions.


Here are some examples of violating ```non-functional``` requirements:
1.  Modularity
• The app does not apply the MVC architecture pattern.
• The app should declare the following packages and their classes: model, view, controller. 

## Understandibility
For the understandability section, we will be inspecting your git log. You should include either the .git folder or else a gitLog.(pdf | txt).