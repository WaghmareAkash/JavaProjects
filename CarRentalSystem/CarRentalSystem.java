
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
  
    
    public void rentCar(Car car,Customer customer, int days){
        if (car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }
        else{
            System.out.println("Car is not availabele currently please select another car!");
        }
    }
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals){
            if(rental.getCar()== car){
                rentalToRemove = rental;
                break;

            }
        }
        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
        }
        else{
            System.out.println("Car was not rented");
        }

    }
    public void menu(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(" #== Car Rental Services ==#");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter you Choice");

            int choice= scanner.nextInt();
            scanner.nextLine();

            if(choice==1){
                System.out.println("\n ==Rent a car ==");
                System.out.println("Enter your name");
                String customerName = scanner.nextLine();
                System.out.println("Enter your Contact Number");
                String conNum = scanner.nextLine();
                System.out.println("Enter your address");
                String cusAddress = scanner.nextLine();

                System.out.println("\n Available cars");
                for (Car car: cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId() + "-" + car.getBrand()+" "+ car.getModel());
                    }
                }

                System.out.println("\n Enter the car Id you want to rent");
                String carId= scanner.nextLine();

                System.out.println("Enter the number of days do you wish to have car rented");
                int rentalDays= scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer= new Customer("cus"+(customers.size()+ 1), customerName, conNum,cusAddress);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car: cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar= car;
                        break;
                    }
                }

                if (selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n == Rental Information ==");
                    System.out.println("customer Id: "+ newCustomer.getCusId());
                    System.out.println("Custmoer Name "+ newCustomer.getName());
                    System.out.println("Car "+ selectedCar.getBrand() + " "+ selectedCar.getModel());
                    System.out.println("Rental Days "+ rentalDays);
                    System.out.printf("Total Price $%.2f%n",totalPrice);

                    System.out.println("\n Confirm your rental Y/N");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\n Car rented successfully\n");
                    } else{
                        System.out.println("\n Rental cancelled");
                    }

                } else{
                    System.out.println("\n invalid car selection or car not available for rent. ");
                }


            }else if (choice == 2){
                System.out.println("\n == Return a Car ==\n");
                System.out.println("Enter the car Id to be returned");
                String carId= scanner.nextLine();

                Car carToReturn = null;
                for (Car car: cars){
                    if (car.getCarId().equals(carId) && !car.isAvailable()){
                        carToReturn= car;
                        break;
                    }
                
                }
                if (carToReturn != null){
                    Customer customer = null;
                    for (Rental rental: rentals){
                        if (rental.getCar()==carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer != null){
                        returnCar(carToReturn);
                        System.out.println("Car returned Successfully by "+ customer.getName());

                    }
                    else{
                        System.out.println("Car was not rented or rental information is missing");
                    }
                }else{
                    System.out.println("Invalid CarId or car not rented");
                }


            }else if (choice==3){
                break;
            }
            else{
                System.out.println("Invalid choice. Please enter a valid option.");            
            }
        }
        System.out.println("\nThank you for using the Car Rental System!");

        scanner.close();

    }
    
}
