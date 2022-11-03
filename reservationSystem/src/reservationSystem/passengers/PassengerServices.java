package reservationSystem.passengers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PassengerServices {

	static int fare;
	static List<String> stops = List.of("vizag","vijayawada","chennai");
	
	static Scanner sc = new Scanner(System.in);

	private static LinkedList<Passenger> passengers = new LinkedList<>();
	static ArrayList<Integer> seatNumbers = new ArrayList<>();
	String pnrNum1;
	
	static {
		for (int j=1; j<=10; j++) {
			seatNumbers.add(j);
		}
	}
	
	public static Integer selectSeatNo() {
		
		System.out.println("Please select your seat ");
		int seatNo = sc.nextInt();
		for (Passenger passenger : passengers ) {
			if (passenger.getSeatNo() == seatNo) {
				System.out.println("Seat was already booked, please select another seat");
				selectSeatNo();
			}
		}
		return seatNo;
	}
	
	public static void printAvaliableSeats() {
		
		for (Passenger passenger : passengers ) {
			for (int i=0; i<seatNumbers.size();i++) {
				if (passenger.getSeatNo() == seatNumbers.get(i)) {
					seatNumbers.remove(i);
				}
			}
		}
		System.out.println("Avaliable seats are : " + seatNumbers); 
	}
	
	public static String setPnrNo() {
		String pnrNumber = "";
		while(true) {
		    int n = (int) (Math.random() * 10);
		    pnrNumber = pnrNumber + n;
		    if (pnrNumber.length() == 5) {
		        break;
		    }
		}
		return pnrNumber;
	}
	
	public String getPnrNo() {
		return PassengerServices.setPnrNo();
	}
	
	public static String name() {
		System.out.println("Please enter your complete name : ");
		String name = sc.next();
		return name;
	}
	
	public static String email() {
		System.out.println("Please enter your email : ");
		String email = sc.next();
		return email;
	}
	
	public static int age() {
		System.out.println("Please enter your age : ");
		int age = sc.nextInt();
		return age;
	}
	
	public static String boardingPoint() {
		System.out.println("Avaliable stops are : " + stops + "\nPlease enter your boarding point : ");
		String boardingPoint = sc.next();
		return boardingPoint;
	}
	
	public static String dropingPoint() {
		System.out.println("Please enter your droping point : ");
		String dropingPoint = sc.next();
		return dropingPoint;
	}
	
	public void ticketDetails() {
		System.out.println("Please enter your PNR number : ");
		String pnrNum1 = sc.next();
		for (Passenger passenger : passengers ) {
			if (passenger.getPnrNo().equals(pnrNum1)) {
				System.out.println("Your Ticket Details are : \n" + passenger);
			}
		}
	}

	public void bookTicket() {
		printAvaliableSeats();
		passengers.add(new Passenger(PassengerServices.selectSeatNo(),PassengerServices.setPnrNo(),PassengerServices.name(),
				PassengerServices.email(),PassengerServices.boardingPoint(),PassengerServices.dropingPoint(),PassengerServices.age()));
		
		for (Passenger passenger : passengers) {
			pnrNum1 = passenger.getPnrNo();
		}
		System.out.println("Congratulations you successfully booked your ticket. Please note your PNR, for further reference : " + 
		pnrNum1);
		System.out.print("You need to pay " +  PassengerServices.calculateFare());
	}
	
	public void printTicketList() {
		for (Passenger passenger : passengers) {
			System.out.println(passenger);
		}
	}
	
	public void cancleTicket() {
		System.out.println("Please enter your PNR number : ");
		String pnrNum1 = sc.next();
		for (Passenger passenger : passengers) {
			if (passenger.getPnrNo().equals(pnrNum1)) {
				seatNumbers.add(passenger.getSeatNo());
				passengers.remove();
				System.out.println("Your ticket was canclled. Thank you & Visit again!!");
			}
		}
	}
	
	public static int calculateFare() {
	
		for(Passenger passenger:passengers) {
			if((passenger.getBoardingPoint().equals("vizag")|| passenger.getBoardingPoint().equals("chennai")) 
					&& (passenger.getDropingPoint().equals("chennai") || passenger.getDropingPoint().equals("vizag"))) {
				if(passenger.getAge() <= 10 && passenger.getAge() > 0) {
					fare = 1000;
				}else if(passenger.getAge() > 70) {
					fare = 1200;
				}else {
					fare = 1500;
				}
			}
			else if ((passenger.getBoardingPoint().equals("vizag")||passenger.getBoardingPoint().equals("vijayawada")) 
					&& (passenger.getDropingPoint().equals("vijayawada")|| passenger.getDropingPoint().equals("vizag"))) {
				if(passenger.getAge() <= 10 && passenger.getAge() > 0) {
					fare = 600;
				}else if(passenger.getAge() > 70) {
					fare = 700;
				}else {
					fare = 800;
				}
			}
			else if ((passenger.getBoardingPoint().equals("vijayawada")|| passenger.getBoardingPoint().equals("chennai")) 
					&& (passenger.getDropingPoint().equals("chennai") || passenger.getDropingPoint().equals("vijayawada"))) {
				if(passenger.getAge() <= 10 && passenger.getAge() > 0) {
					fare = 700;
				}else if(passenger.getAge() > 70) {
					fare = 800;
				}else {
					fare = 900;
				}
			}
			else {
				System.out.println("No bus avaliable betwwen those two stops, please exit and try again");
			}
		}
		return fare;
	}
}
