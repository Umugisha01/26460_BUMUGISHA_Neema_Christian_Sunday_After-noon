// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_Handling {
private static Scanner scanner = new Scanner(System.in);

    // 1. IOException: Simulate reading a non-existent file
    public static void simulateIOException() {
        System.out.print("Enter a filename to read (non-existent file): ");
        String filename = scanner.nextLine();
        try {
            FileReader file = new FileReader(filename); // Attempt to open the specified file
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage()); // Handle IOException
        }
    }

    // 2. FileNotFoundException: Specific IOException for missing files
    public static void simulateFileNotFoundException() {
        System.out.print("Enter a missing filename to read: ");
        String filename = scanner.nextLine();
        try {
            FileReader file = new FileReader(filename); // Attempt to open a missing file
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage()); // Handle FileNotFoundException
        }
    }

    // 3. EOFException: Simulate reading beyond file content
    public static void simulateEOFException() {
      System.out.print("Enter a filename for EOF simulation (empty file): ");
      String filename = scanner.nextLine();
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
          ois.readObject(); // Attempt to read from the file
      } catch (EOFException e) {
          System.out.println("EOFException caught: " + e.getMessage()); // Handle EOFException
      } catch (ClassNotFoundException e) {
          System.out.println("ClassNotFoundException caught: " + e.getMessage()); // Handle ClassNotFoundException
      } catch (IOException e) {
          System.out.println("IOException caught: " + e.getMessage()); // Handle other IOExceptions
      }
    } 

    // 4. SQLException: Simulate a database error
    public static void simulateSQLException() {
        System.out.print("Simulating database connection error... ");
        try {
            throw new SQLException("Database not found."); // Simulate a database connection error
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage()); // Handle SQLException
        }
    }

    // 5. ClassNotFoundException: Missing class at runtime
    public static void simulateClassNotFoundException() {
        System.out.print("Simulating class loading error... ");
        try {
            Class.forName("com.nonexistent.Class"); // Attempt to load a non-existent class
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage()); // Handle ClassNotFoundException
        }
    }

    // 6. ArithmeticException: Simulate division by zero
    public static void simulateArithmeticException() {
        System.out.print("Enter two integers for division (a/b): ");
        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = a / b; // Attempt to divide by zero if b is 0
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage()); // Handle ArithmeticException
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught: Please enter valid integers."); // Handle invalid input type
            scanner.next(); // Clear invalid input
        }
    }

    // 7. NullPointerException: Accessing a null reference
    public static void simulateNullPointerException() {
        String str = null; 
        try {
            str.length(); // Attempt to access a method on a null reference
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage()); // Handle NullPointerException
        }
    }

    // 8. ArrayIndexOutOfBoundsException: Accessing an invalid array index
    public static void simulateArrayIndexOutOfBoundsException() {
        int[] arr = new int[5]; 
        try {
            System.out.print("Enter an index to access in the array (0-4): ");
            int index = scanner.nextInt(); 
            int num = arr[index]; // Attempt to access an out-of-bounds index in the array
            System.out.println("Value at index " + index + ": " + num);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage()); // Handle ArrayIndexOutOfBoundsException
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught: Please enter a valid integer."); // Handle invalid input type
            scanner.next(); // Clear invalid input
        }
    }

    // 9. ClassCastException: Invalid type cast
    @SuppressWarnings("removal")
    public static void simulateClassCastException() {
        Object obj = new Integer(100); 
        try {
            String str = (String) obj; // Attempt to cast an Integer to a String
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage()); // Handle ClassCastException
        }
    }

    // 10. IllegalArgumentException: Passing an invalid argument to a method
    public static void simulateIllegalArgumentException() {
        System.out.print("Enter an integer less than 10: ");
        try {
            int value = scanner.nextInt();
            if (value >= 10) throw new IllegalArgumentException("Value must be less than 10."); 
            System.out.println("You entered a valid value: " + value);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage()); // Handle IllegalArgumentException
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught: Please enter a valid integer."); // Handle invalid input type
            scanner.next(); // Clear invalid input
        }
    }

    // 11. NumberFormatException: Invalid string to number conversion simulation using user input.
    public static void simulateNumberFormatException() {
        while (true) { 
            System.out.print("Enter a string to convert to an integer (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) { 
                break; // Exit the loop if the user types 'exit'
            }

            try { 
                int number = Integer.parseInt(input); 
                System.out.println("You entered a valid integer: " + number);
            } catch (NumberFormatException e) { 
                System.out.println("NumberFormatException caught: Invalid input string '" + input + "'. Please enter a valid integer.");
            }
        }
    }

    public static void main(String[] args) { 
         simulateIOException();
         simulateFileNotFoundException();
         simulateEOFException();
         simulateSQLException();
         simulateClassNotFoundException();
         simulateArithmeticException();
         simulateNullPointerException();
         simulateArrayIndexOutOfBoundsException();
         simulateClassCastException();
         simulateIllegalArgumentException();
         simulateNumberFormatException();

         scanner.close();  // Close the scanner at the end of the program.
      }
    
}

