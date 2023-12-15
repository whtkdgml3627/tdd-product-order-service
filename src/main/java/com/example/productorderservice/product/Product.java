package com.example.productorderservice.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

/**
 * Version     : 1.0
 * 패키지명    　: com.example.productorderservice.product
 * 파일명    　　: Product
 * 작성일자    　: 2023-12-14
 * 작성자    　　: 조상희
 * 설명    　　　: 클래스 설명
 * 수정일자    　: *
 * 수정자    　　: *
 * 수정내역    　: *
 */

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int price;
	private DiscountPolicy discountPolicy;

	public Product(String name, int price, DiscountPolicy discountPolicy) {
		Assert.hasText(name, "상품명은 필수입니다.");
		Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
		Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
		this.name = name;
		this.price = price;
		this.discountPolicy = discountPolicy;
	}

}
