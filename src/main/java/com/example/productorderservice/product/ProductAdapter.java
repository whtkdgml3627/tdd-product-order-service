package com.example.productorderservice.product;

import org.springframework.stereotype.Component;

/**
 * Version     : 1.0
 * 패키지명    　: com.example.productorderservice.product
 * 파일명    　　: ProductAdapter
 * 작성일자    　: 2023-12-14
 * 작성자    　　: 조상희
 * 설명    　　　: 클래스 설명
 * 수정일자    　: *
 * 수정자    　　: *
 * 수정내역    　: *
 */
@Component
class ProductAdapter implements ProductPort {
	private final ProductRepository productRepository;

	ProductAdapter(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

}
