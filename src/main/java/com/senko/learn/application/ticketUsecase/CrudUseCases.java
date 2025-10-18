package com.senko.learn.application.ticketUsecase;

import com.senko.learn.domain.booking.dto.CreateTicketDTO;
import com.senko.learn.domain.booking.Ticket;
import com.senko.learn.domain.repo.TicketRepo;

public class CrudUseCases {
    private final TicketRepo repo;

    public CrudUseCases(TicketRepo repo){
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
