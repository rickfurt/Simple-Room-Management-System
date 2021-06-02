
public class Amenity {
	int AmenityId;
	String AmenityName;
	String AmenityDescription;
	double price;
	private double customerDiscount;

	
	Amenity(int AmenityId,String AmenityName, String AmenityDescription, double price) {
		this.AmenityId = AmenityId;
		this.AmenityName =AmenityName;
		this.AmenityDescription =AmenityDescription;
		this.price = price;
	}

	public int getAmenityId() {
		return AmenityId;
	}

	public String getAmenityName() {
		return AmenityName;
	}

	public String getAmenityDescription() {
		return AmenityDescription;
	}

	// Format double to display only 2 decimals example 2.12 
	// instead of value like 2.12321 --> String.format("%.2f", this.getPrice()
	@Override
	public String toString() {
		return  this.getAmenityName() + "| Desc : " + this.getAmenityDescription() + "| Price: " + String.format("%.2f", this.getPrice());
	}
	
	public void setCustomerDiscount(double rate) {
		customerDiscount = rate * this.price;
	}
	
	public double getPrice() {
		return getCustomerDiscount();
	}
	
	public double getCustomerDiscount() {
		if(this.customerDiscount == 0) {
			return this.price;
		}else {
			return this.price - customerDiscount;	
		}
	}
	
	
}
