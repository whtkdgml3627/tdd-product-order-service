package com.example.productorderservice.product;

import java.util.HashMap;
import java.util.Map;

/**
 * Version     : 1.0
 * 패키지명    　: com.example.productorderservice.product
 * 파일명    　　: ProductRepository
 * 작성일자    　: 2023-12-14
 * 작성자    　　: 조상희
 * 설명    　　　: 클래스 설명
 * 수정일자    　: *
 * 수정자    　　: *
 * 수정내역    　: *
 */
class ProductRepository {
	private Map<Long, Product> persistence = new HashMap<>();
	private Long sequence = 0L;

	public void save(final Product product) {
		product.assignId(++sequence);
		persistence.put(product.getId(), product);
	}
}
