import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.myapp.model.Manufacturer;
import com.myapp.model.Vehicle;
import com.myapp.model.VehicleDescendingComparator;

public class HashMapApp extends AbstractApp {

	private static Map<Manufacturer, Collection<Vehicle>> carsByManufacturer = new HashMap<Manufacturer, Collection<Vehicle>>(); 
	
	public static void main(String[] args) {
		
		Manufacturer fiat = HashMapApp.createManufacturer(1, "Fiat");
		Manufacturer volks = HashMapApp.createManufacturer(1, "Volkswagen");		
		
		Vehicle palio = HashMapApp.createCar(1, "Palio");
		Vehicle palio2 = HashMapApp.createCar(999, "Palio");
		Vehicle uno =  HashMapApp.createCar(2, "Uno");
		Vehicle ferrari = HashMapApp.createCar(3, "Ferrari");		
		Vehicle fusca = HashMapApp.createCar(4, "Fusca");
		Vehicle saveiro = HashMapApp.createCar(5, "Saveiro");
		Vehicle gol = HashMapApp.createCar(6, "Gol");
				
		HashMapApp.addCarOn(fiat, palio2);
		HashMapApp.addCarOn(fiat, palio);
		HashMapApp.addCarOn(fiat, uno);
		HashMapApp.addCarOn(fiat, ferrari);
		HashMapApp.addCarOn(volks, fusca);
		HashMapApp.addCarOn(volks, saveiro);
		HashMapApp.addCarOn(volks, gol);
		
		Map<Manufacturer, Collection<Vehicle>> carsByManufacturerAllSorted = HashMapApp.sortAllMap(carsByManufacturer); 	
		
		HashMapApp.printAllManufacturers("map - no sorted", carsByManufacturer);
		HashMapApp.printAllManufacturers("map - manufacturers and vehicles sorted", carsByManufacturerAllSorted);
	}
	
	private static Map<Manufacturer, Collection<Vehicle>> sortAllMap(Map<Manufacturer, Collection<Vehicle>> mapInput) {
		
		Map<Manufacturer, Collection<Vehicle>> mapOutput = new TreeMap<Manufacturer, Collection<Vehicle>>();
		mapOutput.putAll(mapInput);
		
		//code below affects the map value which is the list and its contents, so it will affect all the maps. instead create a new instance of the value (vehicle list) 
		//Collection carsLists = mapOutput.values();		
		//for (Object object : carsLists) {
		//	List vehicles = (List)object;
		//	Collections.sort(vehicles);
		//}
		
		Set<Manufacturer> manufacturers = mapOutput.keySet();
		for (Manufacturer manufacturer: manufacturers) {
					
			List sourceVehiclesList = (List) mapOutput.get(manufacturer);
			Set sortedVehiclesList = new TreeSet();//new TreeSet(new VehicleDescendingComparator());
			sortedVehiclesList.addAll(sourceVehiclesList);
			mapOutput.put(manufacturer, sortedVehiclesList);
		}
				
		return mapOutput;
	}

	private static void addCarOn(Manufacturer manufacturer, Vehicle vehicle) {
		
		Collection vehicles = carsByManufacturer.get(manufacturer);
		
		if (vehicles == null) {
			vehicles = new ArrayList<Vehicle>();
			carsByManufacturer.put(manufacturer, vehicles);
		}
		
		vehicles.add(vehicle);		
	}
	
	private static void printAllManufacturers(String reportName, Map carsByManufacturer) {
		
		System.out.println("####### REPORT NAME: " + reportName + " #######");
		
		Collection manufacturers = carsByManufacturer.keySet();
				
		for (Object manufacturer: manufacturers) {
			System.out.println(manufacturer);
			Collection vehicles = (Collection) carsByManufacturer.get(manufacturer);
			for (Object vehicle : vehicles) {
				System.out.println(vehicle);				
			}
			System.out.println("");
		}
	}

}
