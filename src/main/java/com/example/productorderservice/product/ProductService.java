package com.example.productorderservice.product;

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
class ProductService {
	private final ProductPort productPort;

	ProductService(final ProductPort productPort) {
		this.productPort = productPort;
	}

	public void addProduct(final AddProductRequest request) {
		final Product product = new Product(request.name(), request.price(), request.discountPolicy());

		productPort.save(product);
	}
}
