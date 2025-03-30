package com.security.authapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_number", nullable = false)
    private Integer id;

    @Column(name = "last_Name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "first_Name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_code", nullable = false)
    private Office officeCode;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @Column(name = "job_title", nullable = false, length = 50)
    private String jobTitle;

}