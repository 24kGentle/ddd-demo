package com.wy.ddd.domain.product.repository.impl;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.domain.product.bo.ProductDetailBo;
import com.wy.ddd.domain.product.repository.ProductDetailRepository;
import com.wy.ddd.infrastructure.entity.ProductDetail;
import com.wy.ddd.infrastructure.mysql.ProductDetailMapper;
import com.wy.ddd.infrastructure.util.LocalBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author wangyang
 * @Create 2022/4/25 19:10
 */
@Component
public class ProductDetailRepositoryImpl implements ProductDetailRepository {

    @Autowired
    ProductDetailMapper productDetailMapper;

    @Override
    public ProductDetailBo queryDetailByProductId(Long productId) {
        ProductDetail productDetail = productDetailMapper.queryDetailByProductId(productId);
        ProductDetailBo productDetailBo = LocalBeanUtils.copyProperties(productDetail, ProductDetailBo.class);
        return productDetailBo;
    }
}
