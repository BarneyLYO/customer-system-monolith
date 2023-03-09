package com.customer.hangzhou.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HangzhouCustomerStaffCreateRequestVO {
    private String nickname;
    private String avatar;
    private String phone;
    private String gender;
    private String goodAt;
    private String remark;
}
