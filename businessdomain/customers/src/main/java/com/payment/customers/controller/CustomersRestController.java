package com.payment.customers.controller;

import com.payment.customers.business.transactions.BusinessTransaction;
import com.payment.customers.entities.Customer;
import com.payment.customers.exception.BusinessRuleException;
import com.payment.customers.repository.CustomerRepository;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.netty.tcp.TcpClient;

import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/customers")
public class CustomersRestController {

    private final CustomerRepository customerRepository;
    private final BusinessTransaction businessTransaction;
    @Value("${user.role}")
    private String role;

    //define timeout
    TcpClient tcpClient = TcpClient
            .create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
            .doOnConnected(connection -> {
                connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS));
                connection.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
            });

    @Autowired
    public CustomersRestController(CustomerRepository customerRepository, BusinessTransaction businessTransaction) {
        this.customerRepository = customerRepository;
        this.businessTransaction = businessTransaction;
    }

    @GetMapping("/role")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello your role is: "+ role);
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> list() {
        List<Customer> findAll = customerRepository.findAll();
        if(findAll == null || findAll.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(findAll);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable UUID id ) {
        return customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Customer> post(@RequestBody Customer input) throws BusinessRuleException, UnknownHostException {
        Customer save = businessTransaction.save(input);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable UUID id, @RequestBody Customer input) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return null;
    }

    @GetMapping("/full")
    public Customer get(@RequestParam  String code) {
        Customer customer = businessTransaction.get(code);
        return customer;
    }

}
