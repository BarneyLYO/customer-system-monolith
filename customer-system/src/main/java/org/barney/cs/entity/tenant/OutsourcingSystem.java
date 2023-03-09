package org.barney.cs.entity.tenant;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("outsourcing_system")
public class OutsourcingSystem {
    private static final long serialVersionUID = 1l;

    @TableId(value = "id", type= IdType.AUTO)
    private Long id;

    private String systemName;

    private String systemCode;

    private String description;

    private String systemUrl;

    private String appId;

    private String appKey;

    private String appSecret;

    @TableLogic
    private Boolean isDeleted;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
