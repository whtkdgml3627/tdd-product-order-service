package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

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
		final var request = 상품등록요청_생성();

		// API 요청
		final var response = 상품등록요청(request);

		assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
	}

	private static ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
		return RestAssured.given().log().all()
		                  .contentType(MediaType.APPLICATION_JSON_VALUE)
		                  .body(request)
		                  .when()
		                  .post("/products")
		                  .then()
		                  .log().all().extract();
	}

	private static AddProductRequest 상품등록요청_생성() {
		final String name = "상품명";
		final int price = 1000;
		DiscountPolicy discountPolicy = DiscountPolicy.NONE;
		return new AddProductRequest(name, price, discountPolicy);
	}

}
