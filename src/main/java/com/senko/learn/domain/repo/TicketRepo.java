package com.senko.learn.domain.repo;

import com.senko.learn.domain.booking.Ticket;

import java.util.List;

public interface TicketRepo {
    Ticket save(Ticket ticket);
    List<Ticket> findAll();
    Ticket findByTicketId(int ticketId);
}
