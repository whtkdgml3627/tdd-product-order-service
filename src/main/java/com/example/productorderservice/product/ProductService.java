package com.example.productorderservice.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Version     : 1.0
 * 패키지명    　: com.example.productorderservice.product
 * 파일명    　　: ProductService
 * 작성일자    　: 2023-12-14
 * 작성자    　　: 조상희
 * 설명    　　　: 클래스 설명
 * 수정일자    　: *
 * 수정자    　　: *
 * 수정내역    　: *
 */

@RestController
@RequestMapping("/products")
class ProductService {
	private final ProductPort productPort;

	ProductService(final ProductPort productPort) {
		this.productPort = productPort;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest request) {
		final Product product = new Product(request.name(), request.price(), request.discountPolicy());

		productPort.save(product);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
