
public class DeluxeSpa extends Room{
	private String suitable;
	private double surcharge;
	
	DeluxeSpa(String desc,int id, double price, String location) {
		 super(desc, id, price, location);
		 this.suitable="Traveler | relax";
		 this.surcharge=50; 
	}
 
	public String getSuitable() {
		return this.suitable;
	}

	public double getSurcharge() {
		return surcharge;
	}

	public double getPrice() {
		 return super.getPrice()+this.getSurcharge();
	}
	
	public String basicInfo() {
		 return super.basicInfo() + " | Suitable for: " +this.getSuitable();
	}
}
