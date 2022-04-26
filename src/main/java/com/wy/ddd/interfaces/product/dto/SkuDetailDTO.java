package com.wy.ddd.interfaces.product.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:24
 */
@Data
public class SkuDetailDTO {

    @JSONField(name = "product_name")
    private String productName;

    @JSONField(name = "product_color")
    private String productColor;

    /**
     * 商品编号
     */
    @JSONField(name = "product_num")
    private String productNum;

    @JSONField(name = "product_desc")
    private String productDesc;
}
