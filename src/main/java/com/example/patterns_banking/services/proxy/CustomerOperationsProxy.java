package com.example.patterns_banking.services.proxy;

import org.springframework.stereotype.Component;

@Component
public class CustomerOperationsProxy implements ICustomerOperations {

    @Override
    public Boolean validateEmail(String email) {
        return !email.contains("@yahoo");
    }
}
