package com.tms.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
public class User {
    private long balance;

    public User() {
        this.balance = 100;
    }
}
