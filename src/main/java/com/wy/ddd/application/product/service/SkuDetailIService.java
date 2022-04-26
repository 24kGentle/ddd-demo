package com.wy.ddd.application.product.service;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.interfaces.product.vo.SkuDetailVO;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:20
 */
public interface SkuDetailIService {


    SkuDetailVO querySkuDetail(SkuDetailBO skuDetailBO);
}
