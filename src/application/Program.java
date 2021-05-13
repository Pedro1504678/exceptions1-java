package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Romm number: ");
		int number = sc.nextInt();
		System.out.print("Chec-in date (dd/MM/yyyy):  ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Chec-out date (dd/MM/yyyy):  ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erron in reservation: Check-out date must be after check-In date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Chec-in date (dd/MM/yyyy):  ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Chec-out date (dd/MM/yyyy):  ");
			checkOut = sdf.parse(sc.next());
			
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erron in reservation: Check-out date must be after check-In date");
				
			}
			else {
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			}
			
		}
		
		
		
		sc.close();

	}

}
