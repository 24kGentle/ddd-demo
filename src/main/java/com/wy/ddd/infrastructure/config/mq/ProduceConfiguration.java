package com.wy.ddd.infrastructure.config.mq;

import com.aliyun.openservices.ons.api.bean.ProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProduceConfiguration {

    @Autowired
    private MqConfig mqConfig;

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    @ConditionalOnProperty(
            name = {"ons.mq.consumer.start"},
            havingValue = "true",
            matchIfMissing = false
    )
    public ProducerBean buildProducer() {
        //ProducerBean用于将Producer集成至Spring Bean中
        ProducerBean producer = new ProducerBean();
        producer.setProperties(mqConfig.getMqPropertie());
        return producer;
    }
}
