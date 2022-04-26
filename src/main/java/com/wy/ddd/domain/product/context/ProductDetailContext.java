package com.wy.ddd.domain.product.context;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.domain.product.bo.ProductDetailBo;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:51
 */
public interface ProductDetailContext {

    ProductDetailBo queryDetailByProductId(Long productId);
}
