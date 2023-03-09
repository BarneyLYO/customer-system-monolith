package org.barney.cs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.barney.cs.config.OutsourcingSystemClient;
import org.barney.cs.endpoints.CustomerStaffEndpoint;
import org.barney.cs.entity.staff.CustomerStaff;
import org.barney.cs.entity.tenant.OutsourcingSystem;
import org.barney.cs.mapper.CustomerStaffMapper;
import org.barney.cs.service.CustomerStaffService;
import org.barney.cs.service.OutsourcingSystemService;
import org.barney.infrastructure.exception.BusinessException;
import org.barney.infrastructure.utils.StringUtils;
import org.barney.infrastructure.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CustomerStaffServiceImpl extends ServiceImpl<CustomerStaffMapper, CustomerStaff> implements CustomerStaffService {

    @Autowired
    OutsourcingSystemService outsourcingSystemService;

    @Autowired
    OutsourcingSystemClient outsourcingSystemClient;

    @Autowired
    CustomerStaffEndpoint customerStaffEndpoint;

    private PageObject<CustomerStaff> getCustomerStaffPageObject(String staffName, Long pageSize, Long pageIndex) {
        LambdaQueryWrapper<CustomerStaff> queryWrapper
                = new LambdaQueryWrapper<>();

        if(StringUtils.hasText(staffName)){
            queryWrapper.like(CustomerStaff::getStaffName, staffName);
        }
        queryWrapper.orderByDesc(CustomerStaff::getCreatedAt);

        IPage<CustomerStaff> page = new Page<>(pageIndex, pageSize);
        IPage<CustomerStaff> pagedResult = baseMapper.selectPage(page, queryWrapper);

        PageObject<CustomerStaff> pagedObject = new PageObject<>();
        pagedObject.buildPage(pagedResult.getRecords(), pagedResult.getTotal(),pagedResult.getCurrent(), pagedResult.getSize());

        return pagedObject;
    }

    @Override
    public PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex) {
        return getCustomerStaffPageObject(null, pageSize, pageIndex);
    }

    @Override
    public List<CustomerStaff> findCustomerStaffs() {
        LambdaQueryWrapper<CustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex) {
        return getCustomerStaffPageObject(staffName, pageSize, pageIndex);
    }

    @Override
    public CustomerStaff findCustomerStaffById(Long staffId) {
        return baseMapper.selectById(staffId);
    }

    @Override
    public Boolean createCustomerStaff(CustomerStaff customerStaff) throws BusinessException {
        return save(customerStaff);
    }

    @Override
    public Boolean updateCustomerStaff(CustomerStaff customerStaff) {
        return updateById(customerStaff);
    }

    @Override
    public Boolean deleteCustomerStaffById(Long staffId) {
        return removeById(staffId);
    }

    @Override
    public void syncOutsourcingCustomerStaffsBySystemId(Long systemId) {
        OutsourcingSystem outsourcingSystem
                = outsourcingSystemService.findOutsourcingSystemById(systemId);
        List<CustomerStaff> customerStaffs = outsourcingSystemClient.getCustomerStaffs(outsourcingSystem);

        saveOrUpdateBatch(customerStaffs);
    }
}
