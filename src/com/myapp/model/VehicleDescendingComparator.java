package com.myapp.model;

import java.util.Comparator;

public class VehicleDescendingComparator implements Comparator<Vehicle> {

	@Override //Comparator interface
	public int compare(Vehicle o1, Vehicle o2) {
		
		if (o1 == null && o2 == null) {
            return 0;
        }
		else if (o1 == null) {
            return 1;
        }
		else if (o2 == null) {
            return -1;
        }
		else {
			int result = o1.getName().compareTo(o2.getName());//level 1 comparison
			
			if (result == 0) { //0 means equal value
				result = o1.getId().compareTo(o2.getId());//level 2 comparison
			}
			
			//multiplying by -1 gives you a descending order
			return result*-1;
		}	
	}

}
