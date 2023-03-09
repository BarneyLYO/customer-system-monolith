package org.barney.cs.entity.staff;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("customer_staff_count")
public class CustomerStaffCount implements Serializable {
    private static final long serialVersionUID = 1l;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String phone;

    private Long count;
}
