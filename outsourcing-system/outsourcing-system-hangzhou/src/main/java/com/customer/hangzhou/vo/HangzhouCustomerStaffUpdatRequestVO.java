package com.customer.hangzhou.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HangzhouCustomerStaffUpdatRequestVO {

    private Long id;

    private String nickname;

    private String avatar;

    private String goodAt;

    private String remark;
}
