package com.wy.ddd.interfaces.product.control;

import com.wy.ddd.application.product.bo.SkuDetailBO;
import com.wy.ddd.application.product.service.SkuDetailIService;
import com.wy.ddd.infrastructure.annotation.LogId;
import com.wy.ddd.infrastructure.enums.BaseResponseEnum;
import com.wy.ddd.infrastructure.util.LocalBeanUtils;
import com.wy.ddd.interfaces.product.dto.SkuDetailDTO;
import com.wy.ddd.interfaces.product.vo.BaseResponseVO;
import com.wy.ddd.interfaces.product.vo.SkuDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:10
 */
@RestController
@RequestMapping("/sku")
@Slf4j
public class SkuCtl {


    @Autowired
    SkuDetailIService skuDetailIService;

    /**
     * 查询商品详情
     * 1、先查商品表
     * 2、再查详情表
     * @param skuDetailDTO
     * @return
     */
    @RequestMapping("/querySkuDetail")
    @LogId
    public BaseResponseVO<SkuDetailVO> querySkuDetail(SkuDetailDTO skuDetailDTO) {
        log.info("SkuCtl querySkuDetail skuDetailDTO={}", skuDetailDTO);
        BaseResponseVO<SkuDetailVO> baseResponseVO = new BaseResponseVO<>();
        SkuDetailBO skuDetailBO = LocalBeanUtils.copyProperties(skuDetailDTO, SkuDetailBO.class);
        SkuDetailVO skuDetailVO = skuDetailIService.querySkuDetail(skuDetailBO);
        baseResponseVO.setCode(BaseResponseEnum.SUCCESS.getCode());
        baseResponseVO.setMessage("查询成功");
        baseResponseVO.setData(skuDetailVO);
        return baseResponseVO;
    }


}
