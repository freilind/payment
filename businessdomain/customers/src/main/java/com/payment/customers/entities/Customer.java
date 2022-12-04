package com.payment.customers.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Customer {
    @Id
    private UUID id = UUID.randomUUID();
    private String code;
    private String iban;
    private String names;
    private String surname;
    private String phone;
    private String address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerProduct> products;
    @Transient
    private List<?> transactions;
}
