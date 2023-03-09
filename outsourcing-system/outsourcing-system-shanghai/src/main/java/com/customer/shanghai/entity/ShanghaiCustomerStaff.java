package com.customer.shanghai.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShanghaiCustomerStaff implements Serializable {
    private static final long serialVersionUID = 1l;

    private Long id;

    private String nickname;

    private String avatar;

    private String phone;

    private String gender;

    private String goodAt;

    private String remark;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isDeleted;
}
