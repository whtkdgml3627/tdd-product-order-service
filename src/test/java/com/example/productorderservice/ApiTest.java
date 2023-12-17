package com.example.productorderservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * Version     : 1.0
 * 패키지명    　: com.example.productorderservice.product
 * 파일명    　　: ApiTest
 * 작성일자    　: 2023-12-15
 * 작성자    　　: 조상희
 * 설명    　　　: 클래스 설명
 * 수정일자    　: *
 * 수정자    　　: *
 * 수정내역    　: *
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

	@Autowired
	private DatabaseCleanup databaseCleanup;

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		if(RestAssured.port == RestAssured.UNDEFINED_PORT){
			RestAssured.port = port;
			databaseCleanup.afterPropertiesSet();
		}
		databaseCleanup.execute();
	}
}
