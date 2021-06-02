import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TimeZone;

public class HotelDriver {
	// create child Amenity classes
	static Amenity freeWifi = new Amenity(1, "Free wifi", "unlimited free wi fi", 0);
	static Amenity globoPlayTV = new Amenity(2, "Globo Play TV", "Globo Play TV streaming service", 9.99);
	static Amenity laundry = new Amenity(3, "laundry room", "laundry room containing washer and dryer", 4.99);
	static Amenity airConditioner = new Amenity(4, "AC and Heater", "Air Conditioner", 0);
	static Amenity coffee = new Amenity(5, "Coffee machine", "coffee machine with Pilao Brazilian coffee pods", 15);
	static Amenity breakfast = new Amenity(6, "Breakfast", "Breakfast with cheese bread", 29.99);
	static Amenity lunch = new Amenity(7, "Lunch", "Brazilian cousine lunch", 49.99);
	static Amenity dinner = new Amenity(8, "Dinner", "Dinner with an authentic brazilian wine", 69.99);
	static Amenity electricBlanket = new Amenity(9, "Electric Blanket", "Electric Blanket", 2.99);
	static Amenity popcornMaker = new Amenity(10, "Popcorn machine", "Popcorn machine", 1.99);
	
	// create child Room classes
	static Deluxe deluxe1 = new Deluxe("Deluxe room 1",1, 300, "middle room");
	static Deluxe deluxe2 = new Deluxe("Deluxe room 2",2, 300, "middle room");
	static Deluxe2Queen deluxe2Q1 = new Deluxe2Queen("Deluxe Queen 1",3,550,"top floor");
	static Deluxe2Queen deluxe2Q2 = new Deluxe2Queen("Deluxe Queen 2",4,550,"top floor");
	static DeluxeSpa deluxeSpa1 = new DeluxeSpa("Deluxe Spa 1",5, 750.00, "right corner");
	static DeluxeSpa deluxeSpa2 = new DeluxeSpa("Deluxe Spa 2",6, 750.00, "right corner");
	static FamilySuite familySuite1 = new FamilySuite("family Suite 1",7, 900.00, "left corner");
	static FamilySuite familySuite2 = new FamilySuite("family Suite 2",8, 900.00, "left corner");
	static TwoBedroomFamilySuite twoBedroomFamilySuite1 = new TwoBedroomFamilySuite("2 Bedroom family suite 1",9, 1200.00, "penthouse");
	static TwoBedroomFamilySuite twoBedroomFamilySuite2 = new TwoBedroomFamilySuite("2 Bedroom family suite 1",10, 1200.00, "penthouse");
	
	// Create an array to store the rooms booked by id;
	static ArrayList<Integer> roomBooked = new ArrayList<>();
	
	// Create customer c1 with the default constructor instances.
	static Customer c1 = new Customer();	
	
	
	public static void showRooms(String customerStatus, double customerDiscount) {
		// create an array to display rooms in a loop.
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		// create an array to display amenities in a loop.
		ArrayList<Amenity> amenities = new ArrayList<Amenity>();
		
		// Set customer discount on rooms.		
		deluxe1.setCustomerDiscount(customerDiscount);
		deluxe2.setCustomerDiscount(customerDiscount);
		deluxe2Q1.setCustomerDiscount(customerDiscount);
		deluxe2Q2.setCustomerDiscount(customerDiscount);
		deluxeSpa1.setCustomerDiscount(customerDiscount);
		deluxeSpa2.setCustomerDiscount(customerDiscount);
		familySuite1.setCustomerDiscount(customerDiscount);
		familySuite2.setCustomerDiscount(customerDiscount);
		twoBedroomFamilySuite1.setCustomerDiscount(customerDiscount);
		twoBedroomFamilySuite2.setCustomerDiscount(customerDiscount);
		
		// set customer discount on amenities
		freeWifi.setCustomerDiscount(customerDiscount);
		globoPlayTV.setCustomerDiscount(customerDiscount);
		laundry.setCustomerDiscount(customerDiscount);
		airConditioner.setCustomerDiscount(customerDiscount);
		coffee.setCustomerDiscount(customerDiscount);
		breakfast.setCustomerDiscount(customerDiscount);
		lunch.setCustomerDiscount(customerDiscount);
		dinner.setCustomerDiscount(customerDiscount);
		electricBlanket.setCustomerDiscount(customerDiscount);
		popcornMaker.setCustomerDiscount(customerDiscount);

		// add amenities to an array to iterate and display
		amenities.add(freeWifi);
		amenities.add(globoPlayTV);
		amenities.add(laundry);
		amenities.add(airConditioner);
		amenities.add(coffee);
		amenities.add(breakfast);
		amenities.add(lunch);
		amenities.add(dinner);
		amenities.add(electricBlanket);
		amenities.add(popcornMaker);
		
		// add rooms to an array to iterate and display
		rooms.add(deluxe1);
		rooms.add(deluxe2);
		rooms.add(deluxe2Q1);
		rooms.add(deluxe2Q2);
		rooms.add(deluxeSpa1);
		rooms.add(deluxeSpa2);
		rooms.add(familySuite1);
		rooms.add(familySuite2);
		rooms.add(twoBedroomFamilySuite1);
		rooms.add(twoBedroomFamilySuite2);
		
		// passing room array and amenity array to roomSelect method.
		roomSelection(rooms, amenities);
	}
	
