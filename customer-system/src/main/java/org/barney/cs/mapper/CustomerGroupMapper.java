package org.barney.cs.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.barney.cs.entity.staff.CustomerGroup;

public interface CustomerGroupMapper extends BaseMapper<CustomerGroup> {
    default CustomerGroup findCustomerGroupByName(String groupName) {
        LambdaQueryWrapper<CustomerGroup> queryWrapper
                    = new LambdaQueryWrapper<>();

        queryWrapper.eq(CustomerGroup::getGroupName, groupName);

        return selectOne(queryWrapper);
    }
}
