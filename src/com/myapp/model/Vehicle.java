package com.myapp.model;

import java.util.Comparator;

public class Vehicle implements Comparator<Vehicle>, Comparable<Vehicle> {

		private Integer id;
		private String name;
		private Manufacturer manufacturer;
					
		public Vehicle() {
			
		}
		
		public Vehicle(Integer id, String name) {
			this.setId(id);
			this.setName(name);
		}
						
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Manufacturer getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(Manufacturer manufacturer) {
			this.manufacturer = manufacturer;
		}
		
		public String toString() {
			return "Vehicle id: " + this.getId() + ", name: " + this.getName() + ", " + (manufacturer != null ? manufacturer : "no manufacturer");
		}
				
		@Override //Comparable interface
		public int compareTo (Vehicle vehicleToCompare) {
					
			return this.getName().compareTo(vehicleToCompare.getName());
		}

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
				
				return result;
			}	
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vehicle other = (Vehicle) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

}
