package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Version     : 1.0
 * 패키지명    　: com.example.productorderservice.product
 * 파일명    　　: ProductServiceTest
 * 작성일자    　: 2023-12-14
 * 작성자    　　: 조상희
 * 설명    　　　: 클래스 설명
 * 수정일자    　: *
 * 수정자    　　: *
 * 수정내역    　: *
 */

class ProductApiTest extends ApiTest {


	@Test
	void 상품등록() {
		final var request = ProductSteps.상품등록요청_생성();

		// API 요청
		final var response = ProductSteps.상품등록요청(request);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	void 상품조회() {
		ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
		Long productId = 1L;

		final var response = ProductSteps.상품조회요청(productId);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
	}

}
