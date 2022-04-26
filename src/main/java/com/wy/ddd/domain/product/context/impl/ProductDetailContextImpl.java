package com.wy.ddd.domain.product.context.impl;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.domain.product.bo.ProductDetailBo;
import com.wy.ddd.domain.product.context.ProductDetailContext;
import com.wy.ddd.domain.product.repository.ProductDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:52
 */
@Component
@Slf4j
public class ProductDetailContextImpl implements ProductDetailContext {

    @Autowired
    ProductDetailRepository productDetailRepository;


    @Override
    public ProductDetailBo queryDetailByProductId(Long productId) {
        log.info("ProductDetailContextImpl queryProductDetailInfo productId={}", productId);
        ProductDetailBo productDetailBo = productDetailRepository.queryDetailByProductId(productId);
        return productDetailBo;
    }
}
