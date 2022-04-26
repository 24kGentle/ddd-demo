package com.wy.ddd.infrastructure.entity;

import lombok.Data;

/**
 * @Author wangyang
 * @Create 2022/4/25 19:16
 */
@Data
public class ProductDetail {

    private Long id;

    private Long productId;

    private String productDesc;

    private String productColor;
}
