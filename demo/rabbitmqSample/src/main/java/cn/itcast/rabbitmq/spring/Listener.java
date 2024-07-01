package cn.itcast.rabbitmq.spring;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring.test.queue", durable = "true"),
            exchange = @Exchange(
                    value = "spring.test.exchange",
                    ignoreDeclarationExceptions = "true", // 忽略交换机声明异常，比如已有一个交换机A，又申明了一个交换机A但参数不一致，此时会报错。加上次
                    //注解会葫芦异常，继续使用已有的交换机或队列
                    type = ExchangeTypes.TOPIC
            ),
            key = {"#.#"}))
    public void listen(String msg){
        System.out.println("接收到消息：" + msg);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-springboot-test",
                    durable="true"),
            exchange = @Exchange(value = "springboot_exchange_test",
                    durable="true",
                    type= "topic",
                    ignoreDeclarationExceptions = "true"),
            key = "springboot.test"
    ))
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        MessageHeaders messageHeaders=message.getHeaders();
        System.err.println("--------------------------------------");
        System.err.println("消费端接收到的消息: " + message.getPayload());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK
        channel.basicAck(deliveryTag, false);
    }
}
