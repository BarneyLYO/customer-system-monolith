package com.customer.shanghai.service.impl;

import com.customer.shanghai.entity.ShanghaiCustomerStaff;
import com.customer.shanghai.repository.ShanghaiCustomerStaffRepository;
import com.customer.shanghai.service.ShanghaiCustomerStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShanghaiCustomerStaffServiceImpl implements ShanghaiCustomerStaffService {

    @Autowired
    private ShanghaiCustomerStaffRepository customerStaffRepository;

    @Override
    public List<ShanghaiCustomerStaff> findAllCustomerStaffs() {
        return customerStaffRepository.findCustomerStaff();
    }

    @Override
    public List<ShanghaiCustomerStaff> findCustomerStaffsByUpdatedTime(Long updatedTime) {
        return customerStaffRepository.findCustomerStaffByUpdatedTime(updatedTime);
    }

    @Override
    public Long createCustomerStaff(ShanghaiCustomerStaff customerStaff) {
        return customerStaffRepository.createCustomerStaff(customerStaff);
    }

    @Override
    public Boolean updateCustomerStaff(ShanghaiCustomerStaff customerStaff) {
        return customerStaffRepository.updateCustomerStaff(customerStaff);
    }

    @Override
    public Boolean deleteCustomerStaffById(Long id) {
        return customerStaffRepository.deleteCustomerStaffById(id);
    }
}
