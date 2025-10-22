package com.senko.learn.domain.booking;

import com.senko.learn.domain.booking.enums.PaymentStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private int paymentId;
    private long amount;
    private PaymentStatus status;

    public void complete(){
        this.status = PaymentStatus.COMPLETED;
    }
}


