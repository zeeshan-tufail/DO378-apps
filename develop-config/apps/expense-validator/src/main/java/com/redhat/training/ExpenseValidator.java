package com.redhat.training;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ExpenseValidator {

    @Inject
    ExpenseConfiguration config;

    public void debugRanges() {
        config.debugMessage().ifPresent(System.out::println);
        // System.out.println("Range - High: " + config.rangeHigh());
        // System.out.println("Range - Low: " + config.rangeLow());
    }

    public boolean isValidAmount(int amount) {
        if (config.debugEnabled()) {
            debugRanges();
        }

        return amount >= config.rangeLow() && amount <= config.rangeHigh();
    }
}
