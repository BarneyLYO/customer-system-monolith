package org.barney.cs.entity.staff;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.barney.cs.entity.enums.Gender;
import org.barney.cs.entity.enums.Status;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_staff")
public class CustomerStaff {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long groupId;

    private String staffName;

    private String nickName;

    private Long accountId;

    private Long systemId;

    private String avatar;

    private String phone;

    private Gender gender;

    private String goodAt;

    private Boolean isAutoReply;

    private String welcomeMessage;

    private Status status;

    private String remark;

    @TableLogic
    private Boolean isDeleted;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
