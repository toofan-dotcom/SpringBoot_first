//package com.codingShuttle.JpaTutorial.jpaTuts.Entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="products_table")
//public class ProductEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private   Long id;
//  private   String sku;
//   private String title;
//   private BigDecimal price;
//   private Integer quantity;
//    @CreationTimestamp
//   private LocalDateTime createdAt;
//    @UpdateTimestamp
//   private   LocalDateTime updatedAt;
//}
