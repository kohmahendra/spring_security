package com.security.authapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_lines")
public class ProductLine {
    @Id
    @Column(name = "product_line", nullable = false, length = 50)
    private String productLine;

    @Column(name = "text_description", length = 4000)
    private String textDescription;

    @Lob
    @Column(name = "html_description")
    private String htmlDescription;

    @Column(name = "image")
    private byte[] image;

}