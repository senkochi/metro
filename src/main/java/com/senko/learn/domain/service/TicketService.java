package com.senko.learn.domain.service;

import com.senko.learn.domain.booking.dto.CreateTicketDTO;
import com.senko.learn.domain.booking.Ticket;
import com.senko.learn.domain.repo.TicketRepo;

public class TicketService {
    private final TicketRepo repo;

    public TicketService(TicketRepo repo){
        this.repo = repo;
    }

    public Ticket createTicket(CreateTicketDTO ticketDTO){
        Ticket ticket = Ticket.builder()
                .price(ticketDTO.getPrice())
                .originalStation(ticketDTO.getOriginalStation())
                .destinationStation(ticketDTO.getDestinationStation())
                .type(ticketDTO.getType())
                .build();
        return repo.save(ticket);
    }
}
