package Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        while (HelperUtils.isNull(input)) {
            System.out.print("Invalid input. Please enter again: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    public static String getStringInput(String prompt, int minLength) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        while (!HelperUtils.isValidString(input, minLength)) {
            System.out.print("Input too short. Try again: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    public static String getStringInput(String prompt, int minLength, int maxLength) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        while (!HelperUtils.isValidString(input, minLength, maxLength)) {
            System.out.print("Input length must be between " + minLength + " and " + maxLength + ". Try again: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    public static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter an integer value.");
            }
        }
    }

    public static int getIntInput(String prompt, int min, int max) {
        int value = getIntInput(prompt);
        while (!HelperUtils.isValidNumber(value, min, max)) {
            System.out.println("Value must be between " + min + " and " + max + ".");
            value = getIntInput(prompt);
        }
        return value;
    }


    public static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a numeric value.");
            }
        }
    }

    public static double getDoubleInput(String prompt, double min, double max) {
        double value = getDoubleInput(prompt);
        while (!HelperUtils.isValidNumber(value, min, max)) {
            System.out.println("Value must be between " + min + " and " + max + ".");
            value = getDoubleInput(prompt);
        }
        return value;
    }


    public static LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.print(prompt + " (yyyy-MM-dd): ");
            String input = scanner.nextLine().trim();
            try {
                if (HelperUtils.isValidDate(input)) {
                    return LocalDate.parse(input, formatter);
                } else {
                    System.out.println("Invalid date format or value. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please use yyyy-MM-dd format.");
            }
        }
    }


    public static boolean getConfirmation(String prompt) {
        System.out.print(prompt + " (Y/N): ");
        String response = scanner.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.print("Invalid input. Enter Y or N: ");
            response = scanner.nextLine().trim().toLowerCase();
        }
        return response.equals("y");
    }

    public static int getMenuChoice(int min, int max) {
        int choice = getIntInput("Enter your choice: ");
        while (choice < min || choice > max) {
            System.out.println("Choice must be between " + min + " and " + max + ".");
            choice = getIntInput("Enter your choice: ");
        }
        return choice;
    }

    public static void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

}
