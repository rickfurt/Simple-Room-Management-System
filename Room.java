import java.util.ArrayList;

class Room {
	private String description;
	private int roomId;
	private double price;
	private String location;
	private double customerDiscount;
	private ArrayList<Amenity> amenities = new ArrayList<>();
	
	Room() {
		this.roomId = 0;
		this.price = 0;
		this.location ="Unknown";
		this.customerDiscount = 0;
	}
	
	public Room(String description, int id, double price, String location) {
		this.description = description;
		this.roomId = id;
		this.price = price;
		this.location =location;
	}
	
	public int getRoomId() {
		return roomId;
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
	
	public void setAmenity(Amenity x) {
		 amenities.add(x);
	}
	
	public String getAmenities() {	
		String output = "";
		
		for(Object i:amenities){  
			output = output +"\n  -"+((Amenity) i).toString();
		} 
		return output; 
	}
	
	public double getTotalAmenities() {	
		double total = 0;
		for(Object i:amenities){  
			total += ((Amenity) i).getPrice();
		} 
		return total;
	}
	
	public double getSubTotal() {
		return  this.getTotalAmenities()+this.getPrice();	 
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getDescription() {
		return description;
	}

	public String toString() {
		return  " Id: "+ this.getRoomId() + 
				" | Type: "+ this.getDescription() +
				" | Price: "+ this.getPrice()+ 
				"\n\n Amenities: "+ this.getAmenities()+
				"\n\n Total Amenities : $ "+ String.format("%.2f", this.getTotalAmenities())+
				"\n Room + Amenities : $ "+ String.format("%.2f", this.getSubTotal());
	}
	
	public String basicInfo() {
		return " Id: "+ this.getRoomId() + 
				" | Type: "+ this.getDescription() +
				" | Price: "+ this.getPrice() + 
				" | Location: "+ this.getLocation();
	}
 
}
 