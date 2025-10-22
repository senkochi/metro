package com.senko.learn.infrastructure.web;

import com.senko.learn.application.booking.CrudUseCases;
import com.senko.learn.domain.booking.dto.CreateTicketDTO;
import com.senko.learn.domain.booking.Ticket;
import com.senko.learn.domain.repo.TicketRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepo repo;

    public TicketController(TicketRepo repo) {
        this.repo = repo;
    }

    @PostMapping()
    public ResponseEntity<?> createTicket(@RequestBody CreateTicketDTO ticketDTO){
        CrudUseCases createTicketUseCase = new CrudUseCases(repo);
        return ResponseEntity.ok(createTicketUseCase.createTicket(ticketDTO));
    }

    @GetMapping()
    public List<Ticket> getAllTicket(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicketByTicketId(@PathVariable int id){
        return repo.findByTicketId(id);
    }
}
