package com.customer.hangzhou.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
@Table(name = "hangzhou_customer_staff")
public class HangzhouCustomerStaff {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
