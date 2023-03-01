package com.customer.beijing.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BeijingCustomerStaff {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nickname;

    private String avatar;

    private String phone;

    private String gender;

    private String goodAt;

    private String remark;

    private Date createdAt;

    private Date updatedAt;

    // 0 f, 1 t
    private Boolean isDeleted;
}
