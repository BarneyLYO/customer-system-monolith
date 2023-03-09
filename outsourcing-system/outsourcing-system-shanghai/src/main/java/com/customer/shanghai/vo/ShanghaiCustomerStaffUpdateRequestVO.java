package com.customer.shanghai.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ShanghaiCustomerStaffUpdateRequestVO {
    private Long id;
    private String nickname;
    private String avatar;
    private String goodAt;
    private String remark;
}
