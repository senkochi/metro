package com.senko.learn.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketJpaRepository extends JpaRepository<TicketEntity, Integer> {
    Optional<TicketEntity> findByTicketId(int ticketId);
}
