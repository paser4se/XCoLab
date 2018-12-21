package org.xcolab.service.members;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MembersServiceApplication {

    private MembersServiceApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(MembersServiceApplication.class, args);
    }
}
