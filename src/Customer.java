public class Customer {

    private String customerId;
    private String name;
    private String adhaarNumber;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId(){
        return this.customerId;
    }

    public String getName(){
        return this.name;
    }


}
