
public class TwoBedroomFamilySuite extends Room{
	private String suitable;
	private double discountRate;
	
	TwoBedroomFamilySuite(String desc,int id, double price, String location) {
		 super(desc, id, price, location);
		 this.suitable="Big Family";
		 this.discountRate= 0.05; 
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


