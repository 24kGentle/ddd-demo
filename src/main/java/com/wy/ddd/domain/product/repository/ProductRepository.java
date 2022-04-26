package com.wy.ddd.domain.product.repository;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.domain.product.bo.ProductBo;

/**
 * @Author wangyang
 * @Create 2022/4/25 19:04
 */
public interface ProductRepository {
    ProductBo queryProductInfo(SkuDetailBO skuDetailBO);
}
