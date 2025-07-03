package com.microservices.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {
    @Value("${test.message}")
    private static String message;

    @GetMapping
    public String getMessage(){
        return message;
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("New customer registration{}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
