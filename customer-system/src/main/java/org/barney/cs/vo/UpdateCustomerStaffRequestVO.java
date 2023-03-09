package org.barney.cs.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.barney.cs.entity.enums.Status;

@Data
@Accessors(chain = true)
public class UpdateCustomerStaffRequestVO {

    private Long id;
    private Long groupId;
    private String nickname;

    private String avatar;

    private Status statis;

    private String goodAt;

    private String welcomeMessage;

    private String remark;
}
