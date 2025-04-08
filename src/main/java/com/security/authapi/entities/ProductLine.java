package com.security.authapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_lines")
public class ProductLine {
    @Id
    @Size(max = 50)
    @Column(name = "product_line", nullable = false, length = 50)
    private String productLine;

    @Size(max = 4000)
    @Column(name = "text_description", length = 4000)
    private String textDescription;

    @Lob
    @Column(name = "html_description")
    private String htmlDescription;

    @Size(max = 255)
    @Column(name = "image")
    private String image;

}