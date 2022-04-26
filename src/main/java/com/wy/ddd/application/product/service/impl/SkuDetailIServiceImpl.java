package com.wy.ddd.application.product.service.impl;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.application.product.service.SkuDetailIService;
import com.wy.ddd.domain.product.bo.ProductBo;
import com.wy.ddd.domain.product.bo.ProductDetailBo;
import com.wy.ddd.domain.product.context.ProductContext;
import com.wy.ddd.domain.product.context.ProductDetailContext;
import com.wy.ddd.infrastructure.exception.BaseException;
import com.wy.ddd.infrastructure.util.LocalBeanUtils;
import com.wy.ddd.interfaces.product.vo.SkuDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:21
 */
@Service
public class SkuDetailIServiceImpl implements SkuDetailIService {

    @Autowired
    ProductContext productContext;

    @Autowired
    ProductDetailContext productDetailContext;

    @Override
    public SkuDetailVO querySkuDetail(SkuDetailBO skuDetailBO) {
        SkuDetailVO skuDetailVO = new SkuDetailVO();
        // 1、验签
        // 2、调用 商品domain
        ProductBo productBo = productContext.queryProductInfo(skuDetailBO);
        if (!Objects.isNull(productBo)) {
            // 3、调用 商品详情domain
            ProductDetailBo productDetailBo = productDetailContext.queryDetailByProductId(productBo.getId());
            skuDetailVO = LocalBeanUtils.copyProperties(productBo, SkuDetailVO.class);
            BeanUtils.copyProperties(productDetailBo, skuDetailVO);
//            if (!Objects.isNull(productDetailBo)) {
//                skuDetailVO.setProductDesc(productDetailBo.getProductDesc());
//                skuDetailVO.setProductColor(productDetailBo.getProductColor());
//            }
        }
        return skuDetailVO;
    }
}
