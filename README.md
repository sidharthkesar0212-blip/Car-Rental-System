# Car Rental System (Java OOP)

A console-based Java application designed to manage vehicle rental operations. The system applies **Object-Oriented Programming (OOP)** principles to handle car inventories, customer profiles, and rental transactional states, ensuring data encapsulation and modular logic tracking.

## 🚀 Features
*   **Inventory Management**: Track vehicle information including unique IDs, model variants, brands, base daily prices, and real-time availability states.
*   **Customer Profiles**: Capture and manage individual client identifying records and profile parameters.
*   **Transaction Processing**: Automatically cross-reference customer profiles with selected vehicles to generate valid rental records.
*   **Dynamically Calculated Rental Fees**: Automatically tracks duration parameters to process multi-day base rate pricing totals during checkouts.

## 📂 Project Structure
The repository contains the following interconnected Java model classes:
*   `Main.java` — Controls the operational UI environment, manages primary option loops, and drives programmatic interactions.
*   `Car.java` — Encapsulates parameters for individual vehicles including pricing schemas and structural availability flags.
*   `Customer.java` — Holds identity metrics and descriptive properties for active consumers.
*   `Rental.java` — Binds an instantiated car reference with a customer profile and calculated transaction dates.
*   `CarRentalSystem.java` — The operational control container managing master lists of inventory, customers, active rentals, and functional reservation handlers.

## 🛠️ Requirements & Installation
*   Java Development Kit (JDK 8 or higher)
*   Any terminal environment or modern Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com
   ```

2. **Navigate into the project directory:**
   ```bash
   cd Car-Rental-System
   ```

3. **Compile the source files:**
   ```bash
   javac *.java
   ```

4. **Execute the application:**
   ```bash
   java Main
   ```

## 📝 Example Flow
```text
== Car Rental System ==
1. Rent a Car
2. Return a Car
3. Exit
Enter your choice: 1

Available Cars:
- CAR001: Tesla Model 3 (\$75.00/day)
- CAR002: Toyota Camry (\$45.00/day)

Enter Car ID to rent: CAR002
Enter rental duration (days): 3
Total calculated price: \$135.00
Confirm rental? (Y/N): Y
Rental confirmed successfully!
```

## ⚖️ License
This project is open-source and available under the [MIT License](LICENSE).
