package com.wy.ddd.domain.product.context.impl;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.domain.product.bo.ProductBo;
import com.wy.ddd.domain.product.bo.ProductDetailBo;
import com.wy.ddd.domain.product.context.ProductContext;
import com.wy.ddd.domain.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:51
 */
@Component
@Slf4j
public class ProductContextImpl implements ProductContext {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductBo queryProductInfo(SkuDetailBO skuDetailBO) {
        log.info("ProductContextImpl queryProductInfo skuDetailBO={}", skuDetailBO);
        ProductBo productBo = productRepository.queryProductInfo(skuDetailBO);
        return productBo;
    }
}
