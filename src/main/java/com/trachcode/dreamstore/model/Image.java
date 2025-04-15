package com.trachcode.dreamstore.model;

import com.trachcode.dreamstore.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String filePath;
    private String fileType;
    private String downloadUrl;
    @Lob
    private Blob image;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
