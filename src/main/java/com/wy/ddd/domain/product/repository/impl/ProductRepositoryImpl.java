package com.wy.ddd.domain.product.repository.impl;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.domain.product.bo.ProductBo;
import com.wy.ddd.domain.product.repository.ProductRepository;
import com.wy.ddd.infrastructure.entity.ProductInfo;
import com.wy.ddd.infrastructure.mysql.ProductMapper;
import com.wy.ddd.infrastructure.util.LocalBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author wangyang
 * @Create 2022/4/25 19:04
 */
@Component
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    ProductMapper productMapper;


    @Override
    public ProductBo queryProductInfo(SkuDetailBO skuDetailBO) {
        ProductInfo productInfo = productMapper.queryProductInfo(skuDetailBO.getProductName());
        ProductBo productBo = LocalBeanUtils.copyProperties(productInfo, ProductBo.class);
        return productBo;
    }

}
