import java.util.Set;
import java.util.TreeSet;

import com.myapp.model.Vehicle;
import com.myapp.model.VehicleDescendingComparator;

public class TreeSetApp extends AbstractApp {

	public static void main(String[] args) {
		
		//to not allow duplicates, Vehicle.hashCode() must be implemented, but when using a Comparator it will consider compare() implementation only
		//in this case the Comparator implemented consider the Vehicle Id + Name and the hashCode() consider only the Vehicle name
		Set<Vehicle> cars = new TreeSet<Vehicle>(new VehicleDescendingComparator());
		
		cars.add(TreeSetApp.createCar(1, "Fusca"));
		cars.add(TreeSetApp.createCar(2, "Ferrari"));
		cars.add(TreeSetApp.createCar(3, "Brasília"));
		Vehicle porche = TreeSetApp.createCar(4, "Porche");
		cars.add(porche);
		cars.add(TreeSetApp.createCar(6, "Lamborguini"));
		cars.add(TreeSetApp.createCar(0, "Lamborguini"));
		cars.add(TreeSetApp.createCar(5, "Lamborguini"));
		cars.add(TreeSetApp.createCar(6, "Lamborguini"));
		cars.add(TreeSetApp.createCar(0, "Lamborguini"));
		cars.add(TreeSetApp.createCar(5, "Lamborguini"));
		cars.add(TreeSetApp.createCar(6, "911 Porche"));
		
		//obj name updated does not sort the object in the collection, just new obj added
		//porche.setName("A Porche");		
				
		Vehicle lastCar = (Vehicle)(((TreeSet)cars).pollLast());
		System.out.println("last car removed: " + lastCar);
		System.out.println("");
		
		TreeSetApp.printAllVehicles("cars - sorted", cars);
				
		Vehicle newBrasiliaInstance = TreeSetApp.createCar(999, "Brasília");
		//Vehicle.equals was Override in order to compare just the Vehicle.name, otherwise this would return false
		TreeSetApp.verifyCarExistence(newBrasiliaInstance, cars);	
	}

}
