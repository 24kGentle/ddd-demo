package com.wy.ddd.infrastructure.config.mq;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "rocketmq")
@Slf4j
public class MqConfig {

    private String accessKey;
    private String secretKey;
    private String nameSrvAddr;
    private String topic;

    private String extractOrderGroupId;
    private String extractOrderTag;

    private String rewriteOrderTopic;
    private String rewriteOrderGroupId;
    private String rewriteOrderTag;

    /**
     * 定时/延时
     */
    private String timeTopic;
    private String timeGroupId;
    private String timeTag;

    public Properties getMqPropertie() {
        log.info("MqConfig getMqPropertie start");
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.AccessKey, this.accessKey);
        properties.setProperty(PropertyKeyConst.SecretKey, this.secretKey);
        properties.setProperty(PropertyKeyConst.NAMESRV_ADDR, this.nameSrvAddr);
        //设置发送超时时间，单位毫秒
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        return properties;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getNameSrvAddr() {
        return nameSrvAddr;
    }

    public void setNameSrvAddr(String nameSrvAddr) {
        this.nameSrvAddr = nameSrvAddr;
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getExtractOrderGroupId() {
        return extractOrderGroupId;
    }

    public void setExtractOrderGroupId(String extractOrderGroupId) {
        this.extractOrderGroupId = extractOrderGroupId;
    }

    public String getExtractOrderTag() {
        return extractOrderTag;
    }

    public void setExtractOrderTag(String extractOrderTag) {
        this.extractOrderTag = extractOrderTag;
    }

    public String getRewriteOrderTopic() {
        return rewriteOrderTopic;
    }

    public void setRewriteOrderTopic(String rewriteOrderTopic) {
        this.rewriteOrderTopic = rewriteOrderTopic;
    }

    public String getRewriteOrderGroupId() {
        return rewriteOrderGroupId;
    }

    public void setRewriteOrderGroupId(String rewriteOrderGroupId) {
        this.rewriteOrderGroupId = rewriteOrderGroupId;
    }

    public String getRewriteOrderTag() {
        return rewriteOrderTag;
    }

    public void setRewriteOrderTag(String rewriteOrderTag) {
        this.rewriteOrderTag = rewriteOrderTag;
    }

    public String getTimeTopic() {
        return timeTopic;
    }

    public void setTimeTopic(String timeTopic) {
        this.timeTopic = timeTopic;
    }

    public String getTimeGroupId() {
        return timeGroupId;
    }

    public void setTimeGroupId(String timeGroupId) {
        this.timeGroupId = timeGroupId;
    }

    public String getTimeTag() {
        return timeTag;
    }

    public void setTimeTag(String timeTag) {
        this.timeTag = timeTag;
    }
}