	public static void roomSelection(ArrayList<Room> roomList, ArrayList<Amenity> amenityList ) {
		int roomId = 0;
		boolean roomValid = false;
		
		while(!roomValid) {
			System.out.println("Please select one of the options below.\n");
			for(Object i:roomList){  
				System.out.println(((Room) i).basicInfo());
			} 
			try {
				Scanner r = new Scanner(System.in);
				roomId = r.nextInt();
				if(roomId<1 || roomId >10) {
					roomValid=false;
				}else {
					roomBooked.add(roomId);
					c1.addRoomPrice(roomList.get(roomId-1).getPrice());
					roomValid=true;
					amenitiesSelection(amenityList, roomBooked, roomList, roomList.get(roomId-1));
				}
			}catch(InputMismatchException y){
				System.out.println("the room Id must be a number between 1 and 10.");
				roomValid=false;
			}
		}
	}
	
	public static void amenitiesSelection(ArrayList<Amenity> amenityList, ArrayList roomBooked,ArrayList rooms, Room room) {
		int amenityId = 0;
		boolean amenityValid = false;
		
		while(!amenityValid) {
			System.out.println("\nPlease select the amenities from the options below.\n");
			for(Object i:amenityList){  
				System.out.println(((Amenity) i).getAmenityId()+"-"+((Amenity) i).toString());
			} 
			try {
				Scanner r = new Scanner(System.in);
				amenityId = r.nextInt();
				if(amenityId<1 || amenityId >10) {
					amenityValid=false;
				}else {
					room.setAmenity(amenityList.get(amenityId-1));
					amenityValid=true;
					c1.addAmenityPrice(amenityList.get(amenityId-1).getPrice());	
					System.out.println("Do you want to add more amenities?.\n1 - Yes\n2 - No");
					Scanner x = new Scanner(System.in);
					int addAmenity = x.nextInt();
					if(addAmenity == 1) {
						amenityValid=false;
					}else {
						amenityValid = true;
						System.out.println("Do you want to add more rooms?.\n1 - Yes\n2 - No");
						Scanner y = new Scanner(System.in);
						int addRoom = y.nextInt();
						if(addRoom == 1) {
							showRooms(c1.getStatus(), c1.getDiscount());
						}else {
							showAll(roomBooked, rooms);
						}
					}
				}
			}catch(InputMismatchException y){
				System.out.println("the amenity Id must be a number between 1 and 10.");
				amenityValid=false;
			}	
		}
	}
	
	public static void showAll( ArrayList roomBooked,ArrayList rooms) {
		star("*");
		System.out.println("\nSummary\n");
		System.out.println("Room(s):");
		for(int i = 0;i<roomBooked.size();i++) {
			int index = (int) roomBooked.get(i)-1;
			star("-");
			System.out.println("\n"+rooms.get(index).toString());
		}
		star("-");
		System.out.println(c1.toString());
	}
	
	public static void userInfo() {
		String name;
		int status;
		
		System.out.println("Input your name.");
		Scanner n = new Scanner(System.in);
		name = n.next();
		
		System.out.println("What is your status ?\n1- Active customer \n2- VIP Customer\n3- New customer");
		Scanner s = new Scanner(System.in);
		status = s.nextInt();
		
		c1 = new Customer(name,status);
		c1.setDiscount(status);
				
		showRooms(c1.getStatus(), c1.getDiscount());
	}
	
	public static void printWelcome() {
		int option;
		boolean isOptionValid = false;
		
		star("*");
		System.out.println("\nWELCOME TO HOTEL MANAGEMENT SYSTEM \n");
		System.out.println(
				"Develop by Ricardo Furtado");
		System.out.println("OODP101 Object Oriented Desing and Programming - Assessment task 4");
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		df.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		final String dateTimeString = df.format(new Date());
		System.out.println(dateTimeString + "\n");
		star("*");
		
		while(!isOptionValid) {
			try {
				System.out.println("\nWould you like to place an order?\n1.Yes\n2.No");
				Scanner in = new Scanner(System.in);
				option = in.nextInt();
				if(option == 1) {
					userInfo();
					isOptionValid = true;
				}else if(option == 2){
					isOptionValid = true;
					System.out.println("Thanks for using Hotel Management System \n\n Goodbye...");
				}else {
					System.out.println("invalid option");
					isOptionValid = false;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Error Input, please select option 1 for yes and 2 for no");
				isOptionValid = false;
			}	
		}
		
	}
	
	public static void star(String a) {
		for (int x = 0; x < 100; x++) {
			System.out.print(a);
		}
	}
	
	public static void main() {
		printWelcome();
	}
}
