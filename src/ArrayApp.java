import java.util.Arrays;
import java.util.List;

import com.myapp.model.Vehicle;
import com.myapp.model.VehicleDescendingComparator;

public class ArrayApp {

	public static void main(String[] args) {
		
		Vehicle[] cars = new Vehicle[10];
		
		cars[0] = ArrayApp.createCar(1, "Lamborguini");
		cars[1] = ArrayApp.createCar(2, "Porche");
		cars[2] = ArrayApp.createCar(3, "Brasília");
		cars[3] = ArrayApp.createCar(5, "Fusca");
		cars[4] = ArrayApp.createCar(4, "Fusca");
		cars[8] = ArrayApp.createCar(10, "Ferrari");
		cars[9] = ArrayApp.createCar(9, "Ferrari");
		
		Vehicle[] carsSortedByNameAsc = ArrayApp.sortVehiclesByName(cars, false);
		Vehicle[] carsSortedByNameDesc = ArrayApp.sortVehiclesByName(cars, true);
		ArrayApp.printAllVehicles("cars - no sorted", cars);
		ArrayApp.printAllVehicles("cars - ascending order", carsSortedByNameAsc);
		ArrayApp.printAllVehicles("cars - descending order", carsSortedByNameDesc);
		
		
		ArrayApp.verifyCarExistence(ArrayApp.createCar(999, "Brasília"), carsSortedByNameDesc);
	}
	
	private static void verifyCarExistence(Vehicle carToFind, Vehicle[] carList) {
		
		int index = -1;
		for (int item = 0; item < carList.length; item++) {
			Vehicle vehicle = carList[item];
			if (vehicle != null && carToFind.equals(vehicle)) {
				index = item;
				break;
			}			
		}
		
		if (index >= 0) {
			System.out.println("car " + carToFind.getName() + " is on index " + index);
		}
		else {
			System.out.println("car " + carToFind.getName() + " does not exists in the list");
		}
		
	}
	
	private static Vehicle createCar(int id, String name) {
		
		Vehicle vehicle = new Vehicle(id, name);
		return vehicle;
	}
	
	private static void printAllVehicles(String listName, Vehicle[] cars) {
		
		if (cars != null) {
			System.out.println("Vehicle list: " + listName);
			
			for (Vehicle vehicle : cars) {
				if (vehicle != null) 
					System.out.println(vehicle);
			}
			System.out.println("");
		}
		else {
			System.out.println("No vehicle to list: " + listName);
		}
	}
	
	private static Vehicle[] sortVehiclesByName(Vehicle[] cars, boolean descendingOrder) {
		
		Vehicle[] sortedCars = cars.clone();
					
		// using Array.sort([array]) - will use Comparable interface to sort and WILL NOT WORK if the array has any null value
		// using Array.sort([array], [Comparator]) - will use Comparator interface to sort and WILL WORK if the array has any null value 
		if (descendingOrder == true)
			Arrays.sort(sortedCars, new VehicleDescendingComparator());
		else
			Arrays.sort(sortedCars, new Vehicle());
		
		return sortedCars;
	}

}
