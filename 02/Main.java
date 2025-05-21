class Vehicle{
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    //constructor
    Vehicle(String licensePlate, String ownerName, int hoursParked){
        this.licensePlate=licensePlate;
        this.ownerName=ownerName;
        this.hoursParked=hoursParked;
    }

    //Getters
    String getLicensePlate(){
        return licensePlate;
    }
    String getOwnerName(){
        return ownerName;
    }
    int getHoursParked(){
        return hoursParked;
    }


    //setters
    void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }
}

class ParkingLot{
    private Vehicle[] vehicles;  //Vehicle[] -- can store full vehicle objects
    private int vehicleCount;

    ParkingLot(){
        vehicles=new Vehicle[5];
        vehicleCount=0;
    }

    //methods: park new vehicle
    void parkVehicle(Vehicle vehicle){
        if(vehicleCount<vehicles.length){
            vehicles[vehicleCount]=vehicle;
            vehicleCount++;
        }
        else{
            System.out.println("Parking lot is full. Cannot park more vehicles.");
        }
    }

    //methods: remove vehicle
    void removeVehicle(String licensePlate){
        for(int i=0;i<vehicleCount;i++){
            if(vehicles[i].getLicensePlate()==licensePlate){
                for(int j=i;j<vehicleCount;j++){
                    vehicles[j]=vehicles[j+1];
                }
                vehicles[vehicleCount - 1] = null;  // Remove last duplicate
                vehicleCount--;
                System.out.println("Vehicle with license plate " + licensePlate + " removed.");
                return;
            }
        }
        System.out.println("Vehicle with license plate " + licensePlate + " not found.");
    }

    //methods: display all parked vehicles
    void displayVehicles(){
        if(vehicleCount==0){
            System.out.println("No vehicles parked.");
        }
        else{
            System.out.println("License Plate\tOwner Name\tHours Parked");
            for(int i=0;i<vehicleCount;i++){
                System.out.println(vehicles[i].getLicensePlate()+"\t\t"+vehicles[i].getOwnerName()+"\t"+vehicles[i].getHoursParked());
            }
        }
    }
}

 class Main{
    public static void main(String[] args){
       

        //test parkingLot
        ParkingLot plot = new ParkingLot();

        //park vehicles

        plot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        plot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        plot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        //remove vehicles
        plot.removeVehicle("XYZ789");
        plot.removeVehicle("NOP000");

        //display parked vehicles
        plot.displayVehicles();
    }
}