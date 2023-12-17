package com.example.productorderservice.product;

import org.springframework.util.Assert;

/**
 * Version     : 1.0
 * 패키지명    　: com.example.productorderservice.product
 * 파일명    　　: GetProductResponse
 * 작성일자    　: 2023-12-17
 * 작성자    　　: 조상희
 * 설명    　　　: 클래스 설명
 * 수정일자    　: *
 * 수정자    　　: *
 * 수정내역    　: *
 */
record GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {
	GetProductResponse {
		Assert.notNull(id, "상품 ID는 필수입니다.");
		Assert.hasText(name, "상품명은 필수입니다.");
		Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
	}
}
