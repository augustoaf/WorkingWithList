import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.myapp.model.*;

public class ArrayListApp {

	public static void main(String[] args) {

		List<Vehicle> cars = new ArrayList<Vehicle>();
		
		cars.add(ArrayListApp.createCar(1, "Fusca"));
		cars.add(ArrayListApp.createCar(2, "Ferrari"));
		cars.add(ArrayListApp.createCar(3, "Brasília"));
		Vehicle porche = ArrayListApp.createCar(4, "Porche");
		cars.add(porche);
		cars.add(ArrayListApp.createCar(6, "Lamborguini"));
		cars.add(ArrayListApp.createCar(0, "Lamborguini"));
		cars.add(ArrayListApp.createCar(5, "Lamborguini"));

		List<Vehicle> carsSortedByNameAsc = ArrayListApp.sortVehiclesByName(cars, false);
		List<Vehicle> carsSortedByNameDesc = ArrayListApp.sortVehiclesByName(cars, true);
		
		carsSortedByNameDesc.get(carsSortedByNameDesc.indexOf(porche)).setName("Porche 911");
		
		ArrayListApp.printAllVehicles("cars - no sorted", cars);
		ArrayListApp.printAllVehicles("cars - ascending order", carsSortedByNameAsc);
		ArrayListApp.printAllVehicles("cars - descending order", carsSortedByNameDesc);
				
		Vehicle newBrasiliaInstance = ArrayListApp.createCar(999, "Brasília");
		//Vehicle.equals was Override in order to compare just the Vehicle.name, otherwise the following instruction would not find anything
		ArrayListApp.verifyCarExistence(newBrasiliaInstance, carsSortedByNameDesc);
	}

	private static void verifyCarExistence(Vehicle carToFind, List<Vehicle> carList) {
		
		System.out.println("");
				
		int index = carList.indexOf(carToFind);
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
	
	private static void printAllVehicles(String listName, List<Vehicle> cars) {
		
		if (cars != null && !cars.isEmpty()) {
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
	
	private static List<Vehicle> sortVehiclesByName(List<Vehicle> cars, boolean descendingOrder) {
		
		List<Vehicle> sortedCars = new ArrayList<Vehicle>(cars);
					
		// using Collections.sort([list]) - will use Comparable interface implemented into the objects inside the ArrayList to sort
		// using Collections.sort([list], [Comparator]) - will use Comparator interface to sort
		if (descendingOrder == true)
			Collections.sort(sortedCars, new VehicleDescendingComparator());
		else
			Collections.sort(sortedCars, new Vehicle());
			
		return sortedCars;
	}
}
