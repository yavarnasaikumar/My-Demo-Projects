package reservationSystem.passengers;

import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
    private static PassengerServices services = new PassengerServices();
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                	PassengerServices.printAvaliableSeats();
                	System.out.println();
                    break;
                case 2:
                	services.bookTicket();
                	System.out.println();
                    break;
                case 3:
                    services.ticketDetails();
                    System.out.println();
                    break;
                case 4:
                    services.printTicketList();
                    System.out.println();
                    break;
                case 5:
                    services.cancleTicket();
                    System.out.println();
                    break;
                case 6:
                    quit = true;
                    System.out.println("Thank you, Visit again!!!");
                    break;
//                case 7:
//                	services.calculateFare();
//                	System.out.println();
//                    break;
                default:
                	System.out.println("Please select correct option");
                	System.out.println();
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\n\t " + "_"+"/"+"\\"+"_"+" *** Welcome ***" + "_"+"/"+"\\"+"_" );
        System.out.println();
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - Avaliable Seats");
        System.out.println("\t 2 - Book your Ticket");
        System.out.println("\t 3 - your Ticket Details");
        System.out.println("\t 4 - print passengers list");
        System.out.println("\t 5 - Ticket Cancellation");
        System.out.println("\t 6 - To quit the application.");
//        System.out.println("\t 7 - Calculate fare");
        System.out.println("\t      ************");
    }

}
