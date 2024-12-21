//package com.codingShuttle.JpaTutorial.jpaTuts.Repositories;
//
//import com.codingShuttle.JpaTutorial.jpaTuts.Entities.ProductEntity;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Repository
//public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
//    List<ProductEntity> findByTitle(String title);
//
//    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);
//
//    List<ProductEntity> findByQuantityAndPrice(Integer quantity, BigDecimal price);
//
//    List<ProductEntity> findByTitleOrderByPrice(String title);
//
//    List<ProductEntity> findBy(Sort sort);
//
//
////    @Query("select e from ProductEntity e where e.id=:id")
////    ProductEntity getProduct(Long id);
//}
