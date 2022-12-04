package com.payment.products.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Product {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String code;
}
