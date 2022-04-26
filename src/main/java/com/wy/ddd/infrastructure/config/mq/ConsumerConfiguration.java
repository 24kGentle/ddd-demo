package com.wy.ddd.infrastructure.config.mq;

import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import com.wy.ddd.application.product.consumer.MQConsumeMsgListenerProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * https://www.cnblogs.com/laifw/p/11369000.html
 */
@Configuration
public class ConsumerConfiguration {

    @Autowired
    private MqConfig mqConfig;

    //普通消息监听器，Consumer注册消息监听器来订阅消息.
    @Autowired
    private MQConsumeMsgListenerProcessor messageListener;

//    @Autowired
//    private MQConsumeMsgListenerProcessor1 messageListener1;
//
//    @Autowired
//    private MQConsumeMsgListenerProcessor2 messageListener2;


    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public ConsumerBean buildConsumer() {
        ConsumerBean consumerBean = new ConsumerBean();
        //配置文件
        Properties properties = mqConfig.getMqPropertie();
        properties.setProperty(PropertyKeyConst.GROUP_ID, mqConfig.getExtractOrderGroupId());
        //将消费者线程数固定为20个 20为默认值
        properties.setProperty(PropertyKeyConst.ConsumeThreadNums, "5");
        //消息消费失败时的最大重试次数，否则进入死信队列
        properties.setProperty(PropertyKeyConst.MaxReconsumeTimes, "5");
        // 最长消费时间
//        PropertyKeyConst.ConsumeTimeout
        consumerBean.setProperties(properties);
        //订阅消息
        Map<Subscription, MessageListener> subscriptionTable = new HashMap<Subscription, MessageListener>();
        //订阅普通消息
        Subscription subscription = new Subscription();
        subscription.setTopic(mqConfig.getTopic());
        subscription.setExpression(mqConfig.getExtractOrderTag());
        subscriptionTable.put(subscription, messageListener);
        consumerBean.setSubscriptionTable(subscriptionTable);
        return consumerBean;
    }


//    @Bean(initMethod = "start", destroyMethod = "shutdown")
//    public ConsumerBean buildConsumer1() {
//        ConsumerBean consumerBean = new ConsumerBean();
//        //配置文件
//        Properties properties = mqConfig.getMqPropertie();
//        properties.setProperty(PropertyKeyConst.GROUP_ID, mqConfig.getRewriteOrderGroupId());
//        //将消费者线程数固定为20个 20为默认值
//        properties.setProperty(PropertyKeyConst.ConsumeThreadNums, "5");
//        //消息消费失败时的最大重试次数
//        properties.setProperty(PropertyKeyConst.MaxReconsumeTimes, "2");
//        consumerBean.setProperties(properties);
//        //订阅消息
//        Map<Subscription, MessageListener> subscriptionTable = new HashMap<Subscription, MessageListener>();
//        //订阅普通消息
//        Subscription subscription = new Subscription();
//        subscription.setTopic(mqConfig.getTopic());
//        subscription.setExpression(mqConfig.getRewriteOrderTag());
//        subscriptionTable.put(subscription, messageListener1);
//
//        consumerBean.setSubscriptionTable(subscriptionTable);
//        return consumerBean;
//    }


//    /**
//     * 延时队列
//     * @return
//     */
//    @Bean(initMethod = "start", destroyMethod = "shutdown")
//    public ConsumerBean buildConsumer2() {
//        ConsumerBean consumerBean = new ConsumerBean();
//        //配置文件
//        Properties properties = mqConfig.getMqPropertie();
//        properties.setProperty(PropertyKeyConst.GROUP_ID, mqConfig.getTimeGroupId());
//        //将消费者线程数固定为20个 20为默认值
//        properties.setProperty(PropertyKeyConst.ConsumeThreadNums, "1");
//        //消息消费失败时的最大重试次数
//        properties.setProperty(PropertyKeyConst.MaxReconsumeTimes, "5");
//        consumerBean.setProperties(properties);
//        //订阅消息
//        Map<Subscription, MessageListener> subscriptionTable = new HashMap<Subscription, MessageListener>();
//        //订阅定时/延时消息
//        Subscription timeMessageListener = new Subscription();
//        timeMessageListener.setTopic(mqConfig.getTimeTopic());
//        timeMessageListener.setExpression(mqConfig.getTimeTag());
//        subscriptionTable.put(timeMessageListener, messageListener2);
//
//        consumerBean.setSubscriptionTable(subscriptionTable);
//        return consumerBean;
//    }
}
