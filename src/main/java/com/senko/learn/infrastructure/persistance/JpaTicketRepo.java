package com.senko.learn.infrastructure.persistance;

import com.senko.learn.domain.exception.TicketNotExistException;
import com.senko.learn.domain.booking.Ticket;
import com.senko.learn.domain.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaTicketRepo implements TicketRepo {

    @Autowired
    private TicketJpaRepository jpa;

    @Override
    public Ticket save(Ticket ticket) {
        TicketEntity entity = TicketEntity.builder()
                .ticketId(ticket.getTicketId())
                .price(ticket.getPrice())
                .originalStation(ticket.getOriginalStation())
                .destinationStation(ticket.getDestinationStation())
                .type(ticket.getType())
                .build();
        TicketEntity saved = jpa.save(entity);
        return Ticket.builder()
                .ticketId(saved.getTicketId())
                .price(saved.getPrice())
                .originalStation(saved.getOriginalStation())
                .destinationStation(saved.getDestinationStation())
                .type(saved.getType())
                .build();
    }

    @Override
    public List<Ticket> findAll() {
        List<TicketEntity> entities = jpa.findAll();
        return entities.stream().map(entity -> new Ticket(
                entity.getTicketId(),
                entity.getPrice(),
                entity.getOriginalStation(),
                entity.getDestinationStation(),
                entity.getType())).toList();
    }

    @Override
    public Ticket findByTicketId(int ticketId) {
        TicketEntity entity = jpa.findByTicketId(ticketId).orElseThrow(() -> new TicketNotExistException("Ticket not found with Id: " + ticketId));
        return Ticket.builder()
                .ticketId(entity.getTicketId())
                .price(entity.getPrice())
                .originalStation(entity.getOriginalStation())
                .destinationStation(entity.getDestinationStation())
                .type(entity.getType())
                .build();
    }
}
