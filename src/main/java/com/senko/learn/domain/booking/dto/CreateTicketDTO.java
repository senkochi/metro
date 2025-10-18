package com.senko.learn.domain.booking.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTicketDTO {
    private int price;
    private String originalStation;
    private String destinationStation;
    private String type;
}
