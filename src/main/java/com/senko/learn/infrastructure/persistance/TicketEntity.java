package com.senko.learn.infrastructure.persistance;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    private int price;

    @Column(name = "original_station")
    private String originalStation;

    @Column(name = "destination_station")
    private String destinationStation;

    private String type;
}
