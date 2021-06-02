class Deluxe extends Room {
 private String suitable;
 private double discountRate;
 
 Deluxe(String desc, int id, double price, String location) {
	 super(desc, id, price, location);
	 this.suitable="couples";
	 this.discountRate=0.10;
 }
 
 public String getSuitable() {
	return suitable;
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
