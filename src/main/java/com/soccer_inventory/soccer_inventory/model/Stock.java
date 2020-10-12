package com.soccer_inventory.soccer_inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Stock {
	
	private int id;
	
	private int variant_id;
	
	private String units;
	
	private String created_Date;
	
	private String last_modified_Date;
	
	public int getVariant_id() {
		return variant_id;
	}

	public void setVariant_id(int variant_id) {
		this.variant_id = variant_id;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}

	public String getLast_modified_Date() {
		return last_modified_Date;
	}

	public void setLast_modified_Date(String last_modified_Date) {
		this.last_modified_Date = last_modified_Date;
	}
	@JsonProperty("_id")
	public int getId() {
		return id;
	}
	@JsonProperty("_id")
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_Date == null) ? 0 : created_Date.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_modified_Date == null) ? 0 : last_modified_Date.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
		result = prime * result + variant_id;
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
		Stock other = (Stock) obj;
		if (created_Date == null) {
			if (other.created_Date != null)
				return false;
		} else if (!created_Date.equals(other.created_Date))
			return false;
		if (id != other.id)
			return false;
		if (last_modified_Date == null) {
			if (other.last_modified_Date != null)
				return false;
		} else if (!last_modified_Date.equals(other.last_modified_Date))
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		if (variant_id != other.variant_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", variant_id=" + variant_id + ", units=" + units + ", created_Date=" + created_Date
				+ ", last_modified_Date=" + last_modified_Date + "]";
	}

	
	
	
	
}
