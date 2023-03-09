package org.barney.cs.endpoints;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    private static final String HTTP_URL = "http://XXX:8080/healthcheck/";

    @Override
    public Health health() {
        try {
            URL url = new URL(HTTP_URL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int status = connection.getResponseCode();
            if(status >= 200 && status < 300) {
                return Health.up().build();
            } else {
                return Health.down().withDetail("Failed! code is: ", status).build();
            }
        } catch (IOException e) {
            return Health.down(e).build();
        }
    }
}
