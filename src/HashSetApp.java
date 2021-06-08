import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.myapp.model.Vehicle;
import com.myapp.model.VehicleDescendingComparator;

public class HashSetApp extends AbstractApp {

	public static void main(String[] args) {
		
		//to not allow duplicates, Vehicle.hashCode() must be implemented.
		Set<Vehicle> cars = new HashSet<Vehicle>();
		
		cars.add(HashSetApp.createCar(1, "Fusca"));
		cars.add(HashSetApp.createCar(2, "Ferrari"));
		cars.add(HashSetApp.createCar(3, "Brasília"));
		Vehicle porche = HashSetApp.createCar(4, "Porche");
		cars.add(porche);
		cars.add(HashSetApp.createCar(6, "Lamborguini"));
		cars.add(HashSetApp.createCar(0, "Lamborguini"));
		cars.add(HashSetApp.createCar(5, "Lamborguini"));

		Collection<Vehicle> carsSortedByNameAsc = HashSetApp.sortVehiclesByName(cars, false);
		Collection<Vehicle> carsSortedByNameDesc = HashSetApp.sortVehiclesByName(cars, true);
		
		((Vehicle)((List)carsSortedByNameDesc).get(((List)carsSortedByNameDesc).indexOf(porche))).setName("Porche 911");
		
		HashSetApp.printAllVehicles("cars - no sorted", cars);
		HashSetApp.printAllVehicles("cars - ascending order", carsSortedByNameAsc);
		HashSetApp.printAllVehicles("cars - descending order", carsSortedByNameDesc);
				
		Vehicle newBrasiliaInstance = HashSetApp.createCar(999, "Brasília");
		//Vehicle.equals was Override in order to compare just the Vehicle.name, otherwise this would return false
		HashSetApp.verifyCarExistence(newBrasiliaInstance, cars);

	}
	
	private static Collection<Vehicle> sortVehiclesByName(Set<Vehicle> cars, boolean descendingOrder) {
		
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
