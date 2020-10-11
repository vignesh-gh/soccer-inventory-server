package com.soccer_inventory.soccer_inventory.model;

import java.util.Date;

public class Variant {
	
	public int id;
	
	public int product_id;
	
	public String color;
	
	public String size;
	
	public String price;
	
	public String name;
	
	public String images;
	
	public String created_Date;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}


	

	public String Last_Modified_Date;


	public String getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}

	public String getLast_Modified_Date() {
		return Last_Modified_Date;
	}

	public void setLast_Modified_Date(String last_Modified_Date) {
		Last_Modified_Date = last_Modified_Date;
	}

	@Override
	public String toString() {
		return "Variant [id=" + id + ", product_id=" + product_id + ", color=" + color + ", size=" + size + ", price="
				+ price + ", name=" + name + ", images=" + images + ", created_Date=" + created_Date
				+ ", Last_Modified_Date=" + Last_Modified_Date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Last_Modified_Date == null) ? 0 : Last_Modified_Date.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((created_Date == null) ? 0 : created_Date.hashCode());
		result = prime * result + id;
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + product_id;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Variant other = (Variant) obj;
		if (Last_Modified_Date == null) {
			if (other.Last_Modified_Date != null)
				return false;
		} else if (!Last_Modified_Date.equals(other.Last_Modified_Date))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (created_Date == null) {
			if (other.created_Date != null)
				return false;
		} else if (!created_Date.equals(other.created_Date))
			return false;
		if (id != other.id)
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product_id != other.product_id)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}





	
	

}
