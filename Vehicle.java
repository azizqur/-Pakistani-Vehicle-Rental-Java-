public class Main {
    public static void main(String[] args) {
        RentalService service = new RentalService();

        Vehicle car = new Car("Toyota", "Corolla", 2020, 5);
        Vehicle bike = new Bike("Honda", "CG 125", 2019, true);
        Vehicle truck = new Truck("Suzuki", "Bolan", 2021, 1.5);

        service.rentVehicle(car, 3);
        service.rentVehicle(bike, 2);
        service.rentVehicle(truck, 5);

        // Try renting already rented vehicle
        service.rentVehicle(car, 1);
    }
}

// ------------------- Vehicle Base Class -------------------
class Vehicle {
    private String make;
    private String model;
    private int year;
    private boolean isRented;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.isRented = false;
    }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public boolean isRented() { return isRented; }
    public void setRented(boolean rented) { isRented = rented; }

    public double calculateRentalCost(int days) {
        return days * 1000.0;
    }

    @Override
    public String toString() {
        return make + " " + model + " (" + year + ") - Rented: " + isRented;
    }
}

// ------------------- Car Class -------------------
class Car extends Vehicle {
    private int seats;

    public Car(String make, String model, int year, int seats) {
        super(make, model, year);
        this.seats = seats;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 2500.0;
    }
}

// ------------------- Bike Class -------------------
class Bike extends Vehicle {
    private boolean hasGear;

    public Bike(String make, String model, int year, boolean hasGear) {
        super(make, model, year);
        this.hasGear = hasGear;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 600.0;
    }
}

// ------------------- Truck Class -------------------
class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String make, String model, int year, double loadCapacity) {
        super(make, model, year);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 5500.0;
    }
}

// ------------------- RentalService Class -------------------
class RentalService {
    public void rentVehicle(Vehicle vehicle, int days) {
        if (!vehicle.isRented()) {
            vehicle.setRented(true);
            double cost = vehicle.calculateRentalCost(days);
            System.out.println("Rented: " + vehicle.toString());
            System.out.println("Rental cost for " + days + " days: " + cost + " PKR\n");
        } else {
            System.out.println("Vehicle is already rented: " + vehicle.toString());
        }
    }
}
