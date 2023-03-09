package org.barney.cs.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.barney.cs.entity.enums.Gender;
import org.barney.cs.entity.enums.Status;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CustomerStaffResponseVO {

    private Long id;
    private Long groupId;
    private String nickname;
    private String staffName;
    private String avatar;
    private String phone;
    private Gender gender;
    private String goodAt;
    private String welcomeMessage;
    private String remark;
    private Status status;
    private LocalDateTime createdAt;
}
