package com.dev.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "first_name")
    private String customerFirstName;

    @Column(name = "middle_name")
    private String customerMiddleName;

    @Column(name = "last_name")
    private String customerLastName;

    @Column(name = "gender")
    private String customerGender;
}
