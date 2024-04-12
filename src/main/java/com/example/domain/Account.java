package com.example.domain;

import java.util.*;

import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
public class Account {
    @Id
    private String id;

    private String iban;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {PERSIST, MERGE})
    private Set<PhoneNumber> phoneNumbers;

    public Account() {
    }

    public Account(String id, String iban, String firstName, String lastName) {
        this.id = id;
        this.iban = iban;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = new HashSet<>();
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
        phoneNumber.setAccount(this);
    }

    public String getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
