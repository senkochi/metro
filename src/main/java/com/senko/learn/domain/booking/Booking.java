package com.senko.learn.domain.booking;

import com.senko.learn.domain.booking.enums.BookingStatus;
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
}
