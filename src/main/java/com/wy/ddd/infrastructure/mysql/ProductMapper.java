package com.wy.ddd.infrastructure.mysql;

import com.wy.ddd.infrastructure.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author wangyang
 * @Create 2022/4/25 19:12
 */
@Mapper
public interface ProductMapper {

    @Select("select * from product_info where product_name = #{productName}")
    public ProductInfo queryProductInfo(@Param("productName") String productName);
}
