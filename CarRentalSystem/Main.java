
public class Main{
    public static void main(String[] args){
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Car car1 = new Car("C001", "Maruti", "Desire", 50.0);
        Car car2 = new Car("C002", "Maruti", "Ertiga", 60.0);
        Car car3 = new Car("C003", "Maruti", "WagonR", 45.0);
        Car car4 = new Car("C004", "Kia", "Carens", 65.0);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.menu();

    }
}