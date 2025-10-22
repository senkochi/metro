package com.senko.learn.domain.booking;

import com.senko.learn.domain.booking.enums.BookingStatus;
import com.senko.learn.domain.booking.enums.TicketStatus;
import com.senko.learn.domain.exception.TicketNotExistException;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    private int bookingId;
    private String customer;
    private LocalDateTime bookingDate;
    private BookingStatus status;
    private List<Ticket> tickets;
    private Payment payment;

    public void addTicket(Ticket ticket){
        if(this.status != BookingStatus.CREATED){
            throw new IllegalStateException("Cannot add ticket after booking confirmed");
        }
        tickets.add(ticket);
    }

    public void cancelTicket(int ticketId) {
        Ticket ticket = tickets.stream()
                .filter(t -> t.getTicketId() == ticketId)
                .findFirst()
                .orElseThrow(() -> new TicketNotExistException("Ticket not found"));
        ticket.cancel();
    }

    public void makePayment(Payment payment){
        if(tickets.isEmpty()){
            throw new IllegalStateException("Ticket list is empty");
        }
        payment.complete();
        this.status = BookingStatus.PAID;
    }
}
