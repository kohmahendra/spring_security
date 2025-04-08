package com.security.authapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Integer id;

    private String lastName;

    private String firstName;

    private String extension;

    private String email;

    private OfficeDTO officeCode;

    private Integer reportsToEmployeeNumber;

    private String jobTitle;
}
