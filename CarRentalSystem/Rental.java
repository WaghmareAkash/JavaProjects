public class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer custmer, int days){
        this.car = car;
        this.customer = custmer;
        this.days = days;
    }
    public Car getCar(){
        return car;
    }
    public Customer getCustomer(){
        return customer;
    }
    public int getDays(){
        return days;
    }
    
}
