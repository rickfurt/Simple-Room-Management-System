public class FamilySuite extends Room{
	private String suitable;
	private double discountRate;
	
	FamilySuite(String desc,int id, double price, String location) {
		 super(desc, id, price, location);
		 this.suitable="Small family";
		 this.discountRate= 0.15; 
	}
 
	public String getSuitable() {
		return this.suitable;
	}

	public double getDiscount() {
		return discountRate*super.getPrice();
	}

	public double getPrice() {
		 return super.getPrice()-this.getDiscount();
	}
	
	public String basicInfo() {
		 return super.basicInfo() + " | Suitable for: " +this.getSuitable();
	} 
	 
}
