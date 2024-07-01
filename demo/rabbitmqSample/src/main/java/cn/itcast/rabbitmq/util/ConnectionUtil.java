package cn.itcast.rabbitmq.util;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import org.springframework.beans.factory.annotation.Value;

public class ConnectionUtil {
//    spring:
//    rabbitmq:
//    host: 192.168.8.188
//    username: ksc
//    password: ksc
//    virtual-host: /test
//    @Value("${spring.rabbitmq.host}")
//    private String host;
//    @Value("${spring.rabbitmq.username}")
//    private String username;
//    @Value("${spring.rabbitmq.password}")
//    private String password;
//    @Value("${spring.rabbitmq.virtual-host}")
//    private String virtualHost;

    /**
     * 建立与RabbitMQ的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("192.168.8.188");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("/test");
        factory.setUsername("ksc");
        factory.setPassword("ksc");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }

}
