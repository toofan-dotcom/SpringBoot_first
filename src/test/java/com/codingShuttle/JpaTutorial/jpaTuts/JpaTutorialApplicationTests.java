package com.codingShuttle.JpaTutorial.jpaTuts;

import com.codingShuttle.JpaTutorial.jpaTuts.Entities.ProductEntity;
import com.codingShuttle.JpaTutorial.jpaTuts.Repositories.ProductRepository;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Builder
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity= ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();
		 ProductEntity savedEntity=productRepository.save(productEntity);
		System.out.println(savedEntity);
	}
    @Test
	void getRepository(){
		List<ProductEntity> entities= productRepository.findByCreatedAtAfter(
				LocalDateTime.of(2024,12,12,0,0,0));
		System.out.println(entities);
	}

	@Test
	void getResult(){
		List<ProductEntity> entities= productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(12.4));
		System.out.println(entities);
	}
//	@Test
//	void getProduct(){
//		System.out.println(productRepository.getProduct(1));
//	}
}
