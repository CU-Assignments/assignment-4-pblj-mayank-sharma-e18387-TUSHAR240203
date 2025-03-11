/*/*✅ Problem 3: Ticket Booking System (Hard Level)
Description:
Develop a multi-threaded ticket booking system that ensures synchronized seat booking to prevent double booking. Use thread priorities to give preference to VIP bookings.

Features:
Multiple users booking tickets simultaneously
Synchronization to prevent double booking
VIP customers have higher priority
Example Output:
VIP Booking: Seat 1 confirmed. Regular Booking: Seat 2 confirmed. Error: Seat already booked. */

import java.util.ArrayList;
import java.util.List;

class Seat {
    private boolean booked;
    private String bookedBy;

    public Seat() {
        this.booked = false;
        this.bookedBy = "";
    }

    public synchronized boolean book(String customerType) {
        if (!booked) {
            booked = true;
            bookedBy = customerType;
            return true;
        }
        return false;
    }

    public String getBookedBy() {
        return bookedBy;
    }
}

class TicketBookingSystem {
    private final List<Seat> seats;

    public TicketBookingSystem(int numberOfSeats) {
        seats = new ArrayList<>();
        for (int i = 0; i < numberOfSeats; i++) {
            seats.add(new Seat());
        }
    }

    public void bookTicket(String customerType) {
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).book(customerType)) {
                System.out.println(customerType + " Booking: Seat " + (i + 1) + " confirmed.");
                return;
            }
        }
        System.out.println("Error: Seat already booked.");
    }
}

class Customer extends Thread {
    private final TicketBookingSystem bookingSystem;
    private final String customerType;

    public Customer(TicketBookingSystem bookingSystem, String customerType) {
        this.bookingSystem = bookingSystem;
        this.customerType = customerType;
    }

    @Override
    public void run() {
        bookingSystem.bookTicket(customerType);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(5);

        // Create VIP and regular customers
        Customer vipCustomer1 = new Customer(bookingSystem, "VIP");
        Customer regularCustomer1 = new Customer(bookingSystem, "Regular");
        Customer vipCustomer2 = new Customer(bookingSystem, "VIP");
        Customer regularCustomer2 = new Customer(bookingSystem, "Regular");

        // Set thread priorities
        vipCustomer1.setPriority(Thread.MAX_PRIORITY);
        regularCustomer1.setPriority(Thread.NORM_PRIORITY);
        vipCustomer2.setPriority(Thread.MAX_PRIORITY);
        regularCustomer2.setPriority(Thread.NORM_PRIORITY);

        // Start the booking process
        vipCustomer1.start();
        regularCustomer1.start();
        vipCustomer2.start();
        regularCustomer2.start();
    }
}
