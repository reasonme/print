package cn.fintecher.summons;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author : sunyanping
 * @Description : 服务注册与发现中心
 * @Date : 2017/4/25.
 */
@SpringBootApplication
@EnableEurekaServer
public class SummonsEurekaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SummonsEurekaApplication.class).web(true).run(args);
    }
}
