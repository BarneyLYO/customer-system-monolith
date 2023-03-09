package com.customer.beijing.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BeijingCustomerStaffCreateRequestVO {
    private String nickname;
    private String avatar;
    private String phone;
    private String gender;
    private String goodAt;
    private String remark;
}
