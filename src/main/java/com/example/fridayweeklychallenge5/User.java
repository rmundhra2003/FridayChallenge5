package com.example.fridayweeklychallenge5;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=3)
    private String firstName;
    @NotNull
    @Size(min=3)
    private String lastName;

    @OneToMany(mappedBy = "user",
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    public Set<Message> messages;

    public User() {
    }

    public User(@NotNull @Size(min = 3) String firstName, @NotNull @Size(min = 3) String lastName, Set<Message> messages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.messages = messages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
