package com.hack.app;

import java.util.Comparator;

public class Offer implements Comparable{
	
	private String name;
	private String productName;
	private float discount;
	private float finalPrice;
	private String source;
	private String description;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return productName;
	}
	public void setProduct(String product) {
		this.productName = product;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(discount);
		result = prime * result;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		Offer other = (Offer) obj;
		if (Float.floatToIntBits(discount) != Float
				.floatToIntBits(other.discount))
			return false;
	
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Offer [name=" + name + ", product=" + productName + ", discount="
				+ discount + ", finalPrice=" + finalPrice + ", source="
				+ source + ", description=" + description + "]";
	}
	
	@Override
	public int compareTo(Object o) {
		if(o.getClass() == getClass()){
			Offer of = (Offer)o;
			if(of.getFinalPrice() >= this.getFinalPrice()){
				return 1;
			} else {
				return -1;
			}
		}
		return -1;
	}
}
