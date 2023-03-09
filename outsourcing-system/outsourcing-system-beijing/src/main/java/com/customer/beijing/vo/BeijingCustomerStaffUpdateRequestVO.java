package com.customer.beijing.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BeijingCustomerStaffUpdateRequestVO {

    private Long id;
    private String nickname;

    private String avatar;

    private String goodAt;

    private String remark;
}
