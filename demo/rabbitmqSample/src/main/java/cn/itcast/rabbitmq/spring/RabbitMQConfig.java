package cn.itcast.rabbitmq.spring;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//RabbitMQ 提供了 Jackson2JsonMessageConverter 来支持消息内容 JSON 序列化与反序列化，消息消费者配置 MessageConverter 为 Jackson2JsonMessageConverter
@Configuration
public class RabbitMQConfig {

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        DefaultJackson2JavaTypeMapper javaTypeMapper=new DefaultJackson2JavaTypeMapper();
        //添加信任包名称，不然会转化失败 
        javaTypeMapper.setTrustedPackages("com.warybee.mqconsumer.entity");
        jackson2JsonMessageConverter.setJavaTypeMapper(javaTypeMapper);
        factory.setMessageConverter(jackson2JsonMessageConverter);
        return factory;
    }
}