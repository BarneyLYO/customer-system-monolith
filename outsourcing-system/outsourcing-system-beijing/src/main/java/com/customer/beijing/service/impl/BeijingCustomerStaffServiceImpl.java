package com.customer.beijing.service.impl;

import com.customer.beijing.entity.BeijingCustomerStaff;
import com.customer.beijing.repository.BeijingCustomerStaffRepository;
import com.customer.beijing.service.BeijingCustomerStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeijingCustomerStaffServiceImpl implements BeijingCustomerStaffService {

    private final BeijingCustomerStaffRepository customerStaffRepository;

    @Autowired
    public BeijingCustomerStaffServiceImpl(BeijingCustomerStaffRepository beijingCustomerStaffRepository) {
        this.customerStaffRepository = beijingCustomerStaffRepository;
    }


    @Override
    public List<BeijingCustomerStaff> findAllCustomerStaffs() {
        return customerStaffRepository.findCustomerStaff();
    }

    @Override
    public List<BeijingCustomerStaff> findCustomerStaffsByUpdatedTime(Long updatedTime) {
        return customerStaffRepository.findCustomerStaffByUpdatedTime(updatedTime);
    }

    @Override
    public Long createCustomerStaff(BeijingCustomerStaff customerStaff) {
        return customerStaffRepository.createCustomerStaff(customerStaff);
    }

    @Override
    public Boolean updateCustomerStaff(BeijingCustomerStaff customerStaff) {
        return customerStaffRepository.updateCustomerStaff(customerStaff);
    }

    @Override
    public Boolean deleteCustomerStaffById(Long id) {
        return customerStaffRepository.deleteCustomerStaffById(id);
    }
}
