import java.util.ArrayList;

class Customer {
	String name;
	double discount;
	int status;
	ArrayList<Double> roomPrices = new ArrayList<>();
	ArrayList<Double> amenityPrices = new ArrayList<>();

	Customer() {
		this.name = "";
		this.discount =0;
		this.status =0;
	}
	
	Customer(String name, int status) {
		this.name = name;
		this.status =status;
	}

	
	public void addRoomPrice(double rmPrice) {
		roomPrices.add(rmPrice);
	}
	
	public void addAmenityPrice(double amPrice) {
		amenityPrices.add(amPrice);
	}
	
	public double getTotalAmenities() {
		double total = 0;
		for(int i=0;i<amenityPrices.size();i++) {
			total+=amenityPrices.get(i);
		}
		return total;
	}
	
	public double getTotalRooms() {
		double total = 0;
		for(int i=0;i<roomPrices.size();i++) {
			total+=roomPrices.get(i);
		}
		return total;
	}
	
	public double getTotal() {
		return this.getTotalAmenities()+this.getTotalRooms();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(int statusType) {		
		switch(statusType) {
			case 1: this.discount = 0.05;
			break;
			case 2: this.discount = 0.10;
			break;
			case 3: this.discount = 0.00;
			break;
		}
}

	public String getStatus() {
		String st = "";
		switch(status) {
			case 1: st = "Active Customer";
			break;
			case 2: st = "VIP";
			break;
			case 3: st = "New Customer";
			break;
		}
		return st;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	public String toString() {
		return "\nCustomer: "+ this.getName() + 
			   " | Status: "+ this.getStatus()+ 
			   " | Discount: "+ this.getDiscount()+
			   "\n Total Rooms: $"+ this.getTotalRooms()+
			   "\n Total Amenities: $"+ String.format("%.2f",this.getTotalAmenities())+
			   "\nTotal: $"+ String.format("%.2f",this.getTotal());
	 }
}



