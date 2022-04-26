package com.wy.ddd.domain.product.bo;

import lombok.Data;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:53
 */
@Data
public class ProductDetailBo {

    private Long id;

    private Long productId;

    private String productDesc;

    private String productColor;
}
