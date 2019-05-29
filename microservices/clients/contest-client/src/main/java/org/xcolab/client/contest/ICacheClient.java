package org.xcolab.client.admin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("xcolab-user-service")
public interface ICacheClient {

    @GetMapping("/clearCache")
    public String clearCache();

}
