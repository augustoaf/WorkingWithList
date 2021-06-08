import java.util.Collection;
import java.util.Iterator;

import com.myapp.model.Manufacturer;
import com.myapp.model.Vehicle;

public abstract class AbstractApp {

	protected static Vehicle createCar(int id, String name) {
		
		Vehicle vehicle = new Vehicle(id, name);
		return vehicle;
	}
	
	protected static Manufacturer createManufacturer(int id, String name) {
		
		Manufacturer manufacturer = new Manufacturer(id, name);
		return manufacturer;
	}
	
	protected static void printAllVehicles(String listName, Collection<Vehicle> cars) {
		
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
	
	protected static void verifyCarExistence(Vehicle carToFind, Collection<Vehicle> carList) {
		
		System.out.println("");
		int index = -1;
		
/*			
		Iterator<Vehicle> iterator = carList.iterator();
		while (iterator.hasNext()) {
			index++;
			Vehicle vehicle = iterator.next();
			if (vehicle.equals(carToFind)) {
				break;
			}
		}
*/
		
		for (Vehicle vehicle : carList) {
			index++;
			if (vehicle.equals(carToFind)) {
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
}
