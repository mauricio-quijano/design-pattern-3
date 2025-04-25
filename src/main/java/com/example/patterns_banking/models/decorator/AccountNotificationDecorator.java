package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountNotificationDecorator extends AccountDecorator {
    private static final double MAX_EXCEEDING = 20000.0;

    public AccountNotificationDecorator(Account account) {
        super(account);
    }

    @Override
    public void deposit(Double amount) {
        super.deposit(amount);
        System.out.println("Se ha realizado un deposito de: " + amount + " en la cuenta de: " + getAccountNumber());
    }

    @Override
    public void withdraw(double amount) {
        double balance = getBalance();

        if (amount > balance + MAX_EXCEEDING) {
            throw new IllegalArgumentException("El monto a retirar excede el limite permitido");
        }

        System.out.println("Se ha realizado un retiro de: " + amount + " en la cuenta de: " + getAccountNumber());

        if (amount >= balance) {
            System.out.println("Se ha retirado un excedente de: " + (amount - balance)
                    + " en la cuenta de: " + getAccountNumber());
            setBalance(0.0);
            amount = 0.0;
        }

        super.withdraw(amount);
    }
}
