#  Exception Handling Execution

This assignment program demonstrates effective exception handling in Java(OOP), showcasing the use of various exception types through simulated scenarios. Each scenario is encapsulated within a method, allowing for clear and modular error management.

## How it works
* _Simulations for different exception types:_Each method focuses on a specific exception, providing user prompts and handling errors using **try-catch** blocks.
 
 * _User-friendly feedback:_Clear messages are displayed when an exception occurs, guiding users through the simulated errors.

## Key Simulations
1. IOException: Simulates reading a non-existent file.
2. FileNotFoundException: Triggers when attempting to access a missing file.
3. EOFException: Occurs while reading beyond a file's content.
4. SQLException: Demonstrates handling database connection errors.
5. ClassNotFoundException: Shows errors during runtime class loading.
6. ArithmeticException: Handles division by zero.
7. NullPointerException: Demonstrates accessing methods on a null reference.
8. ArrayIndexOutOfBoundsException: Manages invalid array index access.
9. ClassCastException: Simulates invalid type casting.
10. IllegalArgumentException: Triggers on invalid method arguments.
11. NumberFormatException: Catches errors during string-to-integer conversions.
   
### 1.IOException: Simulates reading a non-existent file.
```java
public class simulateIOException {
private static void simulateIOException() {
  Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a filename to read (non_existent_file.txt): ");
        String filename = scanner.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }
}
```

### 2.FileNotFoundException: Executes a specific exception when a file is missing.
```java
public class simulateFileNotFoundException {
   private static void simulateFileNotFoundException() {
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a filename to open (non_existent_file.txt): ");
        String filename = scanner.nextLine();
        try {
            FileInputStream fis = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

}
```

### 3.EOFException: Handles attempts to read beyond the content of a file.
```java
public class simulateEOFException {
  private static void simulateEOFException() {
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a filename to read integers (empty_file.txt): ");
        String filename = scanner.nextLine();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (true) {
                dis.readInt();
            }
        } catch (EOFException e) {
            System.out.println("EOFException caught: End of file reached");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

}
```

### 4.SQLException: Simulates a database connection error.
```java
public class simulateSQLException {
  private static void simulateSQLException() {
        // Database connection simulation
        System.out.println("Simulating SQLException (no actual DB connection).");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/non_existent_db", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

}
```

### 5.ClassNotFoundException: Simulates a failure to load a class at runtime.
```java
public class simulateClassNotFoundException {
  private static void simulateClassNotFoundException() {
    try {
        Class.forName("com.nonexistent.ClassName");
    } catch (ClassNotFoundException e) {
        System.out.println("ClassNotFoundException caught: " + e.getMessage());
    }
}

}
```

### 6.ArithmeticException: Handles division by zero scenarios.
```java
public class simulateArithmeticException {
   private static void simulateArithmeticException() {
    Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number to divide 10 by: ");
            int divisor = scanner.nextInt();
            int result = 10 / divisor;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught: Please enter a valid integer.");
            scanner.next(); // Clear the invalid input
        }
    }

}
```

### 7.NullPointerException: Simulates accessing a method on a null reference.
```java
public class simulateNullPointerException {
  private static void simulateNullPointerException() {
    try {
        String str = null;
        System.out.println(str.length());
    } catch (NullPointerException e) {
        System.out.println("NullPointerException caught: " + e.getMessage());
    }
}

}
```

### 8.ArrayIndexOutOfBoundsException: Manages invalid array index access.
```java
public class simulateArrayIndexOutOfBoundsException {
  private static void simulateArrayIndexOutOfBoundsException() {
    Scanner scanner = new Scanner(System.in);

        try {
            int[] arr = new int[5];
            System.out.print("Enter an index to access (0-4): ");
            int index = scanner.nextInt();
            System.out.println(arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException caught: Please enter a valid integer.");
            scanner.next(); // Clear the invalid input
        }
    }

}
```

### 9.ClassCastException: Demonstrates type casting errors.
```java
public class simulateClassCastException {
  private static void simulateClassCastException() {
    try {
        Object obj = Integer.valueOf(10);
        String str = (String) obj;
    } catch (ClassCastException e) {
        System.out.println("ClassCastException caught: " + e.getMessage());
    }
}

}
```

### 10.IllegalArgumentException: Handles invalid arguments passed to a method.
```java
public class simulateIllegalArgumentException {
  private static void simulateIllegalArgumentException() {
    try {
        Thread.sleep(-1);
    } catch (IllegalArgumentException e) {
        System.out.println("IllegalArgumentException caught: " + e.getMessage());
    } catch (InterruptedException e) {
        System.out.println("InterruptedException caught: " + e.getMessage());
    }
}

}
```

### 11.NumberFormatException: Catches invalid string-to-integer conversions.
```java
public class simulateNumberFormatException {
  private static void simulateNumberFormatException() {
    Scanner scanner = new Scanner(System.in);

    try {
        System.out.print("Enter a string to convert to an integer: ");
        String input = scanner.next();
        int num = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        System.out.println("NumberFormatException caught: " + e.getMessage());
    }
}

}
```


## The Main CLass:
```java
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
```
# Conclusion
This program is an excellent example of how to implement and manage exception handling in Java. It emphasizes:

Proactive Error Handling: By anticipating potential exceptions, it prepares the program to respond gracefully.
User Guidance: Ensuring users understand the errors and how they occur.
Modular Design: Each exception is independently managed, making the code easier to maintain and extend.
This demonstration serves as a valuable learning tool for anyone studying Java or Object-Oriented Programming. It highlights best practices for building robust and error-tolerant applications.
