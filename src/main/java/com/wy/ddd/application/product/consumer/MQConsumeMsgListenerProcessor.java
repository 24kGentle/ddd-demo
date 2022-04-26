package com.wy.ddd.application.product.consumer;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.wy.ddd.infrastructure.annotation.LogId;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static com.aliyun.openservices.ons.api.Action.ReconsumeLater;

/**
 * https://www.cnblogs.com/laifw/p/11369000.html
 */
@Component
@Slf4j
public class MQConsumeMsgListenerProcessor implements MessageListener {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @SneakyThrows
    @Override
    @LogId
    public Action consume(Message message, ConsumeContext context) {
        log.info("接收到MQ消息. Topic :" + message.getTopic() + ", tag :" + message.getTag() + " msgId : " + message.getMsgID() + ", Key :" + message.getKey() + ", body:" + new String(message.getBody()));
        Thread.sleep(3_000L);
        log.info("receiver:" + new String(message.getBody()));
        return ReconsumeLater;
        //        System.out.println("Receive: " + message);
//        try {
//            String msgTag = message.getTag();//消息类型
//            String msgKey = message.getKey();//唯一key
//            switch (msgTag) {
//                //--------普通通知
//                case "userMessage":
//                    Thread.sleep(8_000L);
//                    log.info("receiver:" + new String(message.getBody()));
//                    break;
//            }
//            return Action.CommitMessage;
//        } catch (Exception e) {
//            log.error("消费MQ消息失败！ msgId:" + message.getMsgID()+"----ExceptionMsg:"+e.getMessage());
//            return Action.ReconsumeLater;
//        }
    }
}
