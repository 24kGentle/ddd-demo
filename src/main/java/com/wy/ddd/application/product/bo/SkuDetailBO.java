package com.wy.ddd.application.product.bo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:33
 */
@Data
public class SkuDetailBO {
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
