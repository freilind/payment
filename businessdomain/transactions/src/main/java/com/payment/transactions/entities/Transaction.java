package com.payment.transactions.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Transaction {

    @Id
    private UUID id = UUID.randomUUID();
    private String reference;
    private String ibanAccount;
    private LocalDateTime date;
    private double amount ;
    private double fee;
    private String description;
    private String status;
    private String channel;
}
