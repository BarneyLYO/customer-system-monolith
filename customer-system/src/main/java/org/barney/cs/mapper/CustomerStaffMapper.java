package org.barney.cs.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.barney.cs.entity.staff.CustomerStaff;

public interface CustomerStaffMapper extends BaseMapper<CustomerStaff> {
    default CustomerStaff findCustomerStaffByPhoneNumber(String phoneNumber) {
        LambdaQueryWrapper<CustomerStaff> queryWrapper
                = new LambdaQueryWrapper<>();

        queryWrapper.eq(CustomerStaff::getPhone, phoneNumber);
        queryWrapper.eq(CustomerStaff::getIsDeleted, false);
        return selectOne(queryWrapper);
    }
}
