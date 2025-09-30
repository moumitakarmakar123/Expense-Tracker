import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Validation utilities for parsing and verifying user input.
 */
public final class InputValidation {

  private static final Set<String> ALLOWED_CATEGORIES = new HashSet<>(
    Arrays.asList("food", "travel", "bills", "entertainment", "other")
  );

  private InputValidation() {}

  public static double parseAndValidateAmount(String raw) {
    if (raw == null) {
      throw new IllegalArgumentException("Amount is required");
    }
    String trimmed = raw.trim();
    if (trimmed.isEmpty()) {
      throw new IllegalArgumentException("Amount is required");
    }
    double value;
    try {
      value = Double.parseDouble(trimmed);
    } catch (NumberFormatException ex) {
      throw new IllegalArgumentException("Amount must be a valid number", ex);
    }
    if (value <= 0 || value >= 1000) {
      throw new IllegalArgumentException("Amount must be > 0 and < 1000");
    }
    return value;
  }

  public static String validateCategory(String raw) {
    if (raw == null) {
      throw new IllegalArgumentException("Category is required");
    }
    String normalized = raw.trim().toLowerCase(Locale.ROOT);
    if (!ALLOWED_CATEGORIES.contains(normalized)) {
      throw new IllegalArgumentException(
        "Category must be one of: food, travel, bills, entertainment, other"
      );
    }
    return normalized;
  }
}


