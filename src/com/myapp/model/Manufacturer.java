package com.myapp.model;

public class Manufacturer implements Comparable<Manufacturer> {

	private Integer id;
	private String name;
	
	public Manufacturer() {
		
	}
	
	public Manufacturer(Integer id, String name) {
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
	
	public String toString() {
		return "Manufacturer Id: " + id + ", name: " + name.toUpperCase();
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
		Manufacturer other = (Manufacturer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Manufacturer o) { //Comparable interface

		return this.getName().compareTo(o.getName());
	}
	
	
}
