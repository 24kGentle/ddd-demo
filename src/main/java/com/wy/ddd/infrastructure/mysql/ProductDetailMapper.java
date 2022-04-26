package com.wy.ddd.infrastructure.mysql;

import com.wy.ddd.infrastructure.entity.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author wangyang
 * @Create 2022/4/25 19:16
 */
@Mapper
public interface ProductDetailMapper {

    @Select("select * from product_detail where product_id = #{productId}")
    ProductDetail queryDetailByProductId(@Param("productId")Long productId);
}
