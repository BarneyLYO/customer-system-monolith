package org.barney.cs.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.barney.cs.entity.enums.Gender;

@Data
@Accessors(chain = true)
public class AddCustomerStaffRequestVO {

    private Long groupId;

    private String nickname;

    private String accountId;

    private String staffName;

    private String avatar;

    private String phone;

    private Gender gender;

    private String status;

    private String goodAt;

    private String welcomeMessage;

    private String remark;
}
