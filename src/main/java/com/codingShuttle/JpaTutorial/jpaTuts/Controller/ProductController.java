//package com.codingShuttle.JpaTutorial.jpaTuts.Controller;
//
//import com.codingShuttle.JpaTutorial.jpaTuts.Entities.ProductEntity;
//import com.codingShuttle.JpaTutorial.jpaTuts.Repositories.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//    @Autowired
//    ProductRepository productRepository;
//
//    @GetMapping
//    public List<ProductEntity> getAllProducts(){
//        return productRepository.findByTitleOrderByPrice("mazza");
//    }
//
//    @GetMapping("/all")
//    public List<ProductEntity> getAllItems(@RequestParam String sortBy){
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
//    }
//
//    @GetMapping("/page")
//    public  List<ProductEntity> getAll(@RequestParam(defaultValue = "id")
//                                      String sortBy, @RequestParam(defaultValue = "1")
//                                      Integer pageNumber){
//        Pageable pageable= PageRequest.of(pageNumber,2);
//        return productRepository.findAll(pageable).getContent();
//    }
//
//}
