package com.example.productorderservice.product;

/**
 * Version     : 1.0
 * 패키지명    　: com.example.productorderservice.product
 * 파일명    　　: ProductPort
 * 작성일자    　: 2023-12-14
 * 작성자    　　: 조상희
 * 설명    　　　: 클래스 설명
 * 수정일자    　: *
 * 수정자    　　: *
 * 수정내역    　: *
 */
interface ProductPort {
	void save(final Product product);

	Product getProduct(long productId);
}
