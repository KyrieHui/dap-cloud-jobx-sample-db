package com.dap.cloud;

import com.dap.cloud.context.print.PrintUtils;
import com.dap.cloud.context.spring.SpringContextUtils;
import com.dap.cloud.jobx.client.JobxAgentStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ImportResource({ "classpath:conf/dap-main.xml" })
public class JobxStarterBootstrap {
    public static void main(String[] args) {

        try {
            String HOST_NAME = InetAddress.getLocalHost().getHostName();
            System.setProperty("HOSTNAME", HOST_NAME);
            System.setProperty("nacos.logging.default.config.enabled", "false");
        } catch (UnknownHostException e) {

        }

        SpringApplication springApplication = new SpringApplication(JobxStarterBootstrap.class);
        ApplicationContext applicationContext = springApplication.run(args);
        SpringContextUtils.setApplicationContext(applicationContext);

        //要求这一步操作必须放在最后进行。所有操作就绪后，上报自己服务状态到worker中，标识当前agent服务就绪，可以参与作业执行
        JobxAgentStarter jobxAgentStarter = new JobxAgentStarter();
        jobxAgentStarter.start();
        PrintUtils.printInfo("job", "dap-cloud-jobx-starter");
    }
}
