package cn.itcast.wanxinp2p.consumer.controller;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

public class MqConsumer {
	public static void main(String[] args) throws MQClientException{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("customerTest");
        consumer.setNamesrvAddr("192.168.137.200:9876");
        consumer.subscribe("TopicTest1", "*");//订阅全部
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    if (msg.getTopic().equals("TopicTest1")) {
                        if (msg.getTags() != null && msg.getTags().equals("TagA")) {
                            System.out.println("TagA:" + new String(msg.getBody()));
                        }
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }

}
