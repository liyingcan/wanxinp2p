package cn.itcast.wanxinp2p.consumer.controller;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class MqProducter {
	public static void main(String[] args) throws Exception {
        DefaultMQProducer mqProducer = new DefaultMQProducer("producerTest");
        mqProducer.setNamesrvAddr("192.168.137.200:9876");
        mqProducer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("TopicTest1",
                    "TagA",
                    "key1",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = mqProducer.send(msg, 6000);
            System.out.println("发送的数据：" + sendResult.toString());
            Thread.sleep(3000);
        }
        mqProducer.shutdown();
    }

}
