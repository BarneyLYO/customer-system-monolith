package org.barney.cs.endpoints;

import org.barney.cs.mapper.CustomerStaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


@Configuration
@Endpoint(id = "customerStaff", enableByDefault = true)
public class CustomerStaffEndpoint {

    @Autowired
    private CustomerStaffMapper customerStaffMapper;

    public Map<String, Object> getCustomerStaffByPhoneNumber(@Selector String arg0) {
        return Map.of(
                arg0, customerStaffMapper.findCustomerStaffByPhoneNumber(arg0)
        );
    }
}
