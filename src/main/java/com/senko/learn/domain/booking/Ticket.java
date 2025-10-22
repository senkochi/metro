package com.senko.learn.domain.booking;

import com.senko.learn.domain.booking.enums.TicketStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
    private int ticketId;
    private int price;
    private String originalStation;
    private String destinationStation;
    private String type;
    private TicketStatus status;

    public void cancel(){
        if(status == TicketStatus.CANCELLED){
            throw new IllegalStateException("Ticket cancelled already");
        }
        this.status = TicketStatus.CANCELLED;
    }

    public void confirm(){
        if(status != TicketStatus.ACTIVE){
            throw new IllegalStateException("Ticket no longer usable");
        }
        this.status = TicketStatus.USED;
    }

    TicketStatus getStatus(){
        return this.status;
    }
}
