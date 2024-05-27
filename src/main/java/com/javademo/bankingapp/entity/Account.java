package com.javademo.bankingapp.entity;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accounts")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long  id;
    @Column(name="account_holder_name")
    private String accountHoldername;
    private double balance;




}
