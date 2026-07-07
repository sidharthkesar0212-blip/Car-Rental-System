import java.util.*;

public class CarRentalSystem {

    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
    public CarRentalSystem(){
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }else{
            System.out.println("This Car is not available for rent");
        }
    }

    public void returnCar(Car car){
        Rental remove = null;
        for(Rental r:rentals){
            if(r.getCar() == car){
                remove = r;
                break;
            }
        }
        if(remove!=null){
            rentals.remove(remove);
            car.returnCar();
            System.out.println("Car Returned Successfully");
        }else{
            System.out.println("This car was not rented");
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("==== Car Rental System ====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter your Choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                System.out.println(" == Rent a Car == ");
                System.out.println("Enter your name: ");
                String cName = sc.nextLine();

                System.out.println("Available Cars:");
                for(Car c:cars){
                    if(c.isAvailable()){
                        System.out.println(c.getcarId() + " . " + c.getBrand() + " . " + c.getModel());
                    }
                }

                System.out.println("Enter the car ID you want to rent:");
                String carid = sc.nextLine();
                System.out.println("Enter the number of days for rental:");
                int days = sc.nextInt();
                sc.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), cName);
                addCustomer(newCustomer);

                Car selected = null;
                for(Car c:cars){
                    if(c.getcarId().equals(carid) && c.isAvailable()){
                        selected = c;
                        break;
                    }
                }
                if(selected != null){
                    double totalPrice = selected.calculatePrice(days);
                    System.out.println(" === rental Information === ");
                    System.out.println("Customer ID: " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Car: " + selected.getBrand() + " " + selected.getModel());
                    System.out.println("Rental days: " + days);
                    System.out.printf("Total Price: Rs.%.2f\n", totalPrice);

                    System.out.println("\n Confirm rental (Y/N): ");
                    String confirm = sc.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selected, newCustomer, days);
                        System.out.println("\n Rented Successfully");
                    }else{
                        System.out.println("Rental Cancelled");
                    }
                }else{
                    System.out.println("Invalid Car Selection or car is not available for rent.");
                }
            }else if(choice == 2){
                System.out.println("\n=== Return a car ===\n");
                System.out.println("Enter the car ID you want to return:");
                String carid = sc.nextLine();

                Car toreturn = null;
                for(Car c:cars){
                    if(c.getcarId().equals(carid)){
                        toreturn = c;
                        break;
                    }
                }
                if(toreturn != null){
                    Customer selected = null;
                    for(Rental r:rentals){
                        if(r.getCar() == toreturn){
                            selected = r.getCustomer();
                            break;
                        }
                    }
                    if(selected != null){
                        returnCar(toreturn);
                        System.out.println("Car returned Successfully");
                    }else {
                        System.out.println("Car was not rented or information is missing");
                    }
                }else{
                    System.out.println("Invalid Car id or car is nor rented");
                }
            }else if(choice == 3){
                break;
            }else{
                System.out.println("Invalid Choice,  Please enter a vallid option:");
            }
        }
        System.out.println("ThankYou for using the system");
    }
}
