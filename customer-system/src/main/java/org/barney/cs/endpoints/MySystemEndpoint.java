package org.barney.cs.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@Endpoint(id = "mySystem", enableByDefault = true)
public class MySystemEndpoint {

    @ReadOperation
    public Map<String, Object> getMySystemInfo() {
        return Map.of(
          "username", System.getenv().get("USERNAME"),
          "computername", System.getenv().get("COMPUTERNAME")
        );
    }

}